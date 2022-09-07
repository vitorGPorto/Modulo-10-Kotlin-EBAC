package com.example.tarefa10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarefa10.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), ListAdapter.ListAdapterListener {
    private lateinit var binding: ActivityMainBinding
    private val itemList: MutableList<ContactInfo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.lista

        CreateMockData()

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter= ListAdapter(itemList,this)

    }
    private  fun CreateMockData (){
        itemList.add(ContactInfo("Andressa Vilela ","(68) 98066-8438"))
        itemList.add(ContactInfo("Aldemar ","(66) 97335-5734"))
        itemList.add(ContactInfo("Maria Beatriz","(68) 98066-8438"))
        itemList.add(ContactInfo("Lizete Araujo","(22) 99923-1249"))
        itemList.add(ContactInfo("Thamirys Net","(83) 98294-8483"))
        itemList.add(ContactInfo("Alda Gadelha","(88) 99710-0756"))
        itemList.add(ContactInfo("Márcio Barroso","(11) 99454-8642"))
        itemList.add(ContactInfo("Helenice Trindade","(98) 98596-7751"))
        itemList.add(ContactInfo("Celia Loureiro","(93) 99373-7580"))
        itemList.add(ContactInfo("Hilda Paes","(27) 97916-1283"))
    }

    override fun onItemCliked(content: String) {
        Snackbar.make(binding.root, content, Snackbar.LENGTH_SHORT).show()
    }


}