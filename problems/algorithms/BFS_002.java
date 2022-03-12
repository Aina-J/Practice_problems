package problems.algorithms;

// 백준 2178 미로 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS_002 {

	static int[][] maze;
	static boolean[][] visited;
	static int n;
	static int m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maze = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = s.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(maze[n - 1][m - 1]);
	}

	static public void bfs(int x, int y) {

		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y));
		
		while (!q.isEmpty()) {
			Dot d = q.poll();
			for (int i = 0; i < 4; i++) {
				
				int nextX = d.x + dx[i];
				int nextY = d.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
	
				if (visited[nextX][nextY] || maze[nextX][nextY] == 0) {
					continue;
				}
			
				q.add(new Dot(nextX, nextY));
				
				maze[nextX][nextY] = maze[d.x][d.y] + 1;
				
				visited[nextX][nextY] = true;
			}
		}
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
