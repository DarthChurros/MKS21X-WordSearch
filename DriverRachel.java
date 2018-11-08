public class DriverRachel{
  public static void main(String[] args){
    //Testing constructor
    //Creating test constructors and testing clear()
    WordSearch mini = new WordSearch(6, 4);
    WordSearch a = new WordSearch(8,8);
    WordSearch b = new WordSearch(16,9);
    WordSearch c = new WordSearch(32,10);
    //-------------------------------------------------------------------------//


    //Testing negative indexes: should throw IllegalArgumentException
    System.out.println("---Initializing the grid to size specified:---");
    try{
      System.out.println("negIndices|Should throw IllegalArgumentException: ");
      WordSearch negIndices = new WordSearch(-9, 2);
    }
    catch (IllegalArgumentException e){
      System.out.println("Handled the error!");
    }
    //-------------------------------------------------------------------------//


    //Testing toString()
    System.out.println("\n\n---Testing toString()---");
    System.out.println("mini|Should print 6 rows of 4 '_'s:");
    System.out.println(mini.toString());
    System.out.println("a|Should print 8 rows of 8 '_'s:");
    System.out.println(a.toString());
    //-------------------------------------------------------------------------//


    //Testing addWordHorizontal(String word, int row, int col)
    System.out.println("\n\n---Testing addWordHorizontal(String word, int row, int col)---");
    System.out.println("Adding \"BIRD\" horizontally to row 0, column 0 of a: Should return true: "+ a.addWordHorizontal("BIRD", 0, 0));
    System.out.println("Adding \"KITTY\" horizontally to row 4, column 2 of a: Should return true: "+ a.addWordHorizontal("KITTY", 4, 2));
    System.out.println("Adding \"YEP\" horizontally to row 6, column 5 of a: Should return true: "+a.addWordHorizontal("YEP",6,5));
    System.out.println("Adding \"BLOB\" horizontally to row 7, column 0 of a: Should return true: "+a.addWordHorizontal("BLOB",7,0));
    System.out.println("Board a should be modified:");
    System.out.println(a.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Attempting to add a word to a negative index or an index too large");
    System.out.println("Attempting to add \"NEGIDX\" horizontally to row -1, column 0 of a: Should return false: "+ a.addWordHorizontal("NEGIDX",-1,0));
    System.out.println("Attempting to add \"BIGIDX\" horizontally to row 4, column 9 of a: Should return false: "+a.addWordHorizontal("BIGIDX",4,9));
    System.out.println("Board a should NOT be modified:");
    System.out.println(a.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Word is too long for given position");
    System.out.println("Attempting to add \"DICTIONARY\" horizontally to row 3, column 0 of a: Should return false: "+ a.addWordHorizontal("DICTIONARY",3,0));
    System.out.println("Attempting to add \"NAW\" horizontally to row 7, column 6 of a: Should return false: "+a.addWordHorizontal("NAW",7,6));
    System.out.println("Board a should NOT be modified:");
    System.out.println(a.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Letters overlap");
    System.out.println("Adding \"DOG\" horizontally to row 0, column 3 of a: Should return true: " + a.addWordHorizontal("DOG", 0, 3));
    System.out.println("Adding \"OAK\" horizontally to row 4, column 0 of a: Should return true: "+ a.addWordHorizontal("OAK", 4, 0));
    System.out.println("Adding \"BLOBFISH\" horizontally to row 7, column 0 of a: Should return true: "+a.addWordHorizontal("BLOBFISH",7,0));
    if (a.addWordHorizontal("DOG",0,3) == false || a.addWordHorizontal("OAK",4,0) == false || a.addWordHorizontal("BLOBFISH",7,0) == false){
      System.out.println("Check that overlapping letters that are the same doesn't prevent addWordHorizontal() from returning true.");
    }
    System.out.println("Board a should be modified:");
    System.out.println(a.toString());
    System.out.println("Attempting to add \"HELLO\" to row 6, column 2 of a: Should return false: "+ a.addWordHorizontal("HELLO", 6, 2));
    System.out.println("Attempting to add \"YES\" to row 6, column 5 of a: Should return false: "+a.addWordHorizontal("YES",6, 5));
    if (a.addWordHorizontal("HELLO", 6, 2)==true||a.addWordHorizontal("YES",6,5)== true){
      System.out.println("Check that overlapping letters that are NOT the same makes addWordHorizontal() return false.");
    }
    System.out.println("Board a should NOT be modified:");
    System.out.println(a.toString());
    //-------------------------------------------------------------------------//


    //-------------------------------------------------------------------------//
    //Testing addWordVertical(String word, int row, int col)
    System.out.println("\n\n---Testing addWordVertical(String word, int row, int col)");
    System.out.println("Adding \"KART\" vertically to row 4, column 5 of b: Should return true: "+ b.addWordVertical("KART", 4, 5));
    System.out.println("Adding \"YOSHIYOSHI\" vertically to row 1, column 3 of b: Should return true: "+ b.addWordVertical("YOSHIYOSHI", 1, 3));
    System.out.println("Adding \"PEACH\" vertically to row 6, column 8 of b: Should return true: "+b.addWordVertical("PEACH",6,8));
    System.out.println("Adding \"LUIGI\" vertically to row 2, column 2 of b: Should return true: "+b.addWordVertical("LUIGI",2,2));
    System.out.println("Board b should be modified:");
    System.out.println(b.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Attempting to add a word to a negative index or an index too large");
    System.out.println("Attempting to add \"NEGIDX\" vertically to row -1, column 0 of b: Should return false: "+ b.addWordVertical("NEGIDX",-1,0));
    System.out.println("Attempting to add \"BIGIDX\" vertically to row 4, column 9 of b: Should return false: "+b.addWordVertical("BIGIDX",4,9));
    System.out.println("Board b should NOT be modified:");
    System.out.println(b.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Word is too long for given position");
    System.out.println("Attempting to add \"NEWYORKCITYNEWYORK\" vertically to row 0, column 0 of b: Should return false: "+ b.addWordVertical("NEWYORKCITYNEWYORK",0,0));
    System.out.println("Attempting to add \"NAW\" vertically to row 14, column 1 of b: Should return false: "+b.addWordVertical("NAW",14,1));
    System.out.println("Board b should NOT be modified:");
    System.out.println(b.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Letters overlap");
    System.out.println("Adding \"TIGGER\" vertically to row 7, column 5 of b: Should return true: "+b.addWordVertical("TIGGER",7,5));
    System.out.println("Adding \"IGLOO\" vertically to row 6, column 2 of b: Should return true: "+ b.addWordVertical("IGLOO", 6,2));
    System.out.println("Adding \"PEACHY\" vertically to row 6, column 8 of b: Should return true: "+b.addWordVertical("PEACHY",6,8));
    if (b.addWordVertical("TIGGER",7,5) == false || b.addWordVertical("IGLOO",6,2) == false || b.addWordVertical("PEACHY",6,8) == false){
      System.out.println("Check that overlapping letters that are the same doesn't prevent addWordVertical() from returning true.");
    }
    System.out.println("Board b should be modified:");
    System.out.println(b.toString());
    System.out.println("Adding \"HI\" vertically to row 6, column 5 of b: Should return false: "+b.addWordVertical("HI",6,5));
    System.out.println("Attempting to add \"SHOP\" to row 8, column 3 of b: Should return false: "+b.addWordVertical("SHOP",8, 3));
    if (b.addWordVertical("HI", 6, 5)==true||b.addWordVertical("SHOP",8,3)== true){
      System.out.println("Check that overlapping letters that are NOT the same makes addWordVertical() return false.");
    }
    System.out.println("Board b should NOT be modified:");
    System.out.println(b.toString());
  }
}
