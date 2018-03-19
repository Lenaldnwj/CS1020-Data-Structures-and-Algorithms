// CS1020 (AY2016/7 Semester 4) - Lab 1 Part 1
//
// Name:Lenald Ng Wai Jun
// Matric. No.:A0154880Y
// Lab group:1
// Collaborators:NIL
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// This program computes the area of the polygon formed by the overlapping rectangles, 0 area if no overlap
//
//
//
//

import java.util.*;
import java.awt.*;


public class OverlapRectangles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int polygon;

        System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
        Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());
        Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());

        arrangeVertices(rect1Vertex1, rect1Vertex2);

        System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
        Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
        Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());

        arrangeVertices(rect2Vertex1, rect2Vertex2);

        // For testing. Remove or comment off the statement below after testing.
        // printAllVertices(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);

        if (checkOverLap(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2)) {

            polygon = polygonArea(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);
            System.out.println("Polygon area = " + polygon);

        }

        else{
            System.out.println("Polygon area = 0");
        }
    }

    // Modify the two vertices entered by the user such that the
    // first vertex represents the bottom-left corner
    // and the second vertex represents the top-right corner
    //Precon : v1 v2 must be of point object
    public static void arrangeVertices(Point v1, Point v2){

        int temp;

        //case 2
        if((v1.x < v2.x) && (v1.y > v2.y) ){
            temp = v1.y;
            v1.y = v2.y;
            v2.y = temp;
        }
        //case 3
        else if ((v1.x > v2.x) && (v1.y > v2.y) ){
            temp = v1.y;
            v1.y = v2.y;
            v2.y = temp;

            temp = v1.x;
            v1.x = v2.x;
            v2.x = temp;

        }
        //case 4
        else if ((v1.x > v2.x) && (v1.y < v2.y)){
            temp = v1.x;
            v1.x = v2.x;
            v2.x = temp;
        }

    }
    //Calculates the area of polygon
    //Precon: input is of point
    //Post con: Area output, Area is not less than 0
    public static int polygonArea(Point r1V1, Point r1V2,
                                  Point r2V1, Point r2V2){

        int total;
        int rec1Area, rec2Area, overLap;

        rec2Area = (r2V2.y - r2V1.y) * (r2V2.x - r2V1.x);
        rec1Area = (r1V2.x - r1V1.x) * (r1V2.y - r1V1.y);
        overLap = (Math.min(r1V2.y, r2V2.y) - Math.max(r1V1.y,r2V1.y)) *
                (Math.min(r1V2.x,r2V2.x)  - Math.max(r1V1.x,r2V1.x) );

        total = Math.abs(rec1Area) + Math.abs(rec2Area) - Math.abs(overLap);

        return total;
    }
    //Check if overlap, returns true if overlap, if not, otherwise.
    //Precon: input is of point object
    //Post con:Return true if overlap, false if not;
    public static boolean checkOverLap(Point r1V1, Point r1V2,
                                       Point r2V1, Point r2V2){

        boolean check= true;

        if( (r2V1.x >= r1V2.x) || (r2V1.y >= r1V2.y) || (r1V1.x>=r2V2.x) || (r1V1.y >= r2V2.y) ){

            return false;
        }

        return check = true;

    }


    // This method is provided for your testing.
    // To print the 2 opposite vertices of each of the 2 rectangles.
    public static void printAllVertices(Point r1V1, Point r1V2,
                                        Point r2V1, Point r2V2) {
        System.out.println("1st rectangle vertex 1: " + r1V1);
        System.out.println("1st rectangle vertex 2: " + r1V2);
        System.out.println("2nd rectangle vertex 1: " + r2V1);
        System.out.println("2nd rectangle vertex 2: " + r2V2);
    }

}
