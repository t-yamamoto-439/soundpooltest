package jp.techacademy.takanari.soundpooltest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import jp.techacademy.takanari.soundpooltest.SoundDto
import kotlinx.android.synthetic.main.item_recycler_view.view.*

class MainActivityAdapter(
    private var mListData: ArrayList<SoundDto>,
    private val onItemClick: (item: Int) -> Unit = {}
): RecyclerView.Adapter<MainActivityAdapter.ViewHolder>() {


    // 1
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var contentTitle = itemView.findViewById(R.id.contentText) as TextView
    }

    // 2
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.item_recycler_view, p0, false)
        val vh = ViewHolder(view)
        //配列押した時
        return vh
    }

    // 3
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if(mListData[position].addflag){
            holder.itemView.setBackgroundColor(Color.rgb(127, 127, 255))
        }
        else if (!mListData[position].addflag){
            holder.itemView.setBackgroundColor(Color.rgb(255,255,255))
        }

        holder.itemView.contentText.setOnClickListener {
            //配列の背景の色変更
            onItemClick(position)

            if (mListData[position].addflag==false) {
                mListData[position].addflag=true
                holder.itemView.setBackgroundColor(Color.rgb(127, 127, 255))

            }else if (mListData[position].addflag==true){
                mListData[position].addflag=false
                holder.itemView.setBackgroundColor(Color.rgb(255,255,255))
            }
        }
//
//        holder.contentTitle.text = mListData[position].test
//
//        if (mListData[position].test2 == true) {
//            holder.contentTitle.setBackgroundColor(Color.rgb(127, 127, 255))       }
    }

    // 4
    override fun getItemCount() = mListData.size
}
