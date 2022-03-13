package com.cs250.joanne.bookshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginName extends AppCompatActivity {

    private String name;
    private TextView nameInput;
    SharedPreferences ctxprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_name);

        ctxprefs = getApplicationContext().getSharedPreferences(String.valueOf(R.string.app_name), Context.MODE_PRIVATE);
        // display stored name
        name = ctxprefs.getString(getString(R.string.login), getString(R.string.owner));
        nameInput = (EditText) findViewById(R.id.nameText);
        nameInput.setText(name);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /** Called when the user clicks the login button */
    public void launchMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String name = nameInput.getText().toString();
        // permanently store name for future app launches and for nav header
        SharedPreferences.Editor editor = ctxprefs.edit();
        editor.putString(getString(R.string.login), name);
        editor.apply();
        startActivity(intent);
    }
}