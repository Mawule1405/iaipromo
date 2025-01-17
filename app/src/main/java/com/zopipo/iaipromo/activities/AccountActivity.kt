package com.zopipo.iaipromo.activities

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.LayoutInflaterCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Promotion
import com.zopipo.iaipromo.services.NationaliteService
import com.zopipo.iaipromo.services.PromotionService
import com.zopipo.iaipromo.shared.Toasts
import com.zopipo.iaipromo.shared.dialogbots.DialogSelect
import com.zopipo.iaipromo.shared.gadgets.ImageLoader
import org.w3c.dom.Text

class AccountActivity : AppCompatActivity() {

    private  var imageUri: Uri? = null
    private val cameraRequestId = 1222
    private val RESULT_LOAD_IMAGE = 123
    lateinit var  photoIv : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_account)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val promotionService = PromotionService()
        val nationaliteService = NationaliteService()
        val dialogSelect = DialogSelect()
        var typeRessource : Int = 0

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        photoIv = findViewById<ImageView>(R.id.photoNaIv)
        val nomEt = findViewById<EditText>(R.id.nomNaEt)
        val prenomEt : EditText = findViewById(R.id.prenomNaEt)
        val emailEt : EditText = findViewById(R.id.emailNaEt)
        val passwordEt : EditText =  findViewById(R.id.passwordNaEt)
        val telephoneEt : EditText = findViewById(R.id.telephoneNaEt)
        val nationaliteTv : TextView = findViewById(R.id.nationaliteNaTv)
        val promotionTv : TextView = findViewById(R.id.promotionNaTv)
        val cvTv : TextView = findViewById(R.id.cvNaTv)

        val loader = ImageLoader(this)
        loader.loadCircularImage(photoIv, R.drawable.defaut_member_image, R.drawable.defaut_member_image)


        photoIv.setOnClickListener{
            val list = listOf("Caméra", "Gallerie")
            dialogSelect.showRessourceSelectionDialog(
                context = this,
                layout = layoutInflater,
                ressources = list,
                actionCamera = { openCamera()},
                actionGallery = { openGallery()},
                defaultAction = {}
            )

        }

        promotionTv.setOnClickListener{

            val list = promotionService.getAllPromotion()

            dialogSelect.showPromotionSelectionDialog(
                context = this,
                layout = layoutInflater,
                textV = promotionTv,
                promotions = list
            )

        }

        nationaliteTv.setOnClickListener{

            val list = nationaliteService.getAllNationalites()
            dialogSelect.showNationaliteSelectionDialog(
                context = this,
                layout = layoutInflater,
                textV = nationaliteTv,
                nationalites = list
            )

        }
    }

    fun openCamera(){
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, RESULT_LOAD_IMAGE)
    }

    fun openGallery(){
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        imageUri = this.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(cameraIntent, cameraRequestId)
    }

    fun defaultRessourceChoice(){
        val toast = Toasts(this, "Aucun choix effectué")
        toast.errorToast()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == cameraRequestId){

            Log.e(TAG, "Example Item: " + data?.data)
            //studentImageView.setImageURI(imageUri)
            Glide.with(this)
                .load(imageUri)
                .apply(RequestOptions.circleCropTransform())
                .into(photoIv)
            if(imageUri != null) {
                //photoIv = photoIv
            }

        }
        else if(requestCode == RESULT_LOAD_IMAGE)
        {
            imageUri = data?.data
            //studentImageView.setImageURI(data?.data)
            if(imageUri != null){
                Glide.with(this)
                    .load(imageUri)
                    .apply(RequestOptions.circleCropTransform())
                    .into(photoIv)
            }else{

            }

        }

    }
}