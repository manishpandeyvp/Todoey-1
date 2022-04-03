package com.example.todoey.ui.home.addTaskFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todoey.MyApplication
import com.example.todoey.R
import com.example.todoey.databinding.AddTaskFragmentBinding
import kotlinx.android.synthetic.main.add_task_fragment.*

class AddTaskFragment : Fragment() {

    private lateinit var viewModel: AddTaskViewModel
    private lateinit var binding: AddTaskFragmentBinding
    private lateinit var selectedColor: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddTaskFragmentBinding.inflate(inflater, container, false)
        return binding.root
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
//        view?.setOnClickListener{ view ->
//            when(view){
//                orangePicker -> setColor(orangePicker)
//                purplePicker -> setColor(purplePicker)
//                yellowPicker -> setColor(yellowPicker)
//                pinkPicker -> setColor(pinkPicker)
//                greenPicker -> setColor(greenPicker)
//                redPicker -> setColor(redPicker)
//            }
//        }
    }

    private fun setColor(view: ImageView) {
        selectedColor.setImageResource(0)
        print("Clicked")
        view.setImageDrawable(
            AppCompatResources.getDrawable(
                MyApplication.getContext(),
                R.drawable.ic_check
            )
        )
        when (view) {
            orangePicker -> setBgColor(R.color.orange)
            purplePicker -> setBgColor(R.color.purple)
            yellowPicker -> setBgColor(R.color.yellow)
            pinkPicker -> setBgColor(R.color.pink)
            greenPicker -> setBgColor(R.color.green)
            redPicker -> setBgColor(R.color.red)
        }
        selectedColor = view
    }

    private fun setBgColor(color: Int) {
        ll_add_task.background = AppCompatResources.getDrawable(MyApplication.getContext(), color)
    }

}