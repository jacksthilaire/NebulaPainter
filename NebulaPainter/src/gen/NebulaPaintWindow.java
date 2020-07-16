package gen;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Checkbox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


//The main application window, and a function to get all of the user choices
public class NebulaPaintWindow {

	private JFrame frmNebulaPainter;
	private JTextField genName;
	private JTextField colorRtxt;
	private JTextField colorGtxt;
	private JTextField colorBtxt;
	private JTextField intensityTxt;
	private boolean useFilter = true;
	private JTextField textRMin;
	private JTextField textRMax;
	private JTextField textGMin;
	private JTextField textGMax;
	private JTextField textBMin;
	private JTextField textBMax;
	private JTextField rectCountTxt;
	private boolean rectUseRandom = true;
	private boolean rectEnabledCheck = false;
	private boolean mainUseRandom = true;
	private JTextField linesCountTxt;
	private boolean linesUseRandom = true;
	private boolean linesEnabledCheck = false;
	private JTextField rectIntensity;

	//run the application, open the window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NebulaPaintWindow window = new NebulaPaintWindow();
					window.frmNebulaPainter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	//call the init
	public NebulaPaintWindow() {
		initialize();
	}

	
	//initialize contents
	private void initialize() {
		frmNebulaPainter = new JFrame();
		frmNebulaPainter.getContentPane().setBackground(Color.DARK_GRAY);
		frmNebulaPainter.setIconImage(Toolkit.getDefaultToolkit().getImage(NebulaPaintWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/minimize-pressed.gif")));
		frmNebulaPainter.setTitle("NebulaPainter");
		frmNebulaPainter.setBounds(100, 100, 950, 800);
		frmNebulaPainter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNebulaPainter.getContentPane().setLayout(null);
		
		JLabel drawNebula = new JLabel("");
		drawNebula.setBackground(Color.LIGHT_GRAY);
		drawNebula.setBounds(320, 13, 602, 602);
		
		ImageIcon imgThisImg = new ImageIcon("./resources/default.png");
		
		JPanel randomPanel_1 = new JPanel();
		randomPanel_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Rectangles", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		randomPanel_1.setBackground(Color.DARK_GRAY);
		randomPanel_1.setBounds(320, 628, 352, 118);
		frmNebulaPainter.getContentPane().add(randomPanel_1);
		randomPanel_1.setLayout(null);
		
		Checkbox rectRanges = new Checkbox("Apply rand ranges?");
		rectRanges.setForeground(Color.WHITE);
		rectRanges.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				//if user unchecks or checks the box, update the variable for this choice
				if(arg0.getStateChange() == 1){
					rectUseRandom = true;
				}
				else{
					rectUseRandom = false;
				}
			}
		});
		
		rectRanges.setState(true);
		rectRanges.setBounds(12, 56, 146, 24);
		randomPanel_1.add(rectRanges);
		
