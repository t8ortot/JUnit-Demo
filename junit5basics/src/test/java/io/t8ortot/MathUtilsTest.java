package io.t8ortot;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static  org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When running MathUtils")
class MathUtilsTest extends Object {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){

        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("Add method")
    @Tag("Math")
    class AddTest{
        @Test
        @DisplayName("Testing positive add function")
        void testAddPositive(){
            int expected = 2;
            int actual = mathUtils.add(1,1);
            assertEquals(expected, actual, "The add method should add two numbers");
        }

        @Test
        @DisplayName("Testing negative add function")
        void testAddNegative(){
            int expected = -2;
            int actual = mathUtils.add(-1,-1);
            assertEquals(expected, actual, "The add method should add two numbers");
        }
    }


    @Test
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Math")
    void testDivide(){

        boolean isServerUp = false;

        //assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide by zero should throw");

    }


    @RepeatedTest(3)
    @Tag("Circle")
    void testComputerCircleRadius() {

        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @DisplayName("Multiply method")
    @Tag("Math")
    void testMultiply(){

        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        assertEquals(4, mathUtils.multiply(2, 2), "should return right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2, 2)),
                () -> assertEquals(0, mathUtils.multiply(2, 0)),
                () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    //@Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled(){

        //fail("This test should be disabled");
    }
}