import java.lang.StackWalker.Option;
import java.util.Optional;

import javax.swing.Action;

import javafx.beans.value.WeakChangeListener;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EnterprisePane extends StackPane {
    private TextField lastname, redAlertTextField;
    private Text welcome;
    private String lastnameEntered;
    private ImageView imageView;
    private Button poweroff, help, redAlert;
    private Button redAlertPods, redAlertSelfDestruct, redAlertCancel;
    private VBox elements, redalertBox;
    private EnterpriseCrewmember member;
    private EnterpriseDesktop desktop;

    public EnterprisePane() {
        elements = new VBox();

        Text header = new Text("Enter your last name: ");
        FontPosture posture = FontPosture.REGULAR;
        FontWeight weight = FontWeight.BOLD;
        header.setStroke(javafx.scene.paint.Color.WHITE);
        header.setFont(Font.font("Lucida Console", weight, posture, 20));

        lastname = new TextField();
        lastname.setOnAction(this:: processEnter);

        
        //Control Buttons
        HBox controls = new HBox();
        controls.setSpacing(20);

        poweroff = new Button("Power Off");
        poweroff.setOnAction(this::processButtonPress);

        help = new Button ("Help");
        Tooltip helpTip = new Tooltip("no help for you lol");
        help.setTooltip(helpTip);
        help.setOnAction(this::processButtonPress);

        redAlert = new Button("RED ALERT");
        redAlert.setOnAction(this::processButtonPress);

        controls.getChildren().addAll(poweroff, help, redAlert);

        Image image = new Image("Enterprise_Forward.jpg");
        imageView = new ImageView(image);

        elements.getChildren().addAll(imageView, header, lastname, controls);
        elements.setStyle("-fx-background-color: black");

        this.getChildren().add(elements);
        
    }

    private void processEnter(ActionEvent event) {
    //     lastname.getText().trim().toLowerCase() =   
        if(event.getSource() == lastname) {
            lastnameEntered = lastname.getText().trim().toLowerCase();
            member = null;
            int memberID = 33;

            for(int i=0; i < EnterpriseCrewmember.getCrew().length ; i++ ){
            
                if (lastnameEntered.equals(EnterpriseCrewmember.getCrew()[i].getLastName())) {
                    member = EnterpriseCrewmember.getCrew()[i];
                    memberID = i;
                }
            }          

            desktop = new EnterpriseDesktop(member, this);
            desktop.setStyle("-fx-background-color: black");

            switch (memberID) {
                case 0:
                    desktop.setPermissions(EnterprisePermissions.ADMIN);
                    break;
                case 1:
                    desktop.setPermissions(EnterprisePermissions.ADMIN);
                    break;
                case 2:
                    desktop.setPermissions(EnterprisePermissions.USER);
                    break;
                case 3:
                    desktop.setPermissions(EnterprisePermissions.USER);
                    break;
                default:
                    break;
            }

            this.getChildren().add(desktop);

        
        






    }



        // for (int i = 0; i < EnterpriseCrewmember.getCrew().length; i++) {
        //     if (lastnameEntered.compareTo(EnterpriseCrewmember.getCrew()[i].getLastName()) == 0) {
        //         welcome.setText("Welcome" + EnterpriseCrewmember.getCrew()[i].getLastName());
        //         elements.getChildren().add(welcome);

        //     }            
        // }


    }

    private void processButtonPress(ActionEvent event) {
        if (event.getSource() == poweroff) {
            Optional<ButtonType> ok;
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setContentText("Shut down now?");
            ok = alert.showAndWait();
            
            if (ok.isPresent() && ok.get() == ButtonType.OK) {
                Text text = new Text();
                text.setText("Shutting down");
                text.setFont(Font.font("Lucida Console", 50));
                text.setStroke(javafx.scene.paint.Color.WHITE);

                this.getChildren().add(text);
            }

        }

        if (event.getSource() == redAlert) { 
            // int redAlertCodeEntered = 0;
            // redAlertTextField = new TextField();
            // redAlertTextField.setPromptText("ENTER OVERRIDE CODE: ");
            // this.getChildren().add(redAlertTextField); 

            // int redAlertCode = 42;
            // redAlertCodeEntered = Integer.parseInt(redAlertTextField.getText().trim());

            // if (redAlertCodeEntered == redAlertCode) {


        // } else {

        // }


            redAlertScript();
            // int redAlertCodeEntered = Integer.parseInt(redAlertTextField.getText())
            
        }

    }

    
    public void redAlertScript() {
        redalertBox = new VBox();
        Text redalertText = new Text();
        
        HBox redalertControls = new HBox();
        redAlertPods = new Button("ESC_PODS");
        redAlertPods.setOnAction(this::processRedAlertButtons);
        redAlertSelfDestruct = new Button("SELF_DESTRUCT");
        redAlertSelfDestruct.setOnAction(this::processButtonPress);
        redAlertCancel = new Button("CANCEL");
        redAlertCancel.setOnAction(this::processRedAlertButtons);
        
        //Disables red alert button based on permissions
        
        // if(desktop.getPermissions() == EnterprisePermissions.ADMIN) {
        //     redAlertSelfDestruct.setDisable(false);
        // } else {
        //     redAlertSelfDestruct.setDisable(true);
        // }

        if (redAlertSelfDestruct.isDisabled()) {
            Tooltip selfDestructTip = new Tooltip("Disabled for this user");
            redAlertSelfDestruct.setTooltip(selfDestructTip);
        }


        redalertControls.getChildren().addAll(redAlertPods, redAlertSelfDestruct, redAlertCancel);
        redalertControls.setSpacing(20);
        redalertControls.setAlignment(Pos.CENTER);

        redalertText.setText("RED ALERT! RED ALERT!");
        redalertText.setFont(Font.font("Lucida Console", 20));

        redalertBox.setStyle("-fx-background-color: red");
        redalertBox.setAlignment(Pos.CENTER);
        redalertBox.setSpacing(20);

        redalertBox.getChildren().addAll(redalertText, redalertControls);
        this.getChildren().add(redalertBox);
        
    }

    private void processRedAlertButtons(ActionEvent event) {
        if (event.getSource() == redAlertCancel) {
            this.getChildren().remove(redalertBox);
        } else if (event.getSource() == redAlertSelfDestruct) {
            
        } else if (event.getSource() == redAlertPods) {            
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setContentText("Arm escape pods?");
            Optional<ButtonType> ok;
            ok = alert.showAndWait();

            if (ok.isPresent() && ok.get() == ButtonType.OK) {
                Alert podMessage = new Alert(AlertType.INFORMATION);
                podMessage.setContentText("Escape pods armed");
                podMessage.show();
            }

        }
    }

    public static void logOut(EnterprisePane pane, EnterpriseDesktop desktop) {
        pane.getChildren().remove(pane.desktop);
    }

    


}
