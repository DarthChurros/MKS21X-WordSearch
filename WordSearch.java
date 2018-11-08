public class WordSearch {
  private char[][] data;

  /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
  public WordSearch(int rows, int cols) {
    data = new char[rows][cols];
    clear();
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = '_';
      }
    }
  }

  /**Each row is a new line, there is a space between each letter
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
   public String toString() {
     String ans = "";
     for (int i = 0; i < data.length; i++) {
       for (int j = 0; j < data[i].length; j++) {
         ans += data[i][j] + " ";
       }
       ans += "\n";
     }
     return ans;
   }
}
