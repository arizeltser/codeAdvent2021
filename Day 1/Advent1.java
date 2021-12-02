import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Advent1 {
	private static class FastScanner {
		private BufferedReader reader = null;
		private StringTokenizer tokenizer = null;
 
		public FastScanner(InputStream in) {
			reader = new BufferedReader(new InputStreamReader(in));
			tokenizer = null;
		}
 
		public String next() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
 
		public String nextLine() {
			if (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					return reader.readLine();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken("\n");
		}
 
		public long nextLong() {
			return Long.parseLong(next());
		}
 
		public int nextInt() {
			return Integer.parseInt(next());
		}
 
		public double nextDouble() {
			return Double.parseDouble(next());
		}
 
		public int[] nextIntArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		public long[] nextLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
			return a;
		}
	}
  public static void main(String[] args) throws FileNotFoundException {
	  File file = new File("data/measurements.txt");
	  Scanner scan = new Scanner(file);
	  
	  
	  int result = 0;
	  ArrayList<Integer> arr = new ArrayList<>();
	  while(scan.hasNext()) {
		  arr.add(Integer.parseInt(scan.nextLine()));
	  }
	  
	  int prevGroup = -1;
	  for(int i = 0; i < arr.size()-1; i++) {
		  
		  if(i > arr.size()-3) {
			  break;
		  }
		  int currGroup = arr.get(i) + arr.get(i+1) + arr.get(i+2);
		  if(prevGroup != -1 || i >= arr.size()-3) {
			  if(currGroup > prevGroup) result++;
		  }
		  prevGroup = currGroup;
	  }
	  
	  /*
	  int firstResult = 0;
	  int prev = -1;
	  while(scan.hasNext()) {
		  int current = Integer.parseInt(scan.nextLine());
		  if(current > prev) firstResult++;
		  prev = current;
	  }
	  
	  
	  System.out.println(firstResult);
	  */
	  System.out.println(result);
	  
  }
}
