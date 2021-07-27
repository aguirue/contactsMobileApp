package Model.Services

import Model.Contact
import retrofit2.Call
import retrofit2.http.GET

interface Services {
    //https://www.uv.mx/apps/hipermedios/moviles/demos/contacts.json
    @GET("/apps/hipermedios/moviles/demos/contacts.json")
    fun requestContacts(): Call<ArrayList<Contact>>


}