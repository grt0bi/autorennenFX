package com.example.autorennenfx;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EventDispatcher {

    private Object source;
    private Map<EventType<? extends Event>, Set<EventHandler<Event>>> eventHandlersMap;

    public EventDispatcher(Object source) {
        this.source = source;
        this.eventHandlersMap = new HashMap<>();
    }

    public void addEventHandler(EventType<? extends Event> eventType, EventHandler<Event> eventHandler) {
        eventHandlersMap
                .computeIfAbsent(eventType, k -> new HashSet<>())
                .add(eventHandler);
    }

    public void removeEventHandler(EventType<? extends Event> eventType, EventHandler<Event> eventHandler) {
        Set<EventHandler<Event>> handlers = eventHandlersMap.get(eventType);
        if (handlers != null) {
            handlers.remove(eventHandler);
        }
    }

    public void dispatchEvent(Event event) {
        EventType<? extends Event> eventType = event.getEventType();
        Set<EventHandler<Event>> handlers = eventHandlersMap.get(eventType);

        if (handlers != null) {
            for (EventHandler<Event> handler : handlers) {
                handler.handle(event);
            }
        }
    }
}
