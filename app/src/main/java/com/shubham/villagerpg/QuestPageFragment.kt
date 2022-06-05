package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.villagerpg.data.*
import com.shubham.villagerpg.databinding.QuestPageBinding

class QuestPageFragment : Fragment() {

    private lateinit var binding: QuestPageBinding
    private lateinit var questDatabase: QuestDatabaseDao
    private lateinit var data: SharedPreferences
    var user = User()

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
            R.layout.quest_page, container, false
        )

        questDatabase = QuestDatabase.getInstance(requireContext()).questDatabaseDao

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

        setScreenData()

        val list = questDatabase.getAvailable()

        val adapter = QuestPageAdaptor(QuestPageAdaptor.QuestListener {

            val actionDetail =
                QuestPageFragmentDirections.actionQuestPageFragmentToQuestDetailsPageFragment()
            actionDetail.id = it
            view?.findNavController()?.navigate(actionDetail)
        })

        binding.list.adapter = adapter

        adapter.submitList(list)
        val title = "Quest"
        binding.head.title.text = title
        return binding.root
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