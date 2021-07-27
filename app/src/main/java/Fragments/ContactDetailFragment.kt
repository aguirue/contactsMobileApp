package Fragments

import Model.Contact
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import mx.uv.profa.course.contacts.R
import mx.uv.profa.course.contacts.databinding.FragmentContactDetailBinding


class ContactDetailFragment : Fragment() {

    private lateinit var binding: FragmentContactDetailBinding
    private var contact =Contact()

    //inicializar el layout correspondiente y obtener referencias a controles
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContactDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val parameter = requireArguments().getSerializable("object_contact") as? Contact
        if (parameter!=null){
            contact = parameter
        }
        showContactInfo()
    }

    private fun showContactInfo(){
        with(binding){
            root.setOnClickListener{ }

            Glide.with(root.context).load(contact.photo).into(contactDetailAvatar)


            contactDetailName.text = contact.name
            contactDetailOcupation.text = contact.ocupation
            contactDetailEmail.text = contact.email
            contactDetilPhone.text = contact.phone
        }
    }

}