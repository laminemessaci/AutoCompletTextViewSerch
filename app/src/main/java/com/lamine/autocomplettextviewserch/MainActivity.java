package com.lamine.autocomplettextviewserch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CountryItem> mCountryItems;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        filleCountry ();
        AutoCompleteTextView editText = findViewById (R.id.actv);
        AutoCompleteCountryAdapter adapter = new AutoCompleteCountryAdapter (this, mCountryItems);
        editText.setAdapter (adapter);
    }

    private void filleCountry(){

        mCountryItems = new ArrayList<> ();
        mCountryItems.add (new CountryItem ("Espagne", R.drawable.spain));
        mCountryItems.add (new CountryItem ("Algeria", R.drawable.algeira));
        mCountryItems.add (new CountryItem ("France", R.drawable.france));
        mCountryItems.add (new CountryItem ("Belgique", R.drawable.belgium));
        mCountryItems.add (new CountryItem ("Luxembourg", R.drawable.luxembourg));
        mCountryItems.add (new CountryItem ("Latvia", R.drawable.latvia));
        mCountryItems.add (new CountryItem ("Bulgarie", R.drawable.bulgaria));
        mCountryItems.add (new CountryItem ("Italie", R.drawable.italy));
        mCountryItems.add (new CountryItem ("Finland", R.drawable.finland));
        mCountryItems.add (new CountryItem ("Romania", R.drawable.romania));
        mCountryItems.add (new CountryItem ("Croatie", R.drawable.croatia));
        mCountryItems.add (new CountryItem ("Danmark", R.drawable.denmark));
    }
}
