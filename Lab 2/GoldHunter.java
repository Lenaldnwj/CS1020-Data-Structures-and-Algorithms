// CS1020 (AY2016/7 Semester 4) - Lab 2
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group:1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// This program computes the amount of gold in each cell in the aftermath.
//
//
//
//

import java.util.*;
class MyMap {
    private char[][] charMap; // map containing the character labels
    private int nRow; // number of rows
    private int nCol; // number of columns

    /* TO STUDENTS: add other attributes you need here */


    // read in a character map from input, you can modify this as you deem fit
    public MyMap(Scanner sc) {
        nRow = sc.nextInt();
        nCol = sc.nextInt();
        charMap = new char[nRow][nCol];
        String line;
        for (int i = 0; i < nRow; i++) {
            line = sc.next();
            for (int j = 0; j < nCol; j++) {
                setLabel(i, j, line.charAt(j));
            }
        }
    }

    // mutator for charMap
    public void setLabel(int row, int col, char label) {
        charMap[row][col] = label;
    }

    // accessor for charMap
    public char getLabel(int row, int col) {
        return charMap[row][col];
    }
    //accessor for row
    public int getRow(){
        return nRow;
    }
    //accessor for col
    public int getCol() {
        return nCol;
    }
    // TO STUDENTS: add other methods you require here
    //This method arranges the array to correspond with the minefield explosion/gold mine aftermath.
    //Precon: row and col are the same as previous array, row and col are positive.
    public void arrange(int row,int col){

        int i,j;

        char [][] charMap2 = new char[row][col];

        for ( i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {

                charMap2[i][j] = getLabel(i, j);
            }
        }

        for ( i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (charMap2[i][j] == '.') {
                    charMap2[i][j] = '0';
                }
            }
        }

        for ( i = 0; i < row; i++) {
            for ( j = 0; j < col; j++) {
                if( charMap2[i][j] == '*'){
                    //UP
                    if( ((i+1)< row) && (charMap2[i+1][j]!='*') ){
                        charMap2[i+1][j]++;
                    }
                    //Down
                    if( ((i-1) < row) && ((i-1)>=0) && ((charMap2[i-1][j]!='*')) ) {
                        charMap2[i - 1][j]++;
                    }
                    //RIGHT
                    if( ((j+1)< col) && (charMap2[i][j+1]!='*')){
                        charMap2[i][j+1]++;
                    }
                    //LEFT
                    if( ((j-1)<col) && ((j-1)>=0) && (charMap2[i][j-1]!='*')) {
                        charMap2[i][j-1]++;
                    }
                    //BOTTOM LEFT
                    if(  ((j-1)>=0) && ((i-1)>=0) && ((charMap2[i-1][j-1]!='*')) ) {
                        charMap2[i - 1][j-1]++;
                    }
                    //TOP LEFT
                    if(  ((j-1)>=0) && ((i+1) < row) && ((charMap2[i+1][j-1]!='*')) ) {
                        charMap2[i+1][j-1]++;
                    }
                    //TOP RIGHT
                    if( ((j+1) < col)  && ((i+1) < row) && ((charMap2[i+1][j+1]!='*')) ) {
                        charMap2[i+1][j+1]++;
                    }
                    //BOTTOM RIGHT
                    if( ((j+1) < col)  && ((i-1)>=0) && ((charMap2[i-1][j+1]!='*')) ) {
                        charMap2[i-1][j+1]++;
                    }
                }

            }
        }

        
        for ( i = 0; i < row; i++) {
            if(i>=1){
                System.out.println();
            }
            for ( j = 0; j < col; j++) {
                System.out.print(charMap2[i][j]);
            }
        }
        System.out.println();


    }
    // To print the output map
    public void display() {

        int row =getRow();
        int col =getCol();
        arrange(row, col);
    }


}


public class GoldHunter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyMap map = new MyMap(sc);

        int row = map.getRow();
        int col = map.getCol();

        map.display();


    }

}
