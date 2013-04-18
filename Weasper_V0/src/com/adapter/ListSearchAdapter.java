package com.adapter;

import net.simonvt.menudrawer.samples.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListSearchAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public ListSearchAdapter(Context context, String[] values) {
    super(context, R.layout.item_list_view_search, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.item_list_view_search, parent, false);
    TextView textView = (TextView) rowView.findViewById(R.id.nomprenom);
    textView.setText(values[position]);



    return rowView;
  }
} 