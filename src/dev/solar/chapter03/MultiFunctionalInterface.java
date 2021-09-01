package dev.solar.chapter03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntBiFunction;

public class MultiFunctionalInterface {
    public static void main(String[] args) {
        Apple apple01 = new Apple( 12, Color.RED);
        Apple apple02 = new Apple( 10, Color.GREEN);
        Apple apple03 = new Apple( 11, Color.GREEN);
        List<Apple> inventory = Arrays.asList(apple01, apple02, apple03);

        // 같은 람다, 다른 함수형 인터페이스
        Comparator<Apple> c1 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        ToIntBiFunction<Apple, Apple> c2 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());
        BiFunction<Apple, Apple, Integer> c3 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        // 형식 추론
        Comparator<Apple> c4 = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()); //형식 추론하지 않음
        Comparator<Apple> c5 = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight()); //형식을 추론함



        // 메서드 참조
        Comparator<Apple> c6 = Comparator.comparing(Apple::getWeight);
    }
}
