import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class molarMass extends constants{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
    public static double MMcalc(String st[]) throws IOException {
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
}
