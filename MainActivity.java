package com.messaging.cdss;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText Regex;
    private EditText  test;
    private TextView output;
    private Button button;
    Pattern pattern;
    Matcher matcher;
    String intermediate;
    boolean found;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Regex = findViewById(R.id.Regex);
        button = findViewById(R.id.Submit);
        test = findViewById(R.id.test);
        output=findViewById(R.id.output);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Regex.getText().toString().isEmpty() || test.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please Enter a String and/or RE", Toast.LENGTH_SHORT).show();
                } else
                    {
                    output.setText("");
                    intermediate="";
                    pattern=Pattern.compile(Regex.getText().toString());
                    matcher=pattern.matcher(test.getText().toString());
                    found=false;
                    while (matcher.find())
                    {
                        intermediate="Found the text "+matcher.group()+" at position "+matcher.start() +" to "+ matcher.end()+"\n";
                        found=true;
                    }
                    if(!found)
                    {
                        intermediate="No matches found";
                    }
                    output.setText(intermediate);
                }


            }
        });
    }
}
