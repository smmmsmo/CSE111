import java.util.Arrays;
public class arrayMemory{
  public static void main(String [] args){
    int [] arr1 = {1,2,3,4,5};
    int [] arr2 = {10,20,30,40,50};
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println("====================");
    arr1 = arr2;
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println("====================");
    arr2[3] = 500;
    arr1[0] = 333;
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println("====================");
  }
}