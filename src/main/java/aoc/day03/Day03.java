package aoc.day03;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Day03
    implements Day
{
    private static final Logger logger = Logger.getLogger( Day03.class.getName( ) );
    private static final Map<String, Integer> SYMBOLS = getCharMap( );

    @Override
    public String part1( final List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        // Define grid
        int rows = input.size( );
        int cols = calculateMaxStringLength( input );
        int[] map = new int[ rows * cols ];
        int sumOfEngineParts;

        List<Coordinates> engineSchematic = processInputGrid( input,
                                                              map,
                                                              cols );

        sumOfEngineParts = calculateAdjacentValues( engineSchematic,
                                                    map,
                                                    cols,
                                                    rows );

        return String.valueOf( sumOfEngineParts );
    }

    @Override
    public String part2( final List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        // Define grid
        int rows = input.size( );
        int cols = calculateMaxStringLength( input );
        int[] map = new int[ rows * cols ];
        int sumOfAllRatios = 0;

        List<Coordinates> engineSchematic = processInputGrid( input,
                                                              map,
                                                              cols );

        for ( Coordinates coordinates : engineSchematic )
        {
            coordinates.findGears( map,
                                   cols,
                                   rows );
        }

        for ( int i = 0; i < engineSchematic.size( ); i++ )
        {
            for ( int j = i + 1; j < engineSchematic.size( ); j++ )
            {
                sumOfAllRatios += engineSchematic
                    .get( i )
                    .getGear( engineSchematic.get( j ) );
            }
        }

        return String.valueOf( sumOfAllRatios );
    }

    private int calculateAdjacentValues( final List<Coordinates> list,
                                         final int[] map,
                                         final int columns,
                                         final int rows )
    {
        int values = 0;

        for ( Coordinates coordinates : list )
        {
            if ( coordinates.isAdjacent( map,
                                         columns,
                                         rows ) )
            {
                values += coordinates.getNumber( );
            }
        }

        return values;
    }

    private static Map<String, Integer> getCharMap( )
    {
        Map<String, Integer> characters = new HashMap<>( );
        characters.put( "*",
                        1 );
        characters.put( "#",
                        2 );
        characters.put( "+",
                        3 );
        characters.put( "$",
                        4 );
        characters.put( "&",
                        5 );
        characters.put( "-",
                        6 );
        characters.put( "%",
                        7 );
        characters.put( "=",
                        8 );
        characters.put( "/",
                        9 );
        characters.put( "@",
                        10 );
        return characters;
    }

    private static int calculateMaxStringLength( List<String> stringList )
    {
        int maxLength = 0;
        for ( String str : stringList )
        {
            maxLength = Math.max( maxLength,
                                  str.length( ) );
        }
        return maxLength;
    }

    private List<Coordinates> processInputGrid( List<String> input,
                                                int[] map,
                                                int columns )
    {

        List<Coordinates> list = new ArrayList<>( );
        Coordinates coordinates = null;
        int x = 0;
        int y = 0;
        Arrays.fill( map,
                     0 );

        for ( String line : input )
        {
            for ( char c : line.toCharArray( ) )
            {
                if ( Character.isDigit( c ) )
                {
                    if ( coordinates == null )
                    {
                        coordinates = new Coordinates( );
                    }

                    coordinates.addNumber( x,
                                           y,
                                           String.valueOf( c ) );

                }
                else
                {
                    if ( coordinates != null )
                    {
                        list.add( coordinates );
                    }
                    coordinates = null;
                }

                handleSymbol( c,
                              map,
                              x,
                              y,
                              columns );

                // Move to the next column
                x++;
            }

            // Reset x to 0 at end of line and move to next row
            x = 0;
            y++;
        }

        return list;
    }

    private void handleSymbol( final char c,
                               final int[] map,
                               final int x,
                               final int y,
                               final int columns )
    {
        String charString = String.valueOf( c );
        if ( SYMBOLS.containsKey( charString ) )
        {
            map[ y * columns + x ] = SYMBOLS.get( charString );
        }
        else if ( !charString.equals( "." ) && !Character.isDigit( c ) )
        {
            logger.warning( "This is not a dot: " + c );
        }
    }
}
