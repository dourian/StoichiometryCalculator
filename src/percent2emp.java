import java.util.*;
import java.io.*;

public class percent2emp extends constants{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		System.out.println("1. % -> emp\n2. emp -> %");
		int choice = readInt();
		if (choice==1) {
			p2e();
		}
		else {
			e2p();
		}
	}

	public static void p2e () throws IOException {
		System.out.println("How many distinct elements?");
		int n = readInt();
		ArrayList<Integer> list = new ArrayList <Integer>();
		
		
//		for (int i=0;i<n;i++) {
//			String element = readInt();
//			list.add(ele);
//		}
	}
	public static void e2p (){
		
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