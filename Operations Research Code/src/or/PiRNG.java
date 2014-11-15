package or;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class PiRNG {
	/** Get initial inputs to feed it to Pi RNG */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out
				.println("Using file picker select your file where your Pi value is stored:");
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();

		System.out
				.println("How many times you want to run the RNG without resetting back to beginning (Sets of data outputs for graphing will be in from 0 to U+set# format)");
		int set = input.nextInt();
		System.out.println("Enter number of samples to take:");
		int limit = input.nextInt();
		System.out.println("Enter size of the slice to take each iteration");
		int slice = input.nextInt();
		System.out
				.println("Enter the initialization point (beginning pointer). Ex: 5 = fifth decimal, 0 = starts at 3.");
		int pointer = input.nextInt();

		System.out.println("Computing... \n");
		System.out.println("Writing to file... \n");
		/**
		 * Call Pi RNG with specified parameters
		 */
		pirng(limit, file, slice, set, pointer);
		System.out.println("Complete! \n");
		input.close();

	}

	/**
	 * Pi RNG. Takes in number of times to run (limit), calculated Pi text file,
	 * slices in which to divide Pi into, number of sets to generate for graphs,
	 * and where to initialize the pointer.
	 */
	public static void pirng(int limit, File pi, int slice, int set, int pointer) {
		try {
			FileInputStream ifs = new FileInputStream(pi);
			FileWriter out = new FileWriter("PiRNGOutput.txt");
			BufferedWriter output = new BufferedWriter(out);
			BufferedInputStream bis = new BufferedInputStream(ifs);
			String rn = "";
			String[] sarr = new String[set];
			bis.skip(pointer);
			for (int j = 0; j < set; j++) {
				rn = "";
				for (int i = 0; i < slice; i++) {
					char c = (char) bis.read();
					if (c == '.')
						/** If a decimal is encountered ignore it and */
						c = (char) bis.read();
					rn += c;
				}
				sarr[j] = rn;
				output.write((Double.parseDouble(rn) / (Math.pow(10, slice)) + "\t\t"));
			}
			output.write(("\n"));
			while (limit > 1 && bis.available() != 0 ) {
				rn = "";
				for (int j = 0; j < sarr.length-1; j++) {
					sarr[j] = sarr[j+1];
				}
				for (int i = 0; i < slice; i++) {
					char c = (char) bis.read();
					if (c == '.')
						c = (char) bis.read();
					rn += c;
				}
				sarr[set-1] = rn;
				
				for (int i = 0; i<sarr.length; i++){
					output.write((Double.parseDouble(sarr[i]) / (Math.pow(10, slice)) + "\t\t"));
				}
				output.write(("\n"));
				limit--;
			}
			out.flush();
			output.flush();
			bis.close();
			out.close();
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
