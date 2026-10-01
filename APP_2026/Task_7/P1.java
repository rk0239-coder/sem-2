class CollegeStudent {

    private int studentId;
    private String name;
    private String department;
    private int year;

    public CollegeStudent(int studentId, String name, String department, int year) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.year = year;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public void displayStudentInfo() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Name         : " + name);
        System.out.println("Department   : " + department);
        System.out.println("Year         : " + year);
    }
}

class CollegeCourse {

    private int courseId;
    private String courseName;
    private int credits;
    private String duration;

    public CollegeCourse(int courseId, String courseName, int credits, String duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.duration = duration;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public String getDuration() {
        return duration;
    }

    public void displayCourseInfo() {
        System.out.println("Course ID    : " + courseId);
        System.out.println("Course Name  : " + courseName);
        System.out.println("Credits      : " + credits);
        System.out.println("Duration     : " + duration);
    }
}

public class P1 {
    public static void main(String[] args) {
        CollegeStudent student1 = new CollegeStudent(101, "Ananya Verma", "Computer Science", 2);
        CollegeCourse course1 = new CollegeCourse(501, "Data Structures & Algorithms", 4, "1 Semester");

        System.out.println("=== Student Information ===");
        student1.displayStudentInfo();

        System.out.println();

        System.out.println("=== Course Information ===");
        course1.displayCourseInfo();
    }
}
