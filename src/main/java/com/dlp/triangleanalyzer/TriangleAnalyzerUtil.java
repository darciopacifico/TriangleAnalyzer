package com.dlp.triangleanalyzer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

/**
 * Contain rules for triangle analysis
 * Created by dpacif1 on 4/3/16.
 */
public class TriangleAnalyzerUtil {
    private static Logger log = LoggerFactory.getLogger(TriangleAnalyzerUtil.class);

    /**
     * This class should not be instantiated
     */
    private TriangleAnalyzerUtil() {
    }

    /**
     * Analyze a b c triangle side entries in order to return triangle type
     *
     * @param a
     * @param b
     * @param c
     * @return #ETriangleType
     */
    public static ETriangleType analyzeTriangle(double a, double b, double c) {
        log.debug("Analyzing triangle {}, {}, {}!", a, b, c);

        if (a <= 0 || b <= 0 || c <= 0) {
            log.error("Error trying to analyze triangle {}, {}, {}! Invalid Entries!", a, b, c);
            throw new IllegalArgumentException(
                    MessageFormat.format("All triangle sides should be greater than zero! a:{}, b:{}, c:{}", a, b, c));
        }

        ETriangleType tType;

        if (a == b && b == c && a == c)
            tType = ETriangleType.EQUILATERAL;
        else if (a == b || b == c || a == c)
            tType = ETriangleType.ISOSCELES;
        else
            tType = ETriangleType.SCALENE;

        log.debug("Triangle {}, {}, {} is {} !", a, b, c, tType);
        return tType;
    }

}
