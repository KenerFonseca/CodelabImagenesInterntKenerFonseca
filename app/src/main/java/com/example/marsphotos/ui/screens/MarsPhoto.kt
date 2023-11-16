package com.example.marsphotos.ui.screens
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//Se crea una clase de datos para representar una foto
@Serializable
data class MarsPhoto(val id: String, @SerialName("img_src") val imgSrc: String)