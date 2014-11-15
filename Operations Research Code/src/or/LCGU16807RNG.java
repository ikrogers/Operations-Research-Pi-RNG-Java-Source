package or;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LCGU16807RNG {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your w0");
		double w0 = input.nextDouble();
		System.out.println("Enter number of iterations you wish to run ie. 10000");
		double limit = input.nextDouble();
		System.out.println("Enter how many data sets you wish to create");
		int set = input.nextInt();
		System.out.println("Begin operation...");
		u16807(w0,limit,set);
		System.out.println("Complete!");

	}
	
	public static void u16807(double w0, double limit, int set) {

		try {
			double a = 16807;
			double c = 0;
			double m = Math.pow(2, 31) - 1;
			FileWriter out = new FileWriter("U16807RNGOutput.txt");
			BufferedWriter output = new BufferedWriter(out);
			double[] sarr = new double[set];
			for (int j = 0; j < set; j++) {
				double temp = ((a * w0 + c) % m);
				w0 = temp;
				sarr[j] = w0/m;
				output.write(""+sarr[j]+"\t\t");
			}
			output.write(("\n"));
			
			while (limit > 1) {
				for (int j = 0; j < sarr.length-1; j++) {
					sarr[j] = sarr[j+1];
				}
				double temp = ((a * w0 + c) % m);
				w0 = temp;
				sarr[set-1] = w0/m;
				
				for (int i = 0; i<sarr.length; i++){
					output.write(""+(sarr[i])+"\t\t");
				}
				output.write(("\n"));
				limit--;
			}
			System.out.println("Writing to file...");

			out.flush();
			output.flush();
			out.close();
			output.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
