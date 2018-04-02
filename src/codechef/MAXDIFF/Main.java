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

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi();
			int K = gi();
			int a[] = new int[N];
			int total = 0;
			for (int i = 0; i < N; i++) {
				a[i] = gi();
				total += a[i];
			}
			Arrays.sort(a);
			int firstK = 0;
			int lastK = 0;
			for (int i = 0; i < K; i++) {
				firstK += a[i];
				lastK += a[N - i - 1];
			}
			//System.out.println(firstK + " " + lastK + " " + total);
			int mm = Math.min(Math.min(firstK, lastK), Math.min(total - firstK, total - lastK));

			System.out.println((total - mm) - mm);
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