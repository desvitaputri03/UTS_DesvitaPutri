package com.mobile.uts_desvitaputri

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobile.uts_desvitaputri.Adapter.AdapterMakanan
import com.mobile.uts_desvitaputri.Model.ModelMakanan

class RecycleMakanan : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var adaptermakanan: AdapterMakanan? = null
    private var listmakanan = mutableListOf<ModelMakanan>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycle_makanan)
        listmakanan = ArrayList()
        recyclerView = findViewById(R.id.rv_makanan)
        adaptermakanan = AdapterMakanan(this,listmakanan)

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager (
            this,2
        )

        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = adaptermakanan

        prepareListMakanan()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun prepareListMakanan(){
        var makanan = ModelMakanan("Dimsum", R.drawable.dimsum)
        listmakanan.add(makanan)

        makanan = ModelMakanan("Sushi", R.drawable.sushi)
        listmakanan.add(makanan)

    }
}