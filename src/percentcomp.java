import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class percentcomp extends constants{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void percentageComposition() throws IOException {
    	System.out.println("Make sure formatting goes as follows: CH4 is formatted as C 1 H 4");
    	System.out.println("Enter your chemical formula");
    	String st[] = reader.readLine().split(" ");
    	double mm = molarMass.MMcalc(st);
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
        for (int i = 0; i < elements.size(); i++) {
        	String st_1[] = new String[2];
        	st_1[0] = elements.get(i);
        	st_1[1] = String.valueOf(amount.get(i));
        	double element = molarMass.MMcalc(st_1);
        	double percent = (element/mm)*100;
        	System.out.printf("Percentage of %s is %f percent\n", st_1[0], percent);
        }
	}
}
