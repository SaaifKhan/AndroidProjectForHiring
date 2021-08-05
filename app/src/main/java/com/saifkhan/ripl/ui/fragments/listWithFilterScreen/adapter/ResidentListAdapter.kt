package com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saifkhan.ripl.databinding.ItemDistrictListBinding
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.EducationModel
import com.saif.hiringproject.data.models.MartialStatusModel
import com.saifkhan.ripl.data.models.MasterModel
import com.saifkhan.ripl.databinding.ItemListResidentBinding

class ResidentListAdapter(
    val list: ArrayList<MasterModel>,
    private val listener: ClickItemListener
) :
    RecyclerView.Adapter<ResidentListAdapter.ViewHolder>() {

    interface ClickItemListener {
        fun onClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemListResidentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = list[position]
        holder.bind.tvHeading.text="NAME: "+""+model.NameOfPerson.toString()
        holder.bind.tvCity.text="Gender: "+""+model.Gender.toString()
        holder.bind.tvAge.text="Age: "+""+model.Age.toString()

        when(model.Gender){
            "0" -> {
                holder.bind.tvCity.text = "Male".toString()
            }
            "1" -> {
                holder.bind.tvCity.text = "Female".toString()
            }
            "-1" -> {
                holder.bind.tvCity.text = "not Specified".toString()
            }
        }


        holder.itemView.setOnClickListener {
            listener.onClicked(position)
        }


    }


    inner class ViewHolder(private var binding: ItemListResidentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }
}