import java.util.Scanner;
import java.util.Arrays;
public class arrayCreation{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int [] arr = new int[size];
    for(int i = 0; i < arr.length; i++){
      arr[i] = sc.nextInt();
    }
//    System.out.println(arr);
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i]+ ", ");
    }
//    System.out.println(Arrays.toString(arr));
  }
}