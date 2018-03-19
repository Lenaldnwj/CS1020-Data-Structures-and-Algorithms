// CS1020 (AY2016/7 Semester 4) - Lab 5
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
//This program flips a linked list at a particular starting index to a particular ending index.
//
//
//
//

import java.util.*;

class ListNode {
	private ListNode next;
	private ListNode before;
	private String element;

	/* constructors */
	public ListNode(String item) { this(item, null, null); }

	public ListNode(String item, ListNode n, ListNode b) {
		element = item; 
		next = n;
		before = b;
	}

	/* get the next ListNode */
	public ListNode getNext() { return next; }
	// Gets the node before;
	public ListNode getPrev() { return before; }

	/* get the element of the ListNode */
	public String getElement() { return element; }

	/* set the next reference */
	public void setNext(ListNode n) { next = n; }
	//Sets the next reference
	public void setPrev(ListNode n) { before = n; }

	public void setElement(String item) { element = item; }
	// you may add more methods to ListNode as you deem fit
}

class LinkedList {
	private ListNode head;
	private ListNode tail;
	private int numNode=0;
	private ListNode current;
	private ListNode previous;
	//Initialise linkedlist with the nodes according the the user input size;
	//Precon: size not negative
	public void initialiseLinkedList(int size) {
		//initialise the linked list here
		String allLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		//System.out.println();
		for(int i=0;i<size;i++){
			//System.out.println(i);
			char letter = allLetter.charAt(i);
			String single = Character.toString(letter);
			//numNode++;
			//System.out.print(single);
			insertLast(single);

		}

	}
	/*public void insertFirst(String element){

		ListNode newNode = new ListNode(element,null);
		if(head==null){
			head = newNode;
		}else{
			newNode.setNext(head);
			head = newNode;

		}


	} */

	//Insert node to the last of the linklist.
	//Precon the element must be of string type.
	public void insertLast(String element){

		if (head==null) {
			tail = new ListNode(element);
			head = tail;
			head.setPrev(null);
			numNode++;
		}
		else if (head!=null){
			tail.setNext(new ListNode(element));
			current = tail;
			tail = tail.getNext();
			tail.setPrev(current);
			numNode++;
		}
	}



	//Manipulate by flipping from the start index to end index
	//Precon: indexes are not negative;
	public void manipulate(int startIndex, int endIndex) {
		//do your working here
		int index1 = startIndex;
		int index2 = numNode - 1 - endIndex;
		ListNode start = head;
		ListNode end = tail;


		if(endIndex < numNode){
			for( index1 = startIndex ; index1>0; index1--){
				start = start.getNext();
			}
			for( index2 =numNode - 1 - endIndex ; index2>0; index2--){
				end = end.getPrev();
			}

		}

		else if(endIndex >= numNode){

			while(index1>0){
				start = start.getNext();
				index1 -=1;
			}
			endIndex = numNode-1;

		}

		for(int i=startIndex; i<=endIndex;i+=2){
			String holder = start.getElement();

			start.setElement(end.getElement());
			end.setElement(holder);

			start = start.getNext();
			end = end.getPrev();
		}

	}


	//Method to print out the result;
	public String print() {
		//for printing the answer
		ListNode print = head;
		String everything;
		everything = print.getElement();
		for(int i=1; i<numNode; i++){
			print = print.getNext();
			everything = everything.concat(print.getElement());
		}

		return everything;
	}

}

public class FlipList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int size;
		int numFlip;

		size = sc.nextInt();
		numFlip = sc.nextInt();

		list.initialiseLinkedList(size);

		for (int i = 0; i < numFlip; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			if(start< size) {
				list.manipulate(start, end);
			}
		}

		// your code here

		System.out.println(list.print());
	}
}
