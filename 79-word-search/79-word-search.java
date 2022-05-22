class Solution {
    public boolean exist(char[][] board, String word) {
    
    boolean vis[][]=new boolean[board.length][board[0].length];
        
    char[] w = word.toCharArray();
    for (int i=0; i<board.length; i++) {
    	for (int j=0; j<board[i].length; j++) {
            vis[i][j]=false;
    		if (exist(board, i, j, w, 0, vis)) return true;
    	}
    }
    return false;
}

private boolean exist(char[][] board, int i, int j, char[] word, int ind, boolean[][] vis) {
	if (ind == word.length) return true;
	if (i<0 || j<0 || i == board.length || j == board[i].length) return false;
	if (board[i][j] != word[ind]) return false;
    
    boolean exist=false;
    if (board[i][j] == word[ind] && vis[i][j]==false){
        vis[i][j]=true;
        exist = exist(board, i, j+1, word, ind+1, vis)
            || exist(board, i, j-1, word, ind+1, vis)
            || exist(board, i+1, j, word, ind+1, vis)
            || exist(board, i-1, j, word, ind+1, vis);
        vis[i][j]=false;
    }
    
	
	return exist;
}
}