package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

var player = 0
var tie = 0
var comp = 0

class MainActivity : AppCompatActivity() {
    lateinit var myimage: ImageView
    lateinit var compimage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rock: Button = findViewById(R.id.button)
        val paper: Button = findViewById(R.id.button2)
        val scissor: Button = findViewById(R.id.button3)

        val p_points: TextView = findViewById(R.id.p_points)
        val t_points: TextView = findViewById(R.id.t_points)
        val c_points: TextView = findViewById(R.id.c_points)

        myimage = findViewById(R.id.playerim)
        compimage = findViewById(R.id.computerim)

        rock.setOnClickListener { play(1) }
        paper.setOnClickListener { play(3) }
        scissor.setOnClickListener { play(2) }


    }

    private fun play(move: Int) {

        //1=rock 2= scissor 3=paper
        var c_move = (1..3).random()


        if (move == c_move) {
            tie += 1
            Toast.makeText(this, "TIE :P", Toast.LENGTH_SHORT).show()
        }
        if ((move == 1 && c_move == 2) || (move == 2 && c_move == 3) || (move == 3 && c_move == 1)) {
            player += 1
            Toast.makeText(this, "YOU WON :)", Toast.LENGTH_SHORT).show()
        }
        if ((move == 1 && c_move == 3) || (move == 2 && c_move == 1) || (move == 3 && c_move == 2)) {
            comp += 1
            Toast.makeText(this, "YOU LOST :(", Toast.LENGTH_SHORT).show()
        }
        var imsrc = when (c_move) {
            1 -> R.drawable.rock
            2 -> R.drawable.scissor
            else -> R.drawable.paper
        }

        var imsrc2 = when (move) {
            1 -> R.drawable.rock
            2 -> R.drawable.scissor
            else -> R.drawable.paper
        }


        compimage.setImageResource(imsrc)
        myimage.setImageResource(imsrc2)

        p_points.text = "PLAYER:$player"
        t_points.text = "TIE:$tie"
        c_points.text = "COMPUTER:$comp"
    }

}

