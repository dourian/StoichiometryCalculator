import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class unittoX extends constants{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static molarMass MM;
	public static void molestoParticles(double moles) throws IOException{
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
    	String st[] = reader.readLine().split(" ");
    	System.out.println("Is your mass in grams? (y/n)");
    	char cond = reader.readCharacter();
    	double mass= 0;
    	if (cond == 'y') {
    		System.out.println("Enter the mass in grams.");
    		mass = reader.readDouble();
    	} else {
    		mass = SIConversion.convert();
    	}
        // n = m / MM
        double n = mass / molarMass.MMcalc(st);
        molestoParticles(n);
        return;
    }
}
