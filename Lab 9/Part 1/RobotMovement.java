// CS1020 (AY2016/7 Semester 4) - Lab 9
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Program helps to navigate the robot from the starting point to the destination.
//
//
//
//

import java.util.*;

public class RobotMovement { 
    private static final int MAX_VALUE = 1000;

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
                //System.out.println(t);
            }
        }

        System.out.println(totalLeastCost(terrain,posI,posJ,size));

    }
    //Caculate the total cost if the robot go the least cost route.
    //Precon : size>1, posI and posJ>=0.
    public static int totalLeastCost(int [][]terrain,int posI,int posJ,int size){

        int e=0,s=0, se=0;
        int min;
        int rowLimit = size-1;
        int colLimit = size-1;
        //int stillI = posI;
        int subsequentRow = posI;
        int subsequentCol = posJ;
        String switchDecider;

        //right
        if(posJ+1<size) {
            e = terrain[posI][posJ+1];
        }else{
            e= 1100;
        }
        //System.out.println(posI + " " + posJ);

        //down
        if(posI+1<size) {
            s = terrain[posI+1][posJ];
        }else{
            s=1100;
        }
        //System.out.println(posI + " " + posJ);

        //diagonal
        if( (posI+1<size) && (posJ+1<size)){
            se= terrain[posI+1][posJ+1];
        }else{
            se=1100;
        }
        //System.out.println(posI + " " + posJ);
        //System.out.println(e + " " + s +" "+ se);

        min = Math.min( Math.min(se,Math.min(e, s)) ,Math.min(e, s)  );
        //System.out.println("min: "+ min);
        //System.out.println("i and j: " + posI + " " + posJ);
        //System.out.println();
        if(min==se || (posI + 1 == size -1 && posJ + 1 == size -1) ){
            switchDecider ="se";
        }else if(min==s || (posI+1 == size -1 && posJ  == size -1)){
            switchDecider ="s";
        }else if(min==e || (posI == size-1 && posJ+1 == size-1)){
            switchDecider = "e";
        }else{
            //switchDecider = "e";
            switchDecider = "nil";
        }

       // System.out.println(switchDecider);

        switch(switchDecider){

            case "e": subsequentRow = posI ;
                    subsequentCol = posJ+1;
                    break;

            case "se": subsequentRow+=1;
                     subsequentCol+=1;
                     break;

            case "s": subsequentRow = posI+1;
                    subsequentCol = posJ;
                    break;
            default:
                break;

        }

        if(posI == rowLimit && posJ == colLimit){

            return terrain[posI][posJ];

        }else{
            return totalLeastCost(terrain,subsequentRow,subsequentCol,size) + terrain[posI][posJ]  ;
        }


    }

}

