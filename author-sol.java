import java.io.*;
import java.util.*;

public class Main {
	
	private static FastReader in;
	private final static long MOD = (long) (1e9 + 7);
	
	public static void main(String[] args) {
		in = new FastReader();
		int tc = 1;
		tc = in.nextInt();
		for(int t = 0; t < tc; t++) {
			new Solver();
		}
	}
	
	/***
	 * Calculates (a ^ b) using binary exponentiation (recursive)
	 * @param a
	 * @param b
	 * @return
	 */
	static long getPower(long a, long b) {
		if(b == 0) {
			return 1;
		}
		if(b == 1) {
			return a;
		}
		long ret = getPower(a, b / 2);
		if(b % 2 == 0) {
			return (ret * ret) % MOD;
		} else {
			return ((ret * ret) % MOD * a) % MOD;
		}
	}
	
	static class Solver {
		Solver() {
			// C(N, k), where 1 <= k <= N
			// = C(N, 1) + C(N, 2) + C(N, 3) + ... + C(N, N)
			// = (2 ^ N) - 1
			long n = in.nextInt();
			long ans = getPower(2, n) % MOD;
			System.out.println((ans - 1) % MOD);
		}
	}
	
	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
		
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
