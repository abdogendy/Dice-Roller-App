/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            rollDice()
            /**
             ** making Toast to show a temporary pop up message for the use
             *  val toast = Toast.makeText(this , "Dice Rolled!", Toast.LENGTH_SHORT).show()
             *
             * */

        }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()


        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView2)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            //The error is because the value of the when expression is assigned to drawableResource,
            // so the when must be exhaustive—it must handle all the cases possible so that a value is always returned,
            // even if you change to a 12-sided dice. Android Studio suggests adding an else branch.
            else -> R.drawable.dice_6

        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        //Now that you've replaced the rolled number with an image, screen readers cannot tell anymore what number was rolled.
        // To fix this, after you've updated the image resource, update the content description of the ImageView.
        // The content description should be a text description of what is shown in the ImageView so that screen readers can describe it.

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        /**
         * The Behavior of The actual Dice
        when (diceRoll) {
        1 -> diceImage.setImageResource(R.drawable.dice_1)
        2 -> diceImage.setImageResource(R.drawable.dice_2)
        3 -> diceImage.setImageResource(R.drawable.dice_3)
        4 -> diceImage.setImageResource(R.drawable.dice_4)
        5 -> diceImage.setImageResource(R.drawable.dice_5)
        6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
         */

        /**
        // Create a new Dice Instance with a 12 Sides and rol it

        val dice2 =Dice(12)
        val dice2Roll = dice2.roll()

        // Update the screen with the dice roll

        val resTextView : TextView =findViewById(R.id.textView3)
        resTextView.text = dice2Roll.toString()

         **/
        val dice2 = Dice(6)
        val rollResult = dice2.roll()

        // Find the Image in The Layout

        val diceImage2 : ImageView = findViewById(R.id.imageView)

        val diceBehavior = when(rollResult){

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage2.setImageResource(diceBehavior)

    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}


