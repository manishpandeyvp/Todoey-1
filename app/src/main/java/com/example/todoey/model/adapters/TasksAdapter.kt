package com.example.todoey.model.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import kotlinx.android.synthetic.main.item_note.view.*

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.ViewHolder>() {

    private var taskList = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = taskList[position]
        val view = holder.itemView

        view.cv_item_task.setCardBackgroundColor(Color.parseColor(task.color))
        view.tv_title.text = task.title
        view.tv_body.text = task.body
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(tasks: List<Task>) {
        this.taskList = tasks
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}