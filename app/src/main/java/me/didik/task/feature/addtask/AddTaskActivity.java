package me.didik.task.feature.addtask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.didik.task.R;
import me.didik.task.base.BaseActivity;
import me.didik.task.model.Task;

public class AddTaskActivity extends BaseActivity implements AddTaskContract.View {

    @BindView(R.id.et_title) EditText etTitle;
    @BindView(R.id.et_desc) EditText etDesc;

    private AddTaskContract.UserActionListener mActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        unbinder = ButterKnife.bind(this);

        mActionListener = new AddTaskPresenter(this);
    }

    @OnClick(R.id.fab)
    public void onClick(View view) {
        String title = etTitle.getText().toString();
        String desc = etDesc.getText().toString();
        Task task = new Task(title, new Date(), desc);
        mActionListener.saveTask(task);
    }

    @Override
    public void backToTaskList() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
