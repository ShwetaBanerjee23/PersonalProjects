public class Student {
    private final String studentId;
    private final String studentName;
    private final String course;
    private final String instituition;
    private final AttendanceRecord attendanceRecord;

    public Student(String studentId,
                    String studentName,
                    String course, 
                    String instituition,
                    AttendanceRecord attendanceRecord) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.instituition = instituition;
        this.attendanceRecord = attendanceRecord;
    }

    /* Mark the student as present for the specified 
       session in the associated attendance record. */
    public void markAsPresent(Session session) {
        attendanceRecord.addStudentPresent(this, session);
    }

    @Override
    public String toString() {
        return studentName 
                + " (" 
                + studentId 
                + "): " 
                + course + ", " 
                + instituition 
                + ".";
    }
}
