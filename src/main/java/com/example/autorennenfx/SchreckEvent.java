package com.example.autorennenfx;

import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Point2D;

public class SchreckEvent extends Event{
    private Point2D point;
    public static final EventType<SchreckEvent> SCHRECK_EVENT_TYPE = new EventType<>(Event.ANY, "SCHRECK_EVENT");

    public SchreckEvent(Object source, Point2D point){
        super(source, Event.NULL_SOURCE_TARGET, SCHRECK_EVENT_TYPE);
        this.point = point;
    }
    public Point2D getPoint(){
        return point;
    }
}
