// CS1020 (AY2016/7 Semester 4) - Lab 9 Part 2
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Program helps to navigate the robot from the starting point to the destination with least cost.
//
//
//
//

import java.util.*;

public class RobotMovement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int posI, posJ;
        size = sc.nextInt();

        int[][] terrain = new int[size][size];

        posI = sc.nextInt();
        posJ = sc.nextInt();

        for( int i=0;i<size;i++){
            for(int j = 0; j<size;j++){
                terrain[i][j] = sc.nextInt();
            }
        }

        System.out.println(totalLeastCost(terrain,posI,posJ,size));

    }

    //Returns the least cost route using recursion
    //Precon: posI,poJ >=0, size>=2;
    public static int totalLeastCost(int[][] grid, int posI, int posJ, int size) {

        int limit = size-1;

        if (posJ >= size || posI >= size ) {
            return 1010;
        }
        else if (posI == limit && posJ == limit) {
            //System.out.println(grid[posI][posJ]);
            return grid[posI][posJ];
        }
        else {
            return minimum (grid, posI, posJ, size) + grid[posI][posJ];
        }
    }
    //Calculate minimum.
    public static int minimum (int[][] grid, int posI, int posJ, int size){

        int min;

        min= Math.min(Math.min(totalLeastCost(grid, posI + 1, posJ, size), totalLeastCost(grid, posI + 1, posJ + 1, size)),
                totalLeastCost(grid, posI, posJ + 1, size));

        //System.out.println(min);

        return min;
    }


}