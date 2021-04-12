import java.util.*;
import java.io.*;

public class Main extends constants{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		System.out.println("Exit code: -1");
		while (true) {
			System.out.println("1. moles->particles/atoms");
			System.out.println("2. <any MASS si unit>->particles/atoms");
			System.out.println("3. molar mass ONLY");
			System.out.println("4. unit conversion ONLY");
			System.out.println("5. particles->moles");
			System.out.println("6. particles->grams");
			System.out.println("7. empiral->%");
			System.out.println("8. %->empirical");
			System.out.println("9. % composition");
			int choice = reader.readInt();
			if (choice == -1) { // exit code
				System.out.println("Goodbye");
				break;
			} else if (choice < -1) { // invalid
				System.out.println("Try again, invalid");
				continue;
			} else if (choice == 1) { // mole -> particle
				System.out.println("Enter number of moles");
				double moles = reader.readDouble();
				unittoX.molestoParticles(moles);
			} else if (choice == 2) { // any mass unit -> particle
				unittoX.gtoParticles();
			} else if (choice == 3) { // MM only
		    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
		    	System.out.println("Enter your chemical formula");
		    	String st[] = reader.readLine().split(" ");
		    	double MM = molarMass.MMcalc(st);
		    	System.out.printf("Molar mass is %fg/mol.\n", MM);
			} else if (choice == 4) { // unit conversion only
				SIConversion.convert();
			} else if (choice == 5) { // particles -> moles
				particlestoX.p2mole();
			} else if (choice == 6) {
				particlestoX.particles2Grams();
			} else if (choice == 7) {
				percent2emp.e2p();
			} else if (choice == 8) {
				percent2emp.p2e();
			} else if (choice == 9) {
		    	percentcomp.percentageComposition();
			}
		} 
		/* TO DO LIST:
		 * 1. particles to moles, particles to grams
		 * 2. ions 
		 * 3. input formatting and such
		 * 4. percentage comp
		 */
	}
}
