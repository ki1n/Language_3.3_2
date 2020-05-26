package com.example.language_33_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner mSpinnerLang, mSpinnerColors;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);

        mSpinnerLang = findViewById(R.id.spinner);
        mSpinnerColors = findViewById(R.id.spinnerColors);
        mButton = findViewById(R.id.button);

        initSpinnerCountries();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = mSpinnerLang.getSelectedItemPosition();
                switch (selected){
                    case 0:
                        switchLocale("en");
                        break;
                    case 1:
                        switchLocale("ru");
                }

                int selectColor = mSpinnerColors.getSelectedItemPosition();
                switch (selectColor){
                    case 0:
                        Utils.changeToTheme(MainActivity.this,Utils.THEME_BLACK);
                        break;
                    case 1:
                        Utils.changeToTheme(MainActivity.this,Utils.THEME_GREEN);
                        break;
                    case 2:
                        Utils.changeToTheme(MainActivity.this,Utils.THEME_BLUE);
                        break;
                }
            }
        });
    }

    private void initSpinnerCountries() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this,
                R.array.language, android.R.layout.simple_spinner_item);
        mSpinnerLang.setAdapter(adapterCountries);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.сolorsArr, android.R.layout.simple_spinner_item);
        mSpinnerColors.setAdapter(adapter);
    }

    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
