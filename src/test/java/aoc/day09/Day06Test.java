package aoc.day09;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day06Test
{
    @Test
    public void part1( )
    {
        // Given
        List<String> input = List.of( "test");

        // When
        String result = new Day09( ).part1( input );

        // Then
        assertEquals( "test",
                      result );
    }

    @Test
    public void part2( )
    {
        // Given
        List<String> input = List.of( "test" );

        // When
        String result = new Day09( ).part2( input );

        // Then
        assertEquals( "test",
                      result );
    }
}

