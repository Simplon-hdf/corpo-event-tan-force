package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private int id;
    private String title;
    private String description;
    private String location;
    private User author;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Comment> comments;
    private List<User> participants;

    public Event(int id, String title, String description, String location, User author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.author = author;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
        this.comments = new ArrayList<>();
        this.participants = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void addParticipant(User user) {
        this.participants.add(user);
    }
}