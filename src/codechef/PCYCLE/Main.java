import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static void solveAll(int[] a) {
		int i = 0;
		List<List<Integer>> allList = new ArrayList<>();
		while (i < a.length) {
			while (i < a.length && a[i] < 0) {
				i++;
			}
			if (i < a.length) {
				allList.add(solve(a, i));
			}
		}
		System.out.println(allList.size());
		for (List<Integer> l : allList) {
			for (Integer e : l) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static List<Integer> solve(int[] a, int nextI) {
		int i = nextI;
		List<Integer> l = new ArrayList<>();
		while (i < a.length && a[i] >= 0) {
			l.add(i + 1);
			a[i] *= -1;
			i = (-1 * a[i]) - 1;
		}
		l.add(l.get(0));
		return l;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		int a[] = new int[T];
		for (int i = 0; i < T; i++) {
			a[i] = gi();
		}
		solveAll(a);
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