package aoc.day02;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Day02Test
{
    @Test
    public void givenInput_whenDeterminingPossibleGames_thenCorrectGameIdSumReturned( )
    {
        // Given
        List<String> input = List.of( "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                                                             "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                                                             "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                                                             "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                                                             "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" );

        // When
        String result = new Day02( ).part1( input );

        // Then
        assertEquals( "8",
                      result );
    }

    @Test
    public void givenEmptyInput_whenDeterminingPossibleGames_thenThrowIllegalArgumentException( )
    {

        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day02( ).part1( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );
    }


    @Test
    public void givenInput_whenFindingMinimumSet_thenCorrectSetPowerSumReturned( )
    {
        // Given
        List<String> input = List.of( "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                                      "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                                      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
                                      "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
                                      "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green" );

        // When
        String result = new Day02( ).part2( input );

        // Then
        assertEquals( "2286",
                      result );
    }

    @Test
    public void givenEmptyInput_whenFindingMinimumSet_thenThrowIllegalArgumentException( )
    {

        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day02( ).part2( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );
    }

    @Test
    public void givenInputWithWrongGameIdPattern_whenFindingMinimumSet_thenThrowIllegalArgumentException( )
    {

        //Given
        List<String> input = List.of( "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                                      "Game 2 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                                      "Fame 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day02( ).part2( input ) );

        // Then
        assertEquals( "Invalid line. Could not find pattern",
                      actualResult.getMessage( ) );
    }

    @Test
    public void givenInputWithWrongPattern_whenFindingMinimumSet_thenThrowIllegalArgumentException( )
    {

        //Given
        List<String> input = List.of( "Game 1 - 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
                                      "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
                                      "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red" );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day02( ).part2( input ) );

        // Then
        assertEquals( "Invalid line. Could not find pattern",
                      actualResult.getMessage( ) );
    }
}