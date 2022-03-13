package com.cs250.joanne.bookshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by joanne.
 */
public class BookAdapter extends ArrayAdapter<Book> {

    int resource;

    public BookAdapter(Context ctx, int res, List<Book> items)
    {
        super(ctx, res, items);
        resource = res;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout itemView;
        Book it = getItem(position);

        if (convertView == null) {
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, itemView, true);
        } else {
            itemView = (LinearLayout) convertView;
        }

        TextView inout = (TextView) itemView.findViewById(R.id.card_text);
        inout.setText(it.isAvail() ? "IN" : "OUT");

        TextView whatView = (TextView) itemView.findViewById(R.id.detail);
        whatView.setText(it.toString());


        return itemView;
    }

}
