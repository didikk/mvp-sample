package me.didik.task.data;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import me.didik.task.model.Task;

/**
 * Created by didik on 06/06/16.
 * Repo
 */
public class TaskRepository {
    public ArrayList<Task> getDummyData() {
        ArrayList<Task> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            tasks.add(new Task("Task " + i, new Date(), "Description " + i));
        }

        return tasks;
    }

    public ArrayList<Task> get() {
        List<Task> tasks = new Select()
                .from(Task.class)
                .orderBy("Timestamp DESC")
                .execute();

        return (ArrayList<Task>) tasks;
    }
}
