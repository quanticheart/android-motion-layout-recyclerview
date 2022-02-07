package br.com.appfactory.androidmotionlayoutrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.view.*

class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity(R.layout.activity_main) {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            supportActionBar?.hide()
            val list = mutableListOf<String>()
            (1..100).forEachIndexed { index, _ ->
                list.add("Item $index")
            }
            rvContent.run {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ItemAdapter(list)
            }
        }
    }
}

class ItemAdapter(
    private val items: List<String>
) : RecyclerView.Adapter<VH>() {

    override fun getItemCount(): Int = items.count()

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.text.text = items[position]
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)
        )
    }
}

class VH(parent: View) : RecyclerView.ViewHolder(parent) {
    val text: TextView = parent.textView
}