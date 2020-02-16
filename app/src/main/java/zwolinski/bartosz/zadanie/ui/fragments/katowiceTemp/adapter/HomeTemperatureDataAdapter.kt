package zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zwolinski.bartosz.zadanie.R
import zwolinski.bartosz.zadanie.ui.fragments.katowiceTemp.adapter.viewHolders.TemperatureDataViewHolder

class HomeTemperatureDataAdapter : RecyclerView.Adapter<TemperatureDataViewHolder>() {

    var items: List<String> = listOf()
        set(value) {
            field = value.take(LIST_ITEM_LIMIT)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemperatureDataViewHolder {
        return TemperatureDataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_home_temperature_data,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TemperatureDataViewHolder, position: Int) {
        holder.bind(items[position], (position + 1).toString())
    }

    override fun getItemCount(): Int = items.size

    companion object {
        const val LIST_ITEM_LIMIT = 10
    }

}