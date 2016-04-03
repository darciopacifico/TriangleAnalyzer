package com.dlp.triangleanalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Console client for triangle analyzer
 * Created by dpacif1 on 4/3/16.
 */
public class SimpleConsoleClient {
    private static Logger log = LoggerFactory.getLogger(SimpleConsoleClient.class);
    private final PrintStream out;
    /**
     * Scanner instance, listening to given inputStream
     */
    private Scanner sc;

    /**
     * Creates an SimpleConsoleClient based on given InputStream
     *
     * @param in
     */
    public SimpleConsoleClient(InputStream in, PrintStream out) {
        this.sc = new Scanner(in);
        this.out = out;
    }

    /**
     * Start client for cliente analyzer
     *
     * @param args
     */
    public static void main(String[] args) {
        log.debug("Starting simple console application!");

        SimpleConsoleClient scc = new SimpleConsoleClient(System.in, System.out);

        log.debug("Starting console! Listening to inputStream!");
        scc.startConsole();
    }

    /**
     * Start Simple console client, consuming commands and inputs from this.sc (scanner)
     */
    public void startConsole() {


        List<Double> triangleSides = new ArrayList<Double>(3);
        out.println("Triangle analyzer:");
        char sideChar = 'A';

        out.print("Please, enter side " + sideChar + " (positive double): ");

        log.debug("OK! Waiting for some entrie!");
        while (this.sc.hasNext()) {

            if (this.sc.hasNextDouble()) {
                double side = this.sc.nextDouble();

                //validate side entry
                if(side>0){
                    triangleSides.add(side);
                    sideChar++;
                }else{
                    log.warn("Not a valid entry! {}", side);
                    out.println("Please, enter a valid positive double!");
                }

                //consumes entries and reset program
                if (triangleSides.size() == 3) {
                    callTriangleAnalyzer(triangleSides);

                    sideChar = 'A';
                    triangleSides.clear();
                    out.println("");
                }
            } else {
                log.warn("Not a valid entry! Not double!");
                //if entry is not a double
                String anyVal = this.sc.next();
                out.println("'"+anyVal+"' is not a valid double Value!" );
                out.println();
            }
            //ask for a new entry
            out.print("Please, enter side " + sideChar + " (positive double): ");
        }
    }

    /**
     * Simply call triangle analyzer. Catch any possible exception
     * @param triangleSides
     */
    private void callTriangleAnalyzer(List<Double> triangleSides) {
        try {

            ETriangleType tType = TriangleAnalyzerUtil.analyzeTriangle(
                    triangleSides.get(0),
                    triangleSides.get(1),
                    triangleSides.get(2));

            out.println("Triangle type is: "+tType);

        } catch (Exception e) {
            log.error("Error trying to analyze triangle!", e);
            out.println("Error trying to determinate triangle type! "+e.getMessage());
            e.printStackTrace();
        }

        out.println();
    }


}
