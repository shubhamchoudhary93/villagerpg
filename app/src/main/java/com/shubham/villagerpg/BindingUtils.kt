package com.shubham.villagerpg

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.shubham.villagerpg.data.Inventory

@BindingAdapter("nameString")
fun TextView.setNameString(item: Inventory) {
    item.let {
        text = item.name
    }
}

@BindingAdapter("quantityString")
fun TextView.setQuantityString(item: Inventory) {
    item.let {
        text = item.quantity.toString()

    }
}

@BindingAdapter("costString")
fun TextView.setCostString(item: Inventory) {
    item.let {
        text = item.cost.toString()

    }
}

@BindingAdapter("sellString")
fun TextView.setSellString(item: Inventory) {
    item.let {
        text = item.sell.toString()

    }
}
