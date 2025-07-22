public class Student {

    public String name;
    public String prog;

    public Student() {
        System.out.println("Default constructor called");
    }

    public Student(String name, String prog) {
        this.name = name;
        this.prog = prog;
    }

    public void updateProgram(String prog) {
        this.prog = prog;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public String accessProgram() {

        return this.prog;
    }

}