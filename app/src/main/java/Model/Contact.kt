package Model

import Model.Services.ConectionManager
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Contact:Serializable {

    @Expose
    @SerializedName("id")
    var idContact: Int = 0

    @Expose
    @SerializedName("name")
    var name: String= ""

    @Expose
    @SerializedName("work")
    var ocupation: String=""

    @Expose
    @SerializedName("phone")
    var phone: String =""

    @Expose
    @SerializedName("email")
    var email: String=""

    @Expose
    @SerializedName("photo")
    var photo: String? = null

    //Esta es similar a una función estática
    companion object {
        fun loadContact(completed: (ArrayList<Contact>) -> Unit) {


            ConectionManager.requestContacts(success = {
                completed(it)
            }, fail = {
                completed(ArrayList())
            })

            /* val array = ArrayList<Contact>()
            val contact01 = Contact()
            contact01.idContact = 1
            contact01.name = "Vanesa Martin"
            contact01.ocupation="Profesora"
            contact01.phone="2288591686"
            contact01.email="aguirue@gmail.com"
            contact01.photo = "https://pbs.twimg.com/profile_images/1309548192560709635/GPoDCUqE_400x400.jpg"
            array.add(contact01)

            val contact02 = Contact()
            contact02.idContact = 2
            contact02.name = "Pablo Lopez"
            contact02.ocupation="Profesor"
            contact02.phone="2288202020"
            contact02.email="aguir@gmail.com"
            contact02.photo= "https://www.cadenadial.com/wp-content/uploads/2020/02/pablo-l%C3%B3pez-720x300.jpg"
            array.add(contact02)

            val contact03 = Contact()
            contact03.idContact = 3
            contact03.name = "Luis Garcia"
            contact03.ocupation="Administrador"
            contact03.phone="2281909090"
            contact03.email="luis_garcia@gmail.com"
            contact03.photo= "https://www.elsiglodedurango.com.mx/m/i/2021/05/983788.jpeg"
            array.add(contact03)

            for(x in 1..10){
                val contact = Contact()
                contact.idContact = x
                contact.name = "Luis Garcia"
                contact.ocupation="Administrador"
                contact.phone="2281909090"
                contact.email="luis_garcia@gmail.com"
                contact.photo= "https://www.elsiglodedurango.com.mx/m/i/2021/05/983788.jpeg"
                array.add(contact)
            }





            return array
        }*/
        }
    }

}