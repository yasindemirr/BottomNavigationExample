package com.demir.bottomsheetexample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.demir.bottomsheetexample.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment()  {
private lateinit var binding : FragmentBottomSheetBinding


override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View {
    binding = FragmentBottomSheetBinding.inflate(
        inflater,
        container,
        false
    )
    return binding.root
}

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.tvSave.setOnClickListener {
        Toast.makeText(activity,"File saved", Toast.LENGTH_LONG).show()
    }

    binding.tvLink.setOnClickListener {
        Toast.makeText(activity,"Link copied", Toast.LENGTH_LONG).show()

    }

    binding.tvShare.setOnClickListener {
        share()
    }

}

private fun share() {
    val type = "text/plain"
    val shareWith = "Share With"
    val subject = "This app is cool"
    val intent = Intent(Intent.ACTION_SEND)
    intent.putExtra(Intent.EXTRA_SUBJECT,subject)
    intent.type = type
    startActivity(Intent.createChooser(intent,shareWith))
}
}