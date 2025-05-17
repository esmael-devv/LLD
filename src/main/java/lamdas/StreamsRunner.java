package lamdas;

import java.util.ArrayList;
import java.util.List;

public class StreamsRunner {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,4,5,7,32);
        for (Integer i : list) {
            System.out.println(i);
        }

        //create a stream from collection
        list.stream().forEach(System.out::println);
        list.stream().forEach(value -> System.out.println(value*value));

        List<Integer> evenNumbers = list
                .stream()
                .filter(val -> val % 2 == 0)
                .toList();
        System.out.println(evenNumbers);

        list
                .stream()
                .map(val -> val * val* val)
                .toList()
                .forEach(System.out::println);
    }
}
