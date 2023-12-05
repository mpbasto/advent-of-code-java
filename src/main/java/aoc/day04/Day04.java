package aoc.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day04
    implements aoc.Day
{
    @Override
    public String part1( final List<String> input )
    {
        if ( input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        List<Integer> total = new ArrayList<>( );
        List<Integer> matchedNumbersList = new ArrayList<>( );

        for ( String str : input )
        {
            // Split based on ":"
            String[] parts = str.split( ":" );

            // Get winning numbers
            List<Integer> winningNumbers = getWinningNumbers( parts );

            // Get my numbers
            List<Integer> myNumbers = getPlayerNumbers( parts );

            int score = calculateScratchcardPoints( winningNumbers,
                                                    myNumbers,
                                                    matchedNumbersList );
            total.add( score );
            matchedNumbersList.clear( );
        }

        int points = total
            .stream( )
            .mapToInt( Integer::intValue )
            .sum( );

        return String.valueOf( points );
    }

    @Override
    public String part2( final List<String> input )
    {
        if ( input.isEmpty( ) )
        {
            throw new IllegalArgumentException( "Input is empty" );
        }

        List<Set<String>> winningSets = new ArrayList<>();
        List<Set<String>> numbersSets = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        input.forEach(cardInput -> parseCardInput(cardInput, winningSets, numbersSets, counts));

        calculateCounts(winningSets, numbersSets, counts);

        int totalScratchCards = counts
            .stream( )
            .mapToInt( Integer::intValue )
            .sum( );

        return String.valueOf( totalScratchCards );
    }

    private int calculateScratchcardPoints( List<Integer> winningList,
                                            List<Integer> playerNumbers,
                                            List<Integer> matchedNumbers )
    {
        // Calculate score
        int score = 0;
        for ( Integer num : playerNumbers )
        {
            if ( winningList.contains( num ) )
            {
                if ( matchedNumbers.isEmpty( ) )
                {
                    matchedNumbers.add( num );
                    score++;
                }
                else
                {
                    matchedNumbers.add( num );
                    score *= 2;
                }
            }
        }

        return score;
    }

    private List<Integer> getPlayerNumbers( String[] parts )
    {
        String[] numbersStr = parts[ 1 ].split( "\\|" )[ 1 ]
            .trim( )
            .split( "\\s+" );
        List<Integer> playerNumbers = new ArrayList<>( );
        for ( String numStr : numbersStr )
        {
            playerNumbers.add( Integer.parseInt( numStr ) );
        }

        return playerNumbers;
    }

    private List<Integer> getWinningNumbers( String[] parts )
    {
        String[] numbersStr = parts[ 1 ].split( "\\|" )[ 0 ]
            .trim( )
            .split( "\\s+" );
        List<Integer> winningNumbers = new ArrayList<>( );
        for ( String numStr : numbersStr )
        {
            winningNumbers.add( Integer.parseInt( numStr ) );
        }

        return winningNumbers;
    }

    private void parseCardInput(String cardInput, List<Set<String>> winningSets, List<Set<String>> numbersSets, List<Integer> counts) {
        String[] parts = cardInput.split(":");
        String[] nums = parts[1].trim().split("\\s*\\|\\s*");

        Set<String> winning = new HashSet<>( Arrays.asList( nums[0].split( "\\s+" ) ));
        Set<String> numbers = new HashSet<>(Arrays.asList(nums[1].split("\\s+")));
        int count = 1;

        winningSets.add(winning);
        numbersSets.add(numbers);
        counts.add(count);
    }

    private void calculateCounts(List<Set<String>> winningSets, List<Set<String>> numbersSets, List<Integer> counts) {
        for (int index = 0; index < winningSets.size(); index++) {
            Set<String> matching = new HashSet<>(winningSets.get(index));
            matching.retainAll(numbersSets.get(index));

            for (int i = index + 1; i < index + matching.size() + 1; i++) {
                counts.set(i, counts.get(i) + counts.get(index));
            }
        }
    }

}
