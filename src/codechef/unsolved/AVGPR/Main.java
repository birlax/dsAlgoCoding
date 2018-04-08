import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	private static int solve(int a[], Set<Integer> twice) {
		int s = 0;
		int i = 0;
		int j = a.length - 1;
		Arrays.sort(a);
		for (Integer v : twice) {
			i = 0;
			j = a.length - 1;
			while (i < j) {
				if (a[i] + a[j] > v) {
					--j;
					continue;
				}
				if (a[i] + a[j] < v) {
					++i;
					continue;
				}
				int ii = i;
				int jj = j;

				if (a[j] == a[i]) {
					int p = j - i + 1;
					s += (p * (p - 1)) / 2;
					ii = jj;
				} else {
					ii = i;
					jj = j;
					while (ii < j && a[ii] == a[i]) {
						ii++;
					}
					while (jj > i && a[jj] == a[j]) {
						--jj;
					}
					s += (ii - i) * (j - jj);
				}
				i = ii;
				j = jj;
			}
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi();
			int a[] = new int[N];
			Set<Integer> twice = new HashSet<>();
			for (int i = 0; i < N; i++) {
				int v = gi();
				a[i] = v;
				twice.add(2 * v);
			}
			System.out.println(solve(a, twice));
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