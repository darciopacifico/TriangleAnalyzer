package com.dlp.triangleanalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test triangle analyzer utils
 * Created by dpacif1 on 4/3/16.
 */
@Test
public class TriangleAnalyzerTest {

    /**
     * Test triangle analyzer
     */
    public void testCommonCases() {
        //common cases
        ETriangleType type1 = TriangleAnalyzerUtil.analyzeTriangle(3, 4, 5);
        Assert.assertEquals(type1, ETriangleType.SCALENE);

        ETriangleType type2 = TriangleAnalyzerUtil.analyzeTriangle(10, 10, 10);
        Assert.assertEquals(type2, ETriangleType.EQUILATERAL);

        ETriangleType type3 = TriangleAnalyzerUtil.analyzeTriangle(30, 30, 20);
        Assert.assertEquals(type3, ETriangleType.ISOSCELES);
    }

    /**
     * Test invalid entries, zero
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidEntries_zero() {
        ETriangleType type1 = TriangleAnalyzerUtil.analyzeTriangle(3, 0, 0);

        Assert.fail("should not reach this point... Triangle has invalid sides!");
    }

    /**
     * Test invalid entries, negatives
     */
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidEntries_negative() {
        ETriangleType type1 = TriangleAnalyzerUtil.analyzeTriangle(3, -9, -10);

        Assert.fail("should not reach this point... Triangle has invalid sides!");
    }

}
