public class WordSearch {
  private char[][] data;

  public WordSearch(int row, int col) {
    data = new char[row][col];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        data[i][j] = '_';
      }
    }
  }
}
