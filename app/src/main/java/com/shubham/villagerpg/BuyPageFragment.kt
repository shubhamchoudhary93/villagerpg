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
import com.shubham.villagerpg.data.UserFunctions.calculateLevel
import com.shubham.villagerpg.databinding.BuyPageBinding
import kotlin.math.floor

class BuyPageFragment : Fragment() {

    private lateinit var binding: BuyPageBinding
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var data: SharedPreferences
    private var user = User()
    private var inventorySelected: Inventory = Inventory()
    private var max = 0

    lateinit var mainHandler: Handler

    private val updateScreenTask = object : Runnable {
        override fun run() {
            setScreenData()
            mainHandler.postDelayed(this, 1000)
        }
    }

    private fun setScreenData() {
        user = calculateLevel(user)
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
            R.layout.buy_page, container, false
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
        binding.buyButtonLayout.visibility = View.GONE
        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao
        fetchAdaptor()
        setListeners()
        val text = "Market: Buy"
        binding.head.title.text = text
        return binding.root
    }

    private fun fetchAdaptor() {
        val list = inventoryDatabase.getAllBuy(user.level)

        val adapter = BuyPageAdaptor(BuyPageAdaptor.InventoryListener {
            binding.buyButtonLayout.visibility = View.VISIBLE
            inventorySelected = inventoryDatabase.get(it)!!
            binding.inventorySelected.text = inventorySelected.name
            max = floor((user.money / inventorySelected.cost).toDouble()).toInt()
            binding.maxInventory.text = max.toString()
        })

        binding.list.adapter = adapter

        adapter.submitList(list)
    }

    private fun setListeners() {
        binding.buyButton.setOnClickListener {
            val q = binding.quantityBuy.text.toString().toInt()
            if (q <= max) {
                val cost = q * inventorySelected.cost
                if (cost <= user.money)
                    inventorySelected.quantity += q
                inventoryDatabase.update(inventorySelected)
                user.money -= cost
                binding.buyButtonLayout.visibility = View.GONE
                fetchAdaptor()
            } else Toast.makeText(context, "Max quantity can be $max.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
        mainHandler.removeCallbacks(updateScreenTask)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
        mainHandler.post(updateScreenTask)
    }
}