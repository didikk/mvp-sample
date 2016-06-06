package me.didik.task.feature.taskdetail;

import me.didik.task.model.Task;

/**
 * Created by didik on 06/06/16.
 * Detail
 */
public interface TaskDetailContract {
    interface View {
        void showTask(Task task);
    }

    interface UserActionListener {
        void openTask(Task task);
    }
}
