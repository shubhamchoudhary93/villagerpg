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
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.ManufacturePageBinding

class ManufacturePageFragment : Fragment() {

    private lateinit var binding: ManufacturePageBinding
    private lateinit var data: SharedPreferences
    private var user = User()
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var finishRequirementDatabase: FinishRequirementDatabaseDao

    //lateinit var mainHandler: Handler
    private var productList: MutableList<Inventory> = mutableListOf()
    private var factorySelected = 0
    private var foodList: MutableList<Inventory> = mutableListOf()
    private var kitchenSelected = 0
    private val busy = "busy"
    private val ready = "ready"
    private lateinit var oldColors: ColorStateList

//    private val updateScreenTask = object : Runnable {
//        override fun run() {
//            for (i in 0..7) {
//                if (user.factory[i].status == 1) {
//                    if (System.currentTimeMillis() >= user.factory[i].stopTime) {
//                        user.factory[i].status = 2
//                    }
//                }
//
//                if (user.kitchen[i].status == 1) {
//                    if (System.currentTimeMillis() >= user.kitchen[i].stopTime) {
//                        user.kitchen[i].status = 2
//                    }
//                }
//            }
//
//            setScreenData()
//            mainHandler.postDelayed(this, 1000)
//        }
//    }

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
        val xpText = user.xp.toString() + "/" + user.nextXp.toString()
        binding.head.xp.text = xpText

        for (i in 0..7) {
            when (user.factory[i].status) {
                0 -> binding.root.findViewById<TextView>(i + 10000).text =
                    ""
                1 -> binding.root.findViewById<TextView>(i + 10000).text =
                    busy
                else -> binding.root.findViewById<TextView>(i + 10000).text = ready
            }

            when (user.kitchen[i].status) {
                0 -> binding.root.findViewById<TextView>(i + 20000).text =
                    ""
                1 -> binding.root.findViewById<TextView>(i + 20000).text =
                    busy
                else -> binding.root.findViewById<TextView>(i + 20000).text = ready
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.manufacture_page, container, false
        )

        data = requireActivity().getSharedPreferences("VillageRPGData", Context.MODE_PRIVATE)
        user = if (data.contains("User")) {
            UserFunctions.fetchUser(data)
        } else {
            user.also {
                user.lastOnline = System.currentTimeMillis()
                user.lastOnlineStamina = System.currentTimeMillis()
                UserFunctions.saveUser(user, data)
                DatabaseCreate.createFirst(requireContext())
            }
        }

        //mainHandler = Handler(Looper.getMainLooper())

        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao
        finishRequirementDatabase =
            FinishRequirementDatabase.getInstance(requireContext()).finishRequirementDatabaseDao
        IDAssign.assign(binding)
        setListeners()
        setScreenData()
        val title = "Manufacture"
        binding.cookButton.isEnabled = false
        binding.manufactureButton.isEnabled = false
        binding.head.title.text = title
        binding.manufacturePage.visibility = View.GONE
        binding.kitchenPage.visibility = View.GONE
        oldColors = binding.itemCost.textColors
        return binding.root
    }

