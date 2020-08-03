package com.mmy.yiyi.commadapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton

/*
 * 
 * 创建自帅气的 清川 on 2020/7/3
 * kotlin 的适配器 格式 多条目
 */
/*class KotlinRecyclerviewAdapter(var data:List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val TYPE0 = 1000

    class viewHolder (itemView:View?): RecyclerView.ViewHolder(itemView) {
        fun addTitle(data:String,isShow:Boolean){
            itemView.fragemnt4_item_layout_title.text=data
            if(isShow){
                itemView.fragemnt4_item_layout_line.visibility=View.VISIBLE
            }else{
                itemView.fragemnt4_item_layout_line.visibility=View.GONE
            }

        }
    }

    class viewHolder0 (itemView:View?): RecyclerView.ViewHolder(itemView) {
        fun addTitle(data:String,isShow:Boolean){
            itemView.fragemnt4_item_layout0_check.isChecked=Constans().isShowShiju
            if(isShow){
                itemView.fragemnt4_item_layout_line.visibility=View.VISIBLE
            }else{
                itemView.fragemnt4_item_layout_line.visibility=View.GONE
            }

        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is viewHolder){
            if(data.size-1==position){
                holder.addTitle(data[position],false)
            }else{
                holder.addTitle(data[position],true)
            }
            holder.itemView.setOnClickListener {
                if(onItemClickListener!=null){
                    onItemClickListener.onClick(it,position)
                }
            }
            holder.itemView.setOnLongClickListener {
                if(onItemClickListener!=null){
                    onItemClickListener.onLongClick(it,position)
                }
                true
            }
        }else{
            holder.itemView.fragemnt4_item_layout0_check.isChecked=Constans().isShowShiju
        }

    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener=onItemClickListener
        //notifyItemChanged()
    }
    private lateinit var onItemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onClick(view: View, position: Int)
        fun onLongClick(view: View, position: Int)
        fun onCheckedClick(view: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType==TYPE0){
            val view0 = from(parent?.context).inflate(
                R.layout.fragment4_recycler_item_layout0,
                parent,
                false
            )
            return viewHolder0(view0)
        }
        val view = from(parent?.context).inflate(
            R.layout.fragment4_recycler_item_layout,
            parent,
            false
        )
        return viewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        if(position==0){
            return TYPE0
        }
        return super.getItemViewType(position)
    }


}
*/


