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

/**
 * This class generates even numbers and implements Iterable and Iterator.
 */
public class EvenNumberGenerator implements Iterable<Integer>, Iterator<Integer> {
    private Integer firstEven;
    private Integer lastEven;

    /**
     * Initializes a new EvenNumberGenerator to return a single even number each time it's next()
     * method is called. The first even number returned in this way is firstEven. Subsequent even
     * numbers returned in this way will be the smallest even number that is larger than the
     * previous.
     * <p>
     * After numberOfEvens numbers have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfEvens - the number of evens that can be generated
     * @param firstEven - the first and smallest even that will be generated
     * @throws IllegalArgumentException - when numberOfEvens is negative, or when firstEven is not
     *         an even number
     */
    public EvenNumberGenerator(int numberOfEvens, Integer firstEven)
                    throws IllegalArgumentException {
        this.firstEven = firstEven;
        for (int i = 0; i < numberOfEvens; i++) {
            Integer previousEven = firstEven;
            firstEven = firstEven + 2;
            this.lastEven = previousEven;
        }
        if (firstEven % 2 != 0 || numberOfEvens < 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method is used by next() method for next() to check if it should keep going.
     */
    @Override
    public boolean hasNext() {
        return firstEven <= lastEven;
    }

    /**
     * This method return the next even number.
     */
    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // This throws an exception when firstEven becomes
                                                // greater than lastEven.
        }
        Integer previousInt = firstEven;
        firstEven = firstEven + 2;
        return previousInt;
    }

    /**
     * This method is needed so the iterator() method returns a this reference.
     */
    @Override
    public Iterator<Integer> iterator() {
        return this;
    }
}
