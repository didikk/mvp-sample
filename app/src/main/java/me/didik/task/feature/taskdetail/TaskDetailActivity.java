package me.didik.task.feature.taskdetail;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.didik.task.R;
import me.didik.task.base.BaseActivity;
import me.didik.task.model.Task;

public class TaskDetailActivity extends BaseActivity implements TaskDetailContract.View {

    @BindView(R.id.tv_title) TextView tvTitle;
    @BindView(R.id.tv_time) TextView tvTime;
    @BindView(R.id.tv_desc) TextView tvDesc;

    private TaskDetailContract.UserActionListener mActionListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);
        unbinder = ButterKnife.bind(this);

        mActionListener = new TaskDetailPresenter(this);
        Task task = (Task) getIntent().getSerializableExtra(DATA);
        mActionListener.openTask(task);
    }

    @Override
    public void showTask(Task task) {
        tvTitle.setText(task.getTitle());
        tvTime.setText(task.getTimestamp().toString());
        tvDesc.setText(task.getDescription());
    }
}
