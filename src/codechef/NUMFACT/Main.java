import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static Map<Integer, Integer> getPrimeFactors(int N, Map<Integer, Integer> m) {
		int p = 2;
		int n = N;
		int c = 0;
		while (p * p <= N) {
			c = 0;
			while (n > 1 && n % p == 0) {
				c++;
				n = n / p;
			}
			if (c != 0) {
				m.putIfAbsent(p, 0);
				m.put(p, m.get(p) + c);
			}
			p++;
		}
		if (n != 1) {
			m.putIfAbsent(n, 0);
			m.put(n, m.get(n) + 1);
		}
		return m;
	}

	public static void main(String[] args) throws IOException {
		long T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi();
			Map<Integer, Integer> m = new HashMap<>();
			for (int i = 0; i < N; i++) {
				getPrimeFactors(gi(), m);
			}
			long s = 1;
			for (int e : m.values()) {
				s = s * (e + 1);
			}
			System.out.println(s);
		}

		return;

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