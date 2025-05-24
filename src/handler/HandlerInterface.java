package handler;

import java.util.List;

public interface HandlerInterface<T> {
    T show(T item);
    List<T> showAll();
    void add(T item);
    void update(T item);
    void delete(T item);
}