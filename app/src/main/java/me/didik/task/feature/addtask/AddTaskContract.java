package me.didik.task.feature.addtask;

import me.didik.task.model.Task;

/**
 * Created by didik on 06/06/16.
 * Add
 */
public interface AddTaskContract {
    interface View {
        void backToTaskList();
    }

    interface UserActionListener {
        void saveTask(Task task);
    }
}
