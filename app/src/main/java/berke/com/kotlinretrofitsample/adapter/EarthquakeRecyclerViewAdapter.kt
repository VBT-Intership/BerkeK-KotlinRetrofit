package berke.com.kotlinretrofitsample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EarthquakeRecyclerViewAdapter(
        var mylist: List<String>
) : RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.CustomViewHolder>() {
    override fun getItemCount(): Int {
        return mylist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.one_row_earthquake, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.itemView.apply {
            Glide.with(this)
                    .load(mylist[position])
                    .centerCrop()
                    .into(mylist)
        }
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}