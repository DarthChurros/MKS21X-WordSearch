import java.util.*;
import java.io.*;

public class WordSearch {
  private char[][] data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;

  /**Initialize the grid to the size specified
   *and fill all of the positions with '_'
   *@param rows is the starting height of the WordSearch
   *@param cols is the starting width of the WordSearch
   */
  public WordSearch(int rows, int cols) {
    if (rows < 0 || cols < 0) {
      throw new IllegalArgumentException("WordSearch dimensions out of bounds!");
    }
    try {
      Scanner in = new Scanner(new File("words.txt"));
      while (in.hasNext()) {
        wordsToAdd.add(in.next());
      }
    } catch(FileNotFoundException e){
      System.out.println("File not found: words.txt");
      System.exit(1);
    }
    data = new char[rows][cols];
    clear();
    seed = 100;
    randgen = new Random(seed);
    addAllWords();
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        data[i][j] = '_';
      }
    }
  }

  private void addAllWords() {
    while (!wordsToAdd.isEmpty()) {
      String word = wordsToAdd.get(0);
      boolean run =  true;
      while (run) {
       run = !addWord(word, randgen.nextInt(), randgen.nextInt(), randgen);
     }
      wordsAdded.add(word);
      wordsToAdd.remove(word);
    }
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added in the direction rowIncrement,colIncrement
   *Words must have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical locaiton of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
   *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
   *@return true when: the word is added successfully.
   *        false when: the word doesn't fit, OR  rowIncrement and colIncrement are both 0,
   *        OR there are overlapping letters that do not match
   */
   private boolean addWord(String word, int row, int col, int rowIncrement, int colIncrement) {
     String reverse = "";
     for (int i = word.length() - 1; i >= 0; i--) {
       reverse += word.charAt(i);
     }
     if (rowIncrement == 1 && colIncrement == 1) {
       return addWordDiagonal(word, row, col);
     }
     if (rowIncrement == 0 && colIncrement == 1) {
       return addWordHorizontal(word, row, col);
     }
     if (rowIncrement == 1 && colIncrement == 0) {
       return addWordVertical(word, row, col);
     }
     if (rowIncrement == -1 && colIncrement == 0) {
       return addWordVertical(reverse, row, col - word.length() + 1);
     }
     if (rowIncrement == 0 && colIncrement == -1) {
       return addWordHorizontal(reverse, row - word.length() + 1, col);
     }
     if (rowIncrement == -1 && colIncrement == -1) {
       return addWordDiagonal(reverse, row - word.length() + 1, col - word.length() + 1);
     }
     if (rowIncrement == 1 && colIncrement == -1) {
       if (row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length || word.length() >= data.length) {
         return false;
       }
       for (int i = 0; i < word.length(); i++) {
         if (row + i >= data.length || data[row+i][col] != '_' && data[row+i][col] != word.charAt(i)) {
           return false;
         }
         if (col - i >= data[i].length || data[row][col-i] != '_' && data[row][col+i] != word.charAt(i)) {
           return false;
         }
       }
       for (int i = 0; i < word.length(); i++) {
         data[row+i][col-i] = word.charAt(i);
       }
       return true;
     }
     if (rowIncrement == -1 && colIncrement == 1) {
       if (row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length || word.length() >= data.length) {
         return false;
       }
       for (int i = 0; i < word.length(); i++) {
         if (row - i >= data.length || data[row-i][col] != '_' && data[row+i][col] != word.charAt(i)) {
           return false;
         }
         if (col + i >= data[i].length || data[row][col+i] != '_' && data[row][col+i] != word.charAt(i)) {
           return false;
         }
       }
       for (int i = 0; i < word.length(); i++) {
         data[row-i][col+i] = word.charAt(i);
       }
       return true;
     }
     return false;
   }

  /**Each row is a new line, there is a space between each letter
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
  public String toString() {
    String ans = "";
    for (int i = 0; i < data.length; i++) {
      ans += "|";
      for (int j = 0; j < data[i].length; j++) {
        ans += data[i][j] + " ";
      }
      ans += "\b|\n";
    }
    return ans;
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from left to right, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical location of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   * or there are overlapping letters that do not match, then false is returned
   * and the board is NOT modified.
   */
  public boolean addWordHorizontal(String word, int row, int col) {
    if (row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length) {
      System.out.println("bad params");
      return false;
    }
    for (int i =  0; i < word.length(); i++) {
      if (col + i >= data[i].length || data[row][col+i] != '_' && data[row][col+i] != word.charAt(i)) {
        return false;
      }
    }
    for (int i =  0; i < word.length(); i++) {
      data[row][col+i] = word.charAt(i);
    }
    return true;
  }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top to bottom, must fit on the WordGrid, and must
   *have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical location of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   *and the board is NOT modified.
   */
  public boolean addWordVertical(String word, int row, int col) {
    if (row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data.length) {
      return false;
    }
    for (int i =  0; i < word.length(); i++) {
      if (row + i >= data.length || data[row+i][col] != '_' && data[row+i][col] != word.charAt(i)) {
        return false;
       }
    }
    for (int i =  0; i < word.length(); i++) {
       data[row+i][col] = word.charAt(i);
    }
    return true;
   }

  /**Attempts to add a given word to the specified position of the WordGrid.
   *The word is added from top left to bottom right, must fit on the WordGrid,
   *and must have a corresponding letter to match any letters that it overlaps.
   *
   *@param word is any text to be added to the word grid.
   *@param row is the vertical location of where you want the word to start.
   *@param col is the horizontal location of where you want the word to start.
   *@return true when the word is added successfully. When the word doesn't fit,
   *or there are overlapping letters that do not match, then false is returned.
   */
   public boolean addWordDiagonal(String word, int row, int col) {
     if (row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length || word.length() >= data.length) {
       return false;
     }
     for (int i = 0; i < word.length(); i++) {
       if (row + i >= data.length || data[row+i][col] != '_' && data[row+i][col] != word.charAt(i)) {
         return false;
       }
       if (col + i >= data[i].length || data[row][col+i] != '_' && data[row][col+i] != word.charAt(i)) {
         return false;
       }
     }
     for (int i = 0; i < word.length(); i++) {
       data[row+i][col+i] = word.charAt(i);
     }
     return true;
   }
}
