package StreamsConcept;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class FilterStream {

    @Test(priority = 1)
    public void filterStream() {
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Arun");
        nameList.add("Johnoson");
        nameList.add("Aathi");
        nameList.add("Tom");
        nameList.add("Arulmozhi");
        nameList.add("Bob");

        //Filter the list with name starts with letter A and get the count
        Long count = nameList.stream().filter(name -> name.startsWith("A")).count();
        System.out.println(count);
    }

    @Test(priority = 2)
    public void createSubStream() {
        Stream.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob")
                .filter(name -> name.length() > 3)
                .sorted()
                .forEach(printname -> System.out.println(printname));
    }

    @Test(priority = 3)
    public void limitResults() {
        Stream.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob")
                .filter(name -> name.length() > 3)
                .sorted()
                .limit(1)
                .forEach(printname -> System.out.println(printname));
    }
}
