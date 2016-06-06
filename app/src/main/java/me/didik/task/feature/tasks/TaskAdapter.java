package me.didik.task.feature.tasks;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.didik.task.R;
import me.didik.task.model.Task;


/**
 * Created by didik on 06/06/16.
 * Adapter
 */
public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private List<Task> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, created;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_title);
            created = (TextView) view.findViewById(R.id.tv_time);
        }
    }

    public TaskAdapter(List<Task> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Task article = list.get(position);


        holder.title.setText(article.getTitle());
        holder.created.setText(article.getTimestamp().toString());

        ViewCompat.setTransitionName(holder.title, String.valueOf(position) + "_title");
        ViewCompat.setTransitionName(holder.created, String.valueOf(position) + "_created");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void replaceData(List<Task> tasks) {
        setList(tasks);
        notifyDataSetChanged();
    }

    public void add(Task task, int position) {
        list.add(position, task);
        notifyItemInserted(position);
    }

    private void setList(List<Task> notes) {
        list = notes;
    }

    public Task getItem(int position) {
        return list.get(position);
    }
}
