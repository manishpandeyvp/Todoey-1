package com.example.todoey.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.todoey.R
import com.example.todoey.ui.home.addTaskFragment.AddTaskFragment
import com.example.todoey.ui.home.allTasksFragment.AllTasksFragment
import com.example.todoey.utils.Communicator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), Communicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setFragment(AllTasksFragment())
        bottom_nav.selectedItemId = R.id.menu_all_tasks
    }

    override fun onResume() {
        super.onResume()
        bottom_nav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_all_tasks -> {
                    setFragment(AllTasksFragment())
                    true
                }
                R.id.menu_add_task -> {
                    setFragment(AddTaskFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun postTaskSaved() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, AllTasksFragment())
        bottom_nav.selectedItemId = R.id.menu_all_tasks
    }
}