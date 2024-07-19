package com.rapidor.shoppingmart.view.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.airbnb.lottie.LottieDrawable
import com.rapidor.shoppingmart.R
import com.rapidor.shoppingmart.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater, container, false)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment2)
            }, 3000)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAnimation()
    }

    private fun setUpAnimation() {
        binding.apply {
            splashScreenLottieAnimation.setAnimation(R.raw.splash_animation)
            splashScreenLottieAnimation.repeatCount = LottieDrawable.INFINITE
            splashScreenLottieAnimation.playAnimation()
        }
    }

}