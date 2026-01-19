package concepts;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FilterStream {

    @Test(priority = 1)
    public void filterStream() {
        var nameList = new ArrayList<String>();
        nameList.add("Arun");
        nameList.add("Johnoson");
        nameList.add("Aathi");
        nameList.add("Tom");
        nameList.add("Arulmozhi");
        nameList.add("Bob");

        long count = nameList.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);
    }

    @Test(priority = 2)
    public void createSubStream() {
        Stream.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob")
                .filter(name -> name.length() > 3)
                .sorted()
                .forEach(System.out::println);
    }

    @Test(priority = 3)
    public void limitResults() {
        Stream.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob")
                .filter(name -> name.length() > 3)
                .sorted()
                .limit(1)
                .forEach(System.out::println);
    }
}
