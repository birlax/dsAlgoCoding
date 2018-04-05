import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	private static long solve(long n, long k) {
		if (n < k) {
			return 0;
		}
		if (n == k) {
			return 1;
		}
		k--;
		n--;
		if (k > n - k) {
			k = n - k;
		}
		long s = 1;
		for (long i = 1; i <= k; i++, n--) {
			s = (s * n) / i;
		}
		return s;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			long N = gl();
			long K = gl();
			System.out.println(solve(N, K));
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