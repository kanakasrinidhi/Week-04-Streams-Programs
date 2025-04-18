import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String title;
    String department;

    CourseType(String title, String department) {
        this.title = title;
        this.department = department;
    }

    abstract void showDetails();
}

class ExamCourse extends CourseType {
    int examWeightage;

    ExamCourse(String title, String department, int examWeightage) {
        super(title, department);
        this.examWeightage = examWeightage;
    }

    void showDetails() {
        System.out.println("Exam Course: " + title + ", Department: " + department + ", Exam Weightage: " + examWeightage + "%");
    }
}

class AssignmentCourse extends CourseType {
    int numberOfAssignments;

    AssignmentCourse(String title, String department, int numberOfAssignments) {
        super(title, department);
        this.numberOfAssignments = numberOfAssignments;
    }

    void showDetails() {
        System.out.println("Assignment Course: " + title + ", Department: " + department + ", Assignments: " + numberOfAssignments);
    }
}

class ResearchCourse extends CourseType {
    String researchTopic;

    ResearchCourse(String title, String department, String researchTopic) {
        super(title, department);
        this.researchTopic = researchTopic;
    }

    void showDetails() {
        System.out.println("Research Course: " + title + ", Department: " + department + ", Topic: " + researchTopic);
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    void addCourse(T course) {
        courseList.add(course);
    }

    List<T> getCourses() {
        return courseList;
    }
}

class CourseUtils {
    static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            c.showDetails();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        Course<AssignmentCourse> assignmentCourses = new Course<>();
        Course<ResearchCourse> researchCourses = new Course<>();

        ExamCourse ec = new ExamCourse("Data Structures", "CS", 70);
        AssignmentCourse ac = new AssignmentCourse("Software Engineering", "IT", 5);
        ResearchCourse rc = new ResearchCourse("AI and Ethics", "AI", "Machine Learning Bias");

        examCourses.addCourse(ec);
        assignmentCourses.addCourse(ac);
        researchCourses.addCourse(rc);

        System.out.println("All Courses:");
        CourseUtils.displayCourses(examCourses.getCourses());
        CourseUtils.displayCourses(assignmentCourses.getCourses());
        CourseUtils.displayCourses(researchCourses.getCourses());
    }
}

