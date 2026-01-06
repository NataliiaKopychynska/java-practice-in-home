package student;

public class Student {
    public String name;
    public int[] marks;

    public Student(int[] marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    public int avg(){
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        System.out.println(sum/marks.length);
        return sum/marks.length;
    }
}
