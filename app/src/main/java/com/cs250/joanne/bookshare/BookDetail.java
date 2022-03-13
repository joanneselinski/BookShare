package com.cs250.joanne.bookshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.snackbar.Snackbar;

public class BookDetail extends AppCompatActivity {

    private ToggleButton toggle;
    private boolean avail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Intent launcher = getIntent();
        TextView titleView = (TextView) findViewById(R.id.text1);
        String temp = launcher.getStringExtra("BOOK_TITLE");
        titleView.setText(temp == null ? "no title" : temp);
        TextView authorView = (TextView) findViewById(R.id.text2);
        temp = launcher.getStringExtra("BOOK_AUTHOR");
        authorView.setText(temp == null ? "no author" : temp);
        toggle = (ToggleButton) findViewById(R.id.togbtn);
        avail = launcher.getBooleanExtra("BOOK_AVAIL", true);
        toggle.setChecked(avail);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                avail = isChecked; // whether or not the toggle is enabled
            }
        });
    }

    /** Called when the user clicks the close button */
    public void close(View view) {
        // use the state of the ToggleButton as the
        // result to return to the fragment that launched this
        int rcode = avail ? 1 : 0;
        setResult(rcode);
       // explicitly pop this activity off the back-stack
        finish();
    }

}