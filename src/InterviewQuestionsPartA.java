import java.util.List;

public class InterviewQuestionsPartA {

    public static void main(String[] args) {
        List<Student> students = Student.loadRecords("src/students.csv");
        List<Patient> patients = Patient.loadRecords("src/patients.csv");
        List<Crime> crimes = Crime.loadRecords("src/Crime.csv");

        //  let's do some quick data analysis on the crimes database.
        //  Let's compare two Boroughs to see which one has the most crime
        int borough1Crimes = 0, borough2Crimes = 0;
        String borough1, borough2;
        borough1 = Utils.getInput("1st Borough: ");
        borough2 = Utils.getInput("2nd Borough: ");

        for (Crime crime : crimes) {
            if (crime.getBorough().equalsIgnoreCase(borough1)) borough1Crimes++;
            if (crime.getBorough().equalsIgnoreCase(borough2)) borough2Crimes++;
        }
        if (borough1Crimes > borough2Crimes) {
            System.out.format("%s has more crimes (%d) than %s (%d)\n", borough1, borough1Crimes, borough2, borough2Crimes);
        } else {
            System.out.format("%s has more crimes (%d) than %s (%d)\n", borough2, borough2Crimes, borough1, borough1Crimes);
        }

        //  now move on to the patients data
        //  What is the BMI results for our patients?
        //  let's only print out the normal ones
        for (Patient patient : patients) {
            String bmiMessage = bodyMassIndex(patient.getHeigth(), patient.getWeight());
            if (bmiMessage.startsWith("Normal"))
                System.out.format("%s %s is %s%n", patient.getFirstName(), patient.getLastName(), bmiMessage);
        }

        //  We certainly do not need to do another for loop for the patients
        //  but I want to keep the examples simple
        Patient oldest = patients.get(0);        // Get the first patient to use as our target
        for (Patient patient : patients) {
            if (patient.getAge() > oldest.getAge())
                oldest = patient;
        }
        System.out.format("%nThe oldest patient is %s %s and they are %d years old%n", oldest.getFirstName(), oldest.getLastName(), oldest.getAge());

        //  finally a tour of the student records
        //  which student has the highest GPA
        Student best;
        best = students.get(0);         //  Get first student as our target student
        for (Student student : students) {
            if (best.getGpa() < student.getGpa())
                best = student;
        }
        System.out.format("%n%s has the highest %f%n", best.getName(), best.getGpa());
    }

    public static String bodyMassIndex(float height, float weight) {
        String msg;
        float bmi = (weight / (height * height)) * 703;
        if (bmi < 18.5) msg = "Underweight - BMI = " + bmi;
        else if (bmi >= 18.5 && bmi < 25) msg = "Normal - BMI = " + bmi;
        else if (bmi >= 25 && bmi < 30) msg = "Overweight - BMI = " + bmi;
        else msg = "Obese - BMI = " + bmi;
        return msg;
    }

    /**
     * getInitials
     *
     * @param name the person's name
     * @return The initials for the name entered
     */
    public static String getInitials(String name) {
        String[] names = name.split(" ");
        String initials = "";

        for (String s : names) {
            initials += s.charAt(0);
        }
        return initials.toUpperCase();
    }

    /**
     * drawBox
     * Given the size of a square print a square with that width and height
     *
     * @param size
     */
    public static void drawBox(int size) {
        for (int i = 0; i < size; i++) {    //  top row of the box
            System.out.print("* ");         //  *******************
        }
        System.out.println();               //  kick out a new line

        for (int r = 0; r < size - 2; r++) {  //  We need to print out size-2 middle rows
            System.out.print("* ");              //  print the left border
            for (int i = 0; i < size - 2; i++) {  //  >                 <
                System.out.print("  ");          //  print out the spaces in between
            }
            System.out.println("*");            //  print the right border
        }

        for (int i = 0; i < size; i++) {    //  this is the bottom row of the box
            System.out.print("* ");         //  *******************
        }
    }

    /**
     * printTree
     * Given the height of a tree print a tree
     *
     * @param height
     */
    public static void printTree(int height) {
        for (int row = 1; row <= height; row++) {
            //   print spaces to pad to the left of the tre
            //  limb 1 print height - 1 spaces
            //  limb 2 print height - 2 spaces
            for (int spaces = 0; spaces < height - row; spaces++) {
                System.out.print(" ");
            }

            //  print *s to create the tree
            for (int stars = 0; stars < row * 2 - 1; stars++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
