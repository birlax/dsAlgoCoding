import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static PriorityQueue<Integer> getMinHeap(int[] a) {
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (a[o1] < a[o2]) {
					return -1;
				}
				if (a[o1] > a[o2]) {
					return 1;
				}
				return 0;
			}
		});
		return q;
	}

	private static int solve(int[] a) {

		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		Map<Integer, Integer> sums = new HashMap<>();
		Map<Integer, Integer[]> range = new HashMap<>();
		int G = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				G++;
				continue;
			}
			if (!map.containsKey(G)) {
				map.put(G, getMinHeap(a));
				range.put(G, new Integer[] { i, i });

			}
			map.get(G).add(i);
			sums.put(G, a[map.get(G).peek()]);
			range.get(G)[1] = i;
		}
		System.out.println(Arrays.toString(a));
		System.out.println(map);
		System.out.println(range);
		System.out.println(sums);

		for (Map.Entry<Integer, PriorityQueue<Integer>> e : map.entrySet()) {
			PriorityQueue<Integer> q = e.getValue();
			Integer key = e.getKey();
			List<Integer> list = new ArrayList<>();
			while (!q.isEmpty() && (a[q.peek()] - sums.get(key) == 0)) {
				list.add(q.poll());
			}
			if (!q.isEmpty()) {
				sums.put(key, a[q.peek()]);
			}
			System.out.println(list);

		}
		System.out.println(map);
		System.out.println(range);
		System.out.println(sums);

		return 0;

	}

	public static void main(String[] args) throws IOException {
		int T = gi();

		for (int t = 0; t < T; t++) {
			int N = gi();
			int a[] = new int[N];
			boolean notPossible = false;
			for (int i = 0; i < N; i++) {
				a[i] = gi();
			}
			int zero = 0;
			for (int i = 0; i < N; i++) {
				a[i] -= gi();
				if (a[i] < 0) {
					notPossible = true;
				}
				if (a[i] == 0) {
					zero++;
				}
			}
			if (notPossible) {
				System.out.println("-1");
			} else if (zero == a.length) {
				System.out.println("0");
			} else {
				System.out.println(solve(a));
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