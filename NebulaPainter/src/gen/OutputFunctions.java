package gen;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//class that deals with information output
//functions to print settings to file, check the existence of the save directory, and display messages to the user
public class OutputFunctions {

	
	//print the settings used to make the image to a corresponding file
	public void printToFile(String filename, int[] choices){
		
		//the names of each setting stored in an array, which pairs with the user's choices, and is displayed on a line
		String[] settingsNames = {"Filter R", "Filter G", "Filter B", "Filter Intensity", "Use Filter?", "Random Range R Start", "R End", 
				"G Start", "G End", "B Start", "B End", "Rectangles Enabled?", "Rectangle Count", "Rect Use Random Range?","Main Use Random Range?",
				"Lines Count", "Lines Use Random Range?", "Lines Enabled?"};
		
		//check the directory and create the new filename from the image name
		checkDir();
		String newFileName = "./nebulas/" +filename + "-settings.txt";
		
		//store sysout to switch back later
		PrintStream sysOut = System.out;
		
		//new file and printstream for the file
		File newFile = new File(newFileName);
		PrintStream outStream;
		
		//set the system output to the new file's printstream
		try {
			outStream = new PrintStream(newFile);
			System.setOut(outStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//use the file name as the title
		System.out.println(filename);
		System.out.println();
		
		//print each setting with it's name
		for(int i = 0; i < choices.length - 1; i++){
			System.out.println(settingsNames[i] + ": " + choices[i]);
		}
		
		//switch back to sysOut
		System.setOut(sysOut);
	}

	//check if the save directory exists, create if not
	public static void checkDir(){
		File nebulaDir = new File("./nebulas");
		boolean dirCreated = nebulaDir.mkdir();
	}
	
	//display a message to the user within the main window as the parent
	public void displayMessage(String title, String message, JFrame parentFrame) {
	    JFrame parent = parentFrame;
	    JOptionPane.showMessageDialog(parent, message, title, 1);
	    
	  }
	
}
