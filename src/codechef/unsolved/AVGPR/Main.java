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

	private static int solve(Map<Integer, Integer> count, Map<Integer, Integer> twice) {
		int s = 0;
		for (Map.Entry<Integer, Integer> outer : count.entrySet()) {
			for (Map.Entry<Integer, Integer> inner : count.entrySet()) {
				if (outer.getKey().intValue() == inner.getKey().intValue()) {
					continue;
				}
				if (twice.containsKey(outer.getKey() + inner.getKey())) {
					s += outer.getValue() * inner.getValue();
				}
			}
		}
		s = s / 2;
		for (Map.Entry<Integer, Integer> outer : count.entrySet()) {
			if (outer.getValue() <= 1) {
				continue;
			} else {
				s += (outer.getValue() * (outer.getValue() - 1)) / 2;
			}
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi();
			Map<Integer, Integer> count = new HashMap<>();
			Map<Integer, Integer> twice = new HashMap<>();
			for (int i = 0; i < N; i++) {
				int v = gi();
				count.putIfAbsent(v, 0);
				count.put(v, count.get(v) + 1);
				twice.put(2 * v, 0);
			}
			System.out.println(solve(count, twice));
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