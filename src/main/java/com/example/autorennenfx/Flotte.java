package com.example.autorennenfx;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Flotte {

    private ArrayList<Fahrzeug> fahrzeuge;

    public Flotte()
    {
        fahrzeuge = new ArrayList<Fahrzeug>();
        fahrzeuge.add(new Auto(50, Color.RED));
        fahrzeuge.add(new Auto(150, Color.BLUE));
        fahrzeuge.add(new Fahrrad(250, Color.GREEN));

        for(Fahrzeug fahrzeug1 : fahrzeuge){
            for(Fahrzeug fahrzeug2 : fahrzeuge){
                if(fahrzeug1 != fahrzeug2){
                    fahrzeug1.addEventHandler(SchreckEvent.SCHRECK_EVENT_TYPE, event -> {
                        Point2D point = ((SchreckEvent) event).getPoint();
                        double distance = Math.sqrt(Math.pow(point.getX() - fahrzeug1.getX(), 2) +
                                Math.pow(point.getY() - fahrzeug1.getY(), 2));
                        if(distance < 200){
                            fahrzeug1.Bremsen();
                        }
                    });
                }
            }
        }

    }

    public ArrayList<Fahrzeug> getFahrzeuge(){
        return fahrzeuge;
    }
    public Fahrzeug getFahrzeug(int i){
        return fahrzeuge.get(i);
    }
    public int getAnzahl(){
        return fahrzeuge.size();
    }
    public void Beschleunigen(int i){
        fahrzeuge.get(i).Beschleunigen();
    }
    public void Bremsen(int i){
        fahrzeuge.get(i).Bremsen();
    }
    public void Hupen(int i){
        if (fahrzeuge.get(i).getClass() == Auto.class){
            Auto auto = (Auto) fahrzeuge.get(i);
            auto.Hupen();
        }
    }
    public Point2D getPoint(int i){
        return fahrzeuge.get(i).getPoint();
    }
}
