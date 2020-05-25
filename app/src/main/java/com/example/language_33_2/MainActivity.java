package com.example.language_33_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinner;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpinner = findViewById(R.id.spinner);
        mButton = findViewById(R.id.button);

        initSpinnerCountries();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = mSpinner.getSelectedItemPosition();
                switch (selected){
                    case 0:
                        switchLocale("en");
                        break;
                    case 1:
                        switchLocale("ru");
                }
            }
        });
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.language, android.R.layout.simple_spinner_item);
        mSpinner.setAdapter(adapterCountries);
    }


    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }


}
