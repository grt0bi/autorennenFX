package com.example.autorennenfx;

import javafx.event.*;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Fahrzeug {
    private double x,y;
    private int laenge;
    private Color farbe;
    protected double geschwindigkeit;
    private double maxGeschwindigkeit, beschleunigung, bremskraft;

    public Fahrzeug(int Y, Color Farbe, int Laenge, double MaxGeschwindigkeit, double Beschleunigung, double Bremskraft){
        x = 100 - Laenge;
        y = Y;
        farbe = Farbe;
        laenge = Laenge;
        geschwindigkeit = 0;
        maxGeschwindigkeit = MaxGeschwindigkeit;
        beschleunigung = Beschleunigung;
        bremskraft = Bremskraft;
    }

    public Fahrzeug() {

    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Point2D getPoint(){
        return new Point2D(x,y);
    }
    public Color getFarbe(){
        return farbe;
    }
    public void Beschleunigen(){
        geschwindigkeit += beschleunigung;
        if(geschwindigkeit > maxGeschwindigkeit){
            geschwindigkeit = maxGeschwindigkeit;
        }
    }
    public void Bremsen(){
        geschwindigkeit -= bremskraft;
        if(geschwindigkeit < 0){
            geschwindigkeit = 0;
        }
    }
    public void Fahren(){
        x += geschwindigkeit;
    }
    public void Kollisionerkennung(double fensterBreite){
        if(x > fensterBreite){
            x = -laenge;
        }
    }
    protected abstract void Anzeigen(GraphicsContext graphicsContext);

    // Event-Handling
    private EventDispatcher eventDispatcher = new EventDispatcher(this);

    public void addEventHandler(EventType<SchreckEvent> eventType, EventHandler<Event> eventHandler){
        eventDispatcher.addEventHandler(eventType, eventHandler);
    }
    public void removeHandler(EventType<SchreckEvent> eventType, EventHandler<Event> eventHandler){
        eventDispatcher.removeEventHandler(eventType, eventHandler);
    }
    protected void fireEvent(Event event){
        eventDispatcher.dispatchEvent(event);
    }

}
