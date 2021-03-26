import java.util.*;
import java.io.*;

public class gramsParticles extends constants{
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.out.println("Exit code: -1");
		while (true) {
			System.out.println("Type 1 for moles->particles, 2 for g->particles, 3 for molar mass ONLY");
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
			}
		} 
		/* TO DO LIST:
		 * 1. particles to moles, particles to grams
		 * 2. ions 
		 * 3. input formatting and such
		 * 4. SI unit conversion
		 */
	}
	
	// FIRST PROBLEM: CONVERT MOLES TO PARTICLES
    public static void molestoParticles(double moles){
        double N = moles * AVAGADROS_CONSTANT;
        // we are counting number of decimal places to have smaller calculations
        // without the hassle of such large numbers like 10e23
        int count = 0;
        if (N > 10) {
           do {
            N /=10;
            count++;
           }while (N > 10);
        } else if (N < 0) {
           do {
            N *=10;
            count--;
           } while (N < 10);
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
    	System.out.println("Enter your mass in grams");
    	double mass = readDouble();

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
