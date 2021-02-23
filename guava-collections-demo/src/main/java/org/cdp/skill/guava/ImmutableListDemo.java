package org.cdp.skill.guava;

import com.google.common.collect.ImmutableList;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;

public class ImmutableListDemo {
  public static void main(String[] args) {
    ImmutableList<String> test1 = ImmutableList.of(
      "hello"
      , "java"
      , "scala"
      , "golang"
      , "shell"
      , "linux"
    );

    System.out.println("ImmutableList<String>: " + test1);

    test1
      .stream()
      .sorted()
      .forEach(System.out::println);


    ImmutableList<Integer> test2 = ImmutableList.of();
    int test3 = test2
      .stream()
      .reduce(Integer::sum)
      .orElse(0);
  }
}
