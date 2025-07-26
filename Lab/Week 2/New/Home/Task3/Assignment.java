public class Assignment {

    public int tasks = 0;
    public String difficulty = "null";
    public boolean submission = false;

    public void printDetails() {
        System.out.println("Number of tasks: " + tasks);
        System.out.println("Difficulty level: " + difficulty);
        System.out.println("Submission required : " + submission);
    }

    public String makeOptional() {
        if (submission) {
            return "Assignment will not require submission.";
        } else {
            return "Submission is already not required.";
        }
    }

}
