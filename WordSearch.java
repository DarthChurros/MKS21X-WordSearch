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

  public WordSearch(int rows, int cols, String fileName, int randSeed, boolean key) {
    if (rows < 0 || cols < 0) {
      throw new IllegalArgumentException("WordSearch dimensions out of bounds!");
    }
    data = new char[rows][cols];
    wordsToAdd = new ArrayList<String>();
    wordsAdded = new ArrayList<String>();
    clear();
    try {
      Scanner in = new Scanner(new File(fileName));
      while (in.hasNext()) {
        String x = in.next();
        wordsToAdd.add(x);
      }
    } catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
    seed = randSeed;
    randgen = new Random(seed);
    addAllWords();
    if (!key) {
      fillRandom();
    }
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
      int tries = 0;
      int xDir = randgen.nextInt() % 2;
      int yDir = randgen.nextInt() % 2;
      boolean stop =  false;
      String word = wordsToAdd.get(0);
      while (!stop) {
        int x = Math.abs(randgen.nextInt());
        int y = Math.abs(randgen.nextInt());
        //System.out.println("Attempting to add " + word + " to " + (x%data.length) + ", "+(y%data[0].length) +" with xDir="+xDir+",yDir="+yDir+"...");
        stop = addWord(word, x % data.length, y % data[0].length, xDir, yDir) || tries >= data.length * data[0].length;
        if (xDir == 0 && yDir == 0) {
          xDir = randgen.nextInt() % 2;
          yDir = randgen.nextInt() % 2;
        }
        tries++;
     }
     if (tries < data.length * data[0].length) {
      wordsAdded.add(word);
    }
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
     if (rowIncrement == 0 && colIncrement == 0 || row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length) {
       return false;
     }
     for (int i = 0; i < word.length(); i++) {
       if (row+i*rowIncrement>=data.length||row+i*rowIncrement<0||col+i*colIncrement>=data[i].length||col+i*colIncrement<0||data[row+i*rowIncrement][col+i*colIncrement] != '_' && data[row+i*rowIncrement][col+i*colIncrement] != word.charAt(i)) {
         return false;
       }
     }
     for (int i = 0; i < word.length(); i++) {
       data[row+i*rowIncrement][col+i*colIncrement] = word.charAt(i);
     }
     return true;
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
    ans += "Words: ";
    for (int i = 0; i < wordsAdded.size(); i++) {
      ans += wordsAdded.get(i) + ", ";
    }
    ans += "\b\b (seed: " + seed + ")";
    return ans;
  }

  public void fillRandom() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] == '_') {
          data[i][j] = (char)(Math.abs((randgen.nextInt()) % 26) + 'A');
        }
      }
    }
  }


  public static void main(String[] args) {
    int seed = Math.abs((int)Math.random()) % 10001;
    switch (args.length) {
      case 3:
        try {
          WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2]);
          System.out.println(WS);
        } catch (IllegalArgumentException e) {
          System.out.println("usage: [rows] [cols] [filename]");
        }
        break;
      case 4:
        try {
          WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
          System.out.println(WS);
        } catch (IllegalArgumentException e) {
          System.out.println("usage: [rows] [cols] [filename] seed");
        }
        break;
      case 5:
        WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),args[4].equals("key"));
        System.out.println(WS);
        break;
    }
  }
}
