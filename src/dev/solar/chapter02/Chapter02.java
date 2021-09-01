package dev.solar.chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Chapter02 {
        public static void main(String[] args) {
            Apple apple01 = new Apple("red", 12);
            Apple apple02 = new Apple("green", 10);
            Apple apple03 = new Apple("green", 11);
            List<Apple> inventory = Arrays.asList(apple01, apple02, apple03);

            // 동작파라미터화 방법 3가지
            //1. 인터페이스와 구현체
            System.out.println("===== 1. 인터페이스와 구현체 ===========================");
            Apple.prettyPrintApple(inventory, new AppleSimpleFormatter());

            //2. 익명객체 사용
            System.out.println("==== 2. 익명객체 사용 ============================");
            Apple.prettyPrintApple(inventory, new AppleFormatter() {

                @Override
                public String accept(final Apple a) {
                    return "A " + a.getColor() + " color apple!";
                }
            });

            //3. 람다 사용
            System.out.println("===== 3. 람다 사용 ===========================");
            Apple.prettyPrintApple(inventory, (Apple a) -> "A " + a.getColor() + " color apple!");

            // 4. 제네릭과 리스트
            System.out.println("===== 4. 제네릭과 리스트 ===========================");
            // 4.1 - 빨간사과 필터링
            List<Apple> filteredApples = filter(inventory, (Apple a) -> "red".equals(a.getColor()));
            filteredApples.stream().forEach((Apple a) -> System.out.println(a.getColor()));

            // 4.2 - 짝수 필터링
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
            List<Integer> filteredNumbers = filter(numbers, (Integer number) -> number % 2 == 0);
            filteredNumbers.stream().forEach(System.out::println);

            // 실전예제
            // 1. Comparator로 정렬하기
            System.out.println("===== 1. Comparator로 정렬하기 ===========================");
            inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
            inventory.stream().forEach((Apple a) -> System.out.println(a.getWeight() + ", " + a.getColor()));

            System.out.println("===== 역순 정렬 ===========================");
            inventory.sort((Apple a1, Apple a2) -> {
                return a2.getWeight() - a1.getWeight();
            });
            inventory.stream().forEach((Apple a) -> System.out.println(a.getWeight() + ", " + a.getColor()));

            System.out.println("===== 색상 정렬 ===========================");
            inventory.sort(Comparator.comparing(Apple::getColor));
            inventory.stream().forEach((Apple a) -> System.out.println(a.getWeight() + ", " + a.getColor()));

            // 2. Runnable로 코드 블록 실행하기
            System.out.println("===== 2. Runnable로 코드 블록 실행하기 ===========================");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hi~~~");
                }
            });
            t.run();

            Thread t2 = new Thread(() -> System.out.println("Hello !!!!"));
            t2.run();

            // 3. Callable을 결과로 반환하기
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<String> threadName = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return Thread.currentThread().getName();
                }
            });
            threadName = executorService.submit(() -> Thread.currentThread().getName());
        }

        public static <T> List<T> filter(List<T> list, Predicate<T> p) {
            List<T> result = new ArrayList<>();
            for (T e : list) {
                if (p.test(e)) {
                    result.add(e);
                }
            }
            return result;
        }
}
