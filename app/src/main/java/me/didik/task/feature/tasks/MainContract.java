package me.didik.task.feature.tasks;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import me.didik.task.model.Task;


/**
 * Created by didik on 06/06/16.
 * Main Contract
 */
public interface MainContract {
    interface View {
        void showTasks(ArrayList<Task> tasks);

        void showAddTask();

        void showTaskDetailUi(Task task);

        void showNoTask();
    }

    interface UserActionListener {
        void addNewTask();

        void loadTask();

        void openTaskDetail(@NonNull Task task);
    }
}
