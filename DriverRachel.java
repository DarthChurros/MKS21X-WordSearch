public class DriverRachel{
  public static void main(String[] args){
    //Testing constructor
    //Creating test constructors and testing clear()
    WordSearch mini = new WordSearch(6, 4);
    WordSearch a = new WordSearch(8,8);
    WordSearch b = new WordSearch(16,9);
    WordSearch c = new WordSearch(10,10);
    WordSearch pokemon = new WordSearch(15, 36);
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
    //-------------------------------------------------------------------------//


    //-------------------------------------------------------------------------//
    //Testing addWordDiagonal(String word, int row, int col)
    System.out.println("\n\n---Testing addWordDiagonal(String word, int row, int col)---");
    System.out.println("Adding \"RAIN\" diagonally to row 1, column 2 of c: Should return true: "+ c.addWordDiagonal("RAIN", 1, 2));
    System.out.println("Adding \"SNOW\" diagonally to row 0, column 3 of c: Should return true: "+ c.addWordDiagonal("SNOW", 0, 3));
    System.out.println("Adding \"SLEET\" diagonally to row 5, column 5 of c: Should return true: "+c.addWordDiagonal("SLEET",5, 5));
    System.out.println("Adding \"SLANT\" diagonally to row 4, column 0 of c: Should return true: "+c.addWordDiagonal("SLANT",4, 0));
    System.out.println("Board a should be modified:");
    System.out.println(c.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Attempting to add a word to a negative index or an index too large");
    System.out.println("Attempting to add \"NEGIDX\" diagonally to row -1, column 0 of c: Should return false: "+ c.addWordDiagonal("NEGIDX",-1,0));
    System.out.println("Attempting to add \"BIGIDX\" diagonally to row 3, column 9 of c: Should return false: "+c.addWordDiagonal("BIGIDX",3,9));
    System.out.println("Board c should NOT be modified:");
    System.out.println(c.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Word is too long for given position");
    System.out.println("Attempting to add \"ALMONDMILK\" diagonally to row 3, column 0 of c: Should return false: "+ c.addWordDiagonal("ALMONDMILK",3,0));
    System.out.println("Attempting to add \"NAW\" diagonally to row 8, column 6 of c: Should return false: "+c.addWordDiagonal("NAW",8,6));
    System.out.println("Board c should NOT be modified:");
    System.out.println(c.toString());
    //-------------------------------------------------------------------------//
    System.out.println("\nCase: Letters overlap");
    System.out.println("Adding \"SLIPS\" diagonally to row 1, column 1 of c: Should return true: " + c.addWordDiagonal("SLIPS", 1, 1));
    System.out.println("Adding \"WET\" diagonally to row 3, column 6 of c: Should return true: "+ c.addWordDiagonal("WET", 3, 6));
    System.out.println("Adding \"RAINDROP\" diagonally to row 1, column 2 of c: Should return true: "+c.addWordDiagonal("RAINDROP",1,2));
    if (c.addWordDiagonal("SLIPS", 1, 1) == false || c.addWordDiagonal("WET",3,6) == false || c.addWordDiagonal("RAINDROP",1,2) == false){
      System.out.println("Check that overlapping letters that are the same doesn't prevent addWordHorizontal() from returning true.");
    }
    System.out.println("Board c should be modified:");
    System.out.println(c.toString());
    System.out.println("Attempting to add \"HELLO\" to row 2, column 2 of c: Should return false: "+ c.addWordDiagonal("HELLO", 2, 2));
    System.out.println("Attempting to add \"ERASE\" to row 0, column 1 of c: Should return false: "+c.addWordDiagonal("ERASE",0, 1));
    if (c.addWordDiagonal("HELLO", 2, 2)==true||c.addWordDiagonal("ERASE",0,1)== true){
      System.out.println("Check that overlapping letters that are NOT the same makes addWordHorizontal() return false.");
    }
    System.out.println("Board c should NOT be modified:");
    System.out.println(c.toString());
    //-------------------------------------------------------------------------//


    //-------------------------------------------------------------------------//
    System.out.println("\nIf everything works well, all tests below should be true");
    System.out.println("Format: POKEMON, ROW, COL: true/false");
    System.out.println("\nHorizontal additions: \n");
    System.out.println("SWELLOW, 0, 0: "+pokemon.addWordHorizontal("SWELLOW",0,0));
    System.out.println("ABSOL, 1, 7: "+pokemon.addWordHorizontal("ABSOL",1,7));
    System.out.println("DUGTRIO, 1, 20: "+pokemon.addWordHorizontal("DUGTRIO",1,20));
    System.out.println("PIPLUP, 3, 16: "+pokemon.addWordHorizontal("PIPLUP", 3, 16));
    System.out.println("HITMONLEE, 3, 23: "+pokemon.addWordHorizontal("HITMONLEE", 3, 23));
    System.out.println("CORPHISH, 4, 9: "+pokemon.addWordHorizontal("CORPHISH", 4, 9));
    System.out.println("TURTWIG, 5, 0: "+pokemon.addWordHorizontal("TURTWIG",5,0));
    System.out.println("MACHOKE, 5, 25: "+pokemon.addWordHorizontal("MACHOKE", 5, 25));
    System.out.println("EXEGGUTOR, 7, 0: "+pokemon.addWordHorizontal("EXEGGUTOR",7,0));
    System.out.println(pokemon.toString());
    /* Result
    0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
  0 S W E L L O W _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  1 _ _ _ _ _ _ _ A B S O L _ _ _ _ _ _ _ _ D U G T R I O _ _ _ _ _ _ _ _ _
  2 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  3 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ P I P L U P _ H I T M O N L E E _ _ _ _
  4 _ _ _ _ _ _ _ _ _ C O R P H I S H _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  5 T U R T W I G _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ M A C H O K E _ _ _ _
  6 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  7 E X E G G U T O R _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  8 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  9 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 10 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 11 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 12 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 13 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 14 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("\nVertical additions: \n");
    System.out.println("SQUIRTLE, 0, 0: "+pokemon.addWordVertical("SQUIRTLE",0,0));
    System.out.println("VULPIX, 0, 21: "+pokemon.addWordVertical("VULPIX", 0, 21));
    System.out.println("PHANPHY, 3, 16: "+pokemon.addWordVertical("PHANPHY",3,16));
    System.out.println(pokemon.toString());
    /* Result
    0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
  0 S W E L L O W _ _ _ _ _ _ _ _ _ _ _ _ _ _ V _ _ _ _ _ _ _ _ _ _ _ _ _ _
  1 Q _ _ _ _ _ _ A B S O L _ _ _ _ _ _ _ _ D U G T R I O _ _ _ _ _ _ _ _ _
  2 U _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ L _ _ _ _ _ _ _ _ _ _ _ _ _ _
  3 I _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ P I P L U P _ H I T M O N L E E _ _ _ _
  4 R _ _ _ _ _ _ _ _ C O R P H I S H _ _ _ _ I _ _ _ _ _ _ _ _ _ _ _ _ _ _
  5 T U R T W I G _ _ _ _ _ _ _ _ _ A _ _ _ _ X _ _ _ M A C H O K E _ _ _ _
  6 L _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ N _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  7 E X E G G U T O R _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  8 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ H _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  9 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Y _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 10 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 11 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 12 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 13 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 14 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("\nDiagonal additions: \n");
    System.out.println("LUCARIO, 0, 3: "+pokemon.addWordDiagonal("LUCARIO",0,3));
    System.out.println("WAILORD, 0, 6: "+pokemon.addWordDiagonal("WAILORD",0,6));
    System.out.println("MAGIKARP, 0, 14: "+pokemon.addWordDiagonal("MAGIKARP",0,14));
    System.out.println("MUDKIP, 0, 29: "+pokemon.addWordDiagonal("MUDKIP",0,29));
    System.out.println("CHIMCHAR, 2, 22: "+pokemon.addWordDiagonal("CHIMCHAR",2,22));
    System.out.println(pokemon.toString());
    /* Result
    0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
  0 S W E L L O W _ _ _ _ _ _ _ M _ _ _ _ _ _ V _ _ _ _ _ _ _ M _ _ _ _ _ _
  1 Q _ _ _ U _ _ A B S O L _ _ _ A _ _ _ _ D U G T R I O _ _ _ U _ _ _ _ _
  2 U _ _ _ _ C _ _ I _ _ _ _ _ _ _ G _ _ _ _ L C _ _ _ _ _ _ _ _ D _ _ _ _
  3 I _ _ _ _ _ A _ _ L _ _ _ _ _ _ P I P L U P _ H I T M O N L E E K _ _ _
  4 R _ _ _ _ _ _ R _ C O R P H I S H _ K _ _ I _ _ I _ _ _ _ _ _ _ _ I _ _
  5 T U R T W I G _ I _ _ R _ _ _ _ A _ _ A _ X _ _ _ M A C H O K E _ _ P _
  6 L _ _ _ _ _ _ _ _ O _ _ D _ _ _ N _ _ _ R _ _ _ _ _ C _ _ _ _ _ _ _ _ _
  7 E X E G G U T O R _ _ _ _ _ _ _ P _ _ _ _ P _ _ _ _ _ H _ _ _ _ _ _ _ _
  8 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ H _ _ _ _ _ _ _ _ _ _ _ A _ _ _ _ _ _ _
  9 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Y _ _ _ _ _ _ _ _ _ _ _ _ R _ _ _ _ _ _
 10 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 11 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 12 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 13 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 14 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
  */

    System.out.println("\nMore horizontal additions: \n");
    System.out.println("STARAPTOR, 7, 11: "+pokemon.addWordHorizontal("STARAPTOR",7,11));
    System.out.println("EEVEE, 7, 31: "+pokemon.addWordHorizontal("EEVEE",7,31));
    System.out.println("GIRATINA, 8, 2: "+pokemon.addWordHorizontal("GIRATINA",8,2));
    System.out.println("TORKOAL, 9, 27: "+pokemon.addWordHorizontal("TORKOAL",9,27));
    System.out.println("MEOWTH, 11, 3: "+pokemon.addWordHorizontal("MEOWTH", 11, 3));
    System.out.println("MAGNAMITE, 11, 3: "+pokemon.addWordHorizontal("MAGNAMITE",12, 18));
    System.out.println("OMASTAR, 13, 0: "+pokemon.addWordHorizontal("OMASTAR",13,0));
    System.out.println("BULBASAUR, 13, 25: "+pokemon.addWordHorizontal("BULBASAUR",13,25));
    System.out.println("PRINPLUP, 14 ,4: "+pokemon.addWordHorizontal("PRINPLUP", 14, 4));
    System.out.println("TOTODILE, 14, 10: "+pokemon.addWordHorizontal("TOTODILE",14,16));
    System.out.println(pokemon.toString());
    /* Result
    0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
  0 S W E L L O W _ _ _ _ _ _ _ M _ _ _ _ _ _ V _ _ _ _ _ _ _ M _ _ _ _ _ _
  1 Q _ _ _ U _ _ A B S O L _ _ _ A _ _ _ _ D U G T R I O _ _ _ U _ _ _ _ _
  2 U _ _ _ _ C _ _ I _ _ _ _ _ _ _ G _ _ _ _ L C _ _ _ _ _ _ _ _ D _ _ _ _
  3 I _ _ _ _ _ A _ _ L _ _ _ _ _ _ P I P L U P _ H I T M O N L E E K _ _ _
  4 R _ _ _ _ _ _ R _ C O R P H I S H _ K _ _ I _ _ I _ _ _ _ _ _ _ _ I _ _
  5 T U R T W I G _ I _ _ R _ _ _ _ A _ _ A _ X _ _ _ M A C H O K E _ _ P _
  6 L _ _ _ _ _ _ _ _ O _ _ D _ _ _ N _ _ _ R _ _ _ _ _ C _ _ _ _ _ _ _ _ _
  7 E X E G G U T O R _ _ S T A R A P T O R _ P _ _ _ _ _ H _ _ _ E E V E E
  8 _ _ G I R A T I N A _ _ _ _ _ _ H _ _ _ _ _ _ _ _ _ _ _ A _ _ _ _ _ _ _
  9 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ Y _ _ _ _ _ _ _ _ _ _ T O R K O A L _ _
 10 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 11 _ _ _ M E O W T H _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 12 _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ M A G N A M I T E _ _ _ _ _ _ _ _ _
 13 O M A S T A R _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ B U L B A S A U R _ _
 14 _ _ _ _ P R I N P L U P _ _ _ _ T O T O D I L E _ _ _ _ _ _ _ _ _ _ _ _
  */

    System.out.println("\nMore vertical additions: \n");
    System.out.println("GROWLITH, 6, 14: "+pokemon.addWordVertical("GROWLITH",6,14));
    System.out.println("MEWTWO, 6, 35: "+pokemon.addWordVertical("MEWTWO",6,35));
    System.out.println("BIDOOF, 9, 0: "+pokemon.addWordVertical("BIDOOF",9,0));
    System.out.println("DITTO, 10, 17: "+pokemon.addWordVertical("DITTO",10,17));
    System.out.println(pokemon.toString());
    /*Result
      0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
    0 S W E L L O W _ _ _ _ _ _ _ M _ _ _ _ _ _ V _ _ _ _ _ _ _ M _ _ _ _ _ _
    1 Q _ _ _ U _ _ A B S O L _ _ _ A _ _ _ _ D U G T R I O _ _ _ U _ _ _ _ _
    2 U _ _ _ _ C _ _ I _ _ _ _ _ _ _ G _ _ _ _ L C _ _ _ _ _ _ _ _ D _ _ _ _
    3 I _ _ _ _ _ A _ _ L _ _ _ _ _ _ P I P L U P _ H I T M O N L E E K _ _ _
    4 R _ _ _ _ _ _ R _ C O R P H I S H _ K _ _ I _ _ I _ _ _ _ _ _ _ _ I _ _
    5 T U R T W I G _ I _ _ R _ _ _ _ A _ _ A _ X _ _ _ M A C H O K E _ _ P _
    6 L _ _ _ _ _ _ _ _ O _ _ D _ G _ N _ _ _ R _ _ _ _ _ C _ _ _ _ _ _ _ _ M
    7 E X E G G U T O R _ _ S T A R A P T O R _ P _ _ _ _ _ H _ _ _ E E V E E
    8 _ _ G I R A T I N A _ _ _ _ O _ H _ _ _ _ _ _ _ _ _ _ _ A _ _ _ _ _ _ W
    9 B _ _ _ _ _ _ _ _ _ _ _ _ _ W _ Y _ _ _ _ _ _ _ _ _ _ T O R K O A L _ T
   10 I _ _ _ _ _ _ _ _ _ _ _ _ _ L _ _ D _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ W
   11 D _ _ M E O W T H _ _ _ _ _ I _ _ I _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ O
   12 O _ _ _ _ _ _ _ _ _ _ _ _ _ T _ _ T M A G N A M I T E _ _ _ _ _ _ _ _ _
   13 O M A S T A R _ _ _ _ _ _ _ H _ _ T _ _ _ _ _ _ _ B U L B A S A U R _ _
   14 F _ _ _ P R I N P L U P _ _ _ _ T O T O D I L E _ _ _ _ _ _ _ _ _ _ _ _
   */

    System.out.println("More diagonal additions: \n");
    System.out.println("LUXRAY, 3, 19: "+pokemon.addWordDiagonal("LUXRAY",3,19));
    System.out.println("DRATINI, 6, 18: "+pokemon.addWordDiagonal("DRATINI",6,18));
    System.out.println("CHARIZARD, 6, 26: "+pokemon.addWordDiagonal("CHARIZARD",6,26));
    System.out.println("GARCHOMP, 7, 4: "+pokemon.addWordDiagonal("GARCHOMP",7,4));
    System.out.println("RATATA, 7, 8: "+pokemon.addWordDiagonal("RATATA",7,8));
    System.out.println(pokemon.toString());
    /* Result
      0 1 2 3 4 5 6 7 8 9 10        15        20        25        30        35
    0 S W E L L O W _ _ _ _ _ _ _ M _ _ _ _ _ _ V _ _ _ _ _ _ _ M _ _ _ _ _ _
    1 Q _ _ _ U _ _ A B S O L _ _ _ A _ _ _ _ D U G T R I O _ _ _ U _ _ _ _ _
    2 U _ _ _ _ C _ _ I _ _ _ _ _ _ _ G _ _ _ _ L C _ _ _ _ _ _ _ _ D _ _ _ _
    3 I _ _ _ _ _ A _ _ L _ _ _ _ _ _ P I P L U P _ H I T M O N L E E K _ _ _
    4 R _ _ _ _ _ _ R _ C 0 R P H I S H _ K _ U I _ _ I _ _ _ _ _ _ _ _ I _ _
    5 T U R T W I G _ I _ _ R _ _ _ _ A _ _ A _ X _ _ _ M A C H O K E _ _ P _
    6 L _ _ _ _ _ _ _ _ O _ _ D _ G _ N _ D _ R _ R _ _ _ C _ _ _ _ _ _ _ _ M
    7 E X E G G U T O R _ _ S T A R A P T O R _ P _ A _ _ _ H _ _ _ E E V E E
    8 _ _ G I R A T I N A _ _ _ _ O _ H _ _ _ A _ _ _ Y _ _ _ A _ _ _ _ _ _ W
    9 B _ _ _ _ _ R _ _ _ T _ _ _ W _ Y _ _ _ _ T _ _ _ _ _ T O R K O A L _ T
   10 I _ _ _ _ _ _ C _ _ _ A _ _ L _ _ D _ _ _ _ I _ _ _ _ _ _ _ I _ _ _ _ W
   11 D _ _ M E O W T H _ _ _ T _ I _ _ I _ _ _ _ _ N _ _ _ _ _ _ _ Z _ _ _ O
   12 O _ _ _ _ _ _ _ _ O _ _ _ A T _ _ T M A G N A M I T E _ _ _ _ _ A _ _ _
   13 O M A S T A R _ _ _ M _ _ _ H _ _ T _ _ _ _ _ _ _ B U L B A S A U R _ _
   14 F _ _ _ P R I N P L U P _ _ _ _ T O T O D I L E _ _ _ _ _ _ _ _ _ _ D _
    */
  }
}
