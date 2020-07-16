package gen;
import java.util.*;
import java.awt.Color;


//class that deals with randomization of colors and rectangle shapes/locations
public class Randomizer {
	
	//creates a random rectangular section, within a specified width and height
	public int[] randomRectangle(int WIDTH, int HEIGHT){
		
		//int array output, {Xstart, Ystart, Xend, Yend}
		int[] output = {0, 0, 0, 0};
		Random rand = new Random();
		
		//for X and Y randomly generate startpoint, side length, and then calculate endpoint
		int xStart = rand.nextInt(WIDTH);
		int xLength = rand.nextInt(WIDTH - xStart);
		int xEnd = xStart + xLength;
		
		int yStart = rand.nextInt(HEIGHT);
		int yLength = rand.nextInt(HEIGHT - yStart);
		int yEnd = yStart + yLength;
		
		//set output array to the randomly generated coordinates
		output[0] = xStart;
		output[1] = yStart;
		output[2] = xEnd;
		output[3] = yEnd;
		
		return output;
	}
	

	//selects a random color from all possible RGB values
	public Color randomColor() {
			
		Random rand = new Random();
		   return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
	}
	
	
	//selects a random color within a specified RGB range
	public Color selectedRandomColor(int r1, int r2, int g1, int g2, int b1, int b2) {
		
		Random rand = new Random();
	    return new Color(rand.nextInt((r2 - r1 + 1) + r1), rand.nextInt((g2 - g1 + 1) + g1), rand.nextInt((b2 - b1 + 1) + b1)); 
	}
}
