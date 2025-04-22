

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class EnterpriseDesktop extends StackPane {
    private static int numDesktopsCreated;
    private EnterpriseCrewmember user;
    private EnterprisePane pane;
    private EnterprisePermissions permissions;
    private Button logoutButton, startMenu;
    private Button starMapGenerator;

    public EnterpriseDesktop(EnterpriseCrewmember user, EnterprisePane pane) {
        this.pane = pane;
        this.user = user;
        numDesktopsCreated++;

        Image background = new Image("federation.jpg");
        ImageView imageView = new ImageView(background);

        this.getChildren().add(imageView);

        VBox home = new VBox();

        //Control buttons
        HBox controls = new HBox();
        
       
        logoutButton = new Button("Log Off");
        logoutButton.setOnAction(this::processButtonPress);
        
        startMenu = new Button("Start");

        controls.getChildren().addAll(startMenu, logoutButton);
        controls.setAlignment(Pos.TOP_LEFT);
        controls.setSpacing(20);

        //Desktop Apps
        HBox applications = new HBox();
        starMapGenerator = new Button("StarMap");
        starMapGenerator.setOnAction(this::processAppButtonPress);

        applications.getChildren().addAll(starMapGenerator);
        applications.setSpacing(20);
        applications.setAlignment(Pos.CENTER);

        home.getChildren().addAll(applications, controls);
        home.setSpacing(20);
        home.setAlignment(Pos.CENTER);

        this.getChildren().add(home);
    }

    public EnterpriseCrewmember getUser() {
        return user;
    }

    public void setUser(EnterpriseCrewmember user) {
        this.user = user;
    }

    public void setPermissions(EnterprisePermissions permissions) {
        this.permissions = permissions;
    }

    public EnterprisePermissions getPermissions() {
        return permissions;
    }

    private void processButtonPress(ActionEvent event) {
        if (event.getSource() == logoutButton) {
            EnterprisePane.logOut(this.pane, this);
        } 
    }

    private void processAppButtonPress(ActionEvent event) {


        if (event.getSource() == starMapGenerator) {
            EnterpriseSectors.createStarMap(4, 4);
            Text[][] sectors = new Text[4][4];
            
            StackPane sectorBackground = new StackPane();

            sectorBackground.setStyle("fx-background-color: black");
            sectorBackground.setAlignment(Pos.CENTER);

            GridPane sectorPane = new GridPane();
            sectorPane.setHgap(20);
            sectorPane.setVgap(20);
            sectorPane.setAlignment(Pos.TOP_LEFT);


            for (int i = 0; i < EnterpriseSectors.getStarMap().length; i++) {
                for (int j = 0; j < EnterpriseSectors.getStarMap()[i].length; j ++) {
                    Text sector = new Text();
                    sector.setText(EnterpriseSectors.getStarMap()[i][j].toString());
                    sector.setStroke(Color.WHITE);
                    sectors[i][j] = sector;
                    sectorPane.add(sector, i, j);
                }
            }

            sectorBackground.getChildren().addAll(sectorPane);
            this.getChildren().addAll(sectorBackground);

            //generates starmap
            //uses each element as the text for graphical elements in a gridpane
            //color based on safe or unsafe

        }
    }


}
