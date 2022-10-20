package com.myultimate.core.view.view.loading

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.*
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.myultimate.core.view.R

/**
 * Created by Hans on 19/10/22.
 */
class LoadingFragment : DialogFragment() {
    private var vFragment: View? = null
    private var loadingListener: LoadingListener? = null
    private var dFragment: DialogFragment? = null
    private var onTimeoutText: String? = null
    private var countDownTimer: CountDownTimer? = null
    private var timeoutDuration: Long = DEFAULT_TIMEOUT

    private lateinit var loading: LottieAnimationView

    fun setOnTimeoutListener(loadingListener: LoadingListener?) {
        this.loadingListener = loadingListener
    }

    fun setTimeoutDuration(duration: Long) {
        timeoutDuration = duration
    }

    fun cancelTimeoutTimer() {
        countDownTimer?.cancel()
    }

    fun createTimeoutTimer() {
        countDownTimer = object : CountDownTimer(timeoutDuration, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                if (onTimeoutText != null) {
                    Toast.makeText(context, onTimeoutText, Toast.LENGTH_SHORT).show()
                }
                if (dialog != null) {
                    try {
                        //handling crash on save state illegal
                        dialog!!.dismiss()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
                loadingListener?.onTimeout()

                try {
                    //handling crash on save state illegal
                    dismissAllowingStateLoss()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        vFragment = inflater.inflate(R.layout.fragment_loading, container, false)

        dFragment = DialogFragment()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        isCancelable = false

        return vFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loading = view.findViewById(R.id.loading)

        try {
            loading.setAnimation("loading.json")
            loading.repeatCount = LottieDrawable.INFINITE
            loading.playAnimation()
            createTimeoutTimer()
            countDownTimer?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onStart() {
        super.onStart()

        /*
         * set the dim opacity to 80%
         */

        val window = dialog?.window
        window?.attributes?.let { windowParams ->
            windowParams.dimAmount = 0.80f
            windowParams.flags = windowParams.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
            window.attributes = windowParams
        }

    }

    fun setOnTimeoutToast(onTimeoutText: String?) {
        this.onTimeoutText = onTimeoutText
    }

    override fun onDestroyView() {
        val dialog = dialog
        // handles https://code.google.com/p/android/issues/detail?id=17423
        if (retainInstance) {
            dialog?.setDismissMessage(null)
        }
        try {
            countDownTimer?.cancel()
        } catch (e: Exception) {
            e.printStackTrace()
            //usecase.logError(LoadingFragment::class.java.simpleName, e, HashMap<K, V>())
        }
        super.onDestroyView()
    }

    companion object {
        const val DEFAULT_TIMEOUT = 60000L

        fun newInstance(bundle: Bundle?): LoadingFragment {
            val fragment = LoadingFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}