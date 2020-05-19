package com.study.onehundred;

/**
 * @Author pangyangyang
 * @Date 2020/05/19
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4->5
 * 输出：1->1->2->3->4->4
 **/
public class L21MergeTwoLists {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode l3 = new ListNode(0);
      ListNode l4 = l3;

      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          l3.next = l1;
          l1 = l1.next;
          l3 = l3.next;
        }else {
          l3.next = l2;
          l2 = l2.next;
          l3 = l3.next;
        }
      }
      if (null == l1) {
        l3.next = l2;
      }
      if (null == l2) {
        l3.next = l1;
      }
      return l4.next;
  }


  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public static void sout(ListNode l) {
    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }

  public static void main(String[] args) {
    ListNode l11 = new ListNode(1);
    ListNode l12 = new ListNode(2);
    ListNode l13 = new ListNode(4);
    l11.next = l12;
    l12.next = l13;

    ListNode l21 = new ListNode(1);
    ListNode l22 = new ListNode(3);
    ListNode l23 = new ListNode(4);
    ListNode l24 = new ListNode(5);
    l21.next = l22;
    l22.next = l23;
    l23.next = l24;

    sout(mergeTwoLists(l13, l24));

  }


}
