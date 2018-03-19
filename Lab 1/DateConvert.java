// CS1020 (AY2016/7 Semester 4) - Lab 1 Part 3
//
// Name: Lenald Ng
// Matric. No.: A0154880Y
// Lab group: 1
// Collaborators: NIL
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// This program converts a string in the UK date format and outputs the equivalent
// American format, and also whether the year is a leap year.
//
//
//
//
import java.util.*;

public class DateConvert {

    // Write your user-defined method below.
    // It is mandatory to have a description above every user-defined method.

    public static void main(String[] args) {

        String month;
        String day;
        String year;
        int len;


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter date in UK format: ");

        month = sc.next();
        day = sc.next();
        len = day.length();
        year = sc.next();

        System.out.println("Date in American format: " + day.substring(0,len-1) + " "+ month  + " "+ year);
        Integer leap = Integer.valueOf(year);

        if(isLeapYear(leap)){
            System.out.println(year + " is a leap year.");
        }
        else{
            System.out.println(year + " is not a leap year.");
        }
    }
    //Checks whether the year is a leap year. Return true if leap year
    //Precon: must be integer, not negative
    //Postcon: Returns true if leap year, false if not.
    public static boolean isLeapYear(int leap){

        if((leap % 400 == 0) || ( (leap % 4 ==0) && (leap % 100 != 0) )){
            return true;
        }
        else{
            return false;
        }

    }
}