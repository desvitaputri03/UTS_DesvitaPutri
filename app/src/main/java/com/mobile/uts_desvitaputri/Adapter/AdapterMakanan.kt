package com.mobile.uts_desvitaputri.Adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mobile.uts_desvitaputri.DetailMakananActivity
import com.mobile.uts_desvitaputri.Model.ModelMakanan
import com.mobile.uts_desvitaputri.R
import com.mobile.uts_desvitaputri.RecycleMakanan

class AdapterMakanan (
    private val getActivity: RecycleMakanan,
    private val makananList: List<ModelMakanan>

) : RecyclerView.Adapter<AdapterMakanan.MyViewHolder>(){
    class MyViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        val txtMakanan : TextView = itemView.findViewById(R.id.txtMakanan)
        val imgMakanan : ImageView = itemView.findViewById(R.id.imgMakanan)
        val cardMakanan : CardView = itemView.findViewById(R.id.cardMakanan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_custom_makanan, parent, false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return makananList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtMakanan.text = makananList[position].title
        holder.imgMakanan.setImageResource(makananList[position].image)

        holder.cardMakanan.setOnClickListener(){
            Toast.makeText(getActivity, makananList[position].title, Toast.LENGTH_SHORT).show()
        }

        //tambahkan intent untuk kepasing data ke detail
        holder.itemView.setOnClickListener(){

            //deklarasi intent
            val intent = Intent(getActivity, DetailMakananActivity::class.java)
            //put extra
            intent.putExtra("image",makananList[position].image)
            intent.putExtra("title",makananList[position].title)

            //intent.putExtra("judul",itemList[position].judul)
            //start pindah ke detail
            getActivity.startActivity(intent)
        }
    }
}