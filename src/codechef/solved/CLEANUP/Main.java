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

	public static void assigne(int a[]) {
		int c = 1;
		// -1 un-finished job
		// 0 finished job
		// 1 means chef will do this.
		// 2 means his assistant will do it.
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				continue;
			}
			a[i] = c;
			if (c == 1) {
				c = 2;
			} else {
				c = 1;
			}
		}
	}

	public static void printJobs(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 2) {
				System.out.print((i + 1) + " ");
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi();
			int M = gi();
			int a[] = new int[N];
			Arrays.fill(a, -1);
			// zero are job done already
			for (int i = 0; i < M; i++) {
				a[gi() - 1] = 0;
			}
			assigne(a);
			printJobs(a);
		}
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