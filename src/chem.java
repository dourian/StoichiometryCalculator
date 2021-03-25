import java.util.*;
import java.math.*;
// hi
public class chem extends constants{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // double moles = sc.nextDouble();
        // molestoParticles(moles);
        String formula = sc.nextLine();
        gtoParticles(formula, 0.0);
    }
     // FIRST PROBLEM: CONVERT MOLES TO PARTICLES
    static void molestoParticles(double moles){
        double N = moles * AVAGADROS_CONSTANT;
        // we are counting number of decimal places to have smaller calculations
        // without the hassle of such large numbers like 10e23
        int count = 0;
        if (N > 10) {
           do {
            N /=10;
            count++;
           }while (N > 10);
        }else if (N < 10) {
           do {
            N *=10;
            count++;
           } while (N < 10);
        }
        int exponent = 23 + count;
        System.out.printf("Number of particles: %f * 10e%d\n", N, exponent);
        return;
    }
    // SECOND PROBLEM (EXT OF FIRST) GRAMS TO PARTICLES
    public static void gtoParticles(String formula, double mass){
        // divide the g by MM, find mm
        ArrayList<String> elements = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();
        String elmName = "";
        String elmCount = "";
        for (int i = 0; i < formula.length();++i) {
            char cur = formula.charAt(i);
            System.out.println(cur);
            if (cur == ' ') {
                if (elmCount.equals("")){
                    elements.add(elmName);
                } else if (elmName.equals("")){
                    int amountInt = Integer.parseInt(elmCount);
                    amount.add(amountInt);
                }
                elmName = "";
                elmCount = "";
            } else if (cur < 58) {
                elmCount+=cur;
            } else if (cur > 58) {
                elmName+=cur;
            }
        }
        System.out.println(elements);
        System.out.println(amount);
        return;
    }
}