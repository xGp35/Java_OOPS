class Student {
    static int totalStudents = 0;

    String name;
    int rollNo;
    double gpa;

    Student(String name, int rollNo, double gpa) {
        this.name = name;
        this.rollNo = rollNo;
        this.gpa = gpa;
        totalStudents++;
    }
}
class StudentTestDrive {
    public static void main(String[] args) {
        Student s1 = new Student("Alice", 1, 8.5);
        Student s2 = new Student("Bob", 2, 9.1);
        Student s3 = new Student("Charlie", 3, 8.8);
    }
}
