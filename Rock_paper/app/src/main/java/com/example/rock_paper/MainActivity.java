package com.example.rock_paper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView resultText;
    private Button rockBtn, paperBtn, scissorsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.resultText);
        rockBtn = findViewById(R.id.rockBtn);
        paperBtn = findViewById(R.id.paperBtn);
        scissorsBtn = findViewById(R.id.scissorsBtn);

        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(0);
            }
        });

        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(1);
            }
        });

        scissorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playGame(2);
            }
        });
    }

    public void playGame(int userChoice) {
        int computerChoice = new Random().nextInt(3);

        if (userChoice == computerChoice) {
            resultText.setText("It's a draw!");
        }
        else if (userChoice == 0 && computerChoice == 2 ||
                userChoice == 1 && computerChoice == 0 ||
                userChoice == 2 && computerChoice == 1) {
            resultText.setText("You win!");
        }
        else {
            resultText.setText("You lose!");
        }

        new AlertDialog.Builder(this)
                .setTitle("Play Again?")
                .setMessage("Do you want to play again?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Restart the game
                        resultText.setText("");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}