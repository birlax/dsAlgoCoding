import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static final int MIXTURES = 100;

	public static void solve(int a[], int s, int e, int smoke[]) {
		if (e == s) {
			return;
		}

		if (e - s == 1) {
			smoke[0] = Math.min(smoke[0], smoke[1] + a[e] * a[s]);
			return;
		}
		for (int i = s + 1; i <= e; i++) {
			int anew[] = new int[a.length - 1];
			System.arraycopy(a, s, anew, 0, i - s - 1);
			anew[i - s - 1] = (a[i] + a[i - 1]) % MIXTURES;
			System.arraycopy(a, i + 1, anew, i - s, e - i);

			smoke[1] += a[i] * a[i - 1];
			// System.out.println(Arrays.toString(anew) + " smoke " +
			// Arrays.toString(smoke));
			solve(anew, 0, anew.length - 1, smoke);
			smoke[1] -= a[i] * a[i - 1];
		}
	}

	public static void main(String[] args) throws IOException {

		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				int T = sc.nextInt();
				int a[] = new int[T];
				for (int i = 0; i < T; i++) {
					a[i] = sc.nextInt();
				}
				int smoke[] = new int[] { Integer.MAX_VALUE, 0 };
				solve(a, 0, a.length - 1, smoke);
				if (smoke[0] == Integer.MAX_VALUE) {
					System.out.println(0);
				} else {
					System.out.println(smoke[0]);
				}
			}
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