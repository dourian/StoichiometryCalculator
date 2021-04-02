import java.util.*;
import java.io.*;

public class Main extends constants{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static SIConversion conversion;
	static unittoX convert;
	static percent2emp p2e2p;
	
	public static void main(String[] args) throws IOException {
		System.out.println("Exit code: -1");
		while (true) {
			System.out.println("Type 1 for moles->particles, 2 for <si unit>->particles, 3 for molar mass ONLY");
			System.out.println("1. moles->particles/atoms");
			System.out.println("2. <any MASS si unit>->particles/atoms");
			System.out.println("3. molar mass ONLY");
			System.out.println("4. unit conversion ONLY");
			System.out.println("5. particles->moles");
			System.out.println("6. empiral->%");
			System.out.println("7. %->empirical");
			int choice = readInt();
			if (choice == -1) {
				System.out.println("Goodbye");
				break;
			} else if (choice < -1) {
				System.out.println("Try again, invalid");
				continue;
			} else if (choice == 1) {
				System.out.println("Enter number of moles");
				double moles = readDouble();
				unittoX.molestoParticles(moles);
			} else if (choice == 2) {
				try {
					unittoX.gtoParticles();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (choice == 3) {
		    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
		    	System.out.println("Enter your chemical formula");
		    	String st[] = readLine().split(" ");
		    	System.out.printf("Your molar mass is %f g/mol\n", molarMass.MMcalc(st));
			} else if (choice == 4) {
				SIConversion.convert();
			} else if (choice == 5) {
				System.out.println("Please enter the number of particles in scientific notation.");
				System.out.println("Enter the decimal before the multiplication of 10.");
				double val = readDouble();
				System.out.println("Enter the exponent ONLY (eg, 10*23 only enter 23)");
				int exponent = readInt();
			} else if (choice == 6) {
				percent2emp.p2e();
			} else if (choice == 7) {
				percent2emp.e2p();
			} else if (choice == 8) {
				
			}
		} 
		/* TO DO LIST:
		 * 1. particles to moles, particles to grams
		 * 2. ions 
		 * 3. input formatting and such
		 * 4. percentage comp
		 */
	}
	
    // wip
    public static void particles2Moles(double val, int exponent) {
    	
    }
    // wip
    public static void particles2Grams() {
    	
    }
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
