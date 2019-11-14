import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *      DO NOT CHANGE THIS CODE
 *      LEAVE IT ALONE
 */
public class Student {
    private int entry;
    private String name;
    private String homeState;
    private String yearInSchool;
    private int scholarship;
    private String major;
    private String minor;
    private float gpa;

    public int getEntry() {
        return entry;
    }
    public void setEntry(int entry) {
        this.entry = entry;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHomeState() {
        return homeState;
    }
    public void setHomeState(String homeState) {
        this.homeState = homeState;
    }
    public String getYearInSchool() {
        return yearInSchool;
    }
    public void setYearInSchool(String yearInSchool) {
        this.yearInSchool = yearInSchool;
    }
    public int getScholarship() {
        return scholarship;
    }
    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public String getMinor() {
        return minor;
    }
    public void setMinor(String minor) {
        this.minor = minor;
    }
    public float getGpa() {
        return gpa;
    }
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "entry=" + entry +
                ", name='" + name + '\'' +
                ", homeState='" + homeState + '\'' +
                ", yearInSchool='" + yearInSchool + '\'' +
                ", scholarship=" + scholarship +
                ", major='" + major + '\'' +
                ", minor='" + minor + '\'' +
                ", gpa=" + gpa +
                '}';
    }

    public Student(int entry, String name, String homeState, String yearInSchool, int scholarship, String major, String minor) {
        this.entry = entry;
        this.name = name;
        this.homeState = homeState;
        this.yearInSchool = yearInSchool;
        this.scholarship = scholarship;
        this.major = major;
        this.minor = minor;
        this.gpa = (int)(Math.random()*5);
    }


    /**
     * loadRecords
     *
     * @param fileName use this file to read in the students to be added to our students list
     */
    public static List<Student> loadRecords(String fileName) {

        List<Student> students = new ArrayList<>();

        // Read in the students.csv file
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // consume the header line
            br.readLine();
            // Read each line of the file and create a Student object for that line
            while ((line = br.readLine()) != null) {
                String[] aLine = line.split(",");
                // The student object has the following fields
                //    							Entry,					Name,		homeState,		Year,	Scholarship,	Major,			Minor
                //			public Student(int entry, 			String name, String homeState, String year, int scholarship, String major, String minor) {

                Student student = new Student(Integer.parseInt(aLine[0]), aLine[1], aLine[2], aLine[3], Integer.parseInt(aLine[4]), aLine[5], aLine[6]);
                students.add(student);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        }
        return students;
    }
}
