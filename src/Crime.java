import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *      DO NOT CHANGE THIS CODE
 *      LEAVE IT ALONE
 */
public class Crime {
    private String complaint;
    private String offenseDescription;
    private String description;
    private String attempted;
    private String categoryCode;
    private String borough;
    private String location;
    private String premiseType;

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getOffenseDescription() {
        return offenseDescription;
    }

    public void setOffenseDescription(String offenseDescription) {
        this.offenseDescription = offenseDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttempted() {
        return attempted;
    }

    public void setAttempted(String attempted) {
        this.attempted = attempted;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPremiseType() {
        return premiseType;
    }

    public void setPremiseType(String premiseType) {
        this.premiseType = premiseType;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "complaint='" + complaint + '\'' +
                ", offenseDescription='" + offenseDescription + '\'' +
                ", description='" + description + '\'' +
                ", attempted='" + attempted + '\'' +
                ", categoryCode='" + categoryCode + '\'' +
                ", borough='" + borough + '\'' +
                ", location='" + location + '\'' +
                ", premiseType='" + premiseType + '\'' +
                '}';
    }

    public Crime(String complaint, String offenseDescription, String description, String attempted, String categoryCode, String borough, String location, String premiseType) {
        this.complaint = complaint;
        this.offenseDescription = offenseDescription;
        this.description = description;
        this.attempted = attempted;
        this.categoryCode = categoryCode;
        this.borough = borough;
        this.location = location;
        this.premiseType = premiseType;
    }

    /**
     * loadRecords
     *
     * @param fileName use this file to read in the students to be added to our students list
     */
    public static List<Crime> loadRecords(String fileName) {

        List<Crime> crimes = new ArrayList<>();

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
                //    					Complaint, OffenseDescription, Description, Attempted, CategoryCode, Borough, Location, PremiseType
                Crime crime = new Crime(aLine[0], aLine[1], aLine[2], aLine[3], aLine[4], aLine[5], aLine[6], aLine[6]);
                crimes.add(crime);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        }
        return crimes;
    }
}
