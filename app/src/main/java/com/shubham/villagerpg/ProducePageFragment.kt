package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.ProducePageBinding


class ProducePageFragment : Fragment() {

    private lateinit var binding: ProducePageBinding
    private lateinit var data: SharedPreferences
    private var user = User()
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    lateinit var mainHandler: Handler
    private var seedList: MutableList<Inventory> = mutableListOf()
    private var itemList: MutableList<Inventory> = mutableListOf()
    private var farmSelected = 0
    private var campSelected = 0
    private val busy = "busy"
    private val ready = "ready"

    private val updateScreenTask = object : Runnable {
        override fun run() {
            user.money++
            for (i in 10000..10007) {
                if (user.farmStatus[i - 10000] == 1) {
                    if (System.currentTimeMillis() >= user.plantStopTime[i - 10000]) {
                        user.farmStatus[i - 10000] = 2
                    }
                }
            }
            for (i in 30000..30007) {
                if (user.campStatus[i - 30000] == 1) {
                    if (System.currentTimeMillis() >= user.produceStopTime[i - 30000]) {
                        user.campStatus[i - 30000] = 2
                    }
                }
            }
            setScreenData()
            val title = "Produce"
            binding.head.title.text = title
            mainHandler.postDelayed(this, 1000)
        }
    }

    private fun setScreenData() {
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.xp.text = user.xp.toString()
        binding.head.stamina.text = user.stamina.toString()

        for (i in 10000..10007) {
            when {
                user.farmStatus[i - 10000] == 0 -> binding.root.findViewById<TextView>(i).text = ""
                user.farmStatus[i - 10000] == 1 -> binding.root.findViewById<TextView>(i).text =
                    busy
                else -> binding.root.findViewById<TextView>(i).text = ready
            }
        }

        for (i in 30000..30007) {
            when {
                user.campStatus[i - 30000] == 0 -> binding.root.findViewById<TextView>(i).text = ""
                user.campStatus[i - 30000] == 1 -> binding.root.findViewById<TextView>(i).text =
                    busy
                else -> binding.root.findViewById<TextView>(i).text = ready
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.produce_page, container, false
        )

        data = requireActivity().getSharedPreferences("VillageRPGData", Context.MODE_PRIVATE)
        user = if (data.contains("User")) {
            UserFunctions.fetchUser(data)
        } else {
            user.also {
                user.lastOnline = System.currentTimeMillis()
                UserFunctions.saveUser(user, data)
            }
        }

        mainHandler = Handler(Looper.getMainLooper())

        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao
        IDAssign.assign(binding)
        setListeners()
        setScreenData()
        binding.plantButton.isEnabled = false
        binding.farmPage.visibility = View.GONE
        binding.producePage.visibility = View.GONE

        return binding.root
    }

    private fun setListeners() {
        for (i in 10000..10007)
            binding.root.findViewById<TextView>(i).setOnClickListener {
                farmSelected = i - 10000
                when {
                    user.farmStatus[i - 10000] == 0 -> {
                        binding.farmPage.visibility = View.VISIBLE
                        seedList = inventoryDatabase.getAvailableByType("seed")

                        val names: MutableList<String> = mutableListOf()
                        var text: String
                        for (j in seedList.indices) {
                            text = seedList[j].name + " (" + seedList[j].quantity + ")"
                            names.add(text)
                        }

                        val adapter: ArrayAdapter<String> =
                            ArrayAdapter<String>(
                                this.requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                names
                            )
                        binding.cropDropdown.adapter = adapter
                    }
                    user.farmStatus[i - 10000] == 1 -> {
                        Toast.makeText(
                            context,
                            "not ready - ${(user.plantStopTime[i - 10000] - System.currentTimeMillis()) / 1000} seconds left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        user.farmStatus[i - 10000] = 0
                        val cropSelectedId =
                            inventoryDatabase.getCorresponding(user.farmCrop[i - 10000].toLong())
                        val cropSelected = inventoryDatabase.get(cropSelectedId)
                        println(cropSelected?.name)
                        if (cropSelected != null) {
                            cropSelected.quantity++
                            user.xp += cropSelected.xp
                            inventoryDatabase.update(cropSelected)
                        }
                        binding.farmPage.visibility = View.GONE
                    }
                }
            }

        for (i in 30000..30007)
            binding.root.findViewById<TextView>(i).setOnClickListener {
                campSelected = i - 30000
                when {
                    user.campStatus[i - 30000] == 0 -> {
                        binding.producePage.visibility = View.VISIBLE
                        itemList = inventoryDatabase.getAvailableItem("item")

                        val names: MutableList<String> = mutableListOf()
                        var text: String
                        for (j in itemList.indices) {
                            text = itemList[j].name + " (" + itemList[j].quantity + ")"
                            names.add(text)
                        }

                        val adapter: ArrayAdapter<String> =
                            ArrayAdapter<String>(
                                this.requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                names
                            )
                        binding.itemDropdown.adapter = adapter
                    }
                    user.campStatus[i - 30000] == 1 -> {
                        Toast.makeText(
                            context,
                            "not ready - ${(user.produceStopTime[i - 30000] - System.currentTimeMillis()) / 1000} seconds left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        user.campStatus[i - 30000] = 0
                        val itemSelected =
                            inventoryDatabase.get(user.produceItem[i - 30000].toLong())
                        if (itemSelected != null) {
                            itemSelected.quantity++
                            user.xp += itemSelected.xp
                            inventoryDatabase.update(itemSelected)
                        }
                        binding.producePage.visibility = View.GONE
                    }
                }
            }

        binding.cropDropdown.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                binding.plantButton.isEnabled = true
                val cropSelected = seedList[binding.cropDropdown.selectedItemPosition]

                binding.cropSeedTime.text = (cropSelected.time / 1000).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                binding.plantButton.isEnabled = false
            }
        }
        binding.plantButton.setOnClickListener {
            val cropSelected = seedList[binding.cropDropdown.selectedItemPosition]

            cropSelected.quantity--
            inventoryDatabase.update(cropSelected)

            binding.root.findViewById<TextView>(farmSelected + 10000).text = busy

            user.farmCrop[farmSelected] = cropSelected.id
            user.farmStatus[farmSelected] = 1
            user.plantStopTime[farmSelected] = System.currentTimeMillis() + cropSelected.time
            binding.farmPage.visibility = View.GONE

        }

        binding.produceButton.setOnClickListener {
            val itemSelected = itemList[binding.itemDropdown.selectedItemPosition]

            if (itemSelected.cost <= user.money) {
                binding.root.findViewById<TextView>(campSelected + 30000).text = busy
                user.money -= itemSelected.cost
                user.produceItem[campSelected] = itemSelected.id
                user.campStatus[campSelected] = 1
                user.produceStopTime[campSelected] = System.currentTimeMillis() + itemSelected.time
                binding.producePage.visibility = View.GONE
            } else Toast.makeText(context, "Not enough money", Toast.LENGTH_SHORT).show()
        }

        binding.itemDropdown.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                binding.plantButton.isEnabled = true
                val itemSelected = itemList[position]

                binding.itemCost.text = itemSelected.cost.toString()
                binding.itemTime.text = (itemSelected.time / 1000).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                binding.plantButton.isEnabled = false
            }
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