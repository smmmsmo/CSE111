public class ComplexNumberTester {
    public static void main(String[] args) {
        ComplexNumber cn1 = new ComplexNumber();
        System.out.println(cn1);
        System.out.println("----------------");
        ComplexNumber cn2 = new ComplexNumber(5.0, 7.0);
        System.out.println(cn2);
    }
}

class RealNumber {
    public double realValue;
    public RealNumber() {
        this(0.0);
    }
    public RealNumber(double realValue) {
        this.realValue = realValue;
    }
    public String toString(){
        return "RealPart: " + realValue;
    }
}

class ComplexNumber extends RealNumber {
    public double imaginaryValue;
    public ComplexNumber() {
    this(1.0, 1.0);
    }
    public ComplexNumber(double realValue, double imaginaryValue) {
        super(realValue);
        this.imaginaryValue = imaginaryValue;
    }
    public String toString(){
        return super.toString() + "\nImaginaryPart: " + imaginaryValue;
    }
}


//output 

// RealPart: 1.0
// ImaginaryPart: 1.0
// ----------------
// RealPart: 5.0
// ImaginaryPart: 7.0
