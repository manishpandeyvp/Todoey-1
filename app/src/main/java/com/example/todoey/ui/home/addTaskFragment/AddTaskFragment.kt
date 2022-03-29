package com.example.todoey.ui.home.addTaskFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.add_task_fragment.*

class AddTaskFragment : Fragment() {

    private lateinit var viewModel: AddTaskViewModel
//    private val firebaseAuth : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_task_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddTaskViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        btn_save.setOnClickListener{
            val title = ev_title.text.toString()
            val desc = ev_desc.text.toString()
            val task = Task(1, title, desc, "");
            viewModel.addTask(task)
        }
    }

//    private fun getCurrentUserUID(): String {
//        val currentUser = firebaseAuth.currentUser
//        var currentUserID = ""
//        if (currentUser != null) {
//            currentUserID = currentUser.uid
//        }
//        return currentUserID
//    }

}