package org.enricogiurin.ocp17.ch10;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Questions {

    public static void main(String[] args) {
        new Questions().iterate2();
    }

    void iterate() {
        var stream = Stream.iterate("", (s) -> s + "1");
        System.out.println(stream.limit(2).map(x -> x + "2"));
    }

    void noneMatch() {
        Predicate<String> predicate = s -> s.length() > 3;
        var stream = Stream.iterate("", s -> !s.isEmpty(), (s) -> s + s);
        var b1 = stream.noneMatch(predicate);
        //stream can't be re-used.
        //this line generates an java.lang.IllegalStateException
        var b2 = stream.anyMatch(predicate);
        System.out.println(b1 + " " + b2);
    }

    void intStream() {
        var is = IntStream.empty();
        OptionalDouble optionalDouble = is.average();
        optionalDouble.ifPresent(System.out::println);
        is = IntStream.empty();
        OptionalInt optionalInt = is.findAny();
        optionalInt.ifPresent(System.out::println);
        is = IntStream.empty();
        int sum = is.sum();
        System.out.println(sum);
    }

    void longStream() {
        var stream = LongStream.of(1, 2, 3);
        OptionalLong optionalLong = stream.map(n -> n * 10)
                .filter(n -> n < 5).findFirst();
        if (optionalLong.isPresent()) System.out.println(optionalLong.getAsLong());
    }

    void generate() {
        Stream<String> stream = Stream.generate(() -> "1");
        stream.limit(10).forEach(System.out::println);
    }

    void iterate2() {
        String result = Stream.iterate(1, x -> ++x)
                .limit(5)
                .map(x -> "" + x)
                .collect(Collectors.joining());
        System.out.println(result);
    }

    void boxed() {

        IntStream intStream = IntStream.of(1, 2, 3);
        Stream<Integer> boxed = intStream.boxed();

    }

    void collectBy() {
        Predicate<String> empty = String::isEmpty;
        Predicate<String> notEmpty = empty.negate();

        Stream<List<String>> result = Stream.generate(() -> "")
                .limit(10)
                .filter(notEmpty)
                .collect(Collectors.groupingBy(k -> k))
                .entrySet()
                .stream()
                .map(Map.Entry::getValue);
    }
}
