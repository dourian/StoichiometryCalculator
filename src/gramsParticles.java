import java.util.*;
import java.io.*;

public class gramsParticles extends constants{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.out.println("Exit code: -1");
		while (true) {
			System.out.println("Type 1 for moles->particles, 2 for <si unit>->particles, 3 for molar mass ONLY");
			System.out.println("1. moles->particles/atoms");
			System.out.println("2. <any MASS si unit> ->particles/atoms");
			System.out.println("3. molar mass ONLY");
			System.out.println("4. unit conversion ONLY");
			System.out.println("5. particles to moles");
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
				molestoParticles(moles);
			} else if (choice == 2) {
				try {
					gtoParticles();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (choice == 3) {
		    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
		    	System.out.println("Enter your chemical formula");
		    	String st[] = readLine().split(" ");
		    	System.out.printf("Your molar mass is %f\n", MMcalc(st));
			} else if (choice == 4) {
				SIConversion();
			} else if (choice == 5) {
				System.out.println("Please enter the number of particles in scientific notation.");
				System.out.println("Enter the decimal before the multiplication of 10.");
				double val = readDouble();
				System.out.println("Enter the exponent ONLY (eg, 10*23 only enter 23)");
				int exponent = readInt();
				
			}
		} 
		/* TO DO LIST:
		 * 1. particles to moles, particles to grams
		 * 2. ions 
		 * 3. input formatting and such
		 * 4. percentage comp
		 */
	}
	
	// FIRST PROBLEM: CONVERT MOLES TO PARTICLES
    public static void molestoParticles(double moles){
        double N = moles * AVAGADROS_CONSTANT;
        // we are counting number of decimal places to have smaller calculations
        // without the hassle of such large numbers like 10e23
        int count = 0;
        while (N > 10) {
            N /=10;
            count++;
        }
        
        while (N < 1) {
            N *=10;
            count--;
           
        }
        int exponent = 23 + count;
        System.out.printf("Number of particles: %f * 10e%d\n", N, exponent);
        return;
    }
    // SECOND PROBLEM: (EXT OF FIRST) GRAMS TO PARTICLES
    // issues: must enter the number of the element not just the element, might fix this later?
    public static void gtoParticles() throws Exception{
        // divide the g by MM, find mm
    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
    	System.out.println("Enter your chemical formula");
    	String st[] = readLine().split(" ");
    	System.out.println("Is your mass in grams? (y/n)");
    	char cond = readCharacter();
    	double mass= 0;
    	if (cond == 'y') {
    		mass = readDouble();
    	} else {
    		mass = SIConversion();
    	}
        // n = m / MM
        double n = mass / MMcalc(st);
        molestoParticles(n);
        return;
    }
    // ORGANIZE: CALCULATE MOLAR MASS SEPARATELY 
    public static double MMcalc(String st[]) {
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        int count = 0;
        for (String i : st) {
        	if (count%2 == 0) {
        		elements.add(i);
        	} else {
        		amount.add(Integer.parseInt(i));
        	}
        	count++;
        }
        double MM = 0.0;
        for (int i = 0; i<amount.size();++i) {
        	String curElm = elements.get(i);
        	int elmAmount = amount.get(i);
        	int index = Arrays.asList(ele).indexOf(curElm);
        	MM += elmAmount*gmol[index];
        }
    	return MM;
    }
    // WORKING SI CONVERSION :) 
    public static double SIConversion() throws IOException {
    	System.out.println("Enter the numeric amount of this unit.");
		double rawMass = readDouble();
		System.out.println("Please note the formatting:");
		System.out.println("tonnes->t");
		System.out.println("kilograms->kg");
		System.out.println("milligrams->mg");
		System.out.println("micrograms->ug");
		System.out.println("nanograms->ng");
		String unit = next();
		int idx = Arrays.asList(SINames).indexOf(unit);
		double convRate = SIConv[idx];
		double mass = rawMass*convRate;
		double MASS = mass;
       int count = 0;
       if (mass <= 0.001 || mass >= 1000) {
	        while (mass > 10) {
	            mass /=10;
	            count++;
	        }
	        
	        while (mass < 1) {
	            mass *=10;
	            count--;
	           
	        }
       }
		System.out.printf("The mass is %f * 10e%d g\n", mass, count);
    	return MASS;
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
