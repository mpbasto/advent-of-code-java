package aoc;

import java.util.ArrayList;
import java.util.List;

public class Coordinates
{
    private int xStart = -1;
    private int xEnd = -1;
    private int y = -1;
    private int number = 0;
    private String numberStr = "";

    static class Gear
    {
        int x;
        int y;

        public Gear( int x,
                     int y )
        {
            this.x = x;
            this.y = y;
        }
    }

    private final List<Gear> gears = new ArrayList<>( );

    public void addNumber( int x,
                           int y,
                           String num )
    {
        this.y = y;
        if ( xStart == -1 )
        {
            this.xStart = x;
        }
        this.xEnd = x;
        numberStr += num;
        number = Integer.parseInt( numberStr );
    }

    public boolean isAdjacent( int[] map,
                               int gridWidth,
                               int rows )
    {
        for ( int x = xStart; x <= xEnd; x++ )
        {
            int rightIndex = y * gridWidth + ( x + 1 );
            int leftIndex = y * gridWidth + ( x - 1 );
            int downIndex = ( y + 1 ) * gridWidth + x;
            int upIndex = ( y - 1 ) * gridWidth + x;
            int downLeftIndex = ( y + 1 ) * gridWidth + ( x - 1 );
            int upLeftIndex = ( y - 1 ) * gridWidth + ( x - 1 );
            int downRightIndex = ( y + 1 ) * gridWidth + ( x + 1 );
            int upRightIndex = ( y - 1 ) * gridWidth + ( x + 1 );

            if ( x + 1 < gridWidth && map[ rightIndex ] != 0 )
            {
                return true;
            }
            if ( x > 0 && map[ leftIndex ] != 0 )
            {
                return true;
            }
            if ( y + 1 < rows && map[ downIndex ] != 0 )
            {
                return true;
            }
            if ( y > 0 && map[ upIndex ] != 0 )
            {
                return true;
            }
            if ( x > 0 && y + 1 < rows && map[ downLeftIndex ] != 0 )
            {
                return true;
            }
            if ( x > 0 && y > 0 && map[ upLeftIndex ] != 0 )
            {
                return true;
            }
            if ( x + 1 < gridWidth && y + 1 < rows && map[ downRightIndex ] != 0 )
            {
                return true;
            }
            if ( y > 0 && x + 1 < gridWidth && map[ upRightIndex ] != 0 )
            {
                return true;
            }
        }

        return false;
    }

    public void findGears( int[] map,
                           int gridWidth,
                           int rows )
    {
        for ( int x = xStart; x <= xEnd; x++ )
        {
            int rightIndex = y * gridWidth + ( x + 1 );
            int leftIndex = y * gridWidth + ( x - 1 );
            int downIndex = ( y + 1 ) * gridWidth + x;
            int upIndex = ( y - 1 ) * gridWidth + x;
            int downLeftIndex = ( y + 1 ) * gridWidth + ( x - 1 );
            int upLeftIndex = ( y - 1 ) * gridWidth + ( x - 1 );
            int downRightIndex = ( y + 1 ) * gridWidth + ( x + 1 );
            int upRightIndex = ( y - 1 ) * gridWidth + ( x + 1 );

            if ( x + 1 < gridWidth && map[ rightIndex ] == 1 )
            {
                gears.add( new Gear( x + 1,
                                     y ) );
            }
            if ( x > 0 && map[ leftIndex ] == 1 )
            {
                gears.add( new Gear( x - 1,
                                     y ) );
            }
            if ( y + 1 < rows && map[ downIndex ] == 1 )
            {
                gears.add( new Gear( x,
                                     y + 1 ) );
            }
            if ( y > 0 && map[ upIndex ] == 1 )
            {
                gears.add( new Gear( x,
                                     y - 1 ) );
            }
            if ( x > 0 && y + 1 < rows && map[ downLeftIndex ] == 1 )
            {
                gears.add( new Gear( x - 1,
                                     y + 1 ) );
            }
            if ( x > 0 && y > 0 && map[ upLeftIndex ] == 1 )
            {
                gears.add( new Gear( x - 1,
                                     y - 1 ) );
            }
            if ( x + 1 < gridWidth && y + 1 < rows && map[ downRightIndex ] == 1 )
            {
                gears.add( new Gear( x + 1,
                                     y + 1 ) );
            }
            if ( y > 0 && x + 1 < gridWidth && map[ upRightIndex ] == 1 )
            {
                gears.add( new Gear( x + 1,
                                     y - 1 ) );
            }
        }
    }

    public int getGear( Coordinates coords )
    {
        int total = 0;

        for ( Gear gear : gears )
        {
            for ( Gear g : coords.gears )
            {
                if ( gear.x == g.x && gear.y == g.y )
                {
                    total = this.getNumber( ) * coords.getNumber( );
                    break;
                }
            }
        }
        return total;
    }

    public int getNumber( )
    {
        return number;
    }
}
