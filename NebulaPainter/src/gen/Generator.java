package gen;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

//--------------------------------//
//RANDOM IMAGE GENERATION
//class that generates images, pixel by pixel, using random numbers and user defined paramaters for RGB ranges
//paints main layer of random colored pixels, then optional filter layer
//options to randomly paint rectanglar regions, and random lines
//--------------------------------//


@SuppressWarnings("serial")
public class Generator extends Canvas{
	
	//width and height of the canvas frame
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	
	private static final Random random = new Random();
	Randomizer randomizer = new Randomizer();
	
	//user selections values, stored in an array, initialized to default settings
	//format:
	
	// {Filter R, Filter G, Filter B, Filter Intensity, Use Filter?, Random Range R Start, R End, G Start, G End, B Start, B End, 
	// Rectangles Enabled?, Rectangle Count, Rect Use Random Range?, Main Use Random Range?, Lines Count, Lines Use Random Range?, Lines Enabled? }
	private static int[] selections = {1, 1, 1, 2000000, 1, 0, 255, 0, 255, 0, 255, 0, 12, 1, 1, 5, 1, 0, 270};
	
	//run the image generator and save it as an image file, using the filename and selections from the user
	public void runGen(String filename, int[] choices){
		
		selections = choices;
		
		//create a new generator, as a canvas
		final Canvas canvas = new Generator();
		
		//check the generated images directory
		OutputFunctions.checkDir();
		
		//save the png file
		saveCanvas(canvas, filename);
	}
	
	
	//paint the canvas: initialize with base, then paint filter and rects/lines
	public void paint(Graphics g) {
		super.paint(g);
		
		//base layer, iterate over every pixel in the frame
        for(int x = 0; x < WIDTH; x++) {
            for(int y = 0; y < HEIGHT; y++) {
            	
            	//set the color of each pixel to a random color
            	Color mainColor = randomizer.randomColor();
            	
            	//if the user is using a random RGB range for colors, use the selected random color function instead
            	if(selections[14] == 1){
            		
            		mainColor = randomizer.selectedRandomColor(selections[5], selections[6], selections[7], selections[8], selections[9], selections[10]);
            	}
            	
            	//apply the color and set the pixel
                g.setColor(mainColor);
                g.drawLine(x, y, x, y);
            }
        }
       
       //paint filter if selected
        if(selections[4] == 1){
        	paint_random_filter(g);
        }
        
        //paint rectangles if selected
        if(selections[11] == 1){
        	
        	//for selected number of rectangles
	        for(int i = 0; i < selections[12]; i++){
	        	paint_random_rects(g);
	        }
        }
        
        //paint lines if selected
        if(selections[17] == 1){
        	paint_random_lines(g);
        }
	}
	
	
	//save the canvas as a png file 
	public static void saveCanvas(Canvas canvas, String filename) {

		//make a buffered image of RGB type with the width and height of the canvas
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
		
		//make a 2D graphics object from the buffered image
		Graphics2D g2= (Graphics2D) image.getGraphics();
		
		//paint the canvas, using the graphics object
		canvas.paint(g2);
		
		//write the image to a file
		try {
			ImageIO.write(image, "png", new File(filename));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//random color filter generated over the entire image
	public void paint_random_filter(Graphics g){
		
		//the number of repetitions of this function
		int count = selections[3];
		
		//hold coordinates of a random pixel
		int x, y = 0;
		
		//each repetition of this loop selects a random pixel in the canvas, and sets it to a chosen RGB color
		while(count > 0){
			
			//random x and y coordinate
			x = random.nextInt(WIDTH);
			y = random.nextInt(HEIGHT);
			
			//set the color of this pixel to the selected RGB value
			g.setColor(new Color(selections[0], selections[1], selections[2]));
			g.drawLine(x, y, x, y);
			
			count--;
		}
		
	}

	
	//select random rectangles within the canvas, and do random rectangular color events with random RGB ranges
	public void paint_random_rects(Graphics g){
		
		//create a randomly sized rectangle within the canvas
		int[] coordinates = randomizer.randomRectangle(WIDTH, HEIGHT);
		
		//paint a random number of pixels, with a user selected intesity, max 270
		int count = random.nextInt(selections[18] + 1); 
		
		//use either user selected color or a random color for the pixels of this rectangle
		if(selections[16] == 1){
			
			//select random color within user defined RGB range
    		Color rectColor = randomizer.selectedRandomColor(selections[5], selections[6], selections[7], selections[8], selections[9], selections[10]);
    		g.setColor(rectColor);
    	}
    	else{
    		
    		//select any random color
    		Color rectColor2 = randomizer.randomColor();
    		g.setColor(rectColor2);
    	}
		
		//initialize coordinates
		int x, y = 0;
		
		//paint count pixels within the selected retangle
		while(count > 0){
			
			//select random pixel within rectangle and paint
			x = random.nextInt((coordinates[2] - coordinates[0]) + 1) + coordinates[0];
			y = random.nextInt((coordinates[3] - coordinates[1]) + 1) + coordinates[1];
			g.drawLine(x, y, x, y);
			
			count--;
		}
		
	}

	
	//select random lines within the canvas with random RGB ranges
	public void paint_random_lines(Graphics g){
		
		//number of repetitions
		int count = selections[15];
		
		//define the two ends of the line
		int x, y, x2, y2 = 0;
	
		//iterate a user selected number of times
		while(count > 0){
			
			//user selected color or true random color
			if(selections[16] == 1){
				
				//select random color within user defined RGB range
	    		Color lineColor = randomizer.selectedRandomColor(selections[5], selections[6], selections[7], selections[8], selections[9], selections[10]);
	    		g.setColor(lineColor);
	    	}
	    	else{
	    		
	    		//true random color
	    		Color lineColor2 = randomizer.randomColor();
	    		g.setColor(lineColor2);
	    	}
			
			//randomize coordinates of the line's endpoints, draw the line
			x = random.nextInt(WIDTH);
			y = random.nextInt(HEIGHT);
			x2 = random.nextInt(WIDTH);
			y2 = random.nextInt(HEIGHT);
			
			g.drawLine(x, y, x2, y2);
			
			count--;
		}
	}
}
