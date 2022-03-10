package problems.algorithms;

// 백준 2667 단지번호붙이기

import java.io.*;
import java.util.*;

public class BFS_001 {
	private static class Node {
		int x, y, step;

		Node(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	static int N;
	static int[][] map;
	static Queue<Node> q = new LinkedList<>();
	static boolean[][] visit;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j] - '0';
			}
		}

		System.out.println("입력");
		print();
		System.out.println("bfs 시작");

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					System.out.println(i + "," + j + " 부터 탐색 시작!!");
					visit[i][j] = true;
					bfs(i, j, 1);
				}
			}
		}
	}

	private static void bfs(int x, int y, int step) {
		q.add(new Node(x, y, step));
		while (!q.isEmpty()) {
			Node n = q.poll();

			for (int i = 0; i < 4; i++) { // 사방탐색 코드
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N 
					&& !visit[nx][ny] && map[nx][ny] == 1) {
					q.add(new Node(nx, ny, n.step + 1));
					map[nx][ny] = n.step + 1;
					print();
				}
			}
		}
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
