package com.shubham.villagerpg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.InventoryDatabase
import com.shubham.villagerpg.data.InventoryDatabaseDao
import com.shubham.villagerpg.databinding.InventoryPageBinding

class InventoryPageFragment : Fragment() {

    private lateinit var binding: InventoryPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.inventory_page, container, false
        )

        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao

        val list = inventoryDatabase.getAvailable()

        val adapter = InventoryPageAdaptor(InventoryPageAdaptor.InventoryListener {
            Toast.makeText(context, "yayy", Toast.LENGTH_SHORT).show()
        })

        binding.list.adapter = adapter

        adapter.submitList(list)
        val title = "Inventory"
        binding.head.title.text = title
        return binding.root
    }

}