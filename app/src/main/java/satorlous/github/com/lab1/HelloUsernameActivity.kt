package satorlous.github.com.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HelloUsernameActivity : AppCompatActivity(), OnClickListener  {

    private lateinit var nameEditText : EditText
    private lateinit var messageText : TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_username)

        val btnSubmit : Button = findViewById(R.id.btn_submit)
        nameEditText = findViewById(R.id.input_name)
        messageText = findViewById(R.id.message_text)
        btnSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?)
    {
        when(v?.id)
        {
            R.id.btn_submit -> onSubmitBtnClicked()
        }
    }

    private fun onSubmitBtnClicked()
    {
        val name = nameEditText.text.toString()
        val message = getString(R.string.hello_username, name)
        messageText.text = message
        messageText.visibility = View.VISIBLE
    }
}