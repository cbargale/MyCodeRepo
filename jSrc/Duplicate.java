import java.util.HashMap;

public class Duplicate
{
  public static void main(String[] args) {
       
    String s = new String(args[0]);
    System.out.println("input string is = " + s);

    HashMap<Character, Integer> chartable = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if (chartable.containsKey(c)) {
        chartable.put(c,  chartable.get(c) + 1);
      }
      else {
        chartable.put(c, 1);
      }
    }
   
    boolean found = false;
    for (int i = 0; i < s.length(); i++){ 
      char c = s.charAt(i); 
      if (chartable.get(c) == 1){
        System.out.println("first non repeat char = " + c);
        found = true;
        break;
      }
    } 
    
    if (!found)
      System.out.println("no non duplicate found");
  }
}
