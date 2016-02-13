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
		int n = inputReader.nextInt();
		int k = inputReader.nextInt();
		int sum = 0;
		int val[][] = new int[n][n];
		int max = n * n;
		int min = 1;
		for (int i = 0; i < n; i++) {
			max -= (n - k);
			for (int j = k - 1; j < n; j++) {
				val[i][j] = max + j - (k - 1);
			}
			for (int j = 0; j < k - 1; j++) {
				val[i][j] = min++;
			}
			max -= 1;
		}

		for (int i = 0; i < n; i++) {
			sum += val[i][k - 1];
		}
		System.out.println(sum);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(val[i][j] + " ");
			}
			System.out.println();
		}
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