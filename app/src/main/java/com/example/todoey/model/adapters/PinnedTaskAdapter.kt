package com.example.todoey.model.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import kotlinx.android.synthetic.main.item_note.view.*

class PinnedTaskAdapter : RecyclerView.Adapter<PinnedTaskAdapter.ViewHolder>() {
    private var pinnedTaskList = emptyList<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = pinnedTaskList[position]

        val view = holder.itemView
        Log.d("MANISH", task.color)
        view.cv_item_task.setCardBackgroundColor(Color.parseColor(task.color))
        view.tv_title.text = task.title
        view.tv_body.text = task.body
    }

    override fun getItemCount(): Int {
        return pinnedTaskList.size
    }

    fun setData(tasks: List<Task>) {
        this.pinnedTaskList = tasks
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}