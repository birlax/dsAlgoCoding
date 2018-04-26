import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static int solve(int n) {

		for (int x = (int) Math.sqrt(n); x >= 1; x--) {
			if (n % x == 0) {
				return (n / x - x);
			}
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {

		int T = gi();
		for (int i = 0; i < T; i++) {
			wr(solve(gi()));

		}
		flush();
	}

	/// output writers
	public static PrintWriter printWriter = new PrintWriter(System.out);
	public static StringBuilder stringBuilder = new StringBuilder("");

	public static void wr(Object sol) {
		stringBuilder.append(sol);
		stringBuilder.append("\n");
	}

	public static void flush() {
		printWriter.println(stringBuilder);
		printWriter.flush();
	}

	/// input readers ////
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