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
    private lateinit var allTasksAdapter: TasksAdapter
    private lateinit var pinnedTaskAdapter: PinnedTaskAdapter


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

        initAdapters()
        observe()

        lifecycleScope.launch {
            tv_fun_fact.text = viewModel.getFact().toString()
        }
    }

    private fun initAdapters() {
        rv_all.layoutManager = LinearLayoutManager(context)
        allTasksAdapter = TasksAdapter()
        rv_all.adapter = allTasksAdapter

        rv_pinned.layoutManager = LinearLayoutManager(context)
        pinnedTaskAdapter = PinnedTaskAdapter()
        rv_pinned.adapter = pinnedTaskAdapter
    }

    private fun observe() {
        viewModel.getTasks().observe(this) { tasks ->
            if (tasks.isNotEmpty()) {
                tv_no_all_notes.visibility = View.GONE
                rv_all.visibility = View.VISIBLE
            } else {
                tv_no_all_notes.visibility = View.VISIBLE
                rv_all.visibility = View.GONE
            }
            allTasksAdapter.setData(tasks)
        }

        viewModel.getPinnedTasks().observe(this) { tasks ->
            if (tasks.isNotEmpty()) {
                tv_no_pinned_notes.visibility = View.GONE
                rv_pinned.visibility = View.VISIBLE
            } else {
                tv_no_pinned_notes.visibility = View.VISIBLE
                rv_pinned.visibility = View.GONE
            }
            pinnedTaskAdapter.setData(tasks)
        }
    }

}