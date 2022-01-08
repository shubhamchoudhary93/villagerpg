package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.graphics.Color
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
    private lateinit var oldColors: ColorStateList
    private var first = true

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

    private val updateStamina = object : Runnable {
        override fun run() {
            if(!first) {
                user.food++
            }
            first = false
            binding.head.food.text = user.food.toString()
            mainHandler.postDelayed(this, 60000)
        }
    }

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()

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
        binding.produceButton.isEnabled = false
        binding.farmPage.visibility = View.GONE
        binding.producePage.visibility = View.GONE
        oldColors = binding.itemCost.textColors
        return binding.root
    }

    private fun setListeners() {
        for (i in 10000..10007)
            binding.root.findViewById<TextView>(i).setOnClickListener {
                farmSelected = i - 10000
                when {
                    user.farmStatus[i - 10000] == 0 -> {
                        binding.farmPage.visibility = View.VISIBLE
                        binding.producePage.visibility = View.GONE
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
                        val cropSelectedName =
                            inventoryDatabase.getCorresponding(user.farmCrop[i - 10000])
                        val cropSelected = inventoryDatabase.getName(cropSelectedName)
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
                        binding.farmPage.visibility = View.GONE
                        itemList = inventoryDatabase.getAvailableItem("raw", user.level)

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
                            inventoryDatabase.getName(user.produceItem[i - 30000])
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
            if (seedList.size >= 1) {
                val cropSelected = seedList[binding.cropDropdown.selectedItemPosition]

                cropSelected.quantity--
                inventoryDatabase.update(cropSelected)

                binding.root.findViewById<TextView>(farmSelected + 10000).text = busy

                user.farmCrop[farmSelected] = cropSelected.name
                user.farmStatus[farmSelected] = 1
                user.plantStopTime[farmSelected] = System.currentTimeMillis() + cropSelected.time
                binding.farmPage.visibility = View.GONE
            }

        }

        binding.produceButton.setOnClickListener {
            if (itemList.size >= 1) {
                val itemSelected = itemList[binding.itemDropdown.selectedItemPosition]

                if (itemSelected.cost <= user.money) {
                    binding.root.findViewById<TextView>(campSelected + 30000).text = busy
                    user.money -= itemSelected.cost
                    user.produceItem[campSelected] = itemSelected.name
                    user.campStatus[campSelected] = 1
                    user.produceStopTime[campSelected] =
                        System.currentTimeMillis() + itemSelected.time
                    binding.producePage.visibility = View.GONE
                } else Toast.makeText(context, "Not enough money", Toast.LENGTH_SHORT).show()
            }
        }

        binding.itemDropdown.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View,
                position: Int,
                id: Long
            ) {
                binding.produceButton.isEnabled = true
                val itemSelected = itemList[position]

                binding.itemCost.text = itemSelected.cost.toString()
                if (itemSelected.cost >= user.money) {
                    binding.itemCost.setTextColor(Color.parseColor("#FF0000"))
                } else {
                    binding.itemCost.setTextColor(oldColors)
                }

                binding.itemTime.text = (itemSelected.time / 1000).toString()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                binding.produceButton.isEnabled = false
            }
        }
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
        mainHandler.removeCallbacks(updateScreenTask)
        mainHandler.removeCallbacks(updateStamina)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
        mainHandler.post(updateScreenTask)
        val currentTime = System.currentTimeMillis()
        val staminaAdd: Int = ((currentTime - user.lastOnline) / 60000).toInt()
        val staminaNew = user.food + staminaAdd
        user.food = staminaNew
        mainHandler.post(updateStamina)
    }

}