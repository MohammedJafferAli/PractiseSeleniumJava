package concepts;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Instruction - By default all the tests are disable, change the value to 'true' to run the test.
public class MapStream {

    @Test(priority = 1, enabled = false)
    public void filterNConvert() {
        Stream.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob")
                .filter(name -> name.endsWith("i"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test(enabled = false)
    public void toUpperCase() {
        var names = List.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob");
        names.stream().sorted().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test(enabled = false)
    public void streamConcat() {
        var devList = new ArrayList<String>();
        devList.add("Mani");
        devList.add("Blossom");
        devList.add("Karthik");
        devList.add("Rob");

        var qaList = List.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob");

        var appSquadList = Stream.concat(devList.stream(), qaList.stream());
        appSquadList.sorted().forEach(System.out::println);

        boolean flag = devList.stream().anyMatch(s -> s.equalsIgnoreCase("Rob"));
        Assert.assertTrue(flag);
    }

    @Test(enabled = false)
    public void streamCollect() {
        var qaList = List.of("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob", "Jaffer");
        var modifiedList = qaList.stream().filter(s -> s.length() > 4).sorted().collect(Collectors.toList());
        System.out.println(modifiedList.get(2));
    }

    @Test(enabled = true)
    public void streamWithIntegers() {
        var numberList = List.of(3, 5, 7, 1, 9, 2, 3, 0);
        var sortedList = numberList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedList.get(5));
    }
}
