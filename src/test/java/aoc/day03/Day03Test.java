package aoc.day03;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day03Test
{

    @Test
    public void part1( )
    {
        // Given
        List<String> input = Collections.singletonList( "test" );

        // When
        String result = new Day03( ).part1( input );

        // Then
        assertEquals( input.get( 0 ),
                      result );
    }

    @Test
    public void part2( )
    {
        // Given
        List<String> input = Collections.singletonList( "test" );

        // When
        String result = new Day03( ).part1( input );

        // Then
        assertEquals( input.get( 0 ),
                      result );
    }
}