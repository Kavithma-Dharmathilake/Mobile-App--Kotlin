package com.example.sampleproject_mobileapplicationdevelopment_kotlin.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.OneExpense
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.R
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.activity.ExpenseHome
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.models.ExpenseData
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.models.Expenses
import java.util.ArrayList


class ExpenseAdapter(private val ExpList: ArrayList<Expenses>)
    : RecyclerView.Adapter<ExpenseAdapter.ViewHolder>(){

   // private lateinit var mListner : onItemListner
    class ViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        val tvExpName:TextView = itemView.findViewById(R.id.ViewExpName)
        val tvExpAmount:TextView = itemView.findViewById(R.id.ViewExpAmount)
        val tvExpDate:TextView = itemView.findViewById(R.id.ViewExpDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseAdapter.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_of_expenses,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentExpense = ExpList[position]
        holder.tvExpName.text = currentExpense.name
        holder.tvExpAmount.text = currentExpense.amount
        holder.tvExpDate.text = currentExpense.date

    }

    override fun getItemCount(): Int {
        return ExpList.size
    }



}