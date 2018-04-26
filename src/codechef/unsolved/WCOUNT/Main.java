import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static final long K = 1000_000_007;

	public static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		if (a < b) {
			return gcd(b, a);
		}
		return gcd(b, a % b);
	}

	public static long reduce(long P, int AA[]) {
		for (int j = 0; j < AA.length; j++) {
			if (AA[j] <= 1) {
				continue;
			}
			long gc  = gcd(P, AA[j]);
			if(gc!=1){
				--AA[j];
				P /= gc;
			}
		}
		return P;
	}

	public static long permutation(long n, int AA[]) {
		long p = 1;
		while (n > 0) {
			p = (( reduce(n, AA) % K) * (p % K)) % K;
			n--;
		}
		return p;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int i = 0; i < T; i++) {
			String s = gs();
			int N = s.length();
			int A[] = new int[256];
			for (int j = 0; j < s.length(); j++) {
				A[s.charAt(j) - 0]++;
			}
			System.out.println(permutation(N, A));
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