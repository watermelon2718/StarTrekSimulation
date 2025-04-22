import java.util.Arrays;
import java.util.Random;

public class EnterpriseCrewmember {
    private static int numCrewmembers;
    private static EnterpriseCrewmember[] crew;
    private static Random generator;
    private int chair, callsign;
    private String username, password, lastname;
    private EnterpriseRoles role;


    public static void createCrew() {
        crew = new EnterpriseCrewmember[4];
        EnterpriseCrewmember picard = new EnterpriseCrewmember("picard");
        EnterpriseCrewmember riker = new EnterpriseCrewmember("riker");
        EnterpriseCrewmember data = new EnterpriseCrewmember("data");
        EnterpriseCrewmember crusher = new EnterpriseCrewmember("crusher");

        crew[0] = picard;
        crew[1] = riker;
        crew[2] = data;
        crew[3] = crusher;

    }

    //call constructor w/ 
    public EnterpriseCrewmember(String lastname) {
        this.lastname = lastname;
        // Integer.parseInt(lastname);


        //you can't do this b/c comparing strings doesn't work
        // if (lastname.compareTo("picard") == 0) {

        // } else if (lastname.compareTo("riker") == 0) {

        // } else if (lastname.compareTo("data") == 0) {

        // } else if (lastname.compareTo("crusher") == 0) {

        // }

        String[] crewNames = {"picard", "riker", "data", "crusher"};
        int rankID = 42;

        for (int i = 0; i < crewNames.length ; i++) {
            if (lastname.compareTo(crewNames[i]) == 0) {
                rankID = i;
            }
        }

        switch (rankID) {
            case 0:
                this.role = EnterpriseRoles.CAPTAIN;
                break;
            case 1:
                this.role = EnterpriseRoles.CMDR;
                break;
            case 2 :
                this.role = EnterpriseRoles.LT;
            case 3:
                this.role = EnterpriseRoles.DOCTOR;
            default:
                this.role = EnterpriseRoles.ENSIGN;
                break;
        }

        // this.callsign = generator.nextInt(40);

        //TODO: add to array at correct index
        // crew[this.role.getRank(role)] = this;
        // crew[this.role.getRank(role)] = this;
        
        numCrewmembers++;

    }
    public static EnterpriseCrewmember[] getCrew() {
        return Arrays.copyOf(crew, crew.length);
    }

    public static void assignChair() {
        for (int i = 0; i < crew.length; i++) {
            crew[i].chair = i; 
        }
    }

    //from textbox we get last names
    
    public static void assignCrewMembers(String lastname) {
        crew = new EnterpriseCrewmember[numCrewmembers];

        for (int i = 0; i < crew.length; i++) { 

        }
    }

    public String getLastName() {
        return lastname;
    }

    public EnterpriseRoles getRole() {
        return role;
    }

    public int getCallSign() {
        return callsign;
    }

    // public String toString(){

    // }

    //     crewNames = new String[numCrewmembers];

    //     for (int i = 0 ; i < crewNames.length; i++) {
    //         crewNames[i] = lastname;
            
    //     }
    // }
    

}
