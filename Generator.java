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
 * This class generates objects based on an arbitrary function and implements Iterable and Iterator
 * as well as Function.
 */
public class Generator<T> implements Iterable<T>, Iterator<T>, Function<T, T> {
    private T firstObj;
    private Function<T, T> function;
    private int counter;

    /**
     * Initializes a new Generator to return an object based on an arbitrary function each time it's
     * next() method is called. The first object returned in this way is firstObj.
     * <p>
     * After numberOfObj objects have been generated and returned from this next() method, the
     * generator will end: its hasNext() method will return false, and its next() method will throw
     * a NoSuchElementException when called after this point.
     * 
     * @param numberOfObj - the number of objects that can be generated
     * @param firstObj - the first object that will be generated
     * @throws IllegalArgumentException - when numberOfEvens is negative, or when firstEven is not
     *         an even number
     */
    public Generator(int numberOfObj, T firstObj, Function<T, T> function)
                    throws IllegalArgumentException {
        this.firstObj = firstObj;
        this.counter = numberOfObj;
        this.function = function;
        if (numberOfObj < 0) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * This method is used by next() method for next() to check if it should keep going.
     */
    public boolean hasNext() {
        return counter > 0;
    }

    /**
     * This method return the next object.
     */
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // This throws an exception when counter becomes
                                                // equal to or less than zero.
        }
        counter--;
        T previousObj = firstObj;
        firstObj = function.apply(previousObj);
        return previousObj;
    }

    /**
     * This method is needed so the iterator() method returns a this reference.
     */
    @Override
    public Iterator<T> iterator() {
        return this;
    }

    /**
     * This method applies an arbitrary function to Object t.
     */
    @Override
    public T apply(T t) {
        return null;
    }

}
