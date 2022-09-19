import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Assignment1Test<assignment1> {
    private Assignment1 assignment1;
    private ByteArrayOutputStream errorMessage;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before //Setting up the testing environment to run the tests properly
    public void setUp() {
        assignment1 = new Assignment1();
        assignment1.populateList();
        errorMessage = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errorMessage));

        System.setOut(new PrintStream(outputStreamCaptor)); // Redirecting the System.out.println() to a printstream

    }

    @After //Returning the program to normal settings after testing
    public void tearDown() {
        System.setErr(System.err);

        System.setOut(standardOut); // Restoring the System.out.println() method to normal

    }

//    @BeforeClass

//    @AfterClass

    @Test  //Testing that the program is importing all 10 entries from the Melbnb.csv file
    public void testPopulateList() {
        assertEquals(10, assignment1.getAllPropertiesList().size());
    }

    @Test //Testing that the search for "south" and "South" returns 3 results
    public void testSearchByLocation1() {
        // Testing to make sure case is ignored in search
        Assert.assertEquals(3, assignment1.searchByLocation(new ByteArrayInputStream("south".getBytes())).size());
        Assert.assertEquals(3, assignment1.searchByLocation(new ByteArrayInputStream("South".getBytes())).size());
    }

    @Test //Testing that the search for "dock" and "Dock" returns 3 results
    public void testSearchByLocation2() {
        // Testing to make sure case is ignored in search
        Assert.assertEquals(3, assignment1.searchByLocation(new ByteArrayInputStream("dock".getBytes())).size());
        Assert.assertEquals(3, assignment1.searchByLocation(new ByteArrayInputStream("Dock".getBytes())).size());
    }

    @Test //Testing the number of properties returned with a rating above 4.75
    public void testSearchByRating1() {
        Assert.assertEquals(2, assignment1.searchByRating(new ByteArrayInputStream("4.75".getBytes())).size());
        // THere are two properties with ratings higher than 4.75 so there should be 2 results
    }

    @Test //Testing the number of properties returned with a rating above 4
    public void testSearchByRating2() {
        Assert.assertEquals(6, assignment1.searchByRating(new ByteArrayInputStream("4".getBytes())).size());
        // THere are 6 properties with ratings higher than 4 so there should be 6 results
    }

    @Test // Testing if the saveProperty method correctly saves returns a single property for saving
    // Taking user selection of "5" and returning a single property
    public void testSaveProperty() {
        assertNotNull(assignment1.saveProperty(assignment1.getAllPropertiesList(), new ByteArrayInputStream("5".getBytes())));
    }

    @Test //Checking if a response outside the number of options should return nothing
    public void testSaveProperty2() {
        assertNull(assignment1.saveProperty(assignment1.getAllPropertiesList(), new ByteArrayInputStream("11".getBytes())));
    }

    @Test //Testing that the method will return a date object in the correct format in the future
    public void testretreiveDateFromUser() {
        assertNotNull(assignment1.retrieveDateFromUser(new ByteArrayInputStream("11/02/2023".getBytes())));
    }

    @Test // Testing if the method returns the correct integers based on user input
    public void testInputCheckerCorrect() {
        assertEquals(1, assignment1.checkSelectionInt(5, new ByteArrayInputStream("1".getBytes())));
        assertEquals(2, assignment1.checkSelectionInt(5, new ByteArrayInputStream("2".getBytes())));
        assertEquals(3, assignment1.checkSelectionInt(5, new ByteArrayInputStream("3".getBytes())));
        assertEquals(4, assignment1.checkSelectionInt(5, new ByteArrayInputStream("4".getBytes())));
        assertEquals(5, assignment1.checkSelectionInt(5, new ByteArrayInputStream("5".getBytes())));
    }

//    @Test  //Test of user entering a string rather than an integer
//    public void testInputCheckerInt() {
//        assignment1.checkSelectionInt(5, new ByteArrayInputStream("abc".getBytes()));
//        Assert.assertEquals("- This is not an integer, Try again.", outputStreamCaptor.toString());
//
//    }
//
//    @Test // Testing if the method returns user responses that are out of bounds
//    public void testInputCheckerOutOfBounds() {
//        assertEquals(0, assignment1.checkSelectionInt(5, new ByteArrayInputStream("0".getBytes())));
//    }
}