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
		double decimal = readDouble();
		System.out.println("Enter the exponent of the 10 (i.e 10e3, only enter 3.)");
		int exponent = readInt();
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
    	double mm = molarMass.MMcalc();
    	double massGrams = mole * mm;
    	System.out.printf("The mass in grams is %f g.", massGrams);
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
