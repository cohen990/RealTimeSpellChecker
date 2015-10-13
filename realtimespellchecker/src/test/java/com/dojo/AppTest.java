package com.dojo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSpellChecker_GivenOneString_SetsTrie()
    {
        List<String> words = new ArrayList<String>();
        words.add("test");
        SpellChecker checker = new SpellChecker(words);
        Trie trie = checker.trie;
        assertTrue(trie.head.hasChild('t'));
        assertTrue(trie.head.getChild('t').hasChild('e'));
        assertTrue(trie.head.getChild('t').getChild('e').hasChild('s'));
        assertTrue(trie.head.getChild('t').getChild('e').getChild('s').hasChild('t'));
    }

    public void testSpellChecker_Givenfoobargarbgae_ReturnsCorrection() throws IOException {
        String input =  "foobar\n" +
                        "garbgae";
        String expected =   "foob<ar\n" +
                            "garbg<ae";

        SpellChecker checker = new SpellChecker(Files.readAllLines(Paths.get("C:/enable1.txt")));

        String result = checker.Check(input);

        assertEquals(expected, result);
    }

    public void testSpellChecker_GivenChallengeInput_ReturnsCorrectOutput() throws IOException {
        String input =
                "accomodate\n" +
                "acknowlegement\n" +
                "arguemint \n" +
                "comitmment \n" +
                "deductabel\n" +
                "depindant\n" +
                "existanse\n" +
                "forworde\n" +
                "herrass\n" +
                "inadvartent\n" +
                "judgemant \n" +
                "ocurrance\n" +
                "parogative\n" +
                "suparseed";
        String expected =
                "accomo<date\n" +
                "acknowleg<ement\n" +
                "arguem<int \n" +
                "comitm<ment \n" +
                "deducta<bel\n" +
                "depin<dant\n" +
                "exista<nse\n" +
                "forword<e\n" +
                "herra<ss\n" +
                "inadva<rtent\n" +
                "judgema<nt \n" +
                "ocur<rance\n" +
                "parog<ative\n" +
                "supa<rseed";

        SpellChecker checker = new SpellChecker(Files.readAllLines(Paths.get("C:/enable1.txt")));

        String result = checker.Check(input);

        assertEquals(expected, result);
    }
}
