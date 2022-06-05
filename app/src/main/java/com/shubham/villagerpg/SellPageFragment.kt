package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.SellPageBinding

class SellPageFragment : Fragment() {

    private lateinit var binding: SellPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var data: SharedPreferences
    private var user = User()
    private var inventorySelected: Inventory = Inventory()
    private var max = 0

    lateinit var mainHandler: Handler

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.sell_page, container, false
        )
        mainHandler = Handler(Looper.getMainLooper())

        data = requireActivity().getSharedPreferences("VillageRPGData", Context.MODE_PRIVATE)
        user = if (data.contains("User")) {
            UserFunctions.fetchUser(data)
        } else {
            user.also {
                user.lastOnline = System.currentTimeMillis()
                UserFunctions.saveUser(user, data)
                DatabaseCreate.createFirst(requireContext())
            }
        }
        binding.sellButtonLayout.visibility = View.GONE
        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao
        fetchAdaptor()
        setListeners()
        setScreenData()
        val title = "Market : Sell"
        binding.head.title.text = title
        return binding.root
    }

    private fun fetchAdaptor() {
        val list = inventoryDatabase.getAllSell()

        val adapter = SellPageAdaptor(SellPageAdaptor.InventoryListener {
            binding.sellButtonLayout.visibility = View.VISIBLE
            inventorySelected = inventoryDatabase.get(it)!!
            binding.inventorySelected.text = inventorySelected.name
            max = inventorySelected.quantity
            binding.maxInventory.text = max.toString()
        })

        binding.list.adapter = adapter

        adapter.submitList(list)
    }

    private fun setListeners() {
        binding.sellButton.setOnClickListener {
            val q = binding.quantitySell.text.toString().toInt()
            if (q <= max) {
                val sellAmount = q * inventorySelected.sell
                inventorySelected.quantity -= q
                inventoryDatabase.update(inventorySelected)
                user.money += sellAmount
                binding.sellButtonLayout.visibility = View.GONE
                fetchAdaptor()
            } else Toast.makeText(context, "Max quantity can be $max.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
    }
}