package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.operator.Operator


class MainActivity : AppCompatActivity() {

    var factorial: Operator = object : Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {

        override fun apply(vararg args: Double): Double {
            val arg = args[0].toInt()
            require(arg.toDouble() == args[0])
            require(arg >= 0)
            var result = 1.0
            for (i in 1..arg) {
                result *= i.toDouble()
            }
            return result
        }
    }
    var sqrt: Operator = object : Operator(";", 1, false, Operator.PRECEDENCE_POWER + 1) {

        override fun apply(vararg args: Double): Double {
            val arg = args[0].toDouble()
            require(arg >= 0)
            var result = Math.sqrt(arg)
            return result
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Clear.setOnClickListener {
            Operation.text = ""
            Resault.text = ""
        }
        Del.setOnClickListener {
            val str = Operation.text.toString()
            if (str.isNotEmpty()){
                Operation.text = str.substring(0, str.length - 1)
                Resault.text = ""
            }
        }
        Equal.setOnClickListener {
            var expressionField = ""
            for (i in 0..Operation.text.length - 1) {
                if (Operation.text[i] == '√') expressionField += ";"
                else expressionField += Operation.text[i]
            }
            try
            {
                val expression = ExpressionBuilder(expressionField).operator(factorial).operator(sqrt).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    Resault.text = longResult.toString(