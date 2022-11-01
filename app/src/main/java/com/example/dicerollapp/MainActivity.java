package com.example.dicerollapp;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.dicerollapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    SecureRandom secureRandomNumbers = new SecureRandom();

    int number1 = 0;
    int number2 = 0;
    int number3 = 0;
    int number4 = 0;
    int number5 = 0;
    int number6 = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        TextView txtNumber1 = (TextView) findViewById(R.id.txtNumber1);
        TextView txtNumber2 = (TextView) findViewById(R.id.txtNumber2);
        TextView txtNumber3 = (TextView) findViewById(R.id.txtNumber3);
        TextView txtNumber4 = (TextView) findViewById(R.id.txtNumber5);
        TextView txtNumber5 = (TextView) findViewById(R.id.txtNumber6);
        TextView txtNumber6 = (TextView) findViewById(R.id.txtNumber7);

        ImageView imgDice = (ImageView) findViewById(R.id.imgDiceLogo);
        ImageView imgDice1 = (ImageView) findViewById(R.id.imgDiceNumber1);
        ImageView imgDice2 = (ImageView) findViewById(R.id.imgDiceNumber2);
        ImageView imgDice3 = (ImageView) findViewById(R.id.imgDiceNumber3);
        ImageView imgDice4 = (ImageView) findViewById(R.id.imgDiceNumber4);
        ImageView imgDice5 = (ImageView) findViewById(R.id.imgDiceNumber5);
        ImageView imgDice6 = (ImageView) findViewById(R.id.imgDiceNumber6);

        Button btnRollTheDice = (Button) findViewById(R.id.btnRollTheDice);

        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int rollTimes =0; rollTimes <= 5000000; rollTimes++){
                    int faceNumber = 1 + secureRandomNumbers.nextInt(6); //random number between 1 and 6

                    switch(faceNumber){
                        case 1:
                            ++number1;
                            break;
                        case 2:
                            ++number2;
                            break;
                        case 3:
                            ++number3;
                            break;
                        case 4:
                            ++number4;
                            break;
                        case 5:
                            ++number5;
                            break;
                        case 6:
                            ++number6;
                            break;
                    }
                }

                txtNumber1.setText(number1 + "");
                txtNumber2.setText(number2 + "");
                txtNumber3.setText(number3 + "");
                txtNumber4.setText(number4 + "");
                txtNumber5.setText(number5 + "");
                txtNumber6.setText(number6 + "");

                imgDice1.setImageResource(R.drawable.dice1);
                imgDice2.setImageResource(R.drawable.dice2);
                imgDice3.setImageResource(R.drawable.dice3);
                imgDice4.setImageResource(R.drawable.dice4);
                imgDice5.setImageResource(R.drawable.dice5);
                imgDice6.setImageResource(R.drawable.dice6);
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}