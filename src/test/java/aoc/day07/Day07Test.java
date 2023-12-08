package aoc.day07;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day07Test
{
    @Test
    public void part1( )
    {
        // Given
        List<String> input = List.of( "test");

        // When
        String result = new Day07( ).part1( input );

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
        String result = new Day07( ).part2( input );

        // Then
        assertEquals( "test",
                      result );
    }
}

