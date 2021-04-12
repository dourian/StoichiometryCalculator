import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class particlestoX extends constants{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static double p2mole() throws IOException {
		System.out.println("Enter the decimal before the mulitplication of 10eX (i.e. 4.5 * 10e4 -> enter only 4.5)");
		double decimal = reader.readDouble();
		System.out.println("Enter the exponent of the 10 (i.e 10e3, only enter 3.)");
		int exponent = reader.readInt();
		double num = decimal/AVAGADROS_CONSTANT;
		exponent -= AVAGADROS_EXPONENT;
		while (exponent > 0) {
			num *=10;
		} 
		while (exponent < 0) {
			num /= 10;
		}
        System.out.printf("Number of moles is %f mol.\n", num);
		return num;
	}
    public static void particles2Grams() throws IOException {
    	double mole = p2mole();
    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
    	System.out.println("Enter your chemical formula");
    	String st[] = reader.readLine().split(" ");
    	double mm = molarMass.MMcalc(st);
    	double massGrams = mole * mm;
    	System.out.printf("The mass in grams is %f g.\n", massGrams);
    }
}
