package org.cdp.skill.guava;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class ImmutableListDemo {
  public static void main(String[] args) {

    // 创建一个不可变数组
    ImmutableList<String> test1 = ImmutableList.of(
      "hello"
      , "java"
      , "scala"
      , "golang"
      , "shell"
      , "linux"
    );
    System.out.println(test1);

    // 复制一个不可变数组
    ImmutableList<String> test2 = ImmutableList.copyOf(test1);
    System.out.println(test2);


    // 排序复制 里面使用的Array.sort
    ImmutableList<Integer> test3 = ImmutableList.of(1,234,234,4,1,3);
    System.out.println(test3);
    ImmutableList<Integer> test4 = ImmutableList.sortedCopyOf(test3);
    System.out.println(test4);

    ArrayList<Integer> test5 = new ArrayList<>();
    test5.add(1);
    test5.add(21);
    test5.add(13);

    Multimap<String, String> multimap = ArrayListMultimap.create();
    multimap.put("a","hello");
    multimap.put("a", "ffff");
    multimap.put("b", "sfd");

    System.out.println(Arrays.toString(multimap.get("a").toArray()));
  }
}
