//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Generating Philosophy
// Files: jsoup-1.10.3.jar
// Course: CS 300, Term 1, Year 2
//
// Author: Joe Soukup
// Email: jsoukup2@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: KOMURAJI SINDE
// Partner Email: sinde@wisc.edu
// Lecturer's Name: Gary Dahl
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _x__ Write-up states that pair programming is allowed for this assignment.
// _x__ We have both read and understand the course Pair Programming Policy.
// _x__ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates
// strangers, etc do. If you received no outside help from either type of
// source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Scanner;
import java.util.function.Function;

/**
 * This class uses the NextWikiLinkFunction to loop through Wikipedia pages to find the Philosophy
 * page.
 */
public class Main {

    /**
     * This method takes a user input representing a Wikipedia page and loops through pages until it
     * gets to Philosophy.
     */
    public static void main(String[] args) {
        int counter = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a Wikipedia topic: "); // This asks for user input for the
                                                              // Wikipedia topic.
        String input = scan.nextLine();
        String newInput = "/wiki/" + input;
        newInput = newInput.replaceAll(" ", "_"); // This makes the user input compatible with the
                                                  // program.
        for (Object i : new Generator(100, newInput, new NextWikiLinkFunction())) {
            System.out.println(counter + ": " + i); // This prints out the current Wikipedia page.
            counter++;
            if (i.toString().equalsIgnoreCase("/wiki/Philosophy")) {
                System.exit(0); // This closes the program when Philosophy page is reached.
            }
            if (i.toString().equalsIgnoreCase("FAILED to find wikipedia page: " + newInput) || i
                            .toString().equalsIgnoreCase("FAILED to find a link in wikipedia page: "
                                            + newInput)) {
                System.exit(0); // This closes the program if the program fails to find the page or
                                // a link in the page.
            }
        }
        scan.close();
    }
}


/**
 * This class implements Function to return input multiplied by two.
 */
class DoubleFunction<T, R> implements Function<Integer, Integer> {

    /**
     * This method takes an Integer t and returns t multiplied by two.
     */
    @Override
    public Integer apply(Integer t) {
        return t * 2;
    }
}


/**
 * This class implements Function to return input plus !.
 */
class AddExclamationFunction<T, R> implements Function<String, String> {

    /**
     * This method takes a String t and returns t plus !.
     */
    @Override
    public String apply(String t) {
        return t + "!";
    }
}
