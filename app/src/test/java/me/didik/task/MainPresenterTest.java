package me.didik.task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import me.didik.task.data.TaskRepository;
import me.didik.task.feature.tasks.MainContract;
import me.didik.task.feature.tasks.MainPresenter;
import me.didik.task.model.Task;

import static org.mockito.Mockito.verify;

/**
 * Created by didik on 06/06/16.
 * Test
 */
public class MainPresenterTest {


    @Mock
    private TaskRepository taskRepository;

    @Mock
    private MainContract.View mView;

    private MainPresenter mainPresenter;

    @Before
    public void setupMainPresenter() {
        MockitoAnnotations.initMocks(this);

        mainPresenter = new MainPresenter(mView);
    }

    @Test
    public void loadTaskFromRepoAndLoadIntoView() {
        mainPresenter.loadTask();
    }

    @Test
    public void clickOnFab() {
        mainPresenter.addNewTask();
    }

    @Test
    public void openTaskDetail() {
        Task task = new Task("Title", new Date(), "Description");
        mainPresenter.openTaskDetail(task);

        verify(mView).showTaskDetailUi(task);
    }
}
