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

	public static boolean isLowerCase(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		return false;
	}

	public static boolean isUpperCase(char c) {
		if (c >= 'A' && c <= 'Z') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		String s = gs();
		char[] chm = new char[26];
		for (int i = 0; i < s.length(); i++) {
			chm[i] = s.charAt(i); 
		}
		for (int t = 0; t < T; t++) {
			String st = gs();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < st.length(); i++) {
				char sst = st.charAt(i);
				if (sst == '_') {
					sb.append(' ');
					continue;
				}
				if (!isUpperCase(sst) && !isLowerCase(sst)) {
					sb.append(sst);
					continue;
				}
				if (isLowerCase(sst)) {
					sb.append(chm[sst - 'a']);
					continue;
				}
				if (isUpperCase(sst)) {
					sb.append((char)(chm[sst - 'A'] + 'A' - 'a'));
					continue;
				}
			}
			System.out.println(sb.toString());
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