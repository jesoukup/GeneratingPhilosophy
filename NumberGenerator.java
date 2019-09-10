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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * This class generates numbers based on an arbitrary function and implements Iterable and Iterator
 * as well as Function.
 */
public class NumberGenerator<T, R>
                implements Iterable<Integer>, Iterator<Integer>, Function<Integer, Integer> {
    private Integer firstInt;
    private Integer lastInt;
    private Function<Integer, Integer> function;

    /**
     * Initializes a new NumberGenerator to return a number based on an arbitrary function each time
     * it's next() method is called. The first number returned in this way is firstInt.
     * <p>
     * After numberOfInts numbers have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfInts - the number of integers that can be generated
     * @param firstInt - the first number that will be generated
     * @throws IllegalArgumentException - when numberOfEvens is negative, or when firstEven is not
     *         an even number
     */
    public NumberGenerator(int numberOfInts, Integer firstInt, Function<Integer, Integer> function)
                    throws IllegalArgumentException {
        this.firstInt = firstInt;
        this.function = function;
        for (int i = 1; i < numberOfInts; i++) {
            Integer previousInt = firstInt;
            firstInt = function.apply(previousInt);
            this.lastInt = function.apply(previousInt);
        }
        if (numberOfInts < 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method is used by next() method for next() to check if it should keep going.
     */
    @Override
    public boolean hasNext() {
        return firstInt <= lastInt;
    }

    /**
     * This method return the next number.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // This throws an exception when firstInt becomes
                                                // greater than lastInt.
        }
        Integer previousInt = firstInt;
        firstInt = function.apply(previousInt);
        return previousInt;
    }

    /**
     * This method is needed so the iterator() method returns a this reference.
     */
    @Override
    public Iterator<Integer> iterator() {
        return this;
    }

    /**
     * This method applies an arbitrary function to Integer t.
     */
    @Override
    public Integer apply(Integer t) {
        return null;
    }
}
