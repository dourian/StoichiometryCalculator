

import java.util.*;
import java.io.*;

public class percent2emp extends constants{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void p2e () throws IOException {
		System.out.println("How many distinct elements?");
		int n = reader.readInt();
		ArrayList<Integer> list = new ArrayList <Integer>();
		ArrayList<Double> percent = new ArrayList <Double>();
		ArrayList<Double> mols = new ArrayList <Double>();

		for (int i=0;i<n;i++) {
			System.out.println("Element "+(i+1)+": ");
			String element = reader.readLine();
			for (int j=0;j<ele.length;j++) {
				if (ele[j].equals(element)) {
					list.add(j);
				}
			}
			System.out.println("Percentage: ");
			percent.add(reader.readDouble());
			double a = percent.get(i)/gmol[list.get(i)];
			mols.add(Math.round(a*100)/100.0);
		}
		for (int i=0;i<list.size();i++) {
			System.out.print(ele[list.get(i)] + ": ");
			System.out.print(mols.get(i));
			System.out.println(" mols");
		}
		double least=Integer.MAX_VALUE;
		for (double x  :mols) {
			if (x<least) least=x;
		}
		for (int i=0;i<list.size();i++) {
			System.out.print(ele[list.get(i)] + ": ");
			System.out.print( Math.round((mols.get(i)/least))+" ");
		}
		System.out.println("\n");
	}
	public static void e2p () throws IOException{
		System.out.println("How many distinct elements?");
		int n = reader.readInt();
		ArrayList<Integer> list = new ArrayList <Integer>();
		ArrayList<Integer> num = new ArrayList <Integer>();
		ArrayList<Double> mass = new ArrayList <Double>();

		for (int i=0;i<n;i++) {
			System.out.println("Element "+(i+1)+": ");
			String element = reader.readLine();
			for (int j=0;j<ele.length;j++) {
				if (ele[j].equals(element)) {
					list.add(j);
				}
			}
			System.out.println("#of element/mol: ");
			num.add(reader.readInt());
			mass.add(num.get(i)*gmol[list.get(i)]);
		}

		double total=0;
		for (double x  :mass) {
			total+=x;
		}
		for (int i=0;i<list.size();i++) {
			System.out.print(ele[list.get(i)] + ": ");
			System.out.printf("%.2f", (mass.get(i)/total)*100);
			System.out.print("% ");
		}
		System.out.println("\n");
	}
}