import java.util.ArrayList;
import java.util.Arrays;

public class molarMass extends constants{
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
}
