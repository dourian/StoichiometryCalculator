import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SIConversion extends constants {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static double convert() throws IOException {
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
		double mass = rawMass * convRate;
		double MASS = mass;
		int count = 0;
		if (mass <= 0.001 || mass >= 1000) {
			while (mass > 10) {
				mass /= 10;
				count++;
			}

			while (mass < 1) {
				mass *= 10;
				count--;

			}
			System.out.printf("The mass is %f * 10e%d g\n", mass, count);
		} else {
			System.out.printf("Your mass is %fg\n", MASS);
		}
		return MASS;
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

