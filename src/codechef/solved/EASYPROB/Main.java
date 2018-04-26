import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static int divPower(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int p = 4;
		int i = 2;
		while (n / p > 0) {
			p = p * 2;
			i++;
		}
		return i - 1;
	}

	public static String printAsPower(int n) {
		if (n <= 0) {
			return "";
		}
		if (n == 1) {
			return "2(0)";
		}
		if (n == 2) {
			return "2";
		}
		if (n == 3) {
			return "2+2(0)";
		}

		int p = divPower(n);
		return "2(" + printAsPower(p) + ")" + ((n - (1 << p)) == 0 ? "" : ("+" + printAsPower(n - (1 << p))));
	}

	public static void main(String[] args) throws IOException {
		int n = 137;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 1315;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 73;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 136;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 255;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 1384;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
		n = 16385;
		System.out.println("console.log('"+n+"="+printAsPower(n)+"');");
	}

	public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 32768);
	public static StringTokenizer stringTokenizer = null;

	public static int gi() throws IOException {
		return Integer.parseInt(next());
	}

	public static long gl() throws IOException {
		return Long.parseLong(next());
	}

	public static double gd() throws IOException {
		return Double.parseDouble(next());
	}

	public static String gs() throws IOException {
		return next();
	}

	public static char gc() throws IOException {
		return next().charAt(0);
	}

	public static String next() {
		while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
			try {
				stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return stringTokenizer.nextToken();
	}

	public static StringBuilder ap(String str) {
		answerStringBuilder.append(str);
		return answerStringBuilder;
	}

	public static StringBuilder answerStringBuilder = new StringBuilder();

}