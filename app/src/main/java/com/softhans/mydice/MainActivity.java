package com.softhans.mydice;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Think of an object as something that has state and behavior (Button, ImageView)
         * It is the raw material from which variables are made out of.
         * Think of a variable as a box(e.g. rollBtn), where you then enter different values (btn 1, btn2)
         * we declare imageview "final" to guarantee that no other image will be used.
         */



        Button rollBtn = (Button) findViewById(R.id.rollButton);
        final ImageView leftDice = (ImageView) findViewById(R.id.leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.rightDice);



        /**To make our apps detect tabs on the screen we need to set a "Listener".
         * In this our case we have our apps to carry out an action when we tap the "Roll"(rollBtn).
         * An array is a collection of items of the same type. it starts counting from 0 and is
         * symbolized by [] brackets.
         * With this apps we refer our apps to the drawables we store in out res(R) and drawable.
         * we delare this array "final" to guarantee that there will be no change ever.
         */
        final int[] diceArray = {R.drawable.dice1,
                           R.drawable.dice2,
                           R.drawable.dice3,
                           R.drawable.dice4,
                           R.drawable.dice5,
                           R.drawable.dice6};

        /** Next we link our dices to the animation from dice_anim2.xml
         *     leftDice.setBackgroundResource(R.drawable.dice_anim);
         *         rightDice.setBackgroundResource(R.drawable.dice_anim);
         */



        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                /** To enable our button create a random number,
                 * we create a variable called "Random" that can hold this object.
                 *  Let's call the Random variable "randomNumberGenerator".
                 *  Note that Random is the object while random
                 */

                Random randomNumberGenerator = new Random();

                int number = randomNumberGenerator.nextInt(6);
                // this code above will generate a number between 0 - 5. remember counting starts from 0 in Java.

                /**Because we need to change the content of the ImageViews(leftDice, rightDice) at runTime
                 * we use "setImageREsource"
                 * in the dice Array bracket, we direct the app to our variable number.
                 */

                leftDice.setImageResource(diceArray[number]);

                number = randomNumberGenerator.nextInt(6);

                /** this code is to rotate again what number we had from one of our variable with a new one.
                 * This is to make sure the dice(variables) don't keep on giving the same random numbers at the same time
                 */

                rightDice.setImageResource(diceArray[number]);


            }

        });
    }


}
