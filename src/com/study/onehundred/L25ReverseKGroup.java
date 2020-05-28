package com.study.onehundred;


/**
 * @Author pangyangyang
 * @Date 2020/05/28
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 **/
public class L25ReverseKGroup {

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode tail = head;
    for (int i = 0; i < k; i++) {
      if (tail == null) {
        return head;
      }
      tail = tail.next;
    }
    ListNode newHead = reverseKNode(head, tail);
    head.next = reverseKGroup(tail, k);
    return newHead;
  }

  public static ListNode reverseKNode(ListNode head, ListNode tail) {
    ListNode pre = null;
    ListNode next;
    while (head != tail) {
      next = head.next;
      head.next = pre;
      pre = head;
      head = next;
    }
    return pre;
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
    ListNode init = init(nums);
    ListNode listNode = reverseKNode(init, init.next.next);
    sout(listNode);
  }
}
