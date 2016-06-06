package me.didik.task.feature.taskdetail;

import me.didik.task.model.Task;

/**
 * Created by didik on 06/06/16.
 * Detail
 */
public class TaskDetailPresenter implements TaskDetailContract.UserActionListener {
    private final TaskDetailContract.View mView;

    public TaskDetailPresenter(TaskDetailContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void openTask(Task task) {
        mView.showTask(task);
    }
}
