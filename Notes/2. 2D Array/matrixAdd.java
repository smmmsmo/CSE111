import java.util.Arrays;
public class matrixAdd{
  public static void main(String [] args){
    int [][] m1 = {{1,2,3},{4,5,6},{7,8,9}};
    int [][] m2 = {{11,12,13},{14,15,16},{17,18,19}};
    if(m1.length == m2.length && m1[0].length == m2[0].length){
      int [][] sum = new int[m1.length][m1[0].length];
      for(int i = 0; i < m1.length; i++){
        for(int j = 0; j < m1[i].length; j++){
          sum[i][j] = m1[i][j] + m2[i][j];
        }
      }
      for(int i = 0; i < sum.length; i++){
        System.out.println(Arrays.toString(sum[i]));
      }
    }
    else{
      System.out.println("Dimensions are different");
    }
  }
}

//To-do: matrix multiplication
