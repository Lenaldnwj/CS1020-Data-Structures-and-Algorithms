// CS1020 (AY2016/7 Semester 4) - Lab 7
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Program simulates the employee management in a company.
//
//
//
//

import java.util.*;

/* Service class representing an employee */
class Employee {
    private String name ;
    private int rank;
    private int earlyFactor=0;
   // private String printType= "fire";

    public Employee (String name,int rank, int earlyFactor){

        this.name=name;
        this.rank=rank;
        this.earlyFactor = earlyFactor;
        //this.printType = printType;
    }

    public int getEarlyFactor(){
        return earlyFactor;
    }

    public String getName(){
        return name;
    }

    public int getRank(){
        return rank;
    }

    public void setRank(int rank){
        this.rank=rank;
    }
    public void setEarlyFactor(int earlyFactor){
        this.earlyFactor = earlyFactor;
    }
}

/* Client class to simulate the employee management system */
public class EmpManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack <Employee> stack = new Stack<> ();
        Stack <Employee> stack2 = new Stack<> ();
        ArrayList <Stack<Employee>> list = new ArrayList<Stack<Employee>>();

        //int promoteEarly=10000;
		int numOperation,numFire;
		String promotedName;
		int promotedRank;
		int earliness=0;
        String input,output="";
		numOperation = sc.nextInt();

		for(int i=0;i<numOperation;i++){

            input = sc.next();

            //If fire is the input
             if(input.equals("fire")){

		        numFire=sc.nextInt();
                stack = reverse(stack);

                output += "fire " + numFire + "\n";

                if(numFire == stack.size()){

                    output += "@\n";

                }

		        for(int x=0;x<numFire;x++) {
		            stack.pop();
                }

                stack = reverse(stack);
                list.add(stack);


                for(int y=0;y<stack.size();y++) {
                    output += stack.get(y).getName() + " " + stack.get(y).getRank() + "\n";
                }
                if( !(i==numOperation-1) ) {
                    output += "\n";
                }
            }
            //If hire is the input
             else if(input.equals("hire")){
                 String name=sc.next();
                 Employee member = new Employee(name,sc.nextInt(), earliness);

                 if(name.equals("Cory")){
                     member.setEarlyFactor(earliness+=2);}
                 stack.push(member);
                 stack = sortStack(stack);
                 stack = sortDuration(stack);
                 stack = reverse(stack);
                 list.add(stack);

                 output += "hire " + member.getName() + " " + member.getRank() + "\n";

                 for(int y=0;y<stack.size();y++) {
                     output += stack.get(y).getName() + " " + stack.get(y).getRank() + "\n";
                 }
                 if( !(i==numOperation-1) ) {
                     output += "\n";
                 }
                 earliness++;

             }
            //If promote is the input
            else if(input.equals("promote")){

                promotedName = sc.next();
                promotedRank = sc.nextInt();

                while( !( stack.peek().getName().equals(promotedName) ) ){

                    stack2.push(stack.pop());

                }

                earliness++;
                stack.peek().setRank(promotedRank);
                stack.peek().setEarlyFactor(earliness);

                //System.out.println(stack.peek().getName() + stack.peek().getRank()
                //+ stack.peek().getEarlyFactor());

                while(!stack2.isEmpty()){

                    stack.push(stack2.pop());

                }

                stack = sortStack(stack);
                stack = sortDuration(stack);
                stack = reverse(stack);

                output += "promote " + promotedName + " " + promotedRank + "\n";
                for(int y=0;y<stack.size();y++) {
                    output += stack.get(y).getName() + " " + stack.get(y).getRank() + "\n";
                }
                if( !(i==numOperation-1) ) {
                    output += "\n";
                }

            }

        }

        System.out.println(output);

    }
    //Sort the stack according to ranks
    public static Stack<Employee> sortStack(Stack<Employee> s1){
        Employee temp;
        Stack<Employee> s2 = new Stack<>();

        while(!s1.isEmpty()){
            temp = s1.pop();
            while(!s2.isEmpty()
                    && s2.peek().getRank()>temp.getRank()){
                s1.push(s2.pop());
            }
            s2.push(temp);
        }

        return s2;
    }
    //Sort the sorted rank stack according to recent hire
    public static Stack<Employee> sortDuration(Stack<Employee> s1){
        Employee temp;
        Stack<Employee> s2 = new Stack<>();

        while(!s1.isEmpty()){
            temp = s1.pop();

            while(!s2.isEmpty()
                    && (s2.peek().getRank()==temp.getRank())
                    && (s2.peek().getEarlyFactor()>temp.getEarlyFactor())
                    ){

                s1.push(s2.pop());
            }
            s2.push(temp);
        }

        return s2;
    }
    //reverse the stack
    public static Stack<Employee> reverse(Stack<Employee> s1){
        Stack<Employee> s2 = new Stack<>();

        while(!s1.isEmpty()){

            s2.push(s1.pop());

        }

        return s2;

    }


}
