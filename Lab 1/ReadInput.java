// CS1020 (AY2016/7 Semester 4) - Lab 1 Part 2
//
// Name: Lenald Ng
// Matric. No.: A0154880Y
// Lab group: 1
// Collaborators:NIL
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// This program outputs/prints the result of operations when given binary operator
// and two bits.
//
//
//
//


import java.util.*;

public class ReadInput {

    public static void main(String[] args) {

        // declare the necessary variables
        int type, i;
        int index = 0;
        int a, b;
        int num_operation;
        int[] arr_print;
        String text = "OR";
        String text2 = "AND";
        // declare a Scanner object to read input
        Scanner sc = new Scanner(System.in);

        // read input and process them accordingly

        type = sc.nextInt();

        //type 1
        if (type == 1) {

            num_operation = sc.nextInt();

            arr_print = new int[num_operation];

            for (i = 0; i < num_operation; i++) {
                String operator = sc.next();
                a = sc.nextInt();
                b = sc.nextInt();
                //Compare to OR
                if (operator.equals(text)) {

                    if (a != b) {

                        arr_print[index] = 1;
                        index++;
                    } else if (a == 0 && b == 0) {

                        arr_print[index] = 0;
                        index++;
                    } else {

                        arr_print[index] = 1;
                        index++;
                    }

                }
                //Compare to AND
                else if (operator.equals(text2)) {

                    if (a == 1 && b == 1) {

                        arr_print[index] = 1;
                        index++;
                    } else {

                        arr_print[index] = 0;
                        index++;
                    }

                }
            }
            for (i = 0; i < arr_print.length; i++) {
                System.out.println(arr_print[i]);
            }
            //type 2
        } else if (type == 2) {

            String operator = "hi";
            String flag = "0";

            arr_print = new int[100];
            while (!operator.equals(flag)) {


                operator = sc.next();
                if (operator.equals(flag)) {
                    break;
                }

                a = sc.nextInt();
                b = sc.nextInt();

                //Compare to OR
                if (operator.equals(text)) {

                    if (a != b) {

                        arr_print[index] = 1;
                        index++;
                    } else if (a == 0 && b == 0) {

                        arr_print[index] = 0;
                        index++;
                    } else {

                        arr_print[index] = 1;
                        index++;
                    }


                }
                //Compare to AND
                else if (operator.equals(text2)) {

                    if (a == 1 && b == 1) {

                        arr_print[index] = 1;
                        index++;
                    } else {

                        arr_print[index] = 0;
                        index++;
                    }

                }



            }




            for (i = 0; i < index; i++) {
                System.out.println(arr_print[i]);
            }

            //type 3
        } else if (type == 3) {

            arr_print = new int[100];
            while (sc.hasNext()) {

                String operator = sc.next();

                a = sc.nextInt();
                b = sc.nextInt();

                //Compare to OR
                if (operator.equals(text)) {

                    if (a != b) {

                        arr_print[index] = 1;
                        index++;
                    } else if (a == 0 && b == 0) {

                        arr_print[index] = 0;
                        index++;
                    } else {

                        arr_print[index] = 1;
                        index++;
                    }



                }
                //Compare to AND
                else if (operator.equals(text2)) {

                    if (a == 1 && b == 1) {

                        arr_print[index] = 1;
                        index++;
                    } else {

                        arr_print[index] = 0;
                        index++;
                    }

                }



            }


            for (i = 0; i < index; i++) {
                System.out.println(arr_print[i]);

            }


        }
    }
}

