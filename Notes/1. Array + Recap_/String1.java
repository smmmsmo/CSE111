import java.util.Scanner;
public class String1{
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    String ans = "";
    for(int i = 0; i < input.length(); i++){
      char ch = input.charAt(i);
      int ascii = (int) ch;
      if(ascii >= 97 && ascii <= 122){
        int newAsc = ascii - 32;
        char upCh = (char) newAsc;
        ans = ans + upCh;
      }
      else{
        ans += ch;
      }
    }
    System.out.println(ans);
  }
}