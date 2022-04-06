package com.example.todoey.ui.home.addTaskFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todoey.MyApplication
import com.example.todoey.R
import com.example.todoey.model.data.task.Task
import com.example.todoey.utils.Communicator
import com.example.todoey.utils.Constants
import kotlinx.android.synthetic.main.add_task_fragment.*

class AddTaskFragment : Fragment() {

    private lateinit var viewModel: AddTaskViewModel
    private lateinit var selectedColor: ImageView
    private var color: String = Integer.toHexString(R.color.orange)
    private var pinned: Boolean = false
    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        communicator = activity as Communicator
        return inflater.inflate(R.layout.add_task_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[AddTaskViewModel::class.java]
        selectedColor = orangePicker
    }

    override fun onResume() {
        super.onResume()

        orangePicker.setOnClickListener {
            setColor(orangePicker)
        }

        purplePicker.setOnClickListener {
            setColor(purplePicker)
        }

        yellowPicker.setOnClickListener {
            setColor(yellowPicker)
        }

        pinkPicker.setOnClickListener {
            setColor(pinkPicker)
        }

        greenPicker.setOnClickListener {
            setColor(greenPicker)
        }

        redPicker.setOnClickListener {
            setColor(redPicker)
        }

        btn_pinned.setOnClickListener {
            if (pinned) {
                btn_pinned.setImageDrawable(
                    AppCompatResources.getDrawable(
                        MyApplication.getContext(),
                        R.drawable.pinned
                    )
                )
            } else {
                btn_pinned.setImageDrawable(
                    AppCompatResources.getDrawable(
                        MyApplication.getContext(),
                        R.drawable.pinned_filled
                    )
                )
            }
            pinned = !pinned
        }

        btn_save.setOnClickListener {
            val title = ev_title.text.toString()
            val body = ev_desc.text.toString()

            val task = Task(0, title, body, pinned, color)

            viewModel.addTask(task).also {
                Toast.makeText(MyApplication.getContext(), "Saved!", Toast.LENGTH_LONG).show()
                communicator.postTaskSaved()
            }
        }
    }

    private fun setColor(view: ImageView) {
        selectedColor.setImageResource(0)
        view.setImageDrawable(
            AppCompatResources.getDrawable(
                MyApplication.getContext(),
                R.drawable.ic_check
            )
        )
        when (view) {
            orangePicker -> setBgColor(R.color.orange, Constants.ORANGE)
            purplePicker -> setBgColor(R.color.purple, Constants.PURPLE)
            yellowPicker -> setBgColor(R.color.yellow, Constants.YELLOW)
            pinkPicker -> setBgColor(R.color.pink, Constants.PINK)
            greenPicker -> setBgColor(R.color.green, Constants.GREEN)
            redPicker -> setBgColor(R.color.red, Constants.RED)
        }
        selectedColor = view
    }

    private fun setBgColor(color: Int, s: String) {
        this.color = s
        ll_add_task.background = AppCompatResources.getDrawable(MyApplication.getContext(), color)
    }


}