package Model.Services

import Model.Contact
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConectionManager {

    private fun create():Services{
        val retrofitBuilder = Retrofit.Builder()
        retrofitBuilder.baseUrl("https://www.uv.mx")

        val gsonBuilder = GsonBuilder()
        gsonBuilder.excludeFieldsWithoutExposeAnnotation()

        val factory = GsonConverterFactory.create(gsonBuilder.create())
        retrofitBuilder.addConverterFactory(factory)

        val retrofit = retrofitBuilder.build()

        return  retrofit.create(Services::class.java)
    }

    fun requestContacts(success:(ArrayList<Contact>)->Unit, fail: (String)-> Unit){
        val call = create().requestContacts()
        call.enqueue(object: Callback<ArrayList<Contact>>{

            override fun onResponse(call: Call<ArrayList<Contact>>, response: Response<ArrayList<Contact>>) {
                val contacts = response.body()
                if(contacts!=null){
                    //Hay datos
                    success(contacts)
                }else{
                    //Hubo problemas al parsear los datos
                    fail("No hay datos")
                }
            }

            override fun onFailure(call: Call<ArrayList<Contact>>, t: Throwable) {
                //Hubo un error
                fail("Ocurrio un error en la conexión")
            }

        })
    }

}