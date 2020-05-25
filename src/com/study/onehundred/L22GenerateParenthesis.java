package com.study.onehundred;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pangyangyang
 * @Date 2020/05/25
 **/
public class L22GenerateParenthesis {

  static List<String> res = new ArrayList<>();
  public static List<String> generateParenthesis(int n) {
    if (n == 0) {
      return res;
    }
    if (n == 1) {
      res.add("()");
      return res;
    }
    dfs(n, n, "");
    return res;
  }

  private static void dfs(int left, int right, String s) {
    if (left == 0 && right == 0) {
      res.add(s);
      return;
    }
    if (left > 0) {
      dfs(left -1, right, s + "(");
    }
    if (right > left) {
      dfs(left, right - 1, s+ ")");
    }
  }


  public static void main(String[] args) {
    System.out.println(generateParenthesis(3));
  }
}