		Checkbox rectEnable = new Checkbox("Enable?");
		rectEnable.setState(true);
		rectEnable.setForeground(Color.WHITE);
		rectEnable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				//if user unchecks or checks the box, update the variable for this choice
				if(arg0.getStateChange() == 1){
					rectEnabledCheck = true;
				}
				else{
					rectEnabledCheck = false;
				}
			}
		});
		rectEnable.setBounds(12, 26, 108, 24);
		randomPanel_1.add(rectEnable);
		
		rectCountTxt = new JTextField();
		rectCountTxt.setText("12");
		rectCountTxt.setBounds(270, 26, 40, 22);
		randomPanel_1.add(rectCountTxt);
		rectCountTxt.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Number (1-20):");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(168, 26, 90, 16);
		randomPanel_1.add(lblNewLabel_2);
		
		rectIntensity = new JTextField();
		rectIntensity.setText("205");
		rectIntensity.setBounds(270, 56, 40, 22);
		randomPanel_1.add(rectIntensity);
		rectIntensity.setColumns(10);
		
		JLabel lblIntensityCap = new JLabel("Intensity(0-270):");
		lblIntensityCap.setForeground(Color.WHITE);
		lblIntensityCap.setBounds(164, 56, 136, 16);
		randomPanel_1.add(lblIntensityCap);
		
		JPanel filterPanel = new JPanel();
		filterPanel.setBackground(Color.DARK_GRAY);
		filterPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Filter", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		filterPanel.setBounds(12, 267, 285, 253);
		frmNebulaPainter.getContentPane().add(filterPanel);
		filterPanel.setLayout(null);
		
		JLabel colorRlbl = new JLabel("Color (R):");
		colorRlbl.setBounds(22, 59, 57, 16);
		colorRlbl.setForeground(Color.WHITE);
		filterPanel.add(colorRlbl);
		
		colorRtxt = new JTextField();
		colorRtxt.setBounds(115, 56, 94, 22);
		colorRtxt.setText("0");
		filterPanel.add(colorRtxt);
		colorRtxt.setColumns(10);
		
		JLabel colorGlbl = new JLabel("Color (G):");
		colorGlbl.setBounds(22, 85, 57, 16);
		colorGlbl.setForeground(Color.WHITE);
		filterPanel.add(colorGlbl);
		
		JLabel colorBlbl = new JLabel("Color (B):");
		colorBlbl.setBounds(23, 111, 56, 16);
		colorBlbl.setForeground(Color.WHITE);
		filterPanel.add(colorBlbl);
		
		colorGtxt = new JTextField();
		colorGtxt.setBounds(115, 82, 94, 22);
		colorGtxt.setText("0");
		colorGtxt.setColumns(10);
		filterPanel.add(colorGtxt);
		
		colorBtxt = new JTextField();
		colorBtxt.setBounds(115, 108, 94, 22);
		colorBtxt.setText("0");
		colorBtxt.setColumns(10);
		filterPanel.add(colorBtxt);
		
		JLabel filterColor = new JLabel("Color (RGB - 0-255):");
		filterColor.setBounds(12, 27, 131, 16);
		filterColor.setForeground(Color.WHITE);
		filterColor.setFont(new Font("Tahoma", Font.BOLD, 13));
		filterPanel.add(filterColor);
		
		JLabel filterIntensityLbl = new JLabel("Intensity (0 - 2000000): ");
		filterIntensityLbl.setBounds(12, 144, 231, 16);
		filterIntensityLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		filterIntensityLbl.setForeground(Color.WHITE);
		filterPanel.add(filterIntensityLbl);
		
		intensityTxt = new JTextField();
		intensityTxt.setBounds(115, 173, 94, 22);
		intensityTxt.setText("1800000");
		intensityTxt.setColumns(10);
		filterPanel.add(intensityTxt);
		
		JLabel intensityLbl = new JLabel("Intensity:");
		intensityLbl.setBounds(22, 173, 53, 16);
		intensityLbl.setForeground(Color.WHITE);
		filterPanel.add(intensityLbl);
		drawNebula.setIcon(imgThisImg);
		frmNebulaPainter.getContentPane().add(drawNebula);
		
		JPanel generatePanel = new JPanel();
		generatePanel.setBackground(Color.GRAY);
		generatePanel.setBorder(null);
		generatePanel.setBounds(12, 13, 285, 95);
		frmNebulaPainter.getContentPane().add(generatePanel);
		generatePanel.setLayout(null);
		
		JButton generateButton = new JButton("Generate Image");
		generateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		generateButton.setForeground(Color.BLACK);
		generateButton.setBounds(60, 48, 156, 34);
		generatePanel.add(generateButton);
		generateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
			
				//initialize empty file name
				String name = "";
				
				Random rand = new Random();
				
				//if the user didn't enter anything, make a random name for the file
				if(genName.getText().length() <= 0){
					name = "nebula-" + rand.nextInt(10000);
				}
				else{
					//set the name to a user selected if applicable
					name = genName.getText();
				}
				
				
				//creating the image, in a local folder for the generated images
				String filename = "./nebulas/" + name + ".png";
					
				//run the generator with user selections and file name
				Generator gen = new Generator();
				gen.runGen(filename, getChoices());
					
				//update the image on the main label
				ImageIcon newImg = new ImageIcon(filename);
				drawNebula.setIcon(newImg);
					
				//reload the frame
				frmNebulaPainter.invalidate();
				frmNebulaPainter.validate();
				frmNebulaPainter.repaint();
					
				//output settings
				OutputFunctions settings = new OutputFunctions();
				settings.printToFile(name, getChoices());
					
				//notify of completion
				settings.displayMessage("Image Saved", "Saved to: ./nebulas/" + name, frmNebulaPainter);
				
			}
		});
		
		genName = new JTextField();
		genName.setBounds(71, 10, 187, 22);
		generatePanel.add(genName);
		genName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Save as: ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		generatePanel.add(lblNewLabel_1);
		
		JPanel randomPanel = new JPanel();
		randomPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Random Color", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		randomPanel.setBounds(12, 533, 285, 195);
		randomPanel.setBackground(Color.DARK_GRAY);
		frmNebulaPainter.getContentPane().add(randomPanel);
		randomPanel.setLayout(null);
		
		JLabel randomColLbl1 = new JLabel("Random Color Ranges:");
		randomColLbl1.setBounds(12, 25, 226, 16);
		randomColLbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		randomColLbl1.setForeground(Color.WHITE);
		randomPanel.add(randomColLbl1);
		
		textRMin = new JTextField();
		textRMin.setBounds(53, 56, 56, 22);
		textRMin.setText("0");
		randomPanel.add(textRMin);
		textRMin.setColumns(10);
		
		textRMax = new JTextField();
		textRMax.setBounds(136, 56, 56, 22);
		textRMax.setText("255");
		textRMax.setColumns(10);
		randomPanel.add(textRMax);
		
		textGMin = new JTextField();
		textGMin.setBounds(53, 86, 57, 22);
		textGMin.setText("0");
		textGMin.setColumns(10);
		randomPanel.add(textGMin);
		
		textGMax = new JTextField();
		textGMax.setBounds(136, 86, 56, 22);
		textGMax.setText("255");
		textGMax.setColumns(10);
		randomPanel.add(textGMax);
		
		textBMin = new JTextField();
		textBMin.setBounds(53, 116, 56, 22);
		textBMin.setText("0");
		textBMin.setColumns(10);
		randomPanel.add(textBMin);
		
		textBMax = new JTextField();
		textBMax.setBounds(136, 116, 56, 22);
		textBMax.setText("255");
		textBMax.setColumns(10);
		randomPanel.add(textBMax);
		
		JLabel lblNewLabel_4 = new JLabel("R: ");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(22, 59, 122, 16);
		randomPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("G: ");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(22, 91, 122, 16);
		randomPanel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("B:  ");
		lblNewLabel_4_2.setForeground(Color.WHITE);
		lblNewLabel_4_2.setBounds(22, 121, 122, 16);
		randomPanel.add(lblNewLabel_4_2);
		
		JPanel randomPanel_1_1 = new JPanel();
		randomPanel_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Lines", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		randomPanel_1_1.setBackground(Color.DARK_GRAY);
		randomPanel_1_1.setBounds(699, 628, 205, 118);
		frmNebulaPainter.getContentPane().add(randomPanel_1_1);
		randomPanel_1_1.setLayout(null);
		
		Checkbox OvalsRanges = new Checkbox("Apply rand ranges?");
		OvalsRanges.setState(true);
		OvalsRanges.setForeground(Color.WHITE);
		OvalsRanges.setBounds(12, 56, 146, 24);
		randomPanel_1_1.add(OvalsRanges);
		
		linesCountTxt = new JTextField();
		linesCountTxt.setText("5");
		linesCountTxt.setBounds(107, 86, 51, 22);
		randomPanel_1_1.add(linesCountTxt);
		linesCountTxt.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Number (1-20):");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(12, 89, 96, 16);
		randomPanel_1_1.add(lblNewLabel_3);
		
		Checkbox linesEnable = new Checkbox("Enable?");
		linesEnable.setForeground(Color.WHITE);
		linesEnable.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//if user unchecks or checks the box, update the variable for this choice
				if(arg0.getStateChange() == 1){
					linesEnabledCheck = true;
				}
				else{
					linesEnabledCheck = false;
				}
			}
		});
		linesEnable.setBounds(10, 26, 108, 24);
		randomPanel_1_1.add(linesEnable);
		
		JPanel randomPanel_1_2 = new JPanel();
		randomPanel_1_2.setBounds(12, 136, 285, 118);
		frmNebulaPainter.getContentPane().add(randomPanel_1_2);
		randomPanel_1_2.setLayout(null);
		randomPanel_1_2.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "General", TitledBorder.LEFT, TitledBorder.TOP, null, Color.WHITE));
		randomPanel_1_2.setBackground(Color.DARK_GRAY);
		
		Checkbox mainLayerRanges = new Checkbox("Apply Random Ranges to Main Layer?");
		mainLayerRanges.setForeground(Color.WHITE);
		mainLayerRanges.setState(true);
		mainLayerRanges.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//if user unchecks or checks the box, update the variable for this choice
				if(arg0.getStateChange() == 1){
					mainUseRandom = true;
				}
				else{
					mainUseRandom = false;
				}
			}
		});
		mainLayerRanges.setBounds(28, 61, 247, 24);
		randomPanel_1_2.add(mainLayerRanges);
		
		Checkbox checkboxFilter_1 = new Checkbox("Use Filter?");
		checkboxFilter_1.setBounds(28, 22, 79, 32);
		randomPanel_1_2.add(checkboxFilter_1);
		checkboxFilter_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		checkboxFilter_1.setForeground(Color.WHITE);
		checkboxFilter_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//if user unchecks or checks the box, update the variable for this choice
				if(arg0.getStateChange() == 1){
					useFilter = true;
				}
				else{
					useFilter = false;
				}
			}
		});
		checkboxFilter_1.setState(true);
	}
	
	
	//get the user's selections and return them in an int array
	private int[] getChoices(){
		
		//array with the same init as the generator
		int[] choices = {1, 1, 1, 2000000, 1, 0, 255, 0, 255, 0, 255, 1, 12, 1, 1, 5, 1, 0, 270};
		
		//check if using random for main layer
		if(mainUseRandom == false){
			choices[14] = 0;
		}
		
		//getting user choices for filter rgb and intensity
		int rChoice = Integer.parseInt(colorRtxt.getText());
		int gChoice = Integer.parseInt(colorGtxt.getText());
		int bChoice = Integer.parseInt(colorBtxt.getText());
		int intenseChoice = Integer.parseInt(intensityTxt.getText());
		
		//if they are in appropriate ranges, update defaults
		if(0 <= rChoice && rChoice <= 255){
			choices[0] = rChoice;
		}
		if(0 <= gChoice && gChoice <= 255){
			choices[1] = gChoice;
		}
		if(0 <= bChoice && bChoice <= 255){
			choices[2] = bChoice;
		}
		
		if(0 <= intenseChoice && intenseChoice <= 2000000){
			choices[3] = intenseChoice;
		}
		
		//use a filter or not
		if(useFilter == true){
			choices[4] = 1;
		}
		else{
			choices[4] = 0;
		}
		
		//random ranges of color used in creating the image chosen by users
		int r1 = Integer.parseInt(textRMin.getText());
		int r2 = Integer.parseInt(textRMax.getText());
		int g1 = Integer.parseInt(textGMin.getText());
		int g2 = Integer.parseInt(textGMax.getText());
		int b1 = Integer.parseInt(textBMin.getText());
		int b2 = Integer.parseInt(textBMax.getText());
		
		//check to make sure they are in appropriate ranges then update defaults
		if(0 <= r1 && r2 <= 255){
			choices[5] = r1;
			choices[6] = r2;
		}
		
		if(0 <= g1 && g2 <= 255){
			choices[7] = g1;
			choices[8] = g2;
		}

		if(0 <= b1 && b2 <= 255){
			choices[9] = b1;
			choices[10] = b2;
		}
		
		//rectangle options
		//user random color check
		if(rectUseRandom == false){
			choices[13] = 0;
		}
		
		//enable check
		if(rectEnabledCheck == true){
			choices[11] = 1;
		}
		
		int rectCount = Integer.parseInt(rectCountTxt.getText());
	
		//check to make sure the count of rectangles is in the range
		if(1 <= rectCount && rectCount <= 20){
			choices[12] = rectCount;
		}
		
		int rectIntense = Integer.parseInt(rectIntensity.getText());
		
		//check to make sure intensity for rects is safe
		if(0 <= rectIntense && rectIntense <= 270){
			choices[18] = rectIntense;
		}
		
		//lines
		//check if lines enabled
		if(linesEnabledCheck == true){
			choices[17] = 1;
		}
		
		int linesCount = Integer.parseInt(linesCountTxt.getText());
		
		//check if count is safe
		if(0 <= linesCount && linesCount <= 20){
			choices[15] = linesCount;
		}
		
		//using random?
		if(linesUseRandom == false){
			choices[16] = 0;
		}
	
		return choices;
	}
}
