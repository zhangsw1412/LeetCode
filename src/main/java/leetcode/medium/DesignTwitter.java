package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by zhangsw on 2018/7/3.
 */
public class DesignTwitter
{
    class Twitter
    {
        class Tweet
        {
            int tweetId;
            int postedTime;

            public Tweet(int tweetId, int postedTime)
            {
                this.tweetId = tweetId;
                this.postedTime = postedTime;
            }
        }

        int timestamp;
        int feedMaxNum;
        Map<Integer, Set<Integer>> followees;
        Map<Integer, List<Tweet>> tweets;

        /**
         * Initialize your data structure here.
         */
        public Twitter()
        {
            this.timestamp = 0;
            this.feedMaxNum = 10;
            this.followees = new HashMap<>();
            this.tweets = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId)
        {
            if (!tweets.containsKey(userId))
            {
                tweets.put(userId, new LinkedList<>());
                follow(userId, userId);
            }
            tweets.get(userId).add(0, new Tweet(tweetId, this.timestamp++));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user
         * followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId)
        {
            PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(this.feedMaxNum + 1, Comparator.comparingInt(t1 -> t1.postedTime));
            Set<Integer> myFollowees = followees.get(userId);
            if (myFollowees != null)
            {
                for (Integer myFollowee : myFollowees)
                {
                    List<Tweet> tweetList = tweets.get(myFollowee);
                    if (tweetList != null)
                    {
                        for (Tweet tweet : tweetList)
                        {
                            priorityQueue.offer(tweet);
                            if (priorityQueue.size() > this.feedMaxNum)
                            {
                                priorityQueue.poll();
                            }
                        }
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            while (!priorityQueue.isEmpty())
            {
                result.add(0, priorityQueue.poll().tweetId);
            }
            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId)
        {
            if (!followees.containsKey(followerId))
            {
                followees.put(followerId, new HashSet<>());
            }
            followees.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId)
        {
            if (followees.containsKey(followerId) && followerId != followeeId)
            {
                followees.get(followerId).remove(followeeId);
            }
        }
    }
}
