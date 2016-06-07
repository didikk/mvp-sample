package me.didik.task.feature.tasks;

import android.support.annotation.NonNull;

import java.util.ArrayList;

import me.didik.task.data.TaskRepository;
import me.didik.task.model.Task;


/**
 * Created by didik on 06/06/16.
 * Presenter
 */
public class MainPresenter implements MainContract.UserActionListener {
    private final MainContract.View mView;
    private final TaskRepository mRepository;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mRepository = new TaskRepository();
    }

    @Override
    public void addNewTask() {
        mView.showAddTask();
    }

    @Override
    public void loadTask() {
        ArrayList<Task> tasks = mRepository.get();
        if (tasks.isEmpty()) mView.showNoTask();
        else mView.showTasks(tasks);
    }

    @Override
    public void openTaskDetail(@NonNull Task task) {
        mView.showTaskDetailUi(task);
    }
}
