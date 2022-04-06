package com.example.todoey.ui.home.allTasksFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoey.R
import com.example.todoey.model.adapters.PinnedTaskAdapter
import com.example.todoey.model.adapters.TasksAdapter
import kotlinx.android.synthetic.main.all_tasks_fragment.*
import kotlinx.coroutines.launch

class AllTasksFragment : Fragment() {

    private lateinit var viewModel: AllTasksViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.all_tasks_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AllTasksViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()

        iv_fun_fact.clipToOutline = true

        getAndSetAllTasksList()
        getAndSetPinnedTasksList()

        lifecycleScope.launch {
            tv_fun_fact.text = viewModel.getFact().toString()
        }
    }

    private fun getAndSetAllTasksList() {
        rv_all.layoutManager = LinearLayoutManager(context)
        val adapter = TasksAdapter()
        rv_all.adapter = adapter

        viewModel.getTasks().observe(this) { tasks ->
            if (tasks.isNotEmpty()) {
                tv_no_all_notes.visibility = View.GONE
                rv_all.visibility = View.VISIBLE
            } else {
                tv_no_all_notes.visibility = View.VISIBLE
                rv_all.visibility = View.GONE
            }
            adapter.setData(tasks)
        }
    }

    private fun getAndSetPinnedTasksList() {
        rv_pinned.layoutManager = LinearLayoutManager(context)
        val adapter = PinnedTaskAdapter()
        rv_pinned.adapter = adapter

        viewModel.getPinnedTasks().observe(this) { tasks ->
            if (tasks.isNotEmpty()) {
                tv_no_pinned_notes.visibility = View.GONE
                rv_pinned.visibility = View.VISIBLE
            } else {
                tv_no_pinned_notes.visibility = View.VISIBLE
                rv_pinned.visibility = View.GONE
            }
            adapter.setData(tasks)
        }
    }

}