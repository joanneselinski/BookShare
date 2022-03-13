package com.cs250.joanne.bookshare;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class AddBookFrag extends Fragment {

    private TextView tv;
    private TextView titleView;
    private TextView authorView;
    private Button btn;
    private MainActivity myact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.add_book_frag, container, false);

        myact = (MainActivity) getActivity();
        myact.getSupportActionBar().setTitle("Add Book");
        tv = (EditText) view.findViewById(R.id.item_text);
        titleView = (EditText) view.findViewById(R.id.title_txt);
        authorView = (EditText) view.findViewById(R.id.author_txt);
        btn = (Button) view.findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book myitem = new Book(titleView.getText().toString(), authorView.getText().toString());
                myitem.setWhat(tv.getText().toString());
                myact.myBooks.add(myitem);
                Toast.makeText(getActivity().getApplicationContext(), "added item", LENGTH_SHORT).show();
            }
        });

        return view;
    }


}
