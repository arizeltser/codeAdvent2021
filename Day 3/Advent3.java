import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Advent3 {
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
  
	
	public static ArrayList<String> findGreatestOrLeast(ArrayList<String> array, int count, int val) {
		if(array.size() <= 1) {
			return array;
		}
		else {
			ArrayList<String> myArr = new ArrayList<>(array);
			int count1 = 0;
			int count0 = 0;
			String myComm = val+"";
			String oppComm = "1";
			if(val == 1) {
				oppComm = "0";
			}
			for(int j = 0; j < myArr.size();j++) {
				String curr = myArr.get(j).substring(count,count+1);
				int currInt = Integer.parseInt(curr);
				if(currInt == 1) {
					count1++;
				}
				else {
					count0++;
				}
			}
			
			//System.out.println(count1+" "+count0);
			  
			if(count1 >= count0) {
				for(int k = 0; k < array.size();k++) {
				  if(array.get(k).substring(count,count+1).equals(oppComm)) {
					  //System.out.println(array.get(k));
					  myArr.remove(array.get(k));
				  }
				}
				//System.out.println("1");
			}
			else {
				for(int k = 0; k < array.size();k++) {
					if(array.get(k).substring(count,count+1).equals(myComm)) {
						//System.out.println(array.get(k));
						 myArr.remove(array.get(k));
					}
				}
				//System.out.println("0");
		  	}
			System.out.println(myArr);
			return findGreatestOrLeast(myArr,count+1,val);
			  
		}
		
		
	}
	
	
	
	
	public static ArrayList<String> findLeast(ArrayList<String> array, int count) {
		if(array.size() <= 1) {
			return array;
		}
		else {
			ArrayList<String> myArr = new ArrayList<>(array);
			int count1 = 0;
			int count0 = 0;
			for(int j = 0; j < myArr.size();j++) {
				String curr = myArr.get(j).substring(count,count+1);
				int currInt = Integer.parseInt(curr);
				if(currInt == 1) {
					count1++;
				}
				else {
					count0++;
				}
			}
			
			System.out.println(count1+" "+count0);
			  
			if(count1 >= count0) {
				for(int k = 0; k < array.size();k++) {
				  if(array.get(k).substring(count,count+1).equals("1")) {
					  //System.out.println(array.get(k));
					  myArr.remove(array.get(k));
				  }
				}
				//System.out.println("1");
			}
			else {
				for(int k = 0; k < array.size();k++) {
					if(array.get(k).substring(count,count+1).equals("0")) {
						//System.out.println(array.get(k));
						 myArr.remove(array.get(k));
					}
				}
				//System.out.println("0");
		  	}
			System.out.println(myArr);
			return findLeast(myArr,count+1);
			  
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
	  File file = new File("data/binary.txt");
	  Scanner scan = new Scanner(file);
	  
	  ArrayList<String> arr = new ArrayList<>();
	  //String gamma = "";
	  //String epsilon = "";
	  
	  
	  while(scan.hasNext()) {
		  String input = scan.nextLine();
		  arr.add(input);
	  }
	  
	  ArrayList<String> common = findGreatestOrLeast(arr,0,1);
	  int oxy = Integer.parseInt(common.get(0),2);
	  System.out.println(oxy);
	  
	  ArrayList<String> uncommon = findGreatestOrLeast(arr,0,0);
	  int scrub = Integer.parseInt(uncommon.get(0),2);
	  System.out.println(scrub);
	  
	  System.out.println(scrub*oxy);
	  
	  
	  
	  /*
	  for(int i = 0; i < arr.get(0).length();i++) {
		  int count1 = 0;
		  int count0 = 0;
		  for(int j = 0; j < arr.size();j++) {
			  String curr = arr.get(j).substring(i,i+1);
			  int currInt = Integer.parseInt(curr);
			  if(currInt == 1) {
				  count1++;
			  }
			  else {
				  count0++;
			  }
		  }
		  
		  if(count1 > count0) {
			  gamma +="1";
			  epsilon +="0";
		  }
		  else {
			  gamma +="0";
			  epsilon +="1";
		  }
	  }
	  
	  int gammaDec = Integer.parseInt(gamma,2);
	  int epsilonDec = Integer.parseInt(epsilon,2);
	  
	  
	  
	 System.out.println(gammaDec*epsilonDec);
	 */
	  
	  scan.close();
	  
	    
	  
  }
}
