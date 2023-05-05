package com.example.sampleproject_mobileapplicationdevelopment_kotlin.models

class ExpenseData {

    var ExpName:String?=null
    var Expamount:String?=null
    var Expdate:String?=null
    var ExpCategory:String?=null

    constructor(ExpName:String?, Expamount:String?, ExpDate:String,ExpCat:String){

        this.ExpName=ExpName
        this.Expamount = Expamount
        this.Expdate= ExpDate
        this.ExpCategory=ExpCat


    }
    constructor(){

    }
}