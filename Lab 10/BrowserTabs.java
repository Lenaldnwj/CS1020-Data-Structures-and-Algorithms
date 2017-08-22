// CS1020 (AY2016/7 Semester 4) - Lab 10
//
// Name: Lenald Ng Wai Jun
// Matric. No.: A0154880Y
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// It is a program that given a list of tabs indicated by a unique integer identifier, the URL and time of creation (an integer > 0), and also a list of button clicks on the
// 2 buttons, will print out the final ordering of the tabs by their integer identifier.
//
//
//
//

import java.util.*;


class Tab{

	private int id;
	private String url;
	private int time;

	Tab(int id, String url, int time){
		this.id = id;
		this.url=url;
		this.time = time;
	}

	public String getUrl(){
		return url;
	}

	public int getTime(){
		return time;
	}

	public int getId(){
		return id;
	}


}
//Class for Compare time
class TimeComparator implements Comparator<Tab> {
	public int compare(Tab p1, Tab p2) {
		// Returns the difference:
		// if positive, age of p1 is greater than p2
		// if zero, the ages are equal
		// if negative, age of p1 is less than p2
		return p1.getTime() - p2.getTime();
	}

	public boolean equals(Object obj) {
		// Simply checks to see if we have the same object
		return this == obj;
	}
} // end AgeComparator

//Class for Compare url
class UrlComparator implements Comparator<Tab> {

	public int compare(Tab p1, Tab p2) {
		// Compares its two arguments for order by name
		return p1.getUrl().compareTo(p2.getUrl());
	}

	public boolean equals(Object obj) {
		// Simply checks to see if we have the same object
		return this == obj;
	}
} // end NameComparator






public class BrowserTabs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numTabs,numClicks;
		//int ID=1;

		UrlComparator urlComp = new UrlComparator();
		TimeComparator timeComp = new TimeComparator();


		//ArrayList<Tab> list = new ArrayList<>();

		numTabs = scanner.nextInt();

		//Tab [] arr = new[numTabs];
		Tab[] arr;
		arr = new Tab[numTabs];
		Tab[] original;
		original = new Tab[numTabs];
		for(int i =0; i<numTabs;i++){

			Tab tabs = new Tab(scanner.nextInt(), scanner.next(), scanner.nextInt());

			arr[i] = tabs;
			original[i] = tabs;
			//list.add(tabs);

		}

		numClicks = scanner.nextInt();

		int button1Consec=0;
		int button2Consec=0;
		for(int i =0; i<numClicks;i++){

			int button = scanner.nextInt();

				/*if(button2Consec!=0 || button1Consec!=0){
					arr = Arrays.copyOf(original,original.length);
				} */

				if(button==1) {
					//System.out.println("button: " + button);

					if(button2Consec==0) {
						Arrays.sort(arr, urlComp);
					}
					else if(button2Consec!=0){
						Arrays.sort(arr, urlComp);
						Arrays.sort(arr, timeComp);
					}
					button1Consec++;
					button2Consec=0;

					/*for (int j = 0; j < numTabs; j++) {
						System.out.println(arr[j].getId() + " " + arr[j].getUrl() + " "
								+ arr[j].getTime());
					}
					System.out.println(); */

				}
				else if(button==2) {
					//System.out.println("button: " + button);
					if(button1Consec==0) {
						Arrays.sort(arr, timeComp);
					}
					else if(button1Consec!=0){
						Arrays.sort(arr, timeComp);
						Arrays.sort(arr, urlComp);
					}
					button2Consec++;
					button1Consec=0;

					/*for (int j = 0; j < numTabs; j++) {
						System.out.println(arr[j].getId() + " " + arr[j].getUrl() + " "
								+ arr[j].getTime());
					}
					System.out.println(); */
				}

		}

		/*for(int i=0;i<numTabs;i++){
			System.out.println(arr[i].getId() +" " + arr[i].getUrl() + " "
			+ arr[i].getTime());

		} */
		
		for(int i=0;i<numTabs;i++){

			System.out.println(arr[i].getId());

		}

	}
}
