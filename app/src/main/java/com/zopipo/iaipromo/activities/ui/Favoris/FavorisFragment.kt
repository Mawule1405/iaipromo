package com.zopipo.iaipromo.activities.ui.Favoris

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zopipo.iaipromo.databinding.FragmentFavorisBinding
import com.zopipo.iaipromo.shared.adapters.MembreFavorisAdapter

class FavorisFragment : Fragment() {

    private var _binding: FragmentFavorisBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val favorisViewModel =
            ViewModelProvider(this).get(FavorisViewModel::class.java)

        _binding = FragmentFavorisBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val favoris = favorisViewModel.utilisateurs2
        val recyclerView: RecyclerView = binding.displayFavorisRv
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MembreFavorisAdapter(favoris)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}