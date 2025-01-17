package com.zopipo.iaipromo.activities.ui.Promotion


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zopipo.iaipromo.databinding.FragmentPromotionBinding
import com.zopipo.iaipromo.shared.adapters.PromotionAdapter


class PromotionFragment : Fragment() {

    private var _binding: FragmentPromotionBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val promotionViewModel =
            ViewModelProvider(this).get(PromotionViewModel::class.java)

        _binding = FragmentPromotionBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val promotions = promotionViewModel.promotions
        // Add more promotions...
        val recyclerView: RecyclerView = binding.displayPromotionRv
        val adapter = PromotionAdapter(promotions)


        // Use LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(requireContext() )
        recyclerView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}