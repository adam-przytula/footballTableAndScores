package sample;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;

import java.util.Vector;

import static javax.swing.JOptionPane.showMessageDialog;

public class Controller {
    int h,g;
    int[][] ranking = new int[6][7];
//    private String teamName []= new String[6];
//    teamName[0]= "Real Madryt";
//          //  "FC Barcelona","Bayern Monachium","Juventus F.C.","Paris Saint Germain","Liverpool F.C."};
    Vector<Integer> vec;
    @FXML
    private Label rankPoints, hostName, stadiumName, rankPositions, visitorName, rankTeams, matchHistory, score;
    @FXML
    private ImageView btnHistory, btnAddScore, stadium, btnTable;
    @FXML
    private TextField score2, score1;
    @FXML
    private Button submit, host, visitor;
    @FXML
    private RadioButton team1, team2, team3, team4, team5, team6;
    @FXML
    private ToggleGroup teamChecked;
    @FXML
    private AnchorPane showAddScore, showTable, showHistory, topbarMenu;
//    @FXML
//    Spinner score1, score2;


    @FXML
    private void setShowAddScore(){
        showAddScore.setVisible(true);
        showTable.setVisible(false);
        showHistory.setVisible(false);
    }
    @FXML
    private void setShowTable(){
        showAddScore.setVisible(false);
        showTable.setVisible(true);
        showHistory.setVisible(false);
    }
    @FXML
    private void setShowHistory(){
        showAddScore.setVisible(false);
        showTable.setVisible(false);
        showHistory.setVisible(true);
    }

    @FXML
    private void onHostClicked(){
        Image stadiumImage;

        if(team1.isSelected() == true){

            h=0;
            if(visitorName.getText() != team1.getText()){
                hostName.setText(team1.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumReal.jpg").toExternalForm());
                stadium.setImage(stadiumImage);
                stadiumName.setText("Santiago Bernabeu\nPojemność: 81 044" );
        }}
        else if(team2.isSelected() == true){
            h=1;
            if(visitorName.getText()!= team2.getText()){
                hostName.setText(team2.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumBarca.jpg").toExternalForm());
                stadium.setImage(stadiumImage);

            stadiumName.setText("Camp Nou\nPojemność: 99 354" );
        }}
        else if(team3.isSelected() == true){
            h=2;
            if(visitorName.getText() != team3.getText()){
                hostName.setText(team3.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumBayern.jpg").toExternalForm());
                stadium.setImage(stadiumImage);

            stadiumName.setText("Allianz Arena\nPojemność: 75 000" );
        }}
        else if(team4.isSelected() == true){
            h=3;
            if(visitorName.getText() != team4.getText()){
                hostName.setText(team4.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumJuve.jpg").toExternalForm());
                stadium.setImage(stadiumImage);

            stadiumName.setText("Allianz Stadium\nPojemność: 41 507" );
        }}
        else if(team5.isSelected() == true){
            h=4;
            if(visitorName.getText() != team5.getText()){
                hostName.setText(team5.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumPsg.jpg").toExternalForm());
                stadium.setImage(stadiumImage);

            stadiumName.setText("Parc des Princes\nPojemność: 47 929" );
        }}
        else{
            h=5;
            if(visitorName.getText() != team6.getText()){
                hostName.setText(team6.getText());
                stadiumImage = new Image(getClass().getResource("images/stadiumLive.jpg").toExternalForm());
                stadium.setImage(stadiumImage);

            stadiumName.setText("Anfield\nPojemność: 54 074" );
        }}

    }
    @FXML
    private void onVisitorClicked()
    {
        if(team1.isSelected() == true)
        {
            g=0;
            if(hostName.getText() != team1.getText())
                visitorName.setText(team1.getText());
        }
        else if(team2.isSelected() == true)
        {
            g=1;
            if(hostName.getText() != team2.getText())
                visitorName.setText(team2.getText());
        }
        else if(team3.isSelected() == true)
        {
            g=2;
            if(hostName.getText() != team3.getText())
                visitorName.setText(team3.getText());
        }
        else if(team4.isSelected() == true)
        {
            g=3;
            if(hostName.getText() != team4.getText())
                visitorName.setText(team4.getText());
        }
        else if(team5.isSelected() == true)
        {
            g=4;
            if(hostName.getText() != team5.getText())
                visitorName.setText(team5.getText());
        }
        else
        {
            g=5;
            if(hostName.getText() != team6.getText())
                visitorName.setText(team6.getText());
        }
    }
    @FXML
    private void onSubmitClicked(){
        try{
        if(Integer.parseInt(score1.getText()) >=0 && Integer.parseInt(score1.getText()) <20 && Integer.parseInt(score2.getText()) >=0 && Integer.parseInt(score2.getText()) <20){
        if((hostName.getText() != "") && (visitorName.getText() != "")){
            matchHistory.setText(hostName.getText() + " - " + visitorName.getText() + "\n" + matchHistory.getText());
            score.setText(Integer.parseInt(score1.getText()) + " : " + Integer.parseInt(score2.getText()) + "\n" + score.getText());
        } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog..");
            alert.setContentText("Choose teams!");
            alert.showAndWait();
        }
    } else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog..");
            alert.setContentText("Enter proper numbers! (0-20)");
            alert.showAndWait();
        }

    } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog...");
            alert.setContentText("Enter some numbers!!!");
            alert.showAndWait();
        }
    }



//// Spinner doesn't working..
//    private void initSpinner() {
//        score1.setValueFactory(
//                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10));
//        score2.setValueFactory(
//                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10));
//    }
//    @FXML
//    public void updateSpinnerValue(Integer newValue) {
//        score1.getValueFactory().setValue(newValue);
//        score2.getValueFactory().setValue(newValue);
//    }


}
