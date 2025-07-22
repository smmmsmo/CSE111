public class Teacher {
    public String name;
    public String initial;
    public String[] courses;
    public int index = 0;

    public Teacher(String name, String initial, int courseCapacity) {
        this.name = name;
        this.initial = initial;
        this.courses = new String[courseCapacity];
        System.out.println("A new teacher has been created");
    }

    public void addCourse(String course) {
        if (index < courses.length) {
            courses[index] = course;
            index++;
        } else {
            System.out.println("Cannot add more courses");
        }
    }

    public void printDetail() {
        System.out.println("Name: " + this.name);
        System.out.println("Initial: " + this.initial);
        for (int i = 0; i < index; i++) {
            System.out.println(courses[i]);
        }
    }
}






















