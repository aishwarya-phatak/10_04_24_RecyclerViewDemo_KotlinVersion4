package `in`.bitcode.a10_04_24_recyclerviewdemo_kotlinversion4

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterImplementation(private var posts : ArrayList<Post>,
                            private var advertisements : ArrayList<Advertisement>) :
                            RecyclerView.Adapter<ViewHolder>() {

    inner class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        var txtUsername : TextView
        var imagePost : ImageView
        var txtPostTitle : TextView

        init {
            txtUsername = view.findViewById(R.id.txtUsername)
            imagePost = view.findViewById(R.id.imagePost)
            txtPostTitle = view.findViewById(R.id.txtPostTitle)
        }

//1.       lateinit var txtUsername : TextView
//2.       var imagePost : ImageView? = null
//3.       var txtPostTitle : TextView = view.findViewById(R.id.txtPostTitle)
//
//4.       init {
//
//        }
    }

    inner class AdvertisementViewHolder(private  val view : View) : RecyclerView.ViewHolder(view){
        var txtAdvertisement : TextView
        init {
            txtAdvertisement = view.findViewById(R.id.txtAdvertisement)
        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}