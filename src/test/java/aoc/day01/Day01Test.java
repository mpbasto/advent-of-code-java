package aoc.day01;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Day01Test
{

    @Test
    public void givenInputLines_whenCalculatingCalibrationValue_thenCorrectValuesReturned( )
    {
        // Given
        List<String> inputLines = List.of( "1abc2",
                                           "pqr3stu8vwx",
                                           "a1b2c3d4e5f",
                                           "treb7uchet" );

        // When
        String actualResult = new Day01( ).part1( inputLines );

        // Then
        assertEquals( "142",
                      actualResult );
    }

    @Test
    public void givenEmptyInputLines_whenCalculatingCalibrationValue_thenThrowIllegalArgumentException( )
    {
        // Given
        List<String> emptyLines = List.of( "",
                                           "",
                                           "",
                                           "" );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day01( ).part1( emptyLines ) );

        // Then
        assertEquals( "Line is empty",
                      actualResult.getMessage( ) );
    }

    @Test
    public void givenInputLinesWithoutDigits_whenCalculatingCalibrationValue_thenThrowIllegalArgumentException( )
    {
        // Given
        List<String> linesWithoutDigits = List.of( "sdfghngfs",
                                                   "asggndf",
                                                   "creakeg",
                                                   "pogthbs" );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day01( ).part1( linesWithoutDigits ) );

        // Then
        assertEquals( "Line does not contain any digits",
                      actualResult.getMessage( ) );
    }

    @Test
    public void givenEmptyInput_whenCalculatingCalibrationValue_thenThrowIllegalArgumentException( )
    {

        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day01( ).part1( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );
    }

    @Test
    public void givenInputLinesWithSpelledOutDigits_whenCalculatingCalibrationValue_thenCorrectValuesReturned( )
    {
        // Given
        List<String> inputLines = List.of( "two1nine",
                                           "eightwothree",
                                           "abcone2threexyz",
                                           "xtwone3four",
                                           "4nineeightseven2",
                                           "zoneight234",
                                           "7pqrstsixteen" );

        // When
        String actualResult = new Day01( ).part2( inputLines );

        // Then
        assertEquals( "281",
                      actualResult );
    }

}
