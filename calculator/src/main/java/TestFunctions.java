import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestFunctions {
    public static void main(String[] args) {
        // inner class -> instance
        // анонимный внутренний класс
        CallbackConsumer<String> call = (arg) -> System.out.println(arg);
        CallbackConsumer<String> call1 = System.out::println;
        System.out.println(call.getClass());
        System.out.println(call1.getClass());
        call1.call("Hello world");

        Consumer<String> consumer = x -> {};
        Predicate<Integer> predicate = arg -> arg % 2 == 0;
        Function<String, Integer> mapper = String::length;
        Supplier<ArrayList<String>> getter = ArrayList::new;

    }
}
