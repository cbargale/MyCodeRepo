import java.util.*;

class HistArea{

  public static int CalcMax(int[] histogram){

     Stack<Integer> st = new Stack<Integer>();
     int i = 0;
     int max = 0;
     int area = 0;

     while (i< histogram.length){

       System.out.println("first while loop i=" + i);

       if (st.isEmpty() || histogram[i] >= histogram[st.peek()]){
          st.push(i);
          i++;
       }
       else{
          int top = st.pop();
          int height = histogram[top];
          int width = st.isEmpty() ? i: i - st.peek() - 1;
          area = height * width;
          if (max < area){
             max = area;
          }          
       }
     }
     
     while (!st.isEmpty()){
       int p = st.pop();
       int height = histogram[p];
       int width = st.isEmpty()? i : i - st.peek() - 1; 
       area = height * width;
       System.out.println("second while loop i=" + i + "p= "+ p + " height = " + height + " width = " + width + " area = " + area + " max= " + max);
       if (max < area){
         max = area;
       }
     }
  
     return max;
  } 

  public static void main(String args[]){
  
    if (args.length == 0){
      System.out.println("Please enter valid histogram values");
      return;
    }

    int[] input = new int[args.length];
    for (int i = 0; i < args.length; i++){
      input[i] = Integer.valueOf(args[i]);
    }

    int value = CalcMax(input);
    System.out.println("max area = " + value);

  }

}

