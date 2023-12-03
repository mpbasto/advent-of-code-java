package aoc.day02;

import aoc.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day02
    implements Day
{
    public static final int RED = 12;
    public static final int BLUE = 14;
    public static final int GREEN = 13;

    @Override
    public String part1( final List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        List<Integer> possibleGames = new ArrayList<>( );
        boolean isPossibleGame;

        for ( String line : input )
        {
            int gameId = getGameId( line );
            String[] sets = extractSetsArray( line );
            isPossibleGame = true;

            for ( String set : sets )
            {
                // Extract number of cubes of each color
                Integer redTotal = countCubes( set,
                                               "red" );
                Integer blueTotal = countCubes( set,
                                                "blue" );
                Integer greenTotal = countCubes( set,
                                                 "green" );

                if ( !( blueTotal <= BLUE && greenTotal <= GREEN && redTotal <= RED ) )
                {
                    isPossibleGame = false;
                    break;
                }
            }

            if ( isPossibleGame )
            {
                possibleGames.add( gameId );
            }
        }

        int sum = 0;
        for ( int gameId : possibleGames )
        {
            sum += gameId;
        }

        return String.valueOf( sum );
    }

    private static int getGameId( String line )
    {

        // Define regex pattern and matcher
        Pattern pattern = Pattern.compile( "Game (\\d+):" );
        Matcher matcher = pattern.matcher( line );

        // Check if pattern found
        if ( matcher.find( ) )
        {
            // Get gameId
            return Integer.parseInt( matcher.group( 1 ) );

        }

            throw new IllegalArgumentException( "Invalid line. Could not find pattern" );
    }

    private static String[] extractSetsArray( String line )
    {
        // Define regex pattern and matcher
        Pattern pattern = Pattern.compile( ": (.*)" );
        Matcher matcher = pattern.matcher( line );

        // Check if pattern found
        if ( matcher.find( ) )
        {
            // Extract set
            String set = matcher.group( 1 );

            // Split sets
            return set.split( ";" );
        }

        throw new IllegalArgumentException( "Invalid line. Could not find pattern" );
    }

    private static Integer countCubes( final String set,
                                       final String colour )
    {
        // Define pattern and matcher
        Pattern colourPattern = Pattern.compile( "\\b(\\d+) " + colour + "\\b" );
        Matcher matcher = colourPattern.matcher( set );

        // Check for pattern
        if ( matcher.find( ) )
        {
            // Convert to int
            return Integer.parseInt( matcher.group( 1 ) );
        }

        return 0;
    }

    @Override
    public String part2( final List<String> input )
    {
        if ( input == null || input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        List<Integer> red = new ArrayList<>( );
        List<Integer> blue = new ArrayList<>( );
        List<Integer> green = new ArrayList<>( );
        List<Integer> games = new ArrayList<>( );
        int powers;

        for ( String line : input )
        {
            String[] sets = extractSetsArray( line );

            for ( String set : sets )
            {
                red.add( countCubes( set,
                                     "red" ) );
                blue.add( countCubes( set,
                                      "blue" ) );
                green.add( countCubes( set,
                                       "green" ) );
            }

            powers = Collections.max( red ) * Collections.max( blue ) * Collections.max( green );
            games.add( powers );

            // Reset counters
            red.clear( );
            blue.clear( );
            green.clear( );
        }

        // Sum all the powers
        int sum = 0;
        for ( int game : games )
        {
            sum += game;
        }

        return String.valueOf( sum );
    }
}
