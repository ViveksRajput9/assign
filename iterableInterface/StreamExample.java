package iterableInterface;

import java.util.*;
interface gg{
	
}
interface ss extends gg{
	
}
public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Stream loop using forEach()
        names.stream().forEach(System.out::println);
        System.out.println(names.size());
    }
}
