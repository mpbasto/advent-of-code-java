package aoc.day03;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Day03Test
{

    @Test
    public void givenInput_whenCalculatingSum_thenReturnExpectedResult( )
    {
        // Given
        List<String> input = List.of( "467..114..",
                                      "...*......",
                                      "..35..633.",
                                      "......#...",
                                      "617*......",
                                      ".....+.58.",
                                      "..592.....",
                                      "......755.",
                                      "...$.*....",
                                      ".664.598.." );

        // When
        String result = new Day03( ).part1( input );

        // Then
        assertEquals( "4361",
                      result );
    }

    @Test
    public void givenEmptyInput_whenCalculatingSum_thenThrowError( )
    {
        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day03( ).part1( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );

    }

    @Test
    public void givenNoPartNumbers_whenCalculateSum_thenReturnsZero( )
    {
        // Given
        List<String> input = List.of( "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      ".........." );

        // When
        String result = new Day03( ).part1( input );

        // Then
        assertEquals( "0",
                      result );
    }

    @Test
    public void givenInput_whenCalculatingSumOfRatios_thenReturnExpectedResult( )
    {
        // Given
        List<String> input = List.of( "467..114..",
                                      "...*......",
                                      "..35..633.",
                                      "......#...",
                                      "617*......",
                                      ".....+.58.",
                                      "..592.....",
                                      "......755.",
                                      "...$.*....",
                                      ".664.598.." );

        // When
        String result = new Day03( ).part2( input );

        // Then
        assertEquals( "467835",
                      result );
    }

    @Test
    public void givenEmptyInput_whenCalculatingSumOfRatios_thenThrowError( )
    {
        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day03( ).part2( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );

    }

    @Test
    public void givenNoPartNumbers_whenCalculateSumOfRatios_thenReturnsZero( )
    {
        // Given
        List<String> input = List.of( "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      "..........",
                                      ".........." );

        // When
        String result = new Day03( ).part2( input );

        // Then
        assertEquals( "0",
                      result );
    }
}