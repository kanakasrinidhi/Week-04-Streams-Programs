import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    abstract String getRoleName();
}

class SoftwareEngineer extends JobRole {
    String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    String getRoleName() {
        return "Product Manager";
    }
}

class Resume<T extends JobRole> {
    private T candidateRole;

    Resume(T candidateRole) {
        this.candidateRole = candidateRole;
    }

    T getCandidateRole() {
        return candidateRole;
    }
}

class ResumeScreening {
    static void screenResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resume for: " + role.getRoleName());
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> jobRoles = new ArrayList<>();
        jobRoles.add(new SoftwareEngineer());
        jobRoles.add(new DataScientist());
        jobRoles.add(new ProductManager());

        ResumeScreening.screenResumes(jobRoles);
    }
}
