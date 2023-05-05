package com.example.sampleproject_mobileapplicationdevelopment_kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.R
import com.example.sampleproject_mobileapplicationdevelopment_kotlin.models.Expenses
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddNewExpense : AppCompatActivity() {

    private lateinit var Expamount:EditText
    private lateinit var Expname:EditText
    private lateinit var Expdate:EditText
    private lateinit var Expcategory:Spinner
    private lateinit var AddNew: Button


    private lateinit var dbref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_expense)

        Expamount = findViewById(R.id.addAmount)
        Expname = findViewById(R.id.ViewExpName)
        Expdate= findViewById(R.id.AddExpDate)
        Expcategory= findViewById(R.id.AddExpCat)
        AddNew = findViewById(R.id.AddExpBtn)

        dbref = FirebaseDatabase.getInstance().getReference("Expenses")

        AddNew.setOnClickListener{
            saveExpenseData()
        }
    }

    private fun saveExpenseData() {

        val addExpname = Expname.text.toString()
        val addExpamount = Expamount.text.toString()
        val addExpdate = Expdate.text.toString()
        val addExpCategory = Expcategory.selectedItem.toString()

        if(addExpamount.isEmpty()){
            Expamount.error ="please enter amount"
        }
        else if(addExpname.isEmpty()){
            Expname.error ="please enter name"
        }
        else if(addExpdate.isEmpty()){
            Expdate.error ="please enter a date"
        }

        else {
            val expId = dbref.push().key!!

            val expense = Expenses(expId, addExpamount, addExpname, addExpdate, addExpCategory)

            dbref.child(expId).setValue(expense)
                .addOnCompleteListener {
                    Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
                    val intent = Intent(this@AddNewExpense, ExpenseHome::class.java)
                    startActivity(intent)
                    finish()
                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }
        }


    }
}
