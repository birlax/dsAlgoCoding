import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	private static long countStrictPrefixAGtBWithCarry(char[] a, long n) {
		int diff = 0;
		int i = 0;
		long s = 0;
		while (n > 0) {
			if (a[i] == 'a') {
				diff++;
			} else {
				diff--;
			}
			if (diff >= 1) {
				s++;
			}
			i++;
			if (i == a.length) {
				n--;
				i = 0;
				if (diff >= a.length) {
					return s + n * a.length;
				}
			}
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int i = 0; i < T; i++) {
			String s = gs();
			long n = gl();
			System.out.println(countStrictPrefixAGtBWithCarry(s.toCharArray(), n));
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