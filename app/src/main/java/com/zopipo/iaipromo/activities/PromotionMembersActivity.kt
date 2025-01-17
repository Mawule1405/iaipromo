package com.zopipo.iaipromo.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zopipo.iaipromo.R
import com.zopipo.iaipromo.modeles.datas.TestData
import com.zopipo.iaipromo.shared.Toasts
import com.zopipo.iaipromo.shared.adapters.MembreAdapter

class PromotionMembersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_promotion_members)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idPromotion = intent.getIntExtra("promotion_id", -1)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val navTv = findViewById<TextView>(R.id.navTv)

        if(idPromotion < 0){
            Intent(this, ConnectActivity::class.java ).also {
                startActivity(it)
            }
        }else{

            val promotion = TestData().getPromotion(idPromotion)
            if (promotion != null) {
                navTv.text = promotion.titre
                val recyclerView: RecyclerView = findViewById(R.id.membersRecyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = MembreAdapter(promotion.membres)
            }

        }

        backBtn.setOnClickListener{
            Intent(this, ConnectActivity::class.java).also {
                startActivity(it)
            }
        }



    }


}