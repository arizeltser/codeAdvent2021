import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class Advent4 {
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
  
	public static ArrayList<int[][]> findLast(ArrayList<int[][]> arr, ArrayList<Integer> picks) {
		if(arr.size() == 1) {
			return arr;
		}
		
		int pick = picks.remove(0);
		
		
		
		for(int i = 0; i < arr.size();i++) {
			  for(int j = 0; j < arr.get(0).length;j++) {
				  for(int k = 0; k < arr.get(0)[0].length;k++) {
					  if(arr.get(i)[j][k] == pick) {
						  int[][] temp = arr.get(i).clone();
						  temp[j][k] = -1;
						  arr.set(i, temp);
					  }
					  
					  
					  
				  }
			  }
		  }
		
		
		ArrayList<int[][]> array = new ArrayList<>(arr);
		for(int i = 0; i < arr.size();i++) {
			  for(int j = 0; j < arr.get(0).length;j++) {
				  for(int k = 0; k < arr.get(0)[0].length;k++) {
					  
					
					  if(arr.get(i)[j][0] == -1 && arr.get(i)[j][1] == -1 && arr.get(i)[j][2] == -1 && arr.get(i)[j][3] == -1 && arr.get(i)[j][4] == -1) {
						  
						  
						  array.remove(arr.get(i));
						  j = 5;
						  
						  break;
					  }
					  
					  if(arr.get(i)[0][k] == -1 && arr.get(i)[1][k] == -1 && arr.get(i)[2][k] == -1 && arr.get(i)[3][k] == -1 && arr.get(i)[4][k] == -1) {
						  
						  array.remove(arr.get(i));
						  j = 5;
						  
						  break;
					  }
				  }
			  }
		  }
		
		
		
		return findLast(array,picks);
		
		
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
	  File file = new File("data/bingo.txt");
	  Scanner scan = new Scanner(file);
	  
	  String chosen = scan.nextLine();
	  String[] chosenArr = chosen.split(",");
	  ArrayList<Integer> chosenArrL = new ArrayList<>();
	  for(int i = 0; i < chosenArr.length;i++) {
		  chosenArrL.add(Integer.parseInt(chosenArr[i]));
	  }
	  
	  ArrayList<int[][]> arr = new ArrayList<>();
	  
	  
	  while(scan.hasNext()) {
		  String input = scan.nextLine();
		  
		  int[][] inner = new int[5][5];
		  int count = 0;
		  
		  
		  
		  
		  
		  while(!input.equals("")) {
			  input = input.replaceAll("  ", " ");
			  
			  if(input.substring(0,1).equals(" ")) {
				  input = input.substring(1);
			  }
			  
			  String[] arrStr = input.split(" ");
			  
			  for(int i = 0; i < arrStr.length;i++) {
				  //System.out.println(arrStr[i]);
				  inner[count][i] = Integer.parseInt(arrStr[i]);
			  }
			  if(scan.hasNext()) {
				  input = scan.nextLine();
			  }
			  else {
				  input ="";
			  }
			  count++;
			  
		  }
		  if(inner[0][0]+inner[0][1]+inner[0][0] != 0) {
			  arr.add(inner);
		  }
	  }
	  
	  
	  /*
	  int finI = 0;
	  int finPick = 0;
	  for(int a = 0; a < chosenArr.length;a++) {
		  int pick = Integer.parseInt(chosenArr[a]);
		  for(int i = 0; i < arr.size();i++) {
			  for(int j = 0; j < arr.get(0).length;j++) {
				  for(int k = 0; k < arr.get(0)[0].length;k++) {
					  if(arr.get(i)[j][k] == pick) {
						  int[][] temp = arr.get(i).clone();
						  temp[j][k] = -1;
						  arr.set(i, temp);
					  }
					  
					  
					  if(arr.get(i)[j][0] == -1 && arr.get(i)[j][1] == -1 && arr.get(i)[j][2] == -1 && arr.get(i)[j][3] == -1 && arr.get(i)[j][4] == -1) {
						  finI = i;
						  finPick = pick;
						  j = 5;
						  i = arr.size();
						  a = chosenArr.length;
						  break;
					  }
					  
					  if(arr.get(i)[0][k] == -1 && arr.get(i)[1][k] == -1 && arr.get(i)[2][k] == -1 && arr.get(i)[3][k] == -1 && arr.get(i)[4][k] == -1) {
						  finI = i;
						  finPick = pick;
						  j = 5;
						  i = arr.size();
						  a = chosenArr.length;
						  break;
					  }
				  }
			  }
		  }
	  }
	  */
		  
		  
		
	  
	  
	  
	  
		
		
		
		
		  
	  ArrayList<int[][]> result = findLast(arr,chosenArrL);
		  
	  int finPick = chosenArrL.get(0);
	  int sum = 0;
	  for(int i = 0; i < 5;i++) {
		  for(int j = 0; j<5;j++) {
			  //System.out.println(result.get(0)[i][j]);
			  if(result.get(0)[i][j] != -1) {
				  sum+=result.get(0)[i][j];
			  }
		  }
	  }
	  
	  
	  System.out.println(sum-finPick);
	  System.out.println(finPick);
	  System.out.println((sum-finPick)*finPick);
	  
	  
	 
	  
	  scan.close();
	  
	    
	  
  }
}
