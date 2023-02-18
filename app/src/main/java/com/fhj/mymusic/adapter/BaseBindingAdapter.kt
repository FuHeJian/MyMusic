package com.fhj.mymusic.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fhj.mymusic.adapter.holder.BaseViewHolder

/**
 *
 *
 * com.fhj.mymusic.adapter
 */
abstract class BaseBindingAdapter<T,N:ViewDataBinding>(diffCallback: DiffUtil.ItemCallback<T>) :
    BaseListAdapter<T>(diffCallback) {

    private lateinit var mBinding: N

/*    protected var mOnItemClickListener: OnItemClickListener<T>? = null
    protected var mOnItemLongClickListener: OnItemLongClickListener<T>? = null

    open fun setOnItemClickListener(onItemClickListener: OnItemClickListener<T>?) {
        mOnItemClickListener = onItemClickListener
    }

    open fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener<T>?) {
        mOnItemLongClickListener = onItemLongClickListener
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<N>(
            LayoutInflater.from(parent.context),
            getLayoutId(viewType),
            parent,
            false
        )
//这里添加lifecycleowner会导致内存泄露吧
        binding.lifecycleOwner = getLifecycleOwner()
        val holder = BaseViewHolder(binding.root,binding)
/*        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(View.OnClickListener { v: View? ->
                val position: Int = holder.getBindingAdapterPosition()
                mOnItemClickListener!!.onItemClick(
                    holder.itemView.getId(),
                    getItem(position),
                    position
                )
            })
        }
        if (mOnItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(OnLongClickListener { v: View? ->
                val position: Int = holder.getBindingAdapterPosition()
                mOnItemLongClickListener!!.onItemLongClick(
                    holder.itemView.getId(),
                    getItem(position),
                    position
                )
                true
            }
            )
        }*/
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding = DataBindingUtil.getBinding<N>(holder.itemView)
        if(binding!=null)
        {
            bindItem(binding,getItem(position),position,holder.itemViewType)
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.binding?.unbind()
    }

    @LayoutRes
    abstract fun getLayoutId(viewType: Int): Int

    abstract fun bindItem(binding:N,item:T,position:Int,type:Int)

    abstract fun getLifecycleOwner():LifecycleOwner

    interface OnItemClickListener<M> {
        fun onItemClick(viewId: Int, item: M, position: Int)
    }

    interface OnItemLongClickListener<M> {
        fun onItemLongClick(viewId: Int, item: M, position: Int)
    }

}