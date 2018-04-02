import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static final String BOB = "BOB";
	public static final String ALICE = "ALICE";

	public static boolean isPrimes(int n, List<Integer> s) {
		if (n <= 1) {
			return false;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (Integer e : s) {
			if (n % e == 0) {
				return false;
			}
		}
		return true;
	}

	public static List<Integer> getPrimes() {
		int n= 10000;
		List<Integer> s = new ArrayList<>(n);
		s.add(2);
		s.add(3);
		s.add(5);
		s.add(7);
		int t = n;
		int i = 8;
		while (t > 0) {
			if (isPrimes(i, s)) {
				s.add(i);
				t--;
			}
			i++;
		}
		return s;
	}

	public static Map<Integer, String> getWinnersLooser(int n) {
		Map<Integer, String> m = new HashMap<>();

		m.put(1, "L");
		m.put(2, "L");
		int k = 0;
		List<Integer> primes = getPrimes();
		for (int i = 2; i <= n; i++) {

			if ("L".equals(m.get(i - 1))) {
				m.put(i, "W");
				continue;
			}
			boolean isAWinner = false;
			k = 0;
			while (k < primes.size() && primes.get(k) < i) {
				int nN = i - primes.get(k);
				if ("L".equals(m.get(nN))) {
					m.put(i, "W");
					isAWinner = true;
					break;
				}
				k++;
			}
			if (!isAWinner) {
				m.put(i, "L");
			}
		}
		return m;
	}

	public static String getWinnerOld(int n, String currentPlayer) {
		Map<Integer, String> m = getWinnersLooser(n);
		if ("L".equals(m.get(n))) {
			return BOB.equals(currentPlayer) ? ALICE : BOB;
		}
		if ("W".equals(m.get(n))) {
			return currentPlayer;
		}
		return "";
	}

	
	
	public static void main(String[] args) throws IOException {
		long s = System.currentTimeMillis();
		// System.out.println(getWinner(1000000000, BOB));
		System.out.println(getPrimes());
		long e = System.currentTimeMillis();
		System.out.println((e - s) + "ms");
		// int T = gi();
		// for (int i = 0; i < T; i++) {

		// }
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