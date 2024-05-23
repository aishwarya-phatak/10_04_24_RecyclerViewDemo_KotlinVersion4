package `in`.bitcode.a10_04_24_recyclerviewdemo_kotlinversion4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerViewPostAdvt: RecyclerView
    private val posts = ArrayList<Post>()
    private val advertisements = ArrayList<Advertisement>()
    private lateinit var postsAdapter : AdapterImplementation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initData()
        initViews()
    }

    fun initViews(){
        recyclerViewPostAdvt = findViewById(R.id.recyclerViewPostAdvt)
        recyclerViewPostAdvt.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
            postsAdapter = AdapterImplementation(posts,advertisements)
            recyclerViewPostAdvt.adapter = postsAdapter
    }

    fun initData(){
        for (i in 1..10){
            posts.add(
                Post("post $i", "postTitle $i",R.drawable.ic_launcher_background)
            )
        }

        for (i in 1..10){
            advertisements.add(Advertisement("adv $i ", "AdvUrl $i"))
        }
    }
}