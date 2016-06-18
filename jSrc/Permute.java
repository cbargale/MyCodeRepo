class Permute{

public static void Combinations(String sample, int startIndex){
   int len = sample.length();
   char[] input = sample.toCharArray();
   int index = startIndex; 
   
   while (index < len){
   
     char tmp = input[startIndex];
     input[startIndex] = input[index];
     input[index] = tmp;
     String sample1 = new String(input);
     Combinations(sample1, startIndex+1);
     // tmp = input[startIndex];
     // input[startIndex] = input[index];
     // input[index] = tmp;     
     index++;
   }

   if (startIndex == len){
      System.out.println(input);
   }
 } 

 public static void main(String args[]){
 
    String s = new String(args[0]);

    Combinations(s,0);
    
  }
}
