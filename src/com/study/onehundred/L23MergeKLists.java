package com.study.onehundred;

/**
 * @Author pangyangyang
 * @Date 2020/05/26
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 **/
public class L23MergeKLists {

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    if (lists.length == 2) {
      return mergeTowList(lists[0], lists[1]);
    }
    int mid = lists.length / 2;
    ListNode[] l1 = new ListNode[mid];
    ListNode[] l2 = new ListNode[lists.length - mid];
    for (int i = 0; i < mid; i++) {
      l1[i] = lists[i];
    }
    for (int i = 0,j = mid; j < lists.length ; i++, j++) {
      l2[i] = lists[j];
    }
    return mergeTowList(mergeKLists(l1), mergeKLists(l2));
  }

  public static ListNode mergeTowList(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;

    ListNode res = null;
    if (l1.val <= l2.val) {
      res = l1;
      res.next = mergeTowList(l1.next, l2);
    }
    if (l2.val < l1.val) {
      res = l2;
      res.next = mergeTowList(l1, l2.next);
    }
    return res;
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
    int[] i1 = {1,4,5};
    int[] i2 = {1,3,4};
    int[] i3 = {2,6};
    ListNode l1 = init(i1);
    ListNode l2 = init(i2);
    ListNode l3 = init(i3);
    ListNode[] lists = {l1, l2, l3};
    ListNode listNode = mergeKLists(lists);
    sout(listNode);
  }
}
