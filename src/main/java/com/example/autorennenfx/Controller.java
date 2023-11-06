package com.example.autorennenfx;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    @FXML
    private Button btnBremse1;

    @FXML
    private Button btnBremse2;

    @FXML
    private Button btnBremse3;

    @FXML
    private Button btnGas1;

    @FXML
    private Button btnGas2;

    @FXML
    private Button btnHupe1;

    @FXML
    private Button btnHupe2;

    @FXML
    private Button btnKlingeln;

    @FXML
    private Button btnTreten;

    @FXML
    private Canvas cvsFahrbahn;

    @FXML
    private Label lblTacho1;

    @FXML
    private Label lblTacho2;
    @FXML
    void actBremse1(ActionEvent event){
        flotte.Bremsen(0);
    }
    @FXML
    void actBremse2(ActionEvent event){
        flotte.Bremsen(1);
    }
    @FXML
    void actBremse3(ActionEvent event){
        flotte.Bremsen(2);
    }
    @FXML
    void actGas1(ActionEvent event){
        flotte.Beschleunigen(0);
    }
    @FXML
    void actGas2(ActionEvent event){
        flotte.Beschleunigen(1);
    }
    @FXML
    void actHupe1(ActionEvent event){
        flotte.Hupen(0);
    }
    @FXML
    void actHupe2(ActionEvent event){
        flotte.Hupen(1);
    }
    /*@FXML
    void actKlingeln(ActionEvent event){
        ((Fahrrad) flotte.getFahrzeug(2)).Klingeln();
    }*/
    @FXML
    void actTreten(ActionEvent event){
        flotte.Beschleunigen(2);
    }
    private Flotte flotte;
    public Controller(){
        flotte = new Flotte();

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long now){
                Controller.this.update();
            }
        };

        timer.start();
    }
    public void update(){
        GraphicsContext graphicsContext = cvsFahrbahn.getGraphicsContext2D();
        graphicsContext.fillRect(0,0, graphicsContext.getCanvas().getWidth(),
                graphicsContext.getCanvas().getHeight());
        for(Fahrzeug fahrzeug : flotte.getFahrzeuge()){
            fahrzeug.Fahren();
            fahrzeug.Kollisionerkennung(cvsFahrbahn.getGraphicsContext2D().getCanvas().getWidth());
            fahrzeug.Anzeigen(cvsFahrbahn.getGraphicsContext2D());
        }
        lblTacho1.setText(((Auto) flotte.getFahrzeug(0)).getGeschwindigkeit());
        lblTacho2.setText(((Auto) flotte.getFahrzeug(1)).getGeschwindigkeit());
    }

}
