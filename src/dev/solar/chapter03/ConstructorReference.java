package dev.solar.chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {
    public static void main(String[] args) {
        Object apple;

        // 1. 기본 생성자 참조
        Supplier<Apple> c1;
//        c1 = () -> new Apple();
        c1 = Apple::new;
        apple = c1.get();
        System.out.println("Supplier Apple : " + apple);

        // 2. 하나의 매개변수 생성자 참조
        Function<Integer, Apple> c2;
//        c2 = (weight) -> new Apple(weight);
        c2 = Apple::new; //Apple(Integer weight) 생성자 참조
        apple = c2.apply(110);
        System.out.println("Function Apple : " + apple);

        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        apples.forEach(System.out::println);

        // 3. 두 개의 매개변수 생성자 참조
        BiFunction<Integer, Color, Object> c3;
//        c3 = (weight, color) -> new Apple(weight, color);
        c3 = Apple::new;//Apple(String color, Integer weight) 생성자 참조
        apple = c3.apply( 200, Color.RED);
        System.out.println("BiFunction Apple : " + apple);

        // 4. 3 개의 매개변수 생성자 참조 -> 직접 구현해야 한다.
        TriFunction<Color, Integer, String, Apple> c4;
//        c4 = (color, weight, area) -> new Apple(color, weight, area);
        c4 = Apple::new; //Apple(final String color, final Integer weight, final String area) 생성자 참조
        apple = c4.apply(Color.GREEN, 140, "대구");
        System.out.println("TriFunction Apple : " + apple);

    }

    public static List<Apple> map(List<Integer> weights, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer weight : weights) {
            result.add(f.apply(weight));
        }
        return result;
    }

    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);
    }
}
