package leetcode.medium;

/**
 * Created by zhangsw on 2018/6/25.
 */
public class OddEvenLinkedList
{
    /**
     * Definition for singly-linked list.
     */
    class ListNode
    {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
            next = null;
        }
    }

    class Solution
    {
        public ListNode oddEvenList(ListNode head)
        {
            if (head == null || head.next == null)
            {
                return head;
            }
            ListNode odd = head, even = head.next, evenHead = even;
            while (even != null && even.next != null)
            {
                odd.next = even.next;
                even.next = even.next.next;
                odd.next.next = evenHead;
                odd = odd.next;
                even = even.next;
            }
            return head;
        }
    }
}
