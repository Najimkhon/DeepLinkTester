package com.example.deeplinktester.ui.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.deeplinktester.databinding.FragmentHomeBinding
import com.example.deeplinktester.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun setListeners() {
        binding.btnCheck.setOnClickListener{
            if (binding.etInput.text.toString().isNotEmpty()){
                try {
                    var myAction = Uri.parse(binding.etInput.text.toString())
                    val intent = Intent(Intent.ACTION_VIEW, myAction)
                    startActivity(intent)
                }catch (e: ActivityNotFoundException){
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }else{
                Toast.makeText(requireContext(), "Please, enter your link", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
