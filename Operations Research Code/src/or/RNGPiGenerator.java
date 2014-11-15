package or;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class RNGPiGenerator {

	public static void main(String[] args) {
		System.out
				.println("Enter which RNG to use. Enter either 1 for Pi or 2 for LCG U16807");
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
		if (in == 1) {
			System.out
					.println("Select corresponding file with Pi values to read...");
			JFileChooser fc = new JFileChooser();
			//fc.showSaveDialog(null);
			//File file = fc.getSelectedFile();
			File file = new File("C:/Users/IK/Dropbox/Networking/IRogers_a1_cs4121/grade/PiRNGOutput.txt");
			try {
				double x = System.currentTimeMillis();
				piSimPi(file);
				System.out.println("Time elapsed:"+(System.currentTimeMillis()-x));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (in == 2) {
			System.out
			.println("Select corresponding file with U16807 values to read...");
			JFileChooser fc = new JFileChooser();
			//fc.showSaveDialog(null);
			//File file = fc.getSelectedFile();
			File file = new File("C:/Users/IK/Dropbox/Networking/IRogers_a1_cs4121/grade/U16807RNGOutput.txt");
			try {
				double x = System.currentTimeMillis();
				piSimU16807(file);
				System.out.println("Time elapsed:"+(System.currentTimeMillis()-x));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else
			System.out.println("Invalid input.");

	}
	
	public static void piSimU16807(File file) throws FileNotFoundException{
		System.out.println("Enter sample size to read...");
		Scanner in = new Scanner(file);
		Scanner input = new Scanner(System.in);
		double size = input.nextDouble();
		System.out.println("Running...");

		int lim = 0;
		double success = 0;
		while (lim < size) {
			double x = Double.parseDouble(in.nextLine());
			double y = Double.parseDouble(in.nextLine());
			if (((x*x) + (y*y)) <= 1){
				success++;
			}	
			lim++;
		}
		double ph = (success / size);
		double tp = Math.PI ;
		double std_err = Math.sqrt((ph * (1 - ph)) / size);
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++\n"
				+ "p hat is: " + ph*4 + "\ntrue p is: " + tp
				+ "\nStandard error is: " + std_err*4);
	}

	public static void piSimPi(File file) throws FileNotFoundException {
		System.out.println("Enter sample size to read...");
		Scanner in = new Scanner(file);
		Scanner input = new Scanner(System.in);
		double size = input.nextDouble();
		System.out.println("Running...");
		int lim = 0;
		double success = 0;
		while (lim < size) {
			double x = Double.parseDouble(in.nextLine());
			double y = Double.parseDouble(in.nextLine());
			if (((x*x) + (y*y)) <= 1){
				success++;
			}	
			lim++;
		}
		double ph = (success / size);
		double tp = Math.PI;
		double std_err = Math.sqrt((ph * (1 - ph)) / size);
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++\n"
				+ "p hat is: " + ph*4 + "\ntrue p is: " + tp
				+ "\nStandard error is: " + std_err*4);

	}

}
