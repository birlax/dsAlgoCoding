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

	public static int countLocalInversions(int a[]) {
		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				count++;
			}
		}
		return count;
	}

	public static int[] mergeSortedArrays(int a[], int b[], int s[]) {

		int l = a.length;
		int r = b.length;

		if (l <= 0) {
			return b;
		}
		if (r <= 0) {
			return a;
		}
		int i = 0;
		int j = 0;
		int m[] = new int[l + r];
		int k = 0;
		while (i < l && j < r) {
			if (a[i] <= b[j]) {
				m[k] = a[i];
				i++;
				k++;
			} else {
				m[k] = b[j];
				s[0] += (l - i);
				j++;
				k++;
			}
		}
		while (i < l) {
			m[k++] = a[i++];

		}
		while (j < r) {
			m[k++] = b[j++];
		}
		return m;
	}

	public static int[] countGlobalInversions(int a[], int s[]) {
		if (a.length <= 1) {
			return a;
		}
		int l = a.length / 2;
		int al[] = Arrays.copyOfRange(a, 0, l);
		int ar[] = Arrays.copyOfRange(a, l, a.length);

		// System.out.println(Arrays.toString(al));
		// System.out.println(Arrays.toString(ar));
		al = countGlobalInversions(al, s);
		ar = countGlobalInversions(ar, s);

		return mergeSortedArrays(al, ar, s);

	}

	/*
	 * public static void main(String[] args) { int a[] = new int[]{1, 20, 6, 4,
	 * 5}; int s[] = new int[]{0}; a=countGlobalInversions(a,s);
	 * System.out.println(Arrays.toString(a)+ " " + s[0]); }
	 */

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int i = 0; i < T; i++) {
			int N = gi();
			int a[] = new int[N];
			for (int j = 0; j < N; j++) {
				a[j] = gi();
			}
			int s[] = new int[] { 0 };
			countGlobalInversions(a, s);
			if (s[0] == countLocalInversions(a)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
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