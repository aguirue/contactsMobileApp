package adapters

import Model.Contact
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mx.uv.profa.course.contacts.databinding.ItemContactBinding

class ContactViewHolder(val binding:ItemContactBinding): RecyclerView.ViewHolder(binding.root) {

    fun binData(contact: Contact, listener: ContactAdapterListener){
        with(binding){
            if (contact.photo != null){
                Glide.with(binding.root.context).load(contact.photo).into(itemContactAvatar)
            }
            itemContactName.text= contact.name
            itemContactOcupation.text = contact.ocupation

            itemContactEmail.setOnClickListener{
                listener.sendEmailSelected(contact)
            //Toast.makeText(root.context, contact.name, Toast.LENGTH_SHORT).show()
            }

            root.setOnClickListener{
                listener.onContactSelected(contact)
            }

        }
    }
}