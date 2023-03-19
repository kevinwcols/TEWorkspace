package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExercisesTest {

    private Exercises sut;
    @Before
    public void init() {
        sut = new Exercises();
    }

    @Test
    public void findMaxValue_with_all_positive_numbers(){
        // Arrange

        int[] input = new int[] {1,2,3,4,5};
        int expected = 5;

        // Act
        int actual = sut.findMaxValue(input);

        // Assert
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findMaxValue_with_largest_as_first_all_positive(){
        // Arrange

        int[] input = new int[] {5,4,3,2,1};
        int expected = 5;

        // Act
        int actual = sut.findMaxValue(input);

        // Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findMaxValue_with_all_negative_numbers() {
        // Arrange
        int[] input = new int[] {-8,-4,-9,-15,-3};
        int expected = -3;

        // Act
        int actual = sut.findMaxValue(input);

        // Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findMaxValue_null_input(){
        // Arrange
        int[] input = null;
        int expected = 0;

        // Act
        int actual = sut.findMaxValue(input);

        // Assert
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void findMaxValue_empty_array(){
        // Arrange
        int[] input = new int[0]; // empty array
        int expected = 0;

        // Act
        int actual = sut.findMaxValue(input);

        // Assert
        Assert.assertEquals("I passed in an empty array, expecting 0",expected,actual);
    }

    @Test(expected = NullPointerException.class)
    public void findMaxValue_with_null_input_and_error_return() {
        // Arrange
        int[] input = null;

        // Act
        sut.findMaxValue(input);
    }
}
