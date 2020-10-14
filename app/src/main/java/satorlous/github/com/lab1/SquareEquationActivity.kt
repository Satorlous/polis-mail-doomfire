package satorlous.github.com.lab1

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlin.math.sqrt

private lateinit var squareEqBtn : Button

class SquareEquationActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square_equation)

        squareEqBtn = findViewById(R.id.calculate_btn)
        squareEqBtn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.calculate_btn -> onSquareEqBtnClick()
        }
    }

    fun getEquationRoots(a: Double, b: Double, c: Double) : Any?
    {

        val discriminant = discriminant(a, b, c)
        return when
        {
            a == 0.0 -> "Не квадратное уравнение"
            discriminant < 0 -> "Нет корней"
            discriminant == 0.0 -> -b / (2 * a)
            else ->  Pair(-b + sqrt(discriminant) / (2 * a), -b - sqrt(discriminant) / (2 * a))
        }
    }

    private fun discriminant(a: Double, b: Double, c: Double) = b * b - 4 * a * c

    private fun onSquareEqBtnClick() {
        val a = findViewById<EditText>(R.id.input_a_var).text.toString().toDoubleOrNull()
        val b = findViewById<EditText>(R.id.input_b_var).text.toString().toDoubleOrNull()
        val c = findViewById<EditText>(R.id.input_c_var).text.toString().toDoubleOrNull()

        val alert1 = AlertDialog.Builder(this).setPositiveButton("Понял") { d, id -> d.cancel() }

        if(a != null && b != null && c != null)
        {
            when (val roots = getEquationRoots(a,b,c)) {
                is String -> alert1.setMessage(roots).create()
                is Double -> alert1.setMessage("x = $roots").create()
                is Pair<*, *> -> alert1.setMessage("x1 = ${roots.first}\r\nx2 = ${roots.second}").create()
            }
            alert1.show()
        }


    }
}