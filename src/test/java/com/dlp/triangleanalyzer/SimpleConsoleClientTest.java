package com.dlp.triangleanalyzer;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Tests for SimpleConsoleClient
 * Created by dpacif1 on 4/3/16.
 */
@Test
public class SimpleConsoleClientTest {

    /**
     * Test triangle analyzer
     */
    public void testConsoleNormalPath() {

        final String mockEntries = " 22 \n 22 \n 22 ";
        InputStream in = new ByteArrayInputStream(mockEntries.getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream pOut = new PrintStream(baos);

        SimpleConsoleClient scc = new SimpleConsoleClient(in,pOut);
        scc.startConsole();
        Assert.assertTrue(baos.toString().contains("EQUILATERAL"), "Simple console doesn't print correct result");
    }

    /**
     * Test triangle analyzer
     */
    public void testConsoleInvalidDouble() {

        final String mockEntries = " 22 \n 22 \n -22 ";
        InputStream in = new ByteArrayInputStream(mockEntries.getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream pOut = new PrintStream(baos);

        SimpleConsoleClient scc = new SimpleConsoleClient(in,pOut);
        scc.startConsole();

        Assert.assertTrue(baos.toString().contains("Please, enter a valid positive double"), "Simple console doesn't treat invalid input correctly!");
    }

    /**
     * Test triangle analyzer
     */
    public void testConsoleInvalidEnter() {
        final String mockEntries = " 22 \n 22 \n -22wrongentry ";
        InputStream in = new ByteArrayInputStream(mockEntries.getBytes());

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream pOut = new PrintStream(baos);

        SimpleConsoleClient scc = new SimpleConsoleClient(in,pOut);
        scc.startConsole();

        Assert.assertTrue(baos.toString().contains("'-22wrongentry' is not a valid double Value!"), "Simple console doesn't treat invalid input correctly!");
    }
}
