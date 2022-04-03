package com.example.todoey.ui.home.allTasksFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoey.R

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
        getAndSetMemberList()
    }

    private fun getAndSetMemberList() {
        viewModel.getTasks().observe(this) { tasks ->
            if (tasks.isNotEmpty()) {
                Log.d("MANISH", tasks.toString())
            } else {
                Log.d("MANISH", "No tasks")
            }
        }
    }

}