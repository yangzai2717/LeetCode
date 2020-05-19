package com.study.onehundred;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author pangyangyang
 * @Date 2020/05/11
 *
 * 输入: "{[]}"
 * 输出: true
 *
 **/
public class L20IsValid {

  public static boolean isValid(String s) {
    if (s.equals("")) {
      return true;
    }
    if (s.length()%2 != 0 ) {
      return false;
    }
    Map<Character, Character> left = new HashMap<>();
    left.put('(', ')');
    left.put('{', '}');
    left.put('[', ']');
    Map<Character, Character> right = new HashMap<>();
    right.put(')', '(');
    right.put('}', '{');
    right.put(']', '[');
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (left.containsKey(c)) {
        stack.push(c);
      }else if (right.containsKey(c)) {
        if (stack.empty()) {
          return false;
        }
        Character pop = stack.pop();
        if (right.get(c).equals(pop)) {
          continue;
        }else {
          return false;
        }
      }
    }
    if (stack.empty()) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(isValid("}"));
  }

}
