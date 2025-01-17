package com.zopipo.iaipromo.activities.ui.compte

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zopipo.iaipromo.databinding.FragmentCompteBinding
import com.zopipo.iaipromo.models.models.Nationalite
import com.zopipo.iaipromo.models.models.Utilisateur
import com.zopipo.iaipromo.shared.adapters.PromotionAdapter
import com.zopipo.iaipromo.shared.adapters.PromotionLvAdapter
import com.zopipo.iaipromo.shared.dialogbots.DialogBotYesNo
import com.zopipo.iaipromo.shared.gadgets.Camera


class CompteFragment : Fragment() {

    private var _binding: FragmentCompteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private  var imageUri: Uri? = null
    private val cameraRequestId = 1222
    private val RESULT_LOAD_IMAGE = 123
    lateinit var  studentImageView : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val compteViewModel =
            ViewModelProvider(this).get(CompteViewModel::class.java)

        _binding = FragmentCompteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val compte = compteViewModel.compte
        val promotions = compte.promotions
        val listView: ListView = binding.pomotionLv

        val nomTv : TextView = binding.nomTv
        val emailTv : TextView = binding.emailTv
        val phoneTv : TextView = binding.phoneTv
        val nationaliteTv : TextView = binding.nationaliteTv
        val cvTv : TextView = binding.cvTv

        val nomIv : ImageView = binding.editFullnameIv
        val emailIv : ImageView = binding.editEmailIv
        val phoneIv : ImageView = binding.editPhoneIv
        val nationaliteIv : ImageView = binding.editNationalityIv
        val cvIv : ImageView =  binding.cvIv

        val cameraIv : ImageView = binding.cameraIv
        val galleryIv : ImageView = binding.galleryIv
        val cameraTv : TextView = binding.cameraTv
        val galleryTv : TextView = binding.galleryTv
        studentImageView = binding.photoIv


        chargement(compte, nomTv, emailTv, phoneTv, nationaliteTv, cvTv )
        val adapter = PromotionLvAdapter(requireContext(), promotions)
        listView.adapter = adapter
        
        listView.setOnItemClickListener { parent, view, position, id ->

            val dialog = DialogBotYesNo(context = requireContext(),
                title = "Confirmation",
                message = "Voullez-vous vous retirer de la ${promotions[position].titre}\n ${promotions[position].description}",
                positiveButtonAction = {},
                negativeButtonAction = {}
                )
            dialog.showDialog()
        }

        cameraTv.setOnClickListener{ openCamera() }
        galleryTv.setOnClickListener{ openGallery() }
        cameraIv.setOnClickListener{ openCamera()}
        galleryIv.setOnClickListener{ openGallery()}


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun chargement(compte: Utilisateur, nomTv : TextView, emailTv : TextView, phoneTv : TextView,
                   nationaliteTv: TextView, cvTv : TextView ){

        nomTv.text = compte.nom+" "+compte.prenom
        emailTv.text = compte.email
        phoneTv.text = compte.phoneNumber
        nationaliteTv.text = compte.nationalite.libelle
        cvTv.text = compte.cv


    }

    fun openGallery(){
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent, RESULT_LOAD_IMAGE)
    }

    fun openCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        imageUri = requireContext().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        startActivityForResult(cameraIntent, cameraRequestId)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == cameraRequestId){

            Log.e(TAG, "Example Item: " + data?.data)
            //studentImageView.setImageURI(imageUri)
            Glide.with(this)
                .load(imageUri)
                .into(studentImageView)
            if(imageUri != null) {
                studentImageView = binding.photoIv
            }

        }
        else if(requestCode == RESULT_LOAD_IMAGE)
        {
            imageUri = data?.data
            //studentImageView.setImageURI(data?.data)
            if(imageUri != null){
                Glide.with(this)
                    .load(imageUri)
                    .into(studentImageView)
            }else{
                studentImageView = binding.photoIv
            }


        }

    }



}