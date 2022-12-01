package com.example.rss_aggregator_2022.features.presentation.rssmanagement

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.rss_aggregator_2022.R
import com.example.rss_aggregator_2022.databinding.FragmentUserFormBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class UserFormFragment : BottomSheetDialogFragment() {
    private var binding: FragmentUserFormBinding? = null

    private val viewModel by lazy {
        this.activity?.let {
            RssManagementFactory().injectRssManagementViewModel(it.getPreferences(Context.MODE_PRIVATE))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserFormBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    private fun setupView() {
        binding?.apply {
            bottomsheetButtonCancel.setOnClickListener() {
                findNavController().navigateUp()
            }
            bottomsheetButtonSave.setOnClickListener() {
                viewModel?.saveRss(
                    inputName.text.toString(),
                    inputUrl.text.toString()
                )
                findNavController().navigateUp()
                saveCheck()

            }
        }
    }
    private fun saveCheck(){
        val userFormSubscriber=
            Observer<UserFormViewModel.FormUiState>{
                showSnackBar(it.isSuccess)
            }
        viewModel?.movieFeedPublisher?.observe(viewLifecycleOwner,userFormSubscriber)
    }
    private fun showSnackBar(isSuccess:Boolean){
        Snackbar.make((requireActivity()).findViewById<ViewGroup>(R.id.main_fragment_view),
        if(isSuccess) {
            R.string.added_record
        }else{
            R.string.error_added_record
        },
        BaseTransientBottomBar.LENGTH_SHORT).show()
    }
}
