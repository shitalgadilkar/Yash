public class Student {
    private int rollNo;
    private String studentFirstName;
    private String studentLastName;
    private int age;

    public Student(int rollNo, String studentFirstName, String studentLastName, int age) {
        this.rollNo = rollNo;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(rollNo + ",").append(studentFirstName).append(" ").append(studentLastName)
                .append(","+age + "").append("]");

        return builder.toString();
    }
    
    @Override
    public boolean equals(Object obj) 
    {
        if(obj != null && obj instanceof Student )
        {
            Student student = (Student)obj;
            if (age != student.age)
                return false;
            if (rollNo != student.rollNo)
                return false;
            if (studentFirstName == null) {
                if (student.studentFirstName != null)
                    return false;
            } else if (!studentFirstName.equals(student.studentFirstName))
                return false;
            if (studentLastName == null) {
                if (student.studentLastName != null)
                    return false;
            } else if (!studentLastName.equals(student.studentLastName))
                return false;
            return true;
        }
        else{
            return false;
        }
        
    }

    @Override
    public int hashCode() {
        return rollNo
        ^studentFirstName.hashCode()
        ^studentLastName.hashCode()
        ^age;
    }

    public static void main(String[] args) {
        Student s1 = new Student(1001, "Kinshuk", "Jain", 22);
        Student s2 = new Student(1001, "Jain", "Kinshuk", 22);
        Student s3 = new Student(1002, "Praveen", "Jain", 25);
        Student s4 = new Student(1002, "Praveen", "Jain", 25);

        System.out.println("Student 1 : "+s1);
        System.out.println("Student 2 : "+s2);
        System.out.println("Student 3 : "+s3);
        System.out.println("Student 4 : "+s4);
        
        System.out.println("S1 equal S2 : "+s1.equals(s2));
        System.out.println("S1 equal S3 : "+s1.equals(s3));
        System.out.println("S3 equal S4 : "+s3.equals(s4));

        System.out.println("S1 hashcode : "+s1.hashCode());
        System.out.println("S2 hashcode : "+s2.hashCode());
        System.out.println("S3 hashcode : "+s3.hashCode());
        System.out.println("S4 hashcode : "+s4.hashCode());
        
    }

   

    
}