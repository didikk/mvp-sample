package me.didik.task.feature.tasks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.didik.task.R;
import me.didik.task.base.BaseActivity;
import me.didik.task.base.RecyclerTouchListener;
import me.didik.task.base.SpacesItemDecoration;
import me.didik.task.feature.addtask.AddTaskActivity;
import me.didik.task.feature.taskdetail.TaskDetailActivity;
import me.didik.task.model.Task;

public class MainActivity extends BaseActivity implements MainContract.View {
    private static final int REQUEST_ADD_TASK = 1;

    @BindView(R.id.null_task) LinearLayout mNoTaskView;
    @BindView(R.id.recycler_view) RecyclerView recyclerView;
    @BindView(R.id.fab) FloatingActionButton fab;

    private TaskAdapter mAdapter;
    private MainContract.UserActionListener mActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);

        mAdapter = new TaskAdapter(new ArrayList<Task>(0));
        mActionListener = new MainPresenter(this);

        initRecycler();
        //mActionListener.loadTask();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActionListener.loadTask();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_TASK && resultCode == Activity.RESULT_OK) {
            toast(getString(R.string.message_success_add_task));
        }
    }

    private void initRecycler() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        SpacesItemDecoration itemDecoration = new SpacesItemDecoration(this, R.dimen.item_offset_5);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this, recyclerView,
                new RecyclerTouchListener.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        Task task = mAdapter.getItem(position);
                        mActionListener.openTaskDetail(task);
                    }

                    @Override
                    public void onLongClick(View view, int position) {

                    }
                }
        ));
    }

    @Override
    public void showTasks(ArrayList<Task> tasks) {
        mAdapter.replaceData(tasks);

        mNoTaskView.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddTask() {
        Intent i = new Intent(this, AddTaskActivity.class);
        startActivityForResult(i, REQUEST_ADD_TASK);
    }

    @Override
    public void showTaskDetailUi(Task task) {
        Intent i = new Intent(this, TaskDetailActivity.class);
        i.putExtra(DATA, task);
        startActivity(i);
    }

    @Override
    public void showNoTask() {
        mNoTaskView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @OnClick(R.id.fab)
    public void onClick(View view) {
        mActionListener.addNewTask();
    }
}
