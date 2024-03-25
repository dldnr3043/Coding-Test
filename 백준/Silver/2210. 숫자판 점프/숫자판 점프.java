
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	
	// 중복 제거를 위한 Set 사용
	static HashSet<String> list;
	static int[][]board;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new HashSet<String>();
		board = new int[5][5];
		
		String[] s;
		
		// initializer
		 for (int i = 0; i < 5; i++) {
	            s = br.readLine().split(" ");
	            for (int j = 0; j < 5; j++) {
	                board[i][j] = Integer.parseInt(s[j]);
	                
	            }
	        }
		
		String str = ""; 
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				DFS(i, j, 0, str);
			}
		}
		
		System.out.print(list.size());
	}
	
	public static void DFS(int x, int y, int depth, String str) {
		if(depth == 6) {
			list.add(str);
			return ;
		}
		for(int i=0;i<4;i++) {
			int nextX = x+dx[i];
			int nextY = y+dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= 5 || nextY >= 5)
				continue;
			
			DFS(nextX, nextY, depth+1,str+board[x][y]);
		}
	}
}
