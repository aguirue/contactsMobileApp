package adapters

import Model.Contact
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import mx.uv.profa.course.contacts.databinding.ItemContactBinding

class ContactsAdapter(val contacts: ArrayList<Contact>, val listener: ContactAdapterListener): Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemContactBinding.inflate(inflater,parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.binData(contact, listener)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}