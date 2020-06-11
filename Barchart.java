//This program program request the user for a file and then prints a bar-chart representing the number of occurences of each alphabet in that file.


import java.util.Scanner; //imports the Scanner class
import java.io.File;//imports the file class
import java.io.FileNotFoundException;// This class throws an error if a file is not found

import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;

class Read {

int[] count = new int[26]; //Creates an array that is been use to loop through the alphabets in a file

int max = 0;

//This method reads the data in the file inputted by a user and counts the occurence of each alphabets

public Read() throws FileNotFoundException {

Scanner user = new Scanner(System.in);
System.out.print("Enter the name of your file: "); // This ask the user to input a file
String filename = user.nextLine().trim(); //This stores the file inputted by the user and removes the spaces between strings

File file = new File(filename);
Scanner scan = new Scanner(file);

//This reads all the line in the file inputted by the user

while(scan.hasNextLine()){
	String filen = scan.nextLine();
	filen = filen.toLowerCase(); //This converts all the alphabets in the file inputted to lowercase
	char[] characters = filen.toCharArray();
	
	//This counts the occurence of each alphabet in the file inputted by the user
	for(int j = 0; j < characters.length; j++){
		if ((characters[j] >= 97) && (characters[j]<= 122)){
			count[characters[j] - 97]++;;
		}	
	}
	
}	
	//This prints out the occurence of each alphabets in the file
	for(int j = 0; j < 26; j++){
		System.out.println((char)(j+97) + " " + count[j]);
		if (max < count[j]){
			max = count[j];
				}

	}
}



}

//This class is been used to draw the axes and the possible rectangles that forms the bar chart

class draw extends JPanel{
int[] freq = new int[26];
int big;
public draw() throws FileNotFoundException{
Read r = new Read(); //Creates an object r from the Read class
big = r.max + 500;
for (int j = 0; j < 26; j++){
freq[j] = r.count[j];
}

}

//This method is used to set the JFrame and draw the x and y axes

public void paintComponent(Graphics g){
String alphabets = "abcdefghijklmnopqrstuvwxyz";	
super.paintComponent(g);
g.setColor(Color.white);
g.setColor(Color.black);
this.setBackground(Color.WHITE);
g.setColor(Color.black);
g.drawLine(25, big - 85, 585, big - 85);
g.drawLine(25, big - 85, 25, 25);
	
//This is been used to draw the various rectangles and print the various alphabets below their corresponding rectangles on the horizontal axis
for (int j = 0; j < 26; j++){
	String n ="";
	n = n + alphabets.charAt(j);
	g.drawString(n, (20*j)+56, big - 68);
	g.drawRect(48+(20*j), big-freq[j]-85, 20, freq[j]);
	
}

//This is been used to calibrate the vertical axis into intervals of 25
for (int i = 0; i <=big-100; i++){
int numbers = i*25;
String numbersfreq = Integer.toString(numbers);
g.drawLine(25, big - 85, 25, 30);
g.drawString(numbersfreq, 4, big-82-(i*25));
	if (numbers >= big-180){
		break;
	}
} 

}
}

//This sets the various parameters of the JFrame

class Barchart{

public static void main(String[] args) throws FileNotFoundException{
draw t = new draw(); //Creates an object t from the draw class
int highest = t.big;
int height = highest;
JFrame jf = new JFrame();
jf.setTitle("Frequencies of Alphabets"); // Sets the title of the JFrame
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(700,height); // Sets the size of the JFrame
jf.setVisible(true);
jf.add(t);

}

}





