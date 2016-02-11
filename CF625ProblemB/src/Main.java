import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] v;

	public static void main(String[] args) throws FileNotFoundException {
		InputReader inputReader = new InputReader(System.in);
		String g = inputReader.next();
		String a = inputReader.next();
		int cnt = 0;
		int T[] = processForKMP(a);
		int index = findIndex(g, a, 0, T);
		while (index > -1) {
			cnt++;
			index = findIndex(g, a, index + a.length(), T);
		}
		System.out.println(cnt);
	}

	/**
	 * returns the indexOf The FirstMatch
	 * 
	 * @param s
	 * @param w
	 * @param T
	 * @return
	 */
	private static int findIndex(String s, String w, int start, int T[]) {
		if (w.length() == 0 || s.length() == 0) {
			return -1;
		}
		int m = start;
		int i = 0;
		while (m + i < s.length()) {
			if (s.charAt(m + i) == w.charAt(i)) {
				if (i == w.length() - 1) {
					return m;
				}
				i++;
			} else if (T[i] > -1) {
				m += i - T[i];
				i = T[i];
			} else {
				i = 0;
				m++;
			}
		}
		return -1;
	}

	/**
	 * pre-process For KMP so that if there is a mismatch, we can know a start
	 * point to skip to..!!
	 * 
	 * @param w
	 * @return
	 */
	private static int[] processForKMP(String w) {
		int T[] = new int[w.length()];
		// initialization for T[0]=-1 and T[1]=0 with arrayBoundChecks
		int k = -1;
		while (k + 1 < w.length() && k < 1) {
			T[k + 1] = k;
			k++;
		}

		int start = 0;
		int i = 2;
		while (i < w.length()) {
			if (w.charAt(i - 1) == w.charAt(start)) {
				T[i] = ++start;
				i++;
			} else if (start > 0) {
				start = T[start];
			} else {
				T[i] = 0;
				i++;
			}
		}
		return T;
	}

}

class InputReader {
	public BufferedReader reader;

	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

}