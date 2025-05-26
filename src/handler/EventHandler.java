// src/handler/EventHandler.java
package handler;

import model.Event;
import model.User;
import java.util.ArrayList;
import java.util.List;

public class EventHandler implements HandlerInterface<Event> {
    private List<Event> events = new ArrayList<>();

    @Override
    public Event show(Event event) {
        if (event == null) return null;
        return events.stream()
                .filter(e -> e.getId() == event.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Event> showAll() {
        return new ArrayList<>(events);
    }

    @Override
    public void add(Event event) {
        if (event != null && !events.contains(event)) {
            events.add(event);
        }
    }

    @Override
    public void update(Event event) {
        if (event == null) return;

        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId() == event.getId()) {
                events.set(i, event);
                return;
            }
        }
    }

    @Override
    public void delete(Event event) {
        if (event != null) {
            events.remove(event);
        }
    }

    public boolean isPresent(User user, Event event) {
        if (user == null || event == null) return false;
        return event.getParticipants().contains(user);
    }
}