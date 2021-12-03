import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Advent2 {
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
	  File file = new File("data/commands.txt");
	  Scanner scan = new Scanner(file);
	  
	  
	  
	  //Map<String,String> coms = new HashMap<>();
	  ArrayList<String> coms2 = new ArrayList<>();
	  int horiz = 0;
	  int depth = 0;
	  int aim = 0;
	  //int count = 0;
	  while(scan.hasNext()) {
		  String input = scan.nextLine();
		  coms2.add(input);
		  //coms.put(input.substring(0,1)+""+count,input.substring(input.indexOf(' ')+1) );
		  //count++;
	  }
	  
	  
	  
	  //System.out.println(coms.keySet());
	  //System.out.println(coms.values());
	  
	  for(int i = 0; i < coms2.size();i++) {
		  String let = coms2.get(i).substring(0,1);
		  int num = Integer.parseInt(coms2.get(i).substring(coms2.get(i).indexOf(' ')+1));
		  
		  if(let.equals("f")) {
			  horiz+= num;
			  depth += num * aim;
		  }
		  else if(let.equals("d")) {
			  aim += num;
		  }
		  else if(let.equals("u")) {
			  aim -= num;
		  }
		  
		  System.out.println(horiz+" "+depth+" "+aim);
	  }
	  
	  /*
	  for (String key : coms.keySet())
      {
		  String val = coms.get(key);
		  if(key.substring(0,1).equals("f")) {
			  horiz+= Integer.parseInt(val);
			  depth += (Integer.parseInt(val) * aim);
		  }
		  else if(key.substring(0,1).equals("d")) {
			  aim += Integer.parseInt(val);
		  }
		  else if(key.substring(0,1).equals("u")) {
			  aim -= Integer.parseInt(val);
		  }
		  
		  //System.out.println(horiz+" "+depth+" "+aim);
      }
      */
	  
	  
	  
	  
	  
	  System.out.println(horiz*depth);
	  
	  scan.close();
	  
	    
	  
  }
}
