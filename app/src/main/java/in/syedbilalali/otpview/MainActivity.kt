package `in`.syedbilalali.otpview

import `in`.syedbilalali.otptextview.OTPListener
import `in`.syedbilalali.otptextview.OtpTextView
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {
    private var otpTextView: OtpTextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val errorButton = findViewById<Button>(R.id.button)
        val successButton = findViewById<Button>(R.id.button2)
        otpTextView = findViewById(R.id.otp_view)
        otpTextView?.requestFocusOTP()
        otpTextView?.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                Toasty.success(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }
        errorButton.setOnClickListener {

            otpTextView?.showError() }
        successButton.setOnClickListener { otpTextView?.showSuccess() }
    }
}
