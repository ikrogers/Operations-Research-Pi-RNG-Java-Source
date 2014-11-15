package or;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class RNGSwitchTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Pick a file containing generated RNs");
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(null);
		File file = fc.getSelectedFile();
		System.out.println("Enter P of A being ON P(0,1)");
		double pA = input.nextDouble();
		System.out.println("Enter P of B being ON P(0,1)");
		double pB = input.nextDouble();
		System.out.println("Enter P of C being ON P(0,1)");
		double pC = input.nextDouble();
		System.out.println("Enter P of D being ON P(0,1)");
		double pD = input.nextDouble();
		System.out.println("Enter number of iterations");
		int iterations = input.nextInt();
		
		System.out.println("Running...");
		try {
			double x = System.currentTimeMillis();
			System.out.println(elSwitch(file,pA,pB,pC,pD,iterations));
			System.out.println("Time elapsed:"+(System.currentTimeMillis()-x));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");


	}

	public static String elSwitch(File file, double pA, double pB, double pC, double pD, int limit) throws FileNotFoundException {
		Scanner input = new Scanner(file);
		double k = 0;
		boolean A;
		boolean B;
		boolean C;
		boolean D;
		double w0;
		int m = limit;
		int tmp = m;
		while (tmp > 0) {
			A = false;
			B = false;
			C = false;
			D = false;
			w0 = Double.parseDouble(input.nextLine());
			if (w0 <= pA) {
				A = true;
			}
			w0 = Double.parseDouble(input.nextLine());
			if (w0 <= pB) {
				C = true;
			}
			w0 = Double.parseDouble(input.nextLine());
			if (w0 <= pC) {
				B = true;
			}
			w0 = Double.parseDouble(input.nextLine());
			if (w0 <= pD) {
				D = true;
			}
			if (A == true && B == true && C == true){
				k++;
			}
			if (A == true && D == true){
				k++;
			}
			tmp--;
		}
		double ph = k/m;
		double tp = pA*pB*pC+(pA*pD);
		double std_err = Math.sqrt((ph*(1-ph))/m);
		String report = "\n+++++++++++++++++++++++++++++++++++++++++\n"+"p hat is: "+ ph + "\ntrue p is: "+ tp+"\nStandard error is: "+ std_err;
		return report;

	}
}
