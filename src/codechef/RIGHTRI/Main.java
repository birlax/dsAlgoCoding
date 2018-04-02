import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import sun.security.action.GetBooleanAction;

// Do not change the class name or package
public class Main {

	public static boolean isRightTriangle(int[] a) {

		double x = Math.sqrt((1.0 * (a[3] - a[1]) * (a[3] - a[1])) + (1.0 * (a[2] - a[0]) * (a[2] - a[0])));
		double y = Math.sqrt((1.0 * (a[5] - a[3]) * (a[5] - a[3])) + (1.0 * (a[4] - a[2]) * (a[4] - a[2])));
		double z = Math.sqrt((1.0 * (a[1] - a[5]) * (a[1] - a[5])) + (1.0 * (a[0] - a[4]) * (a[0] - a[4])));
		double dd[] = new double[] { x, y, z };
		Arrays.sort(dd);
		//System.out.println(Arrays.toString(dd)  + " -> " + (dd[2] * dd[2]) + " " +  (dd[1] * dd[1] + dd[0] * dd[0]) );
		if (Math.round(dd[2] * dd[2]) == Math.round((dd[1] * dd[1] + dd[0] * dd[0]))) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		int c = 0;
		for (int t = 0; t < T; t++) {
			int a[] = new int[6];
			for (int i = 0; i < 6; i++) {
				a[i] = gi();
			}
			if (isRightTriangle(a)) {
				c++;
			}
		}
		System.out.println(c);

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