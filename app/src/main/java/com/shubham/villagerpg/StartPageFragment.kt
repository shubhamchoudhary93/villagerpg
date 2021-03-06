package com.shubham.villagerpg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.shubham.villagerpg.data.DatabaseCreate
import com.shubham.villagerpg.data.User
import com.shubham.villagerpg.data.UserFunctions
import com.shubham.villagerpg.databinding.StartPageBinding

class StartPageFragment : Fragment() {

    private lateinit var binding: StartPageBinding
    private lateinit var data: SharedPreferences
    var user = User()

    private fun setScreenData() {
        user = UserFunctions.calculateLevel(user)
        binding.head.name.text = user.name
        binding.head.money.text = user.money.toString()
        binding.head.gold.text = user.gold.toString()
        binding.head.level.text = user.level.toString()
        binding.head.food.text = user.food.toString()
        val xpText = user.xp.toString() + "/" + user.nextXp.toString()
        binding.head.xp.text = xpText
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.start_page, container, false
        )

        setDATA()

        setScreenData()
        setListeners()
        val title = "VillageRPG"
        binding.head.title.text = title
        return binding.root
    }

    private fun setDATA() {
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
    }

    private fun setListeners() {
        binding.produceButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_producePageFragment)
        }
        binding.manufactureButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_manufacturePageFragment)
        }
        binding.marketButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_marketPageFragment)
        }
        binding.inventoryButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_inventoryPageFragment)
        }
        binding.exploreButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_explorePageFragment)
        }
        binding.questButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_questPageFragment)
        }
        binding.statsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(R.id.action_startPageFragment_to_statsPageFragment)
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