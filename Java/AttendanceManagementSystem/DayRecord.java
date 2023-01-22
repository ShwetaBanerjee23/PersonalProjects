import java.util.List;
import java.util.ArrayList;

public class DayRecord {
    /* Store which session this record represents. */
    private final Session session;
    /* Store all the students who were present for 
       this session. */
    private List<Student> studentsPresent;

    public DayRecord(Session session) {
        this.session = session;
        this.studentsPresent = new ArrayList<>();
    }

    /* Add a student who was present for this session. */
    public void addStudentPresent(Student student) {
        studentsPresent.add(student);
    }

    /* Check if this record represents the given session. */
    public boolean isSession(Session s) {
        return session == s;
    }

    /* Return a list of all students who were present for 
       this session. */
    public List<Student> getStudentsPresent() {
        return studentsPresent;
    }

    @Override
    public String toString() {
        return session.toString();
    }
}
