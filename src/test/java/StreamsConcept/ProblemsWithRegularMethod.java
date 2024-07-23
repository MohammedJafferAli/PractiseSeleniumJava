package StreamsConcept;

/*
*What is stream?
* Stream API is used to process collections of objects.
*  A stream in Java is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
*
* Operations in Streams:
1.Creating stream - Either the existing array to stream or create a new Stream
2. Intermediate Operations
3. Terminate Operations
*
Goal
1. From the given arraylist get the count of elements/values matching with starting letter 'A'
*
*
*
* */

import java.util.ArrayList;

public class ProblemsWithRegularMethod {

    public static void main(String[] args) {

        int count = 0;
        ArrayList<String> nameList = new ArrayList<String>();
        nameList.add("Arun");
        nameList.add("Johnoson");
        nameList.add("Aathi");
        nameList.add("Tom");
        nameList.add("Arulmozhi");
        nameList.add("Bob");

        for (String name :nameList)
        {
            if (name.startsWith("A"))
            {
                count++;
            }

        }
        System.out.println(count);

    }
}
