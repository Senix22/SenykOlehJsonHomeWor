package com.senix22.jsonhomework

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Me(
    @SerializedName("I")
    val name: String,
    val dad : Father,
    val mother : Mother,
    val age : Int,
    val IsAdult: Boolean
)
data class Father(
    @SerializedName("Father")
    val name:String,
    val age : Int,
    val isAdult: Boolean,
    val mother : String,
    val father: String
)
data class Mother (
    @SerializedName("Mother")
    val name : String,
    val age:Int,
    val isAdult: Boolean,
    val mother: String,
    val father : String
)

enum class Grandparents(val value: String) {

    DadMom ("Alla"),
    DadFather ("Leonid"),
    MomMom("Olha"),
    MomFather("Stanislav")

}



fun main() {

    val gson = Gson()


    println(gson.toJson(Me("Oleh", Father("Serhi",42,true,Grandparents.DadMom.value,Grandparents.DadFather.value),
        Mother("Veronika",44,true,Grandparents.MomMom.value,Grandparents.MomFather.value),20, true)).toString())

    val str = """{"I":"Oleh","dad":{"Father":"Serhi","age":42,"isAdult":true,"mother":"Alla","father":"Leonid"},"mother":{"Mother":"Veronika","age":44,"isAdult":true,"mother":"Olha","father":"Stanislav"},"age":20,"IsAdult":true}"""

    println(gson.fromJson<Me>(str, Me::class.java))

}
