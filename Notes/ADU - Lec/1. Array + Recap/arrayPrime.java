import java.util.Arrays;
public class arrayPrime{
  public static void main(String [] args){
    int [] arr = {4,10,15,20,1};
//    int primeCount = 0;
    boolean primeCheck = false;
    for(int i = 0; i < arr.length; i++){
      int divCount = 0;
      for(int j = 1; j <= arr[i]; j++){
        if(arr[i] % j == 0){
          divCount++;
        }
      }
      if(divCount == 2){
//        primeCount++;
        primeCheck = true;
        System.out.println(arr[i]);
      }
    }
//    if(primeCount == 0){
    if(primeCheck == false){
      System.out.println("No prime numbers");
    }
  }
}
      
      
      