package com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saifkhan.ripl.databinding.ItemDistrictListBinding
import com.saif.hiringproject.data.models.DistrictModel
import com.saif.hiringproject.data.models.EducationModel
import com.saif.hiringproject.data.models.MartialStatusModel

class EducationAdapter(
    val list: ArrayList<EducationModel>,
    private val listener: ClickItemListener
) :
    RecyclerView.Adapter<EducationAdapter.ViewHolder>() {

    interface ClickItemListener {
        fun onClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDistrictListBinding.inflate(
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

        holder.bind.tvDistrictNames.text = model.educationName.toString()


        holder.itemView.setOnClickListener {
            listener.onClicked(position)
        }


    }


    inner class ViewHolder(private var binding: ItemDistrictListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }
}