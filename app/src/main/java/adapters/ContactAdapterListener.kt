package adapters

import Model.Contact

interface ContactAdapterListener {

    fun onContactSelected(contact: Contact)
    fun sendEmailSelected(contact: Contact)

}