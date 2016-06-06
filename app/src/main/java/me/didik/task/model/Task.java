package me.didik.task.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by didik on 06/06/16.
 * Task
 */
@Table(name = "MyTask")
public class Task extends Model implements Serializable {
    @Column(name = "Title")
    private String title;

    @Column(name = "Timestamp")
    private Date timestamp;

    @Column(name = "Description")
    private String description;

    public Task() {
        super();
    }

    public Task(String title, Date timestamp, String description) {
        super();
        this.title = title;
        this.timestamp = timestamp;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", timestamp=" + timestamp +
                ", description='" + description + '\'' +
                '}';
    }
}
