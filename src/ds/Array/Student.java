package ds.Array;

public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student (name : %s , score : %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> sList = new Array<>();
        sList.addLast(new Student("test1", 1));
        sList.addLast(new Student("test2", 2));
        sList.addLast(new Student("test3", 3));
        System.out.println(sList);
    }
}
