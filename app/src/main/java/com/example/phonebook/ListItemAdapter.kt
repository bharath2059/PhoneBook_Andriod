package com.example.phonebook

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.phonebook.databinding.ListitemBinding


class ListItemAdapter(val clickListener :(contactId:Long)->Unit) : ListAdapter<Contact, ListItemAdapter.ListItemViewHolder>(ContactDiffItem()){

    var data = listOf<Contact>()
    set (value) {
        field = value
        notifyDataSetChanged()
    }

    //override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder = ListItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }

      class ListItemViewHolder(val binding: ListitemBinding) : RecyclerView.ViewHolder(binding.root){

       //   val contactName = rootView.findViewById<TextView>(R.id.contactName)

          companion object {
             fun inflateFrom(parent: ViewGroup) : ListItemViewHolder{
                 val layoutInflater = LayoutInflater.from(parent.context)
                 val binding = ListitemBinding.inflate(layoutInflater,parent,false)
              //   val view = layoutInflater.inflate(R.layout.listitem, parent, false) as CardView
                 return ListItemViewHolder(binding)
              }

          }
          fun bind(item : Contact,clickListener :(contactId:Long)->Unit) {
            binding.listItem = item

              binding.root.setOnClickListener(){
                  clickListener(item.contactId)
              }

          }
      }


}