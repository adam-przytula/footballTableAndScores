package sample;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;

public class Controller {
    int h,g;
    int[][] ranking = new int[6][7];
    String[] teamName = new String[]{"Real Madrid","FC Barcelona","Bayern Munich","Juventus FC","Paris Saint Germain","Liverpool FC"};
    Vector<Integer> vec = new Vector<Integer>();
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
    private AnchorPane showAddScore, showTable, showHistory, topBar;

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
    private void onVisitorClicked(){
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

    private void setStats(){
        //[][0]-Matches
        //[][1]-Win
        //[][2]-Draw
        //[][3]-Loss
        //[][4]-Goals scored
        //[][5]-Goals conceded
        //[][6]-Points
        if((Integer.parseInt(score1.getText())) > (Integer.parseInt(score2.getText()))){
            ranking[h][0] ++;
            ranking[h][1] ++;
            ranking[h][4] += Integer.parseInt(score1.getText());
            ranking[h][5] += Integer.parseInt(score2.getText());
            ranking[h][6] += 3;

            ranking[g][0] ++;
            ranking[g][3] ++;
            ranking[g][4] += Integer.parseInt(score2.getText());
            ranking[g][5] += Integer.parseInt(score1.getText());
        }
        else if(Integer.parseInt(score1.getText()) < Integer.parseInt(score2.getText()))
        {
            ranking[g][0] ++;
            ranking[g][1] ++;
            ranking[g][4] += Integer.parseInt(score2.getText());
            ranking[g][5] += Integer.parseInt(score1.getText());
            ranking[g][6] += 3;

            ranking[h][0] ++;
            ranking[h][3] ++;
            ranking[h][4] += Integer.parseInt(score1.getText());
            ranking[h][5] += Integer.parseInt(score2.getText());

        }
        else //Draw
        {
            ranking[h][0] ++;
            ranking[h][2] ++;
            ranking[h][4] += Integer.parseInt(score1.getText());
            ranking[h][5] += Integer.parseInt(score2.getText());
            ranking[h][6] += 1;

            ranking[g][0] ++;
            ranking[g][2] ++;
            ranking[g][4] += Integer.parseInt(score2.getText());
            ranking[g][5] += Integer.parseInt(score1.getText());
            ranking[g][6] += 1;

        }
    }

    private void rankingSort(){
        vec.clear();
        try {
            for (int i = 0; i < 6; i++) vec.add(Integer.valueOf(ranking[i][6]));
            Collections.sort(vec);
        } catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog...");
            alert.setContentText("Ooops.. Something goes wrong!");
            alert.showAndWait();
        }
    }

    @FXML
    private void showStats(){
        String temp1;
        int k = 5;
        int skip = -1;
        int ii=0;
        rankingSort();

        rankPoints.setText("M      W      D       L      GS     GC      P");
        rankTeams.setText("Team ");
        rankPositions.setText("#\n1\n2\n3\n4\n5\n6");

        while(k>=0){
            for (int i = 0; i < 6; i++) {
                if (vec.get(k) == Integer.valueOf(ranking[i][6])){
                    rankTeams.setText(rankTeams.getText() + "\n" + teamName[i]);
                    temp1 = "";
                    for (int j = 0; j < 7; j++) {
                        temp1 = temp1 + ranking[i][j] + "       ";
                    }
                    rankPoints.setText(rankPoints.getText() + "\n" + temp1);
                    k--;
                    ii++;
                }
                if(ii == 6)break;
            }
            if(ii == 6)break;
        }
    }

    @FXML
    private void onSubmitClicked(){
        try{
            if(Integer.parseInt(score1.getText()) >=0 && Integer.parseInt(score1.getText()) <20 && Integer.parseInt(score2.getText()) >=0 && Integer.parseInt(score2.getText()) <20){
                if((hostName.getText() != "") && (visitorName.getText() != "")){
                    matchHistory.setText(hostName.getText() + " - " + visitorName.getText() + "\n" + matchHistory.getText());
                    score.setText(Integer.parseInt(score1.getText()) + " : " + Integer.parseInt(score2.getText()) + "\n" + score.getText());

                    setStats();
                    showStats();
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

    @FXML
    private void onAboutClicked(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About author");
        alert.setHeaderText("Author: Adam Przytuła");
        alert.setContentText("CS student at Lublin University of Technology.");
        alert.showAndWait();
    }

    @FXML
    private void onLoadClicked(){
        matchHistory.setText("\n" + matchHistory.getText());
        score.setText("\n" + score.getText());
        try {
            Scanner read = new Scanner(new File("C:\\Users\\Adam\\Documents\\Git\\footballTableAndScores\\src\\sample\\data.txt"));
            String textLine;
            while (read.hasNext()) {
                textLine = read.nextLine();
                matchHistory.setText(textLine + "\n" + matchHistory.getText());
                textLine = read.nextLine();
                score.setText(textLine + "\n" + score.getText());
            }
            read.close();

            setStatsFromFile();
            showStats();
        } catch(FileNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("File not found!");
            alert.setContentText("Enter proper path to data file.");
            alert.showAndWait();
        }
    }

    @FXML
    private void onSaveClicked(){
        try {
            PrintWriter save = new PrintWriter("C:\\Users\\Adam\\Documents\\Git\\footballTableAndScores\\src\\sample\\savedScores.txt");
            save.print(matchHistory.getText() + "   " + score.getText() + "     ");
            save.close();
        } catch(FileNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("File not found!");
            alert.setContentText("Wrong path.");
            alert.showAndWait();
        }
    }

    @FXML
    private void onExitClicked(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure to close this application?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
            System.exit(0);
        }
    }

    @FXML
    private void onEraseClicked(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure to erase all?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            matchHistory.setText("");
            score.setText("");
            rankPositions.setText("");
            rankTeams.setText("");
            rankPoints.setText("");
        }

    }

    private void setStatsFromFile()
    {
        ranking[0][0]+=5;
        ranking[0][1]+=4;
        ranking[0][2]+=1;
        ranking[0][3]+=0;
        ranking[0][4]+=14;
        ranking[0][5]+=7;
        ranking[0][6]+=13;

        ranking[1][0]+=6;
        ranking[1][1]+=3;
        ranking[1][2]+=2;
        ranking[1][3]+=1;
        ranking[1][4]+=9;
        ranking[1][5]+=7;
        ranking[1][6]+=11;

        ranking[2][0]+=4;
        ranking[2][1]+=0;
        ranking[2][2]+=1;
        ranking[2][3]+=3;
        ranking[2][4]+=3;
        ranking[2][5]+=9;
        ranking[2][6]+=1;

        ranking[3][0]+=6;
        ranking[3][1]+=1;
        ranking[3][2]+=3;
        ranking[3][3]+=2;
        ranking[3][4]+=5;
        ranking[3][5]+=8;
        ranking[3][6]+=6;

        ranking[4][0]+=5;
        ranking[4][1]+=1;
        ranking[4][2]+=1;
        ranking[4][3]+=3;
        ranking[4][4]+=8;
        ranking[4][5]+=8;
        ranking[4][6]+=4;

        ranking[5][0]+=4;
        ranking[5][1]+=1;
        ranking[5][2]+=2;
        ranking[5][3]+=1;
        ranking[5][4]+=5;
        ranking[5][5]+=5;
        ranking[5][6]+=5;
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
