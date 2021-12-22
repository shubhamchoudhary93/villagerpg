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
import androidx.navigation.findNavController
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.QuestDetailsPageBinding

class QuestDetailsPageFragment : Fragment() {

    private lateinit var binding: QuestDetailsPageBinding
    private lateinit var questDatabase: QuestDatabaseDao
    private lateinit var inventoryDatabase: InventoryDatabaseDao
    private lateinit var questRewardDatabase: QuestRewardDatabaseDao
    private lateinit var data: SharedPreferences
    var user = User()
    lateinit var mainHandler: Handler

    private val updateScreenTask = object : Runnable {
        override fun run() {
            user.money++
            setScreenData()
            mainHandler.postDelayed(this, 1000)
        }
    }

    private fun setScreenData() {
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.xp.text = user.xp.toString()
        binding.head.stamina.text = user.stamina.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.quest_details_page, container, false
        )

        questDatabase = QuestDatabase.getInstance(requireContext()).questDatabaseDao
        questRewardDatabase =
            QuestRewardDatabase.getInstance(requireContext()).questRewardDatabaseDao
        inventoryDatabase = InventoryDatabase.getInstance(requireContext()).inventoryDatabaseDao

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

        mainHandler = Handler(Looper.getMainLooper())

        val id = QuestDetailsPageFragmentArgs.fromBundle(requireArguments()).id
        val quest = questDatabase.get(id)
        binding.name.text = quest?.name

        val requirementList = quest?.name?.let {
            questDatabase.getByName(
                it
            )
        }

        var text = ""
        if (requirementList != null) {
            for (i in requirementList.indices) {
                text =
                    text + requirementList[i].inventory + " " + requirementList[i].quantity + "\n"
            }
        }

        binding.requirements.text = text

        val rewardList = quest?.name?.let {
            questRewardDatabase.getByName(
                it
            )
        }

        text = ""
        if (rewardList != null) {
            for (i in rewardList.indices) {
                text =
                    text + rewardList[i].inventory + " " + rewardList[i].quantity + "\n"
            }
        }

        binding.rewards.text = text
        val title = "Quest Details"
        binding.head.title.text = title

        binding.collect.setOnClickListener {
            if (requirementList != null) {
                var trueCheck = false
                for (i in requirementList.indices) {
                    val inventory = requirementList[i].inventory
                    val quantity = requirementList[i].quantity

                    val inventoryValue = inventoryDatabase.getName(inventory)
                    if (inventoryValue != null) {
                        trueCheck = inventoryValue.quantity >= quantity
                    }
                }
                if (trueCheck) {
                    for (i in requirementList.indices) {
                        val inventory = requirementList[i].inventory
                        val quantity = requirementList[i].quantity

                        val inventoryValue = inventoryDatabase.getName(inventory)
                        if (inventoryValue != null) {
                            inventoryValue.quantity -= quantity
                            inventoryDatabase.update(inventoryValue)
                        }
                    }
                    if (rewardList != null) {
                        for (i in rewardList.indices) {
                            val inventory = rewardList[i].inventory
                            val quantity = rewardList[i].quantity

                            when (inventory) {
                                "Money" -> {
                                    user.money += quantity
                                }
                                "Gold" -> {
                                    user.gold += quantity
                                }
                                else -> {
                                    val inventoryValue = inventoryDatabase.getName(inventory)
                                    if (inventoryValue != null) {
                                        inventoryValue.quantity += quantity
                                        inventoryDatabase.update(inventoryValue)
                                    }
                                }
                            }
                        }
                    }

                    quest.completed = 1
                    questDatabase.update(quest)

                    view?.findNavController()
                        ?.navigate(R.id.action_questDetailsPageFragment_to_questPageFragment)
                } else {
                    Toast.makeText(context, "Requirements not met", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return binding.root
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