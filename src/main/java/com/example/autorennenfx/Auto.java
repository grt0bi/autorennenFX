package com.example.autorennenfx;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Objects;

import static javafx.event.Event.fireEvent;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Auto extends Fahrzeug{
    public Auto(int Y, Color Farbe){
        super(Y, Farbe, 55, 30, 0.5, 1.5);
    }

    public String getGeschwindigkeit(){
        DecimalFormat decimalFormat = new DecimalFormat("000");
        return decimalFormat.format(geschwindigkeit * 10);
    }
    public void Hupen(){
        Media media = new Media(new File(Objects.requireNonNull(getClass().getResource("hupe.wav")).getPath()).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        SchreckEvent schreckEvent = new SchreckEvent(this, new Point2D(getX(), getY()));
    }
    @Override
    protected void Anzeigen(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BLACK);
        //Reifen
        graphicsContext.fillRect(getX() + 5, getY() +2,10,8);
        graphicsContext.fillRect(getX() + 5, getY() +35,10,8);
        graphicsContext.fillRect(getX() + 40, getY() +5,10,8);
        graphicsContext.fillRect(getX() + 40, getY() +32,10,8);

        //Achsen
        graphicsContext.setLineWidth(3);
        graphicsContext.setStroke(getFarbe());
        graphicsContext.strokeLine(getX() +10, getY()+10, getX()+10,getY()+15);
        graphicsContext.strokeLine(getX() +10, getY()+30, getX()+10,getY()+35);
        graphicsContext.strokeLine(getX() +45, getY()+13, getX()+45,getY()+18);
        graphicsContext.strokeLine(getX() +45, getY()+27, getX()+45,getY()+32);

        //Karosserie
        graphicsContext.setFill(getFarbe());
        graphicsContext.fillPolygon(
                new double[] {getX(), getX() + 35, getX() + 55, getX() + 55, getX()+35,getX(), getX()},
                new double[] {getY()+15,getY()+15,getY()+20,getY()+25,getY()+30,getY()+30,getY()+15},
                7);

        //Cockpit
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(getX() +23, getY() +18, 10, 10);
    }
}
