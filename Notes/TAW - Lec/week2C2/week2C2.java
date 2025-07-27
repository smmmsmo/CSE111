import java.util.*;
public class week2C2
{
  public static void main(String [] args)
  {
    int [][] arr2D1 = {{1,2,3}, {4,5,6}};
    int [][] arr2D2 = {{7,8}, {9,10}, {11,12}};
    int rowA = arr2D1.length;    //M
    int colA = arr2D1[0].length;
    int rowB = arr2D2.length;
    int colB = arr2D2[0].length;  // P
    int [][] multArr = new int[rowA][colB];
    
    for(int m=0;m<rowA;m++){
      for(int p=0;p<colB;p++){
        for(int n=0;n<colA;n++){
          multArr[m][p] += arr2D1[m][n] * arr2D2[n][p];
        }
      }
    } 
    
    
    
//    int [][] arr2D1 = {{1,2,3}, {4,5,6}, {7,8,9}}; 
//    int [][] arr2D2 = {{11,12,13}, {14,15,16}, {17,18,19}};
//    int row = arr2D2.length;
//    int col = arr2D1[0].length;
//    int [][] new2D = new int[row][col];
//    for(int r=0;r<row;r++){
//      for(int c=0;c<col;c++){
//        new2D[r][c] = arr2D1[r][c] + arr2D2[r][c];
//      }
//    }
    
    
    
    
    
    
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Enter row number");
//    int row = sc.nextInt();
//    System.out.println("Enter col number");
//    int col = sc.nextInt();
//    int [][] arr2D = new int[row][col];
//    for(int r=0;r<row;r++){
//      for(int c=0;c<col;c++){
//        arr2D[r][c] = sc.nextInt();
//      }
//    }
    
    
    
    
    
//    int [][] arr2D = {{1,2,3}, {4,5,6}, {7,8,9}}; 
//    int row = arr2D.length;   //ROW number ber kore
//    int col = arr2D[1].length;   //COLUMN number ber kore
    for(int r=0;r<row;r++){         //2D array print kore
      for(int c=0;c<col;c++){
        System.out.print(new2D[r][c]+" ");
      }
      System.out.println();
    }
    
    
    
    
    
    
//    arr2D[2][0] = 77;
//    System.out.println(arr2D[1][0]);
//    System.out.println(arr2D[2][1]);
    
    
    
    
    
    
//    System.out.println(Arrays.toString(arr2D[0]));
//    System.out.println(Arrays.toString(arr2D[1]));
//    System.out.println(Arrays.toString(arr2D[2]));
//    System.out.println(arr2D[0]);
//    System.out.println(arr2D[1]);
//    System.out.println(arr2D[2]);
//    System.out.println(Arrays.toString(arr2D));
  }
}