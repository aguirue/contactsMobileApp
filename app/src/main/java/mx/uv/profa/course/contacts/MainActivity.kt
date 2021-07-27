package mx.uv.profa.course.contacts

import Fragments.ContactDetailFragment
import adapters.ContactsAdapter
import Model.Contact
import adapters.ContactAdapterListener
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import mx.uv.profa.course.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ContactAdapterListener {

    private lateinit var binding: ActivityMainBinding
    private val  contacts = ArrayList<Contact>()

    private val adapter by lazy {
      ContactsAdapter(contacts, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.setHasFixedSize(true)
        //Como vemos el
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.layoutManager =  layoutManager

        binding.recyclerView.adapter= adapter

        loadContact()
    }

    private fun loadContact(){
        Contact.loadContact {
            contacts.addAll(it)
            adapter.notifyDataSetChanged()
        }

    }

    override fun onContactSelected(contact: Contact) {
        Toast.makeText(this, "Selecciono Tarjeta", Toast.LENGTH_SHORT).show()


        val params = Bundle()
        params.putSerializable("object_contact", contact)

        val detailFragment=ContactDetailFragment()
        detailFragment.arguments=params
        supportFragmentManager.beginTransaction().add(R.id.main_frame, detailFragment).addToBackStack("ContactDetailFragment").commit()

    }

    override fun sendEmailSelected(contact: Contact) {
        //Toast.makeText(this, "Enviar correo", Toast.LENGTH_SHORT).show()
        val email = Uri.parse("mailto:${contact.email}")
        val intent = Intent(Intent.ACTION_SENDTO,email)
        startActivity(intent)

    }

}