import java.util.ArrayList;
import java.util.List;

public class AttendanceRecord {
    /* Store all the possible sessions. */
    private List<DayRecord> allSessions;

    public AttendanceRecord() {
        allSessions = new ArrayList<>();
        for (Session s : Session.values()) {
            allSessions.add(new DayRecord(s));
        }
    }

    /* Mark a student as present by adding them to the 
       list of students present for a specified session. */
    public void addStudentPresent(Student student, Session session) {
        for (DayRecord d : allSessions) {
            if (d.isSession(session)) {
                d.addStudentPresent(student);
            }
        }
    }

    /* Identify all the students present for a specified 
       session.*/
    public List<Student> studentsPresent(Session session) {
        for (DayRecord d : allSessions) {
            if (d.isSession(session)) {
                return d.getStudentsPresent();
            }
        }
        return null;
    }

    /* Identify all the sessions when a student has been 
       present. */
    public List<DayRecord> daysPresent(Student student) {
        List<DayRecord> days = new ArrayList<>();

        for (DayRecord d : allSessions) {
            if (d.getStudentsPresent().contains(student)) {
                days.add(d);
            }
        }

        return days;
    }
}
