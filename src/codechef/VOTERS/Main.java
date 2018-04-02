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

	public static void main(String[] args) throws IOException {
		int T = gi();
		T += gi();
		T += gi();
		Map<Integer, Integer> m = new HashMap<>();
		int k = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < T; i++) {
			k = gi();
			m.putIfAbsent(k, 0);
			m.put(k, m.get(k)+1);
			if (m.get(k) == 2) {
				list.add(k);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer e : list) {
			System.out.println(e + " ");
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