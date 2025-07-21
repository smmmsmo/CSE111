public class StudentTester {
    public static void main(String[] args) {
        Student s1 = new Student("Harry", "CSE");
        System.out.println(s1.name);
        s1.updateName("Harry Potter");
        System.out.println(s1.name);
        System.out.println(s1.prog);
        s1.updateProgram("CS");
        String var = s1.accessProgram();
        System.out.println(var);
    }
}
