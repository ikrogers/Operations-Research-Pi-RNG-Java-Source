package or;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.math.plot.*;

public class XYZPlot {
	
	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		Scanner in = new Scanner(file);
		System.out.println("Enter sample size you are reading in");
		int size = new Scanner(System.in).nextInt();
		
		  double[] x = new double[size];
		  double[] y = new double[size];
		  double[] z = new double[size];
		  int lim = 0;
		  while (lim<size){
			  String s = in.nextLine();
			  String [] sa = new String[3];
			  x[lim] = Double.parseDouble(s.split("\t\t")[0]);
			  y[lim] = Double.parseDouble(s.split("\t\t")[1]);
			  z[lim] = Double.parseDouble(s.split("\t\t")[2]);

			  lim++;
		  }
		  
		 

		  
		 
		  // create your PlotPanel (you can use it as a JPanel)
		  Plot3DPanel plot = new Plot3DPanel();
		 
		  // add a line plot to the PlotPanel
		  plot.addScatterPlot("my plot", x,y,z);
		  plot.changePlotColor(0, Color.BLACK);
		  // put the PlotPanel in a JFrame, as a JPanel
		  JFrame frame = new JFrame("a plot panel");
		  frame.setContentPane(plot);
		  frame.setVisible(true);
		
		
		
	}

}
