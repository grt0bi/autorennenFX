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

public class Fahrrad extends Fahrzeug {
    public Fahrrad(int Y, Color Farbe) {
        super(Y, Farbe, 55, 30, 0.5, 1.5);
    }

    public String getGeschwindigkeit() {
        DecimalFormat decimalFormat = new DecimalFormat("000");
        return decimalFormat.format(geschwindigkeit * 10);
    }

    @Override
    protected void Anzeigen(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Color.BLACK);
        // Reifen
        graphicsContext.fillRect(getX() + 5, getY() + 2, 10, 8);
        graphicsContext.fillRect(getX() + 5, getY() + 35, 10, 8);
        graphicsContext.fillRect(getX() + 40, getY() + 5, 10, 8);
        graphicsContext.fillRect(getX() + 40, getY() + 32, 10, 8);

        // Achsen
        graphicsContext.setLineWidth(3);
        graphicsContext.setStroke(getFarbe());
        graphicsContext.strokeLine(getX() + 10, getY() + 10, getX() + 10, getY() + 15);
        graphicsContext.strokeLine(getX() + 10, getY() + 30, getX() + 10, getY() + 35);
        graphicsContext.strokeLine(getX() + 45, getY() + 13, getX() + 45, getY() + 18);
        graphicsContext.strokeLine(getX() + 45, getY() + 27, getX() + 45, getY() + 32);

        // Rahmen (statt Karosserie)
        graphicsContext.setFill(getFarbe());
        graphicsContext.fillRect(getX() + 10, getY() + 15, 35, 15);

        // Sattel
        graphicsContext.setFill(Color.BROWN); // Beispiel-Farbe
        graphicsContext.fillRect(getX() + 22, getY() + 10, 10, 5);

        // Lenker
        graphicsContext.setFill(Color.SILVER); // Beispiel-Farbe
        graphicsContext.fillRect(getX() + 8, getY() + 12, 3, 20);

        // Pedale (Beispiel)
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(getX() + 10, getY() + 32, 5, 5);
        graphicsContext.fillOval(getX() + 33, getY() + 32, 5, 5);
    }
}
