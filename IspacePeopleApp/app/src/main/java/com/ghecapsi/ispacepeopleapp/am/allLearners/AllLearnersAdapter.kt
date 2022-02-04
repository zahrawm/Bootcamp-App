package com.ghecapsi.ispacepeopleapp.am.allLearners

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ghecapsi.ispacepeopleapp.R

class AllLearnersAdapter(
    private val context: Context,
    private val learnersList: List<AllLearnersDataModel>,
    private val handleLearnerClick: HandleLearnerClick
  ):RecyclerView.Adapter<AllLearnersAdapter.AllLearnersViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllLearnersViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.learner_row_data,parent,false)
        return  AllLearnersViewHolder(rootView)
    }
    interface HandleLearnerClick{
        fun onLearnerClick(position: Int)
    }

    override fun onBindViewHolder(holder: AllLearnersViewHolder, position: Int) {
        val dataPosition = learnersList[position]

        holder.first_name.text = dataPosition.FirstName
        holder.learnerClick.setOnClickListener {
           handleLearnerClick.onLearnerClick(position)
        }

        Glide
            .with(context)
            .load(dataPosition.profileImg)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imgUrl);
    }



    override fun getItemCount(): Int {
       return learnersList.size
    }


    class AllLearnersViewHolder(LearnerView:View):RecyclerView.ViewHolder(LearnerView) {
        val imgUrl: ImageView = LearnerView.findViewById(R.id.imageView)
        val first_name: TextView = LearnerView.findViewById(R.id.textView)
        val learnerClick: CardView = LearnerView.findViewById(R.id.relaytiveLayout)
    }

}