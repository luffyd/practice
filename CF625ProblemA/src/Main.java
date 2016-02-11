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
		long n = inputReader.nextLong();
		long a = inputReader.nextLong();
		long b = inputReader.nextLong();
		long c = inputReader.nextLong();
		long cnt = 0;
		if (n >= b && b - c <= a) {
			// try to buy glass bottles
			cnt++;
			cnt += (n - b) / (b - c);
			n = n - cnt * (b - c);
		}
		// now try to buy plastic
		cnt += n / a;
		System.out.println(cnt);
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