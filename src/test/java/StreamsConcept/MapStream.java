package StreamsConcept;

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
                //To manuplate your steam use map method in streams
                .map(upper -> upper.toUpperCase())
                .forEach(printName -> System.out.println(printName));
    }

    @Test(enabled = false)
    public void toUpperCase() {
        //Consider already having an array of Strings 'names' convert it to stream then do the manipulation
        List<String> names = Arrays.asList("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob");
        names.stream().sorted().map(String::toUpperCase).forEach(System.out::println); //Lambda express replaced with method reference
    }

    // Merge two stream into single stream
    @Test(enabled = false)
    public void streamConcat() {
        ArrayList<String> devList = new ArrayList<String>();
        devList.add("Mani");
        devList.add("Blossom");
        devList.add("Karthik");
        devList.add("Rob");

        List<String> qaList = Arrays.asList("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob");

        Stream<String> appSquadList = Stream.concat(devList.stream(), qaList.stream());
        appSquadList.sorted().forEach(System.out::println);

        //find the matching value inside the stream
        boolean flag = devList.stream().anyMatch(s -> s.equalsIgnoreCase("Rob"));
        Assert.assertTrue(flag);

    }

    //Collect method - once the stream manipulation is done. Convert the stream back to List, Set or Map for further validation
    @Test(enabled = false)
    public void streamCollect() {
        List<String> qaList = Arrays.asList("Arun", "Johnoson", "Aathi", "Tom", "Arulmozhi", "Bob", "Jaffer");
        List<String> modifiedList = qaList.stream().filter(s -> s.length() > 4).sorted().collect(Collectors.toList());
        System.out.println(modifiedList.get(2));
    }

    // Use integer stream to get unique values, sort then print particular index
    @Test(enabled = true)
    public void streamWithIntegers() {
        List<Integer> numberList = Arrays.asList(3, 5, 7, 1, 9, 2, 3, 0);
        // numberList.stream().distinct().sorted().limit(3).forEach(System.out::println);
        List<Integer> sortedList = numberList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(sortedList.get(5));
    }
}
