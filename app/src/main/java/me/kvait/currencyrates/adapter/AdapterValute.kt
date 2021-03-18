package me.kvait.currencyrates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_currency.view.*
import me.kvait.currencyrates.R
import me.kvait.currencyrates.model.SimpleRate

class AdapterValute(private val listValute: List<SimpleRate>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
    private val list = listValute


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false)
        return ValuteViewHolder(this, view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder as ValuteViewHolder) {
            bind(list[position])
        }
    }

    override fun getItemCount() = list.count()

    class ValuteViewHolder(val adapter: AdapterValute, view: View) : RecyclerView.ViewHolder(view) {
        fun bind(valute: SimpleRate) {
            with(itemView) {
                char_code.text = valute.charCode
                currency_name.text = valute.name
                currency_min.text = context.getString(R.string.min1) + valute.nominal.toString() + context.getString(R.string.min2)
                rate.text = valute.value.toString()
            }
        }
    }
}