package com.saif.hiringproject.ui.fragments.SurveylocalityselectionFragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saifkhan.ripl.databinding.ItemTehsilsListBinding
import com.saif.hiringproject.data.models.TeshsilModel

class TehsilsAdapter(
    val list: ArrayList<TeshsilModel>,
    private val listener: ClickItemListener
) :
    RecyclerView.Adapter<TehsilsAdapter.ViewHolder>() {



    interface ClickItemListener {
        fun onClicked(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTehsilsListBinding.inflate(
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

        holder.bind.tvTehsilsName.text = model.tehName.toString()



        holder.itemView.setOnClickListener {
            listener.onClicked(position)
        }


    }


    inner class ViewHolder(private var binding: ItemTehsilsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val bind = binding
    }
}