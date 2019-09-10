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

import java.io.IOException;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NextWikiLinkFunction<T, R> implements Function<String, String> {
    @Override
    public String apply(String t) {
        try {
            // Download a Wikipedia page, using t in their internal link format: /wiki/Some_Subject
            Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
            // Use .css selector to retrieve a collection of links from this page's description
            // "p a" selects links within paragraphs
            // ":not(span a)" skips pronunciations
            // ":not(sup a)" skips citations
            Elements links = doc.select("p a[href*=\"/wiki/\"]:not(span a):not(sup a)");
            // return the link attribute from the first element of this list
            return links.get(0).attr("href");
            // Otherwise return an appropriate error message:
        } catch (IOException | IllegalArgumentException e) {
            return "FAILED to find wikipedia page: " + t;
        } catch (IndexOutOfBoundsException e) {
            return "FAILED to find a link in wikipedia page: " + t;
        }
    }
}
