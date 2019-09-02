
public class SurroundedRegion {

	public static void main(String[] args) {
		char[][] board = new char[8][8];
		solution(board);
	}
	
	private static void solution(char[][] board) {
		if(board == null || board.length == 0) {
			return ;
		}
		
		int rows = board.length, cols = board[0].length;
		//initialize a visited area
		boolean[][] visited = new boolean[rows][cols];
		
		for(int j = 0; j < cols;j++){
			if(board[0][j] == 'O') {
				//
				dfs(board, 0, j, visited, false);
			}
			
			if(board[rows-1][j] == 'O') {
				dfs(board, rows - 1, j, visited, false);
			}
		}
		
		for(int i = 1; i < rows - 1; i++) {
			if(board[i][0] == 'O') {
				dfs(board, i, 0, visited, false);
			}
			if(board[i][cols - 1] == 'O') {
				dfs(board, i, 0, visited, false);
			}
		}
		
		for(int i = 1; i < rows - 2; i++) {
			for(int j = 1; j < cols - 2; j++) {
				if(board[i][j] == 'O') {
					dfs(board, i, j, visited, true);
				}
				
			}
		}
	}
	
	private static void dfs(char[][] board, int row, int col, boolean[][] visited, boolean flip) {
		
		if(row < 0  || row > board.length -1 || col < 0 || col > board.length - 1) {
			return ;
		}
		if(visited[row][col]){
			return ;
		}
		if(board[row][col] == 'X') {
			return ;
		}
		if(flip) {
			board[row][col] = 'X';
		}
		
		visited[row][col] = true;
	}

}
