package aoc.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Day04Test
{
    @Test
    public void givenScratchcardInput_whenCalculatingPoints_thenReturnExpectedResult( )
    {
        // Given
        List<String> input = List.of( "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
        "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
        "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
        "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
        "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
        "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11" );

        // When
        String result = new Day04( ).part1( input );

        // Then
        assertEquals( "13",
                      result );
    }

    @Test
    public void givenEmptyInput_whenCalculatingPoints_thenThrowError( )
    {
        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day04( ).part1( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );

    }

    @Test
    public void givenInput_whenCalculatingTotalScratchcards_thenReturnExpectedResult( )
    {
        // Given
        List<String> input = new ArrayList<>(List.of( "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
                                                       "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
                                                       "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
                                                       "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
                                                       "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
                                                       "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11" ));

        // When
        String result = new Day04( ).part2( input );

        // Then
        assertEquals( "30",
                      result );
    }

    @Test
    public void givenEmptyInput_whenCalculatingTotalScratchcards_thenThrowError( )
    {
        //Given
        List<String> emptyInput = Collections.emptyList( );

        // When
        IllegalArgumentException actualResult = assertThrows( IllegalArgumentException.class,
                                                              ( ) -> new Day04( ).part2( emptyInput ) );

        // Then
        assertEquals( "Input is empty",
                      actualResult.getMessage( ) );

    }

}
