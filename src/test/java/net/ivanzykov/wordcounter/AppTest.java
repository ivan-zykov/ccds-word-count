package net.ivanzykov.wordcounter;

import net.ivanzykov.wordcounter.wordcount.CriticalAppException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        // Capture printing to console
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        // Restore standard out
        System.setOut(standardOut);
    }

    @Test
    void main_usersInputFromConsole_countsNineAllAndSevenUniqueWords() {
        // Prepare user's input
        InputStream standardIn = System.in;
        String usersInput = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        InputStream inputStream = new ByteArrayInputStream(usersInput.getBytes());
        System.setIn(inputStream);

        // Run this test
        App.main(new String[]{});

        assertEquals("Enter text: Number of words: 9, unique: 7", outputStreamCaptor.toString().trim());

        // Restore standard in
        System.setIn(standardIn);
    }

    @Test
    void main_tooManyArgs_throwsException() {
        Exception exception = assertThrows(CriticalAppException.class, () ->
                App.main(new String[]{"one", "two"}));

        assertEquals("Wrong number of arguments. Only one is supported.",
                exception.getMessage());
    }

    @Test
    void main_usersInputFromFile_countsFourAllAndFourUniqueWords() {
        // Run this test
        App.main(new String[]{"mytext.txt"});

        assertEquals("Number of words: 4, unique: 4", outputStreamCaptor.toString().trim());
    }

    @Test
    void main_usersInputFileNotFound_throwsCriticalException() {
        Exception exception = assertThrows(CriticalAppException.class, () ->
                App.main(new String[]{"wrongFile"}));

        assertEquals("File with user's input not found.", exception.getMessage());
    }
}
