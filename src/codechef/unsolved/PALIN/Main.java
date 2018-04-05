import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static char[] nextPalindromeAllNineDigit(char s[]) {
		if (s.length == 1 && s[0] == '9') {
			return new char[] { '1', '1' };
		}
		int j = s.length - 1;
		char[] sp = new char[j + 2];
		Arrays.fill(sp, '0');
		sp[0] = '1';
		sp[j + 1] = '1';
		return sp;
	}

	public static char[] nextPalindromeTwoDigit(char s[]) {
		if (s[0] <= s[1]) {
			s = addOne(s, 0);
		}
		s[1] = s[0];
		return s;
	}

	public static boolean isAllNine(char s[]) {
		for (int i = 0; i < s.length; i++) {
			if (s[i] != '9') {
				return false;
			}
		}
		return true;
	}

	public static char[] addOne(char s[], int i) {
		++s[i];
		return s;
	}

	public static char[] nextPalindromeSingleDigit(char s[]) {
		return addOne(s, 0);
	}

	public static char[] nextPalindromeOddLengthComplex(char s[]) {
		int L = s.length;
		int M = L / 2;
		int i = M - 1;
		int j = M + 1;
		boolean simple = false;
		i = j = M;
		while (i >= 0 && j < L && s[i] == s[j]) {
			--i;
			++j;
			if (i >= 0 && j < L && s[j] < s[i]) {
				s[j] = s[i];
				simple = true;
				// copy rest
				while (i >= 0 && j < L) {
					s[j] = s[i];
					--i;
					++j;
				}
			}
		}

		if (simple) {
			return s;
		}

		i = M - 1;
		j = M + 1;

		if (s[M] != '9') {
			addOne(s, M);
			// copy rest
			while (i >= 0 && j < L) {
				s[j] = s[i];
				--i;
				++j;
			}
		} else {
			while (i >= 0 && j < L) {
				if (s[i] > s[j]) {
					s[j] = s[i];
					break;
				}
				if (s[i] != '9') {
					addOne(s, i);
					s[j] = s[i];
					for (int p = i + 1; p < j; p++) {
						s[p] = '0';
					}
					break;
				}
				--i;
				++j;
			}
			// copy rest
			while (i >= 0 && j < L) {
				s[j] = s[i];
				--i;
				++j;
			}

		}
		return s;
	}

	public static char[] nextPalindromeEvenLengthComplex(char s[]) {
		int L = s.length;
		int M = L / 2;
		int i = M - 1;
		int j = M + 1;
		boolean simple = false;
		j = M;
		i = j - 1;
		if (s[i] > s[j]) {
			s[j] = s[i];
			simple = true;
			// copy rest
			while (i >= 0 && j < L) {
				s[j] = s[i];
				--i;
				++j;
			}
		}
		j = M;
		i = j - 1;
		if (s[i] < s[j]) {
			addOne(s, i);
			s[j] = s[i];
			simple = true;
			// copy rest
			while (i >= 0 && j < L) {
				s[j] = s[i];
				--i;
				++j;
			}
		}
		j = M;
		i = j - 1;
		while (!simple && i >= 0 && j < L && s[i] == s[j]) {
			--i;
			++j;
			if (i >= 0 && j < L && s[j] < s[i]) {
				s[j] = s[i];
				simple = true;
				// copy rest
				while (i >= 0 && j < L) {
					s[j] = s[i];
					--i;
					++j;
				}
			}
			if (i >= 0 && j < L && s[j] > s[i]) {
				addOne(s, i);
				s[j] = s[i];
				for (int p = i + 1; p < j; p++) {
					s[p] = '0';
				}
				simple = true;
				// copy rest
				while (i >= 0 && j < L) {
					s[j] = s[i];
					--i;
					++j;
				}
			}
		}
		j = M;
		i = j - 1;
		while (!simple && i >= 0 && j < L && s[i] == s[j]) {
			if (i >= 0 && j < L && s[j] == s[i] && s[i] != '9') {
				addOne(s, i);
				s[j] = s[i];
				for (int p = i + 1; p < j; p++) {
					s[p] = '0';
				}
				simple = true;
				// copy rest
				while (i >= 0 && j < L) {
					s[j] = s[i];
					--i;
					++j;
				}
			}
			--i;
			++j;
		}

		if (simple) {
			return s;
		}
		i = 0;
		j = L - 1;
		addOne(s, i);
		s[j] = s[i];
		for (int p = i + 1; p < j; p++) {
			s[p] = '0';
		}
		return s;

	}

	public static String nextPalindrome(String s) {
		if (isAllNine(s.toCharArray())) {
			return new String(nextPalindromeAllNineDigit(s.toCharArray()));
		}
		if (s.length() == 1) {
			return new String(nextPalindromeSingleDigit(s.toCharArray()));
		}
		if (s.length() == 2) {
			return new String(nextPalindromeTwoDigit(s.toCharArray()));
		}
		if (s.length() % 2 == 1) {
			return new String(nextPalindromeOddLengthComplex(s.toCharArray()));
		}
		return new String(nextPalindromeEvenLengthComplex(s.toCharArray()));
	}

	public static void main(String[] args) throws IOException {
		// System.out.println(nextPalindrome("199991"));
		// String s = "100011110001";
		// String t = s;
		// for (int i = 0; i < 1100010; i++) {
		// t = nextPalindrome(s);
		// System.out.println(s + " -> " + t);
		// s = t;
		// }
		int T = gi();
		for (int t = 0; t < T; t++) {
			System.out.println(nextPalindrome(gs()));
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