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
   *@param fileName is the name of the file containing the word list
   *@param randSeed is the seed for the random generation of the WordSearch
   *@param key dictates whether the random letters should be omitted from the
   *WordSearch
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

  /**Attempts to add all words in wordsToAdd to the WordGrid. Each word
   *is chosen at random and assigned a random direction and position. If the
   *word cannot be added using addWord, another attempt is made with a
   *different starting position. Once a number of tries equal to the number
   *of possible starting positions has been made, the word is skipped.
   */
  private void addAllWords() {
    boolean wordStop = false;
    int wordTries = wordsToAdd.size() * 3;
    while (!(wordStop || wordsToAdd.isEmpty())) {
      int tries = data.length * data[0].length;
      int xDir = randgen.nextInt(3) - 1;
      int yDir = randgen.nextInt(3) - 1;
      boolean stop =  false;
      String word = wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
      while (!stop) {
        int x = randgen.nextInt(data.length);
        int y = randgen.nextInt(data[0].length);
        //System.out.println("Attempting to add " + word + " to " + (x%data.length) + ", "+(y%data[0].length) +" with xDir="+xDir+",yDir="+yDir+"...");
        stop = addWord(word, x, y, xDir, yDir) || tries <= 0;
        if (xDir == 0 && yDir == 0) {
          xDir = randgen.nextInt(2) - 1;
          yDir = randgen.nextInt(2) - 1;
        }
        tries--;
      }
      if (tries > 0) {
        wordsAdded.add(word);
        wordsToAdd.remove(word);
      } else {
        wordTries--;
      }
      if (wordTries <= 0) {
        wordStop = true;
      }
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
     if (rowIncrement == 0 && colIncrement == 0 || row < 0 || row >= data.length || col < 0 || col >= data[0].length || word.length() >= data[0].length || word.length() >= data.length) {
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
        if (data[i][j] == '_') {
          ans += "  ";
        } else {
          ans += data[i][j] + " ";
        }
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

  private void fillRandom() {
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < data[i].length; j++) {
        if (data[i][j] == '_') {
          data[i][j] = (char)(Math.abs((randgen.nextInt()) % 26) + 'A');
        }
      }
    }
  }


  public static void main(String[] args) {
    switch (args.length) {
      case 3:
        try {
          WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2], (int)(Math.random()*10000), false);
          System.out.println(WS);
        } catch (IllegalArgumentException e) {
          System.out.println("usage: [rows] [cols] [filename]");
        }
        break;
      case 4:
        try {
          WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]), false);
          System.out.println(WS);
        } catch (IllegalArgumentException e) {
          System.out.println("usage: [rows] [cols] [filename] [seed]");
        }
        break;
      case 5:
        try {
          WordSearch WS = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]),args[4].equals("key"));
          System.out.println(WS);
        } catch (IllegalArgumentException e) {
          System.out.println("usage: [rows] [cols] [filename] [seed] [key]");
        }
        break;
      default:
        System.out.println("You must include the puzzle's dimensions and words!");
    }
  }
}
