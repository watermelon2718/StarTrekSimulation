import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Enterprise extends Application {
    // private static final int CREW_NUMBER;

    public void start(Stage stage) throws Exception {
        EnterprisePane pane = new EnterprisePane();

        Scene scene = new Scene(pane, 500, 500, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("STARSHIP ENTERPRISE");
        stage.show();
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Starship Enterprise");
        System.out.println("Enter Y to start system: ");
        if (scan.nextLine().trim().toLowerCase().charAt(0) != 'y') { return; }
        EnterpriseCrewmember.createCrew();

        // System.out.println(EnterpriseCrewmember.getCrew());

        launch(args);
        

        
        // // CREW_NUMBER = 4;
        // String[] usernames = new String[4];
        // // usernames[0];
        // // usernames.length; // number of elements in array

        // for (String username : usernames) {
            
        // }


        // EnterpriseRoles role = EnterpriseRoles.CAPTAIN;

        // switch (role) {
        //     case CAPTAIN:
        //         break;
        //     case CMDR :
        //         break;
        //     case LT :
        //         break;
        //     case ENSIGN :
        //         break;
        //     default:
        //         break;
        // }

        //enter your last name
        //returns rank
        //enter password
        //stores passwords in array
        // login - requires username and password
        //Alert dialog if wrong
        // user logged in - some type of situation

    }

    public void assignCrew() {

    }


}

/* 
A hobbit lived there, in a hole in the ground
And the way that he lived was as nice as it sounds
The hole was not nasty or dirty or wet
The hole was as comfy as hobbit holes get

But adventure came calling, and the hole was left vacant
And when he returned people called him a vagrant
But whatever they say, he returned with much gold
Which he keeps in his tunnels - a great deal, I'm told

They say his adventure involved slaying a dragon
They tell of his journeys o'er great homebrewed flagons
And his nephew was like him, so everyone says
Just as strange yet as charming in a Bagginish way

They tell of how Frodo, and Merry, and Sam
And Peregrin Took, that unparalleled ham
Set out on adventures in the lands of the east
Of journeys and perils and slaying of beasts

But long ago Bilbo, and Frodo, and Sam
Passed into the West, in the way of all man
Their toils and struggles - they left in the past
To enter their rest with the Vala at last.

 */
