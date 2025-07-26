public class ImaginaryNumberTester {
  public static void main(String[] args) {
    ImaginaryNumber num1 = new ImaginaryNumber();
    String p = num1.printNumber();
    System.out.println(p);
    System.out.println("1********");
    num1.realPart = 3;
    num1.imaginaryPart = 7;
    System.out.println(num1.printNumber());
    System.out.println("2********");
    ImaginaryNumber num2 = new ImaginaryNumber();
    num2.realPart = 1;
    num2.imaginaryPart = 9;
    System.out.println(num2.printNumber());
  }
}
