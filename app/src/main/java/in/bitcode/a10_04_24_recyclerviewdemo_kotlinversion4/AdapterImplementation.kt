package `in`.bitcode.a10_04_24_recyclerviewdemo_kotlinversion4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class AdapterImplementation(private var posts : ArrayList<Post>,
                            private var advertisements : ArrayList<Advertisement>) :
                            RecyclerView.Adapter<ViewHolder>() {

                                interface OnPostClickListener{
                                    fun onPostClick(position : Int, post : Post)
                                }

    var onPostClickListener : OnPostClickListener? = null

    val VIEW_TYPE_POST = 1
    val VIEW_TYPE_ADVT = 2

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

    interface OnAdvertisementClickListener{
         fun onAdvertisementClick(position : Int, advertisement: Advertisement)
    }

    var advertisement : Advertisement? = null

    inner class AdvertisementViewHolder(private  val view : View) : RecyclerView.ViewHolder(view){
        var txtAdvertisement : TextView
        init {
            txtAdvertisement = view.findViewById(R.id.txtAdvertisement)
        }
    }

    override fun getItemCount(): Int {
       return posts.size + advertisements.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       if (viewType == VIEW_TYPE_POST){
           var layoutInflater = LayoutInflater.from(parent.context)
           var postView = layoutInflater.inflate(R.layout.post_view,null)
           return PostViewHolder(postView)
       } else {
           var layoutInflater = LayoutInflater.from(parent.context)
           var advertisementView = layoutInflater.inflate(R.layout.advertisement_view, null)
           return AdvertisementViewHolder(advertisementView)
       }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is PostViewHolder){
            val post = posts[position - position/3]
            holder.txtUsername.text = post.username
            holder.txtPostTitle.text = post.title
            holder.imagePost.setImageResource(post.imageId)
        }
        if (holder is AdvertisementViewHolder){
            val advertisement = advertisements[position/2 - 1]
            holder.txtAdvertisement.text = advertisement.title
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if(position % 3 == 2){
            VIEW_TYPE_ADVT
        } else {
            VIEW_TYPE_POST
        }
    }
}