    private fun setListeners() {
        for (i in 0..7) {
            binding.root.findViewById<TextView>(i + 10000).setOnClickListener {
                factorySelected = i
                when (user.factory[i].status) {
                    0 -> {
                        binding.kitchenPage.visibility = View.GONE
                        binding.manufacturePage.visibility = View.VISIBLE
                        productList = inventoryDatabase.getAvailableItem("product", user.level)

                        val names: MutableList<String> = mutableListOf()
                        var text: String
                        for (j in productList.indices) {
                            text = productList[j].name + " (" + productList[j].quantity + ")"
                            names.add(text)
                        }

                        val adapter: ArrayAdapter<String> =
                            ArrayAdapter<String>(
                                this.requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                names
                            )
                        binding.productDropdown.adapter = adapter
                    }
                    1 -> {
                        binding.manufacturePage.visibility = View.GONE
                        Toast.makeText(
                            context,
                            "not ready - ${(user.factory[i].stopTime - System.currentTimeMillis()) / 1000} seconds left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        user.factory[i].status = 0

                        val productSelected =
                            inventoryDatabase.getName(user.factory[i].item)
                        if (productSelected != null) {
                            productSelected.quantity++
                            user.xp += productSelected.xp
                            inventoryDatabase.update(productSelected)
                        }
                        user.factory[i].item = ""
                        user.factory[i].stopTime = 0L
                        binding.manufacturePage.visibility = View.GONE
                    }
                }
            }

            binding.root.findViewById<TextView>(i + 20000).setOnClickListener {
                kitchenSelected = i
                when (user.kitchen[i].status) {
                    0 -> {
                        binding.manufacturePage.visibility = View.GONE
                        binding.kitchenPage.visibility = View.VISIBLE
                        foodList = inventoryDatabase.getAvailableItem("food", user.level)

                        val names: MutableList<String> = mutableListOf()
                        var text: String
                        for (j in foodList.indices) {
                            text = foodList[j].name + " (" + foodList[j].quantity + ")"
                            names.add(text)
                        }

                        val adapter: ArrayAdapter<String> =
                            ArrayAdapter<String>(
                                this.requireContext(),
                                android.R.layout.simple_spinner_dropdown_item,
                                names
                            )
                        binding.foodDropdown.adapter = adapter
                    }
                    1 -> {
                        binding.kitchenPage.visibility = View.GONE
                        Toast.makeText(
                            context,
                            "not ready - ${(user.kitchen[i].stopTime - System.currentTimeMillis()) / 1000} seconds left",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else -> {
                        user.kitchen[i].status = 0

                        val foodSelected =
                            inventoryDatabase.getName(user.kitchen[i].item)
                        println(foodSelected?.name)
                        if (foodSelected != null) {
                            foodSelected.quantity++
                            user.xp += foodSelected.xp
                            inventoryDatabase.update(foodSelected)
                        }
                        user.kitchen[i].item = ""
                        user.kitchen[i].stopTime = 0L
                        binding.kitchenPage.visibility = View.GONE
                    }
                }
            }

        }
        binding.productDropdown.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    binding.manufactureButton.isEnabled = true
                    val itemSelected = productList[position]

                    binding.itemCost.text = itemSelected.cost.toString()
                    binding.itemTime.text = (itemSelected.time / 1000).toString()
                    if (itemSelected.cost >= user.money) {
                        binding.itemCost.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        binding.itemCost.setTextColor(oldColors)
                    }

                    val requirementList = finishRequirementDatabase.getByRequirementID(
                        itemSelected.name
                    )

                    val inventoryList = mutableListOf<Inventory>()

                    for (i in requirementList.indices) {
                        inventoryDatabase.getName(requirementList[i].inventory)
                            ?.let { it1 -> inventoryList.add(it1) }
                    }
                    var text = ""
                    for (i in requirementList.indices) {
                        text =
                            text + inventoryList[i].name + " " + requirementList[i].quantity + "\n"
                    }

                    binding.requirementsManufacture.text = text
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    binding.manufactureButton.isEnabled = false
                }
            }

        binding.foodDropdown.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View,
                    position: Int,
                    id: Long
                ) {
                    binding.cookButton.isEnabled = true
                    val foodSelected = foodList[position]

                    binding.foodCost.text = foodSelected.cost.toString()
                    binding.foodTime.text = (foodSelected.time / 1000).toString()

                    if (foodSelected.cost >= user.money) {
                        binding.foodCost.setTextColor(Color.parseColor("#FF0000"))
                    } else {
                        binding.foodCost.setTextColor(oldColors)
                    }

                    val requirementList = finishRequirementDatabase.getByRequirementID(
                        foodSelected.name
                    )

                    val inventoryList = mutableListOf<Inventory>()

                    for (i in requirementList.indices) {
                        inventoryDatabase.getName(requirementList[i].inventory)
                            ?.let { it1 -> inventoryList.add(it1) }
                    }
                    var text = ""
                    for (i in requirementList.indices) {
                        text =
                            text + inventoryList[i].name + " " + requirementList[i].quantity + "\n"
                    }

                    binding.requirementsCooking.text = text
                }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    binding.cookButton.isEnabled = false
                }
            }

        binding.manufactureButton.setOnClickListener {
            if (productList.size >= 1) {
                val productSelected = productList[binding.productDropdown.selectedItemPosition]
                if (productSelected.cost <= user.money) {
                    val requirementList = finishRequirementDatabase.getByRequirementID(
                        productSelected.name
                    )

                    val inventoryList = mutableListOf<Inventory>()

                    for (i in requirementList.indices) {
                        inventoryDatabase.getName(requirementList[i].inventory)
                            ?.let { it1 -> inventoryList.add(it1) }
                    }

                    var canManufacture = 0
                    for (i in requirementList.indices) {
                        if (requirementList[i].quantity <= inventoryList[i].quantity) canManufacture += 1
                    }

                    println(canManufacture)
                    println(requirementList.size)
                    if (canManufacture == requirementList.size) {
                        user.money -= productSelected.cost
                        for (i in requirementList.indices) {
                            inventoryList[i].quantity =
                                inventoryList[i].quantity - requirementList[i].quantity
                            inventoryDatabase.update(inventoryList[i])
                        }

                        binding.root.findViewById<TextView>(factorySelected + 10000).text =
                            busy

                        user.factory[factorySelected].item = productSelected.name
                        user.factory[factorySelected].status = 1
                        user.factory[factorySelected].stopTime =
                            System.currentTimeMillis() + productSelected.time
                        binding.manufacturePage.visibility = View.GONE
                    } else Toast.makeText(context, "Requirements not met", Toast.LENGTH_SHORT)
                        .show()

                } else Toast.makeText(context, "Not enough money", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cookButton.setOnClickListener {
            if (foodList.size >= 1) {
                val foodSelected = foodList[binding.foodDropdown.selectedItemPosition]
                if (foodSelected.cost <= user.money) {
                    val requirementList = finishRequirementDatabase.getByRequirementID(
                        foodSelected.name
                    )

                    val inventoryList = mutableListOf<Inventory>()

                    for (i in requirementList.indices) {
                        inventoryDatabase.getName(requirementList[i].inventory)
                            ?.let { it1 -> inventoryList.add(it1) }
                    }

                    var canCook = 0
                    for (i in requirementList.indices) {
                        if (requirementList[i].quantity <= inventoryList[i].quantity) canCook += 1
                    }

                    if (canCook == requirementList.size) {
                        user.money -= foodSelected.cost
                        for (i in requirementList.indices) {
                            inventoryList[i].quantity =
                                inventoryList[i].quantity - requirementList[i].quantity
                            inventoryDatabase.update(inventoryList[i])
                        }

                        binding.root.findViewById<TextView>(kitchenSelected + 20000).text = busy

                        user.kitchen[kitchenSelected].item = foodSelected.name
                        user.kitchen[kitchenSelected].status = 1
                        user.kitchen[kitchenSelected].stopTime =
                            System.currentTimeMillis() + foodSelected.time
                        binding.kitchenPage.visibility = View.GONE
                    } else Toast.makeText(context, "Requirements not met", Toast.LENGTH_SHORT)
                        .show()

                } else Toast.makeText(context, "Not enough money", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        user.lastOnline = System.currentTimeMillis()
        UserFunctions.saveUser(user, data)
//        mainHandler.removeCallbacks(updateScreenTask)
    }

    override fun onResume() {
        super.onResume()
        user = UserFunctions.fetchUser(data)
//        mainHandler.post(updateScreenTask)
    }
}