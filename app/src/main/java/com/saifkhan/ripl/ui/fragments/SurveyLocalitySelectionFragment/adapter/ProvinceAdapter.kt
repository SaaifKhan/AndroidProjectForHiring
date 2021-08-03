package com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saifkhan.ripl.databinding.ItemProvinceListBinding
import com.saif.hiringproject.data.models.ProvinceModel

class ProvinceAdapter(
    val list: ArrayList<ProvinceModel>,
    private val listener: ClickItemListener
) :
    RecyclerView.Adapter<ProvinceAdapter.ViewHolder>() {

    interface ClickItemListener {
        fun onClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProvinceListBinding.inflate(
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

        holder.bind.tvProvinceNames.text = model.prName.toString()

        holder.itemView.setOnClickListener {
            listener.onClicked(position)
        }
    }


    inner class ViewHolder(private var binding: ItemProvinceListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }
}