package aoc.day01;

import aoc.Day;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01
    implements Day
{
    // TODO: Improve part 2
    static String[] numbers =
        { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty" };

    @Override
    public String part1( List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        int sum = 0;
        for ( String line : input )
        {
            sum += getValues( line );
        }

        return String.valueOf( sum );
    }

    @Override
    public String part2( List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        int total = 0;

        for ( String line : input )
        {
            line = processWordPositions( line );
            total += getCalibrationValue( line );
        }

        return String.valueOf( total );
    }

    public static int getCalibrationValue( String line )
    {
        if ( line == null || line.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Line is empty" );
        }

        int calibrationValue = 0;

        int firstDigit = processFirstDigit( line );
        calibrationValue += firstDigit;

        int lastDigit = processLastDigit( line );
        calibrationValue += lastDigit;

        return calibrationValue;
    }

    private int getValues( String line )
    {
        if ( line == null || line.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Line is empty" );
        }

        // Find location of digits
        int firstDigitIndex = findFirstDigitIndex( line );
        int lastDigitIndex = findLastDigitIndex( line );

        // Extract digits
        char firstDigit = line.charAt( firstDigitIndex );
        char lastDigit = line.charAt( lastDigitIndex );

        // Convert to int and combine them
        return Integer.parseInt( "" + firstDigit + lastDigit );

    }

    private int findFirstDigitIndex( String line )
    {
        for ( int i = 0; i < line.length( ); i++ )
        {
            if ( Character.isDigit( line.charAt( i ) ) )
            {
                return i;
            }
        }
        throw new IllegalArgumentException( "Line does not contain any digits" );
    }

    private int findLastDigitIndex( String line )
    {
        for ( int i = line.length( ) - 1; i >= 0; i-- )
        {
            if ( Character.isDigit( line.charAt( i ) ) )
            {
                return i;
            }
        }
        throw new IllegalArgumentException( "Line does not contain any digits" );
    }

    public static String processWordPositions( String line )
    {
        Map<Integer, Integer> locationMap = new HashMap<>( );

        processWordPositionsInLine( line,
                                    locationMap );
        processNumericPositionsInLine( line,
                                       locationMap );

        return buildResultString( locationMap );
    }

    private static void processWordPositionsInLine( String line,
                                                    Map<Integer, Integer> locationMap )
    {
        for ( int i = 0; i < numbers.length; i++ )
        {
            String currentWord = numbers[ i ];
            int currentIndex = line.indexOf( currentWord );

            while ( currentIndex != -1 )
            {
                locationMap.put( currentIndex,
                                 i );
                currentIndex = line.indexOf( currentWord,
                                             currentIndex + 1 );
            }
        }
    }

    private static void processNumericPositionsInLine( String line,
                                                       Map<Integer, Integer> locationMap )
    {

        for ( int i = 0; i < line.length( ); i++ )
        {
            char currentChar = line.charAt( i );

            if ( Character.isDigit( currentChar ) )
            {
                locationMap.put( i,
                                 Character.getNumericValue( currentChar ) );
            }
        }
    }

    private static String buildResultString( Map<Integer, Integer> locationMap )
    {
        StringBuilder output = new StringBuilder( );
        for ( Map.Entry<Integer, Integer> entry : locationMap.entrySet( ) )
        {
            output.append( entry.getValue( ) );
        }
        return output.toString( );
    }

    public static int processFirstDigit( String line )
    {
        for ( int i = 0, len = line.length( ); i < len; i++ )
        {
            char currentChar = line.charAt( i );
            if ( Character.isDigit( currentChar ) )
            {
                return 10 * Character.getNumericValue( currentChar );
            }
        }

        throw new IllegalArgumentException( "Line does not contain any digits" );
    }

    public static int processLastDigit( String line )
    {
        for ( int len = line.length( ), i = len - 1; i >= 0; i-- )
        {
            char currentChar = line.charAt( i );
            if ( Character.isDigit( currentChar ) )
            {
                return Integer.parseInt( String.valueOf( currentChar ) );
            }
        }

        throw new IllegalArgumentException( "Line does not contain any digits" );
    }

}