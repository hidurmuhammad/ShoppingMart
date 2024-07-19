package com.rapidor.shoppingmart.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rapidor.shoppingmart.R

class ModalBottomSheetDialogFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Inflating ModalSheet Layout to this fragment
        return inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backExplore = view.findViewById<Button>(R.id.btnBackToExplore)
        val btnContinue = view.findViewById<Button>(R.id.btnContinue)
        backExplore?.setOnClickListener { findNavController().navigate(R.id.action_modalBottomSheetDialogFragment_to_homeFragment2) }
        btnContinue?.setOnClickListener { findNavController().navigate(R.id.action_modalBottomSheetDialogFragment_to_addToCartFragment) }

        setUpAnimation()

    }

    private fun setUpAnimation() {
        val lottieModalBottomSheet =
            view?.findViewById<LottieAnimationView>(R.id.lottieModalBottomSheet)
        lottieModalBottomSheet?.setAnimation(R.raw.add_to_cart)
        lottieModalBottomSheet?.repeatCount = LottieDrawable.INFINITE
        lottieModalBottomSheet?.playAnimation()
    }

}



