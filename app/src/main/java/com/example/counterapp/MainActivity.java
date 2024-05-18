package com.example.counterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private int count = 0;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView = findViewById(R.id.textView2);
        Button buttonCount = findViewById(R.id.button6);
        Button buttonToast = findViewById(R.id.button5);

        // Set initial count value
        textView.setText(String.valueOf(count));

        buttonCount.setOnClickListener(v -> {
            count++;
            textView.setText(String.valueOf(count));
        });

        buttonToast.setOnClickListener(v -> {
            if (count > 0) {
                count--;
            }
            textView.setText(String.valueOf(count));
        });
    }
}
