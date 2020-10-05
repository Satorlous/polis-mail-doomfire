package satorlous.github.com.lab1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var  helloWorldBtn : Button;
    private lateinit var  helloUserBtn : Button;
    private lateinit var  fireBtn : Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        helloWorldBtn = findViewById(R.id.btn_hello_world)
        helloUserBtn = findViewById(R.id.btn_hello_user)
        fireBtn = findViewById(R.id.btn_fire)

        helloUserBtn.setOnClickListener(this)
        helloWorldBtn.setOnClickListener(this)
        fireBtn.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.btn_hello_world -> onClickHelloWorldBtn()
            R.id.btn_hello_user -> onClickHelloUserBtn()
            R.id.btn_fire -> onClickFireBtn()
        }
    }

    private fun onClickHelloWorldBtn() {
        startActivity(Intent(this, HelloWorldActivity::class.java))
    }

    private fun onClickHelloUserBtn() {
        startActivity(Intent(this, HelloUsernameActivity::class.java))
    }

    private fun onClickFireBtn() {
        startActivity(Intent(this, FireActivity::class.java))
    }
}