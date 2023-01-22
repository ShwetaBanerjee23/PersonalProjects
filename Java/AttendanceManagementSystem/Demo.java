public class Demo {
    public static void main(String[] args) {
        /* Create a new attendance record. */
        AttendanceRecord ar = new AttendanceRecord();

        /* Create a few students. */
        Student s0 = new Student("#001", 
                                    "Student A", 
                                    "MBA", 
                                    "Stanford University",
                                    ar);
        Student s1 = new Student("#002", 
                                    "Student B", 
                                    "Engineering", 
                                    "MIT",
                                    ar);
        Student s2 = new Student("#003", 
                                    "Student C", 
                                    "Computer Science", 
                                    "Imperial College London",
                                    ar);
        Student s3 = new Student("#004", 
                                    "Student D", 
                                    "Engineering", 
                                    "Harvard University",
                                    ar);
        Student s4 = new Student("#005", 
                                    "Student E",
                                    "Aeronautical Engineering", 
                                    "California Institute of Technology",
                                    ar);

        /* Add attendance data. */
        s0.markAsPresent(Session.MONDAY_AM);
        s0.markAsPresent(Session.TUESDAY_AM);
        s0.markAsPresent(Session.WEDNESDAY_AM);
        s0.markAsPresent(Session.THURSDAY_AM);
        s0.markAsPresent(Session.FRIDAY_AM);

        s1.markAsPresent(Session.MONDAY_PM);
        s1.markAsPresent(Session.TUESDAY_AM);
        s1.markAsPresent(Session.TUESDAY_PM);
        s1.markAsPresent(Session.WEDNESDAY_AM);
        s1.markAsPresent(Session.THURSDAY_AM);
        s1.markAsPresent(Session.THURSDAY_PM);
        s1.markAsPresent(Session.FRIDAY_AM);

        s2.markAsPresent(Session.MONDAY_AM);
        s2.markAsPresent(Session.MONDAY_PM);
        s2.markAsPresent(Session.TUESDAY_AM);
        s2.markAsPresent(Session.TUESDAY_PM);
        s2.markAsPresent(Session.WEDNESDAY_AM);
        s2.markAsPresent(Session.WEDNESDAY_PM);
        s2.markAsPresent(Session.THURSDAY_AM);
        s2.markAsPresent(Session.THURSDAY_PM);
        s2.markAsPresent(Session.FRIDAY_AM);
        s2.markAsPresent(Session.FRIDAY_PM);

        s3.markAsPresent(Session.MONDAY_AM);
        s3.markAsPresent(Session.MONDAY_PM);
        s3.markAsPresent(Session.WEDNESDAY_AM);
        s3.markAsPresent(Session.WEDNESDAY_PM);
        s3.markAsPresent(Session.FRIDAY_AM);
        s3.markAsPresent(Session.FRIDAY_PM);

        s4.markAsPresent(Session.TUESDAY_AM);
        s4.markAsPresent(Session.TUESDAY_PM);
        s4.markAsPresent(Session.THURSDAY_AM);
        s4.markAsPresent(Session.THURSDAY_PM);

        /* Check information has been stored correctly. */
        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        
        System.out.println("Student 0 was present on the following days: ");
        System.out.println(ar.daysPresent(s0));

        System.out.println("Student 1 was present on the following days: ");
        System.out.println(ar.daysPresent(s1));

        System.out.println("Student 2 was present on the following days: ");
        System.out.println(ar.daysPresent(s2));

        System.out.println("Student 3 was present on the following days: ");
        System.out.println(ar.daysPresent(s3));

        System.out.println("Student 4 was present on the following days: ");
        System.out.println(ar.daysPresent(s4));
    }
}
