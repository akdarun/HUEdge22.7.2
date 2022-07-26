import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Consumer<Integer> sqrt = x -> System.out.println(Math.sqrt(x));
        Supplier<Long> supplier = () -> (long) (Math.random() * 10000000000L);
        Function<Integer, List<String>> function = integer -> Arrays.stream(String.valueOf(integer).split("")).collect(Collectors.toList());
        Predicate<String> predicate = s -> Long.valueOf(s) < 10000000000L && Long.valueOf(s) >= 0L;
        BiFunction<String, String, String> biFunc = (a, b) -> a + " " + b;
        BinaryOperator<Integer> maxBinOp = BinaryOperator.maxBy(Comparator.naturalOrder()); // or we can pass custom comparator
        BinaryOperator<Integer> minBinOp = BinaryOperator.minBy(Comparator.naturalOrder()); // or we can pass custom comparator
        UnaryOperator<Integer> square = x -> x * x;

        sqrt.accept(20);
        System.out.println(supplier.get());
        System.out.println(function.apply(789876));
        System.out.println(predicate.test(supplier.get().toString()));
        System.out.println(biFunc.apply("hello", "world"));
        System.out.println(maxBinOp.apply(2, 6) + " " + minBinOp.apply(2, 6));
        System.out.println(square.apply(5));
    }
}


@FunctionalInterface
interface DoJob {
    public int add(int a, int b);
}

interface ServiceIntf {
    method1();
    method2();
    method3();
}
class Service implements ServiceIntf {

}

@Autowired
private ServiceIntf service;


