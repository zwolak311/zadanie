package zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.adapter.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_home_temperature_data.view.*

class TemperatureDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(tempAndDateText: String, positionText: String) {
        itemView.item_home_temperature_data_tv.text = tempAndDateText
        itemView.item_home_temperature_position_tv.text = positionText
    }

}