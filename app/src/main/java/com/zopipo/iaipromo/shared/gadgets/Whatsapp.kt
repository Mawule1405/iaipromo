package com.zopipo.iaipromo.shared.gadgets
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

// Data class pour la requête
data class WhatsAppMessage(
    val messaging_product: String = "whatsapp",
    val to: String,
    val type: String = "text",
    val text: TextBody
)

data class TextBody(val body: String)

// Interface API
interface WhatsAppApi {
    @POST("<phone_number_id>/messages")
    @Headers("Authorization: Bearer <access_token>", "Content-Type: application/json")
    suspend fun sendMessage(@Body message: WhatsAppMessage)
}

// Création du client Retrofit
val retrofit = Retrofit.Builder()
    .baseUrl("https://graph.facebook.com/v17.0/") // Base URL de l'API
    .addConverterFactory(GsonConverterFactory.create())
    .client(OkHttpClient())
    .build()

val api = retrofit.create(WhatsAppApi::class.java)

// Envoi du message
suspend fun sendWhatsAppMessage(number: String, verificationCode: String) {
    val message = WhatsAppMessage(
        to = number,
        text = TextBody("Votre code de réinitialisation est : $verificationCode")
    )
    api.sendMessage(message)
}
