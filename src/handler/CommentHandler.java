// src/handler/CommentHandler.java
package handler;

import model.Comment;
import java.util.ArrayList;
import java.util.List;

public class CommentHandler implements HandlerInterface<Comment> {
    private List<Comment> comments = new ArrayList<>();

    @Override
    public Comment show(Comment comment) {
        if (comment == null) return null;
        return comments.stream()
                .filter(c -> c.getId() == comment.getId())
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Comment> showAll() {
        return new ArrayList<>(comments);
    }

    @Override
    public void add(Comment comment) {
        if (comment != null && !comments.contains(comment)) {
            comments.add(comment);
        }
    }

    @Override
    public void update(Comment comment) {
        if (comment == null) return;

        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).getId() == comment.getId()) {
                comments.set(i, comment);
                return;
            }
        }
    }

    @Override
    public void delete(Comment comment) {
        if (comment != null) {
            comments.remove(comment);
        }
    }
}