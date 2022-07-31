// --== CS400 Project One File Header ==--
// Name: Dong Won Nam
// Email: dnam9@wisc.edu
// Team: red
// Group: AD
// TA: Ilay
// Lecturer: Gary Dahl
// Notes to Grader: N/A
public class HashtableMapTests {

  /*
   * Check for put and get methods
   */
  public static boolean test1() {

    // Check for String
    HashtableMap<String, String> hashTable1 = new HashtableMap<String, String>(5);
    hashTable1.put("Song1", "S1");
    hashTable1.put("Song2", "S2");
    hashTable1.put("Song3", "S3");
    hashTable1.put("Song4", "S4"); // Load factor exceeds 80%

    if (!hashTable1.get("Song1").equals("S1")) {
      System.out.println("Error in test1 get()");
      System.out.println("Expected: S1, Actual: " + hashTable1.get("Song1"));
      return false;
    }

    hashTable1.put("Song5", "S5");
    hashTable1.put("Song6", "S6");
    hashTable1.put("Song7", "S7");
    hashTable1.put("Song8", "S8");

    if (!hashTable1.get("Song6").equals("S6")) {
      System.out.println("Error in test1 get()");
      System.out.println("Expected: S6, Actual: " + hashTable1.get("Song6"));
      return false;
    }

    if (!hashTable1.get("Song8").equals("S8")) {
      System.out.println("Error in test1: Key does not match value");
      System.out.println("Expected: S8, Actual: " + hashTable1.get("Song8"));
      return false;
    }

    hashTable1.put("Song8", "S10"); // Put duplicate

    if (!hashTable1.get("Song8").equals("S8")) {
      System.out.println("Error in test1: Duplicate issue");
      System.out.println("Expected: S8, Actual: " + hashTable1.get("Song8"));
      return false;
    }

    // Check for Integer
    HashtableMap<Integer, Integer> hashTable2 = new HashtableMap<Integer, Integer>(5);
    hashTable2.put(14, 5);
    hashTable2.put(23, 1);
    hashTable2.put(3, 5); // Same hashCode as 23
    hashTable2.put(5, 6); // Load factor exceeds 80% -> Capacity is 10

    if (!hashTable2.get(14).equals(5)) {
      System.out.println("Error in test1 get()");
      System.out.println("Expected: 5, Actual: " + hashTable2.get(14));
      return false;
    }

    if (!hashTable2.get(3).equals(5)) {
      System.out.println("Error in test1 get(): Collision issue");
      System.out.println("Expected: 5, Actual: " + hashTable2.get(3));
      return false;
    }

    hashTable2.put(2, 8);
    hashTable2.put(8, 3);
    hashTable2.put(6, 6);
    hashTable2.put(26, 1);

    if (hashTable2.size() != 8) {
      System.out.println("Error in test1: Size does not match");
      System.out.println("Expected: 8, Actual: " + hashTable2.size());
      return false;
    }

    if (!hashTable2.get(6).equals(6)) {
      System.out.println("Error in test1 get()");
      System.out.println("Expected: 6, Actual: " + hashTable2.get(6));
      return false;
    }

    hashTable2.put(26, 1); // Put duplicate

    if (!hashTable2.get(6).equals(6)) {
      System.out.println("Error in test1 get()");
      System.out.println("Expected: 6, Actual: " + hashTable2.get(6));
      return false;
    }

    return true;
  }

