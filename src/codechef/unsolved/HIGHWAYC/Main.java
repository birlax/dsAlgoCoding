import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Do not change the class name or package
public class Main {

	public static double getDD(int a) {
		return 1.0 * a;
	}

	public static double direction(int i, int D[]) {
		if (D[i] == 1) {
			return 1.0;
		}
		return -1.0;
	}

	public static void solve(int N, int V[], int D[], int Y[], int L[], int W, int S) {
		double T[] = new double[] { 0.0 };
		double timeForLaneCrossing = getDD(W) / getDD(S);
		for (int i = 0; i < N; i++) {
			doCrossing(i, V, D, Y, L, T, timeForLaneCrossing);
		}
		System.out.println(T[0]);
	}

	public static void doCrossing(int i, int V[], int D[], int Y[], int L[], double T[], double timeForLaneCrossing) {
		double lowT = T[0];
		double highT = lowT + timeForLaneCrossing;

		double vehicalToCrossTime = 0.0;

		if (!isSafeToCross(i, V, D, Y, L, lowT, highT)) {
			// System.out.println("wait for : " + i);
			vehicalToCrossTime = Math.max(0.0, (Math.abs(getDD(Y[i])) + getDD(L[i]) - T[0] * getDD(V[i])))
					/ getDD(V[i]);
		}
		T[0] += (timeForLaneCrossing + vehicalToCrossTime);
	}

	public static boolean isSafeToCross(int i, int V[], int D[], int Y[], int L[], double lowT, double highT) {
		double precision = 0.000001;

		while (highT - lowT > 0.0000000001 ) {
			double mid = lowT + ((highT - lowT) / 2.0);
			double distanceTraveled = direction(i, D) * (getDD(V[i]) * mid);
			double yForCabFront = getDD(Y[i]) + distanceTraveled;

			double yForCabRare = yForCabFront + (direction(i, D) > 0 ? -1.0 * getDD(L[i]) : getDD(L[i]));
			//System.out.println(lowT + " - " + highT + " - rar : " + yForCabRare + " for : " + yForCabFront);
			if (direction(i, D) > 0) {
				if (yForCabFront >= -1 * precision) {
					return false;
				}
				if (yForCabRare >= -1 * precision) {
					return false;
				}
			} else {
				if (yForCabFront >= precision) {
					return false;
				}
				if (yForCabRare >= precision) {
					return false;
				}
			}
			if ((yForCabFront * yForCabRare) < 0.0) {
				return false;
			} else {
				if (direction(i, D) > 0) {
					if (yForCabFront < 0) {
						lowT = mid;
					} else {
						highT = mid;
					}
				} else {
					if (yForCabFront > 0) {
						lowT = mid;
					} else {
						highT = mid;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		int T = gi();
		for (int t = 0; t < T; t++) {
			int N = gi(); // no of lanes.
			int S = gi(); // walking speed
			int W = gi(); // width for the lane
			int V[] = new int[N];
			int D[] = new int[N];
			int Y[] = new int[N];
			int L[] = new int[N];
			int i = 0;
			for (i = 0; i < N; i++) {
				V[i] = gi();
			}
			for (i = 0; i < N; i++) {
				D[i] = gi();
			}
			for (i = 0; i < N; i++) {
				Y[i] = gi();
			}
			for (i = 0; i < N; i++) {
				L[i] = gi();
			}
			solve(N, V, D, Y, L, W, S);
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