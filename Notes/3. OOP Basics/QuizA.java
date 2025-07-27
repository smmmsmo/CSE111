class examClass {
    public int ques;
    public int sum;
    public void methodA() {
        System.out.println(ques + " " + 0 + " " + 0);
    }
}
class QuizA {
    public int x, y;
    public int sum = 1;
    public QuizA(int x, int y) {
        this.x = y;
        this.y = x;
    }
    public void methodA() {
        int x = 3;
        y = this.y + x;
        examClass exam = new examClass();
        exam.sum = x;
        exam.ques = this.y;
        x = this.x + x + exam.sum;
        this.y = this.sum + methodB(exam.ques, exam);
        System.out.println(x + " " + this.y + " " + sum);
        sum = x % 2 + this.x;
        y = x + y + exam.sum;
        System.out.println(x + " " + y + " " + sum);
    }
    public int methodB(int x1, examClass x2) {
        int y = 0;
        y = this.y + x2.sum;
        x2.ques = x1 + x2.ques;
        sum = sum + x + y;
        System.out.println(this.x + " " + this.y + " " + sum);
        return x2.sum;
    }
}

