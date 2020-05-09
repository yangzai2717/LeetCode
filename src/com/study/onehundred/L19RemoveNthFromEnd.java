package com.study.onehundred;

/**
 * @Author pangyangyang
 * @Date 2020/05/08
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 **/
public class L19RemoveNthFromEnd {

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode(0);
    temp.next = head;
    ListNode first = temp;
    ListNode second = temp;
    for (int i = 1; i < n + 1; i++) {
        first = first.next;
    }
    while (first.next != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return temp.next;
  }

  public static void outList(ListNode head) {
    while (head.next != null) {
      System.out.println(head.val);
      head = head.next;
    }
    System.out.println(head.val);
  }

  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    ListNode listNode = removeNthFromEnd(node5, 1);
    outList(listNode);
  }

  public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
        val = x;
      }
 }
}