  /*
   * Check for size method
   */
  public static boolean test2() {
    // Check for String
    HashtableMap<String, String> hashTable1 = new HashtableMap<String, String>(5);
    hashTable1.put("Song1", "S1");
    hashTable1.put("Song2", "S2");
    hashTable1.put("Song3", "S3");
    hashTable1.put("Song4", "S4"); // Load factor exceeds 80% -> Capacity is 10

    if (hashTable1.size() != 4) {
      System.out.println("Error in test2 size(): Size does not match");
      System.out.println("Expected: 4, Actual: " + hashTable1.size());
      return false;
    }

    hashTable1.put("Song5", "S5");
    hashTable1.put("Song6", "S6");
    hashTable1.put("Song7", "S7");
    hashTable1.put("Song8", "S8"); // Load factor exceeds 80% -> Capacity is 15


    if (hashTable1.size() != 8) {
      System.out.println("Error in test2 size(): Size does not match");
      System.out.println("Expected: 8, Actual: " + hashTable1.size());
      return false;
    }

    // Check for Integer
    HashtableMap<Integer, Integer> hashTable2 = new HashtableMap<Integer, Integer>(5);
    hashTable2.put(14, 5);
    hashTable2.put(23, 1);
    hashTable2.put(3, 5); // Same hashCode as 23
    hashTable2.put(5, 6); // Load factor exceeds 80%

    if (hashTable2.size() != 4) {
      System.out.println("Error in test2 size(): Size does not match");
      System.out.println("Expected: 4, Actual: " + hashTable2.size());
      return false;
    }

    hashTable2.put(2, 8);
    hashTable2.put(8, 3);
    hashTable2.put(6, 6);
    hashTable2.put(26, 1);

    if (hashTable2.size() != 8) {
      System.out.println("Error in test2 size(): Size does not match");
      System.out.println("Expected: 8, Actual: " + hashTable2.size());
      return false;
    }
    return true;
  }

  /*
   * Check for remove method and get to check if it is removed
   */
  public static boolean test3() {
    // Check for String
    HashtableMap<String, String> hashTable1 = new HashtableMap<String, String>(5);
    hashTable1.put("Song1", "S1");
    hashTable1.put("Song2", "S2");
    hashTable1.put("Song3", "S3");
    hashTable1.put("Song4", "S4"); // Load factor exceeds 80%
    hashTable1.put("Song5", "S5");
    hashTable1.put("Song6", "S6");
    hashTable1.put("Song7", "S7");
    hashTable1.put("Song8", "S8");

    hashTable1.remove("Song1");

    if (hashTable1.containsKey("Song1")) {
      System.out.println("Error in test3 remove()");
      System.out.println("Expected: false Actual: " + hashTable1.containsKey("Song1"));
      return false;
    }

    if (!hashTable1.remove("Song2").equals("S2")) {
      System.out.println("Error in test3 remove()");
      System.out.println("Expected: S2 Actual: " + hashTable1.remove("Song2"));
      return false;
    }

    if (hashTable1.size() != 6) {
      System.out.println("Error in test3 remove(): wrong size");
      System.out.println("Expected: 6 Actual: " + hashTable1.size());
      return false;
    }

    // Check for Integer
    HashtableMap<Integer, Integer> hashTable2 = new HashtableMap<Integer, Integer>(5);
    hashTable2.put(14, 5);
    hashTable2.put(23, 1);
    hashTable2.put(3, 5); // Same hashCode as 23
    hashTable2.put(5, 6); // Load factor exceeds 80%
    hashTable2.put(2, 8);
    hashTable2.put(8, 3);
    hashTable2.put(6, 6);
    hashTable2.put(26, 1);

    if (!hashTable2.remove(23).equals(1)) {
      System.out.println("Error in test3 remove()");
      System.out.println("Expected: 1 Actual: " + hashTable2.remove(23));
      return false;
    }

    if (hashTable2.size() != 7) {
      System.out.println("Error in test3 remove(): wrong size");
      System.out.println("Expected: 7 Actual: " + hashTable2.size());
      return false;
    }

    return true;
  }

  /*
   * Check for containsKey
   */
  public static boolean test4() {

    // Check for String
    HashtableMap<String, String> hashTable1 = new HashtableMap<String, String>(5);
    hashTable1.put("Song1", "S1");
    hashTable1.put("Song2", "S2");
    hashTable1.put("Song3", "S3");
    hashTable1.put("Song4", "S4"); // Load factor exceeds 80%
    hashTable1.put("Song5", "S5");
    hashTable1.put("Song6", "S6");
    hashTable1.put("Song7", "S7");
    hashTable1.put("Song8", "S8");

    if (!hashTable1.containsKey("Song1")) {
      System.out.println("Error in test4 containsKey()");
      System.out.println("Expected: true Actual: " + hashTable1.containsKey("Song1"));
      return false;
    }

    if (hashTable1.containsKey("Song10")) {
      System.out.println("Error in test4 containsKey()");
      System.out.println("Expected: false Actual: " + hashTable1.containsKey("Song1"));
      return false;
    }

    // Check for Integer
    HashtableMap<Integer, Integer> hashTable2 = new HashtableMap<Integer, Integer>(5);
    hashTable2.put(14, 5);
    hashTable2.put(23, 1);
    hashTable2.put(2, 5);
    hashTable2.put(5, 6); // Load factor exceeds 80%
    hashTable2.put(2, 8);
    hashTable2.put(8, 3);
    hashTable2.put(6, 6);
    hashTable2.put(26, 1);

    if (!hashTable2.containsKey(5)) {
      System.out.println("Error in test4 containsKey()");
      System.out.println("Expected: true Actual: " + hashTable2.containsKey(5));
      return false;
    }

    if (hashTable2.containsKey(7)) {
      System.out.println("Error in test4 containsKey()");
      System.out.println("Expected: false Actual: " + hashTable2.containsKey(7));
      return false;
    }

    return true;
  }

  /*
   * Check for clear method
   */
  public static boolean test5() {
    // Check for String
    HashtableMap<String, String> hashTable1 = new HashtableMap<String, String>(5);
    hashTable1.put("Song1", "S1");
    hashTable1.put("Song2", "S2");
    hashTable1.put("Song3", "S3");
    hashTable1.put("Song4", "S4"); // Load factor exceeds 80% -> Capacity is 10

    if (hashTable1.size() != 4) {
      System.out.println("Error in test5 size(): Size does not match");
      System.out.println("Expected: 4, Actual: " + hashTable1.size());
      return false;
    }

    hashTable1.put("Song5", "S5");
    hashTable1.put("Song6", "S6");
    hashTable1.put("Song7", "S7");
    hashTable1.put("Song8", "S8"); // Load factor exceeds 80% -> Capacity is 15


    if (hashTable1.size() != 8) {
      System.out.println("Error in test5 size(): Size does not match");
      System.out.println("Expected: 8, Actual: " + hashTable1.size());
      return false;
    }


    hashTable1.clear();

    if (hashTable1.size() != 0) {
      System.out.println("Error in test5 clear()");
      System.out.println("Expected: 0, Actual: " + hashTable1.size());
      return false;
    }


    // Check for Integer
    HashtableMap<Integer, Integer> hashTable2 = new HashtableMap<Integer, Integer>(5);
    hashTable2.put(14, 5);
    hashTable2.put(23, 1);
    hashTable2.put(3, 5); // Same hashCode as 23
    hashTable2.put(5, 6); // Load factor exceeds 80%

    if (hashTable2.size() != 4) {
      System.out.println("Error in test5 size(): Size does not match");
      System.out.println("Expected: 4, Actual: " + hashTable2.size());
      return false;
    }

    hashTable2.put(2, 8);
    hashTable2.put(8, 3);
    hashTable2.put(6, 6);
    hashTable2.put(26, 1);

    if (hashTable2.size() != 8) {
      System.out.println("Error in test5 size(): Size does not match");
      System.out.println("Expected: 8, Actual: " + hashTable2.size());
      return false;
    }

    hashTable2.clear();

    if (hashTable2.size() != 0) {
      System.out.println("Error in test5 clear()");
      System.out.println("Expected: 0, Actual: " + hashTable2.size());
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    System.out.println(test3());
    System.out.println(test4());
    System.out.println(test5());
  }

}
