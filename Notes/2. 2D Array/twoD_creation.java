import java.util.Arrays;
import java.util.Scanner;
public class twoD_creation{
  public static void main(String [] args){
    int [][] twoD = {
      {1,2,3,10},
      {4,5,6,11},
      {7,8,9,12, 13}
    };
//    for(int i = 0; i < twoD.length; i++){ //row number
//      for(int j = 0; j < twoD[i].length; j++){ //col number
//        System.out.print(twoD[i][j] + " ");
//      }
//      System.out.println();
//    }
//    System.out.println(twoD);
//    System.out.println(Arrays.toString(twoD));
//    System.out.println(twoD[0]);
//    System.out.println(twoD[2][0]);
//    System.out.println(Arrays.toString(twoD[1]));
//    System.out.println(twoD.length);  //rows
//    System.out.println(twoD[0].length);  //columns
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();
    int [][] a2d = new int[row][col];
    for(int i = 0; i < a2d.length; i++){
      for(int j = 0; j < a2d[i].length; j++){
        a2d[i][j] = sc.nextInt();
      }
    }
    for(int i = 0; i < row; i++){
      System.out.println(Arrays.toString(a2d[i]));
    }
  }
}