package me.didik.task.feature.addtask;

import me.didik.task.model.Task;

/**
 * Created by didik on 06/06/16.
 * Add task
 */
public class AddTaskPresenter implements AddTaskContract.UserActionListener {
    private final AddTaskContract.View mView;

    public AddTaskPresenter(AddTaskContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void saveTask(Task task) {
        task.save();
        mView.backToTaskList();
    }
}
