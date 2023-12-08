package aoc.day07;

import aoc.Day;

import java.util.List;

public class Day07 implements Day
{
    @Override
    public String part1( final List<String> input )
    {
        if ( input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }
        return input.get( 0 );
    }

    @Override
    public String part2( final List<String> input )
    {
        if ( input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        return input.get( 0 );
    }
}
