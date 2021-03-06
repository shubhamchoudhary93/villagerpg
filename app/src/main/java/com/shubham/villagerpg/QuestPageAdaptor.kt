package com.shubham.villagerpg

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shubham.villagerpg.data.Quest
import com.shubham.villagerpg.databinding.QuestPageItemBinding

class QuestPageAdaptor(val clickListener: QuestListener) :
    ListAdapter<Quest, QuestPageAdaptor.ViewHolder>(QuestDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: QuestPageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Quest,
            clickListener: QuestListener
        ) {
            binding.quest = item
            binding.executePendingBindings()
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = QuestPageItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    class QuestDiffCallback : DiffUtil.ItemCallback<Quest>() {
        override fun areItemsTheSame(oldItem: Quest, newItem: Quest): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Quest, newItem: Quest): Boolean {
            return oldItem == newItem
        }
    }

    class QuestListener(val clickListener: (id: Long) -> Unit) {
        fun onClick(quest: Quest) = clickListener(quest.id.toLong())
    }
}