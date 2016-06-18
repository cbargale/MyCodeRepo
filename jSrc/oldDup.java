public class oldDup
{
  public static void main(String[] args) {
    
    String s = new String(args[0]);
    boolean AllDuplicates = true;
    for (int i = 0; i < s.length(); i++) {
      boolean found = false;
      for (int j = 0; j < s.length(); j++) {
        if (i == j) continue;
        if (s.charAt(i) == s.charAt(j)) {
          found = true;
          break;
        }
      }
      if (!found){
        System.out.println("first non repeat char is =" + s.charAt(i));
        AllDuplicates = false;
        break;
      }
    }
    
    if (AllDuplicates) 
      System.out.println("All characters are duplicate");
  }
}
