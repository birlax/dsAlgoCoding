import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static int[] getIntArray(String a, int L) {
		int aa[] = new int[L];
		int i = aa.length - 1;
		int j = a.length() - 1;
		for (; j >= 0 && i >= 0; j--, i--) {
			aa[i] = a.charAt(j) - '0';
		}
		return aa;
	}

	public static int compare(int a[], int b[]) {
		int i = -1;
		while (i + 1 < a.length) {
			i++;
			if (a[i] == b[i]) {
				continue;
			}
			if (a[i] < b[i]) {
				return -1;
			} else {
				return 1;
			}
		}
		return 0;
	}

	public static int[] findRemainder(int aa[], int bb[]) {
		while (compare(aa, bb) >= 0) {
			int bbCopy[] = Arrays.copyOf(bb, bb.length);
			moveForwardBy(aa, bbCopy);
			// System.out.println("bb =" + Arrays.toString(bb));
			// System.out.println("bbc =" + Arrays.toString(bbCopy));
			substractTillBigger(aa, bbCopy);
		}
		return aa;
	}

	public static int[] substractTillBigger(int aa[], int bb[]) {
		while (compare(aa, bb) >= 0) {
			int i = aa.length - 1;
			while (i > 0) {
				if (bb[i] <= aa[i]) {
					aa[i] = aa[i] - bb[i];
				} else {
					aa[i - 1]--;
					aa[i] = aa[i] - bb[i] + 10;
				}
				i--;
			}
			// System.out.println(Arrays.toString(aa));
		}
		return aa;
	}

	public static int[] moveForwardBy(int aa[], int bb[]) {
		int i = 0;
		while (i < aa.length && aa[i] == 0) {
			i++;
		}
		int j = 0;
		while (j < bb.length && bb[j] == 0) {
			j++;
		}
		if (j - i >= 2) {
			i++;
			while (j < bb.length) {
				bb[i] = bb[j];
				i++;
				j++;
			}
			while (i < bb.length) {
				bb[i] = 0;
				i++;
			}
		}
		return bb;
	}

	public static int[] GCD1(String a, String b) {
		int L = Math.max(a.length(), b.length()) + 2;
		int aa[] = getIntArray(a, L);
		int bb[] = getIntArray(b, L);
		return findRemainder(aa, bb);
	}

	public static int parserArrayInt(int a[]) {
		int j = 0;
		while (j < a.length && a[j] == 0) {
			j++;
		}

		int n = 0;
		while (j < a.length) {
			n = n * 10 + a[j];
			j++;
		}
		return n;
	}

	public static String GCD2(String a, int b) {
		if (b == 0) {
			return a;
		}
		if (b == 1) {
			return "1";
		}
		int aa[] = GCD1(a, b + "");
		// System.out.println(Arrays.toString(aa));
		int A = parserArrayInt(aa);
		return gcd(b, A) + "";
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int i = 0; i < T; i++) {
			int b = gi();
			String a = gs();
			System.out.println(GCD2(a, b));
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