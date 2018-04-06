import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			System.out.println(solve(gd()));
		}
	}

	private static double solve(double n) {
		double d = 1.0;
		double s = 0.0;
		for (; d <= n; d++) {
			s += (1.0 / d);
		}
		s = s * n;
		s = (int) (s * 100.0);
		return s / 100.0;
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