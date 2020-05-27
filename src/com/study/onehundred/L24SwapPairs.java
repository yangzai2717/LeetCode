package com.study.onehundred;


/**
 * @Author pangyangyang
 * @Date 2020/05/27
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 **/
public class L24SwapPairs {

  public static ListNode swapPairs(ListNode head) {
    //终止条件
    if (head == null || head.next == null) {
      return head;
    }
    //当前循环需要做什么
    //head head.next swapPairs(head.next)
    ListNode next = head.next;
    head.next = swapPairs(next.next);
    next.next = head;
    //返回值，返回每次处理好的链表
    return next;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public static ListNode init(int[] nums) {
    ListNode listNode = new ListNode(nums[0]);
    ListNode l1 = listNode;
    for (int i = 1; i < nums.length; i++) {
      ListNode node = new ListNode(nums[i]);
      listNode.next = node;
      listNode = listNode.next;
    }
    return l1;
  }

  public static void sout(ListNode l) {
    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    sout(swapPairs(init(nums)));
  }
}
