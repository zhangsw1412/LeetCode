# 联合索引

联合索引又叫复合索引。两个或更多个列上的索引被称作复合索引。

对于复合索引：Mysql从左到右的使用索引中的字段，一个查询可以只使用索引中的一部份，但只能是最左侧部分。例如索引是key index （a,b,c）。可以支持a | a,b| a,b,c 3种组合进行查找，但不支持 b,c进行查找 。当最左侧字段是常量引用时，索引就十分有效。

`最左前缀匹配原则，非常重要的原则，mysql会一直向右匹配直到遇到范围查询(>、<、between、like)就停止匹配`

利用索引中的附加列，可以缩小搜索的范围，但使用一个具有两列的索引不同于使用两个单独的索引。复合索引的结构与电话簿类似，人名由姓和名构成，电话簿首先按姓氏对进行排序，然后按名字对有相同姓氏的人进行排序。如果知道姓，电话簿将非常有用；如果知道姓和名，电话簿则更为有用，但如果只知道名不知道姓，电话簿将没有用处。

 如：建立 姓名、年龄、性别的复合索引。

```mysql
create table myTest(
    a int,
    b int,
    c int,
    KEY a(a,b,c)
);
```

(1)    select * from myTest  where a=3 and b=5 and c=4;   ----  abc顺序
abc三个索引都在where条件里面用到了，而且都发挥了作用

(2)    select * from myTest  where  c=4 and b=6 and a=3;
where里面的条件顺序在查询之前会被mysql自动优化，效果跟上一句一样

(3)    select * from myTest  where a=3 and c=7;
a用到索引，b没有用，所以c是没有用到索引效果的

(4)    select * from myTest  where a=3 and b>7 and c=3;     ---- b范围值，断点，阻塞了c的索引
a用到了，b也用到了，c没有用到，这个地方b是范围值，也算断点，只不过自身用到了索引

(5)    select * from myTest  where b=3 and c=4;   --- 联合索引必须按照顺序使用，并且需要全部使用
因为a索引没有使用，所以这里 bc都没有用上索引效果

(6)    select * from myTest  where a>4 and b=7 and c=9;
a用到了  b没有使用，c没有使用

(7)    select * from myTest  where a=3 order by b;
a用到了索引，b在结果排序中也用到了索引的效果，a下面任意一段的b是排好序的

(8)    select * from myTest  where a=3 order by c;
a用到了索引，但是这个地方c没有发挥排序效果，因为中间断点了，使用 explain 可以看到 filesort

(9)    select * from mytable where b=3 order by a;
b没有用到索引，排序中a也没有发挥索引效果

# 索引失效

- 不在索引列上做任何操作（计算、函数、（自动or手动）类型转换），会导致索引失效而转向全表扫描

- 存储引擎不能使用索引范围条件右边的列

- 尽量使用覆盖索引（只访问索引的查询（索引列包含查询列）），减少select *，这样会减少回表查询的次数

- mysql在使用不等于（！=或者<>）的时候无法使用索引会导致全表扫描

- is null,is not null也无法使用索引，索引是不索引空值的，所以这样的操作不能使用索引，可以用其他的办法处理，例如：数字类型，判断大于0，字符串类型设置一个默认值，判断是否等于默认值即可

- 在索引字段上使用not，<>，!=。不等于操作符是永远不会用到索引的，因此对它的处理只会产生全表扫描。 优化方法： key<>0 改为 key>0 or key<0

- like以通配符开头（'%abc…'）mysql索引失效会变成全表扫描的操作，当like前缀没有%，后缀有%时，索引有效

- 字符串不加单引号索引失效。如varchar不加单引号的话可能会自动转换为int型，使索引无效，产生全表扫描

  ```mysql
  SELECT * from staffs where name='2000';  -- 因为mysql会在底层对其进行隐式的类型转换
  SELECT * from staffs where name=2000;  -- 未使用索引
  ```

* or语句前后没有同时使用索引。当or左右查询字段只有一个是索引，该索引失效，只有当or左右查询字段均为索引时，才会生效
* 对索引字段进行计算操作、字段上使用函数
* 当全表扫描速度比索引速度快时，mysql会使用全表扫描，此时索引失效

##### 一般性建议

对于单键索引，尽量选择针对当前query过滤性更好的索引
在选择组合索引的时候，当前Query中过滤性最好的字段在索引字段顺序中，位置越靠前越好
在选择组合索引的时候，尽量选择可以能够包含当前query中的where子句中更多字段的索引
尽可能通过分析统计信息和调整query的写法来达到选择合适索引的目的

# 利用索引优化ORDER BY语句

MySQL索引通常是被用于提高WHERE条件的数据行匹配或者执行联结操作时匹配其它表的数据行的搜索速度。

MySQL也能利用索引来快速地执行ORDER BY和GROUP BY语句的排序和分组操作。

1. ORDER BY的索引优化

   SELECT [column1],[column2],…. FROM [TABLE] ORDER BY [sort];
   在[sort]这个栏位上建立索引就可以实现利用索引进行order by 优化

2. WHERE + ORDER BY的索引优化

   SELECT [column1],[column2],…. FROM [TABLE] WHERE [columnX] = [value] ORDER BY [sort];
   建立一个联合索引(columnX,sort)来实现order by 优化

3. WHERE + 多个字段ORDER BY

   SELECT * FROM [table] WHERE uid=1 ORDER x,y LIMIT 0,10;
   建立索引(uid,x,y)实现order by的优化,比建立(x,y,uid)索引效果要好得多

##### MySQL Order By不能使用索引来优化排序的情况

* 对不同的索引键做 ORDER BY ：(key1,key2分别建立索引)
SELECT * FROM t1 ORDER BY key1, key2;

* 在非连续的索引键部分上做 ORDER BY：(key_part1,key_part2建立联合索引;key2建立索引)
SELECT * FROM t1 WHERE key2=constant ORDER BY key_part2;

* 同时使用了 ASC 和 DESC：(key_part1,key_part2建立联合索引)
SELECT * FROM t1 ORDER BY key_part1 DESC, key_part2 ASC;

* 用于搜索记录的索引键和做 ORDER BY 的不是同一个：(key1,key2分别建立索引)
SELECT * FROM t1 WHERE key2=constant ORDER BY key1;

* 如果在WHERE和ORDER BY的栏位上应用表达式(函数)时，则无法利用索引来实现order by的优化
SELECT * FROM t1 ORDER BY YEAR(logindate) LIMIT 0,10;