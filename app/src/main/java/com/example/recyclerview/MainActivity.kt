package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.databinding.RowBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var imgRes = intArrayOf(R.drawable.imgflag1,R.drawable.imgflag2,R.drawable.imgflag3,R.drawable.imgflag4,
            R.drawable.imgflag5,R.drawable.imgflag6,R.drawable.imgflag7,R.drawable.imgflag8)

    var data1 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = RecyclerAdapter()
        binding.recycler1.adapter = adapter1

        binding.recycler1.layoutManager = LinearLayoutManager(this)

    }

    //RecyclerView의  Adapter 클래스
    inner class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolderClass>() {

        //ViewHolder 클래스
        inner class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
            //val rowImageView = itemView.findViewById<ImageView>(R.id.rowImageView)
            //val rowTextView =  itemView.findViewById<TextView>(R.id.rowTextView)
            var rowView = itemView as RowBinding
            val rowImageView = rowView.rowImageView
            val rowTextView = rowView.rowTextView

            override fun onClick(v: View?) {
                binding.textView.text = data1[adapterPosition]
            }
        }

        //항목 구성을 위해 사용할  ViewHolder 객체가 필요할 때 호출되는 메소드
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
            //val itemView = layoutInflater.inflate(R.layout.row, null)
            val itemView = RowBinding.inflate(layoutInflater)
            val view = itemView.root
            val holder = ViewHolderClass(view)
            view.setOnClickListener(holder)

            return holder
        }

        //ViewHolder를 통해 항목을 구성할 때 항목 내의 View 객체에 데이터를 셋팅한다.
        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]
        }

        //
        override fun getItemCount(): Int {
            return imgRes.size
        }
    }
}