package com.study;

public class Main {

  public static int minCount(int[] coins) {
    int ans = 0;
    for(int c : coins){
      ans += (c + 1) / 2;
    }
    return ans;
  }

    public static   void main(String[] args) {
      int[] ints = {2,4,10};
      System.out.println(minCount(ints));
    }
}
