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
		int N = gi();
		int t = 0;
		for (int i = 1; i <= N; i++) {
			t -= i;
			t += gi();
		}
		if (t == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
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