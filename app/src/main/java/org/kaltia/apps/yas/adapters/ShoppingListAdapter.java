package org.kaltia.apps.yas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.kaltia.apps.yas.R;


public class ShoppingListAdapter extends ArrayAdapter<String> {
    public ShoppingListAdapter(Context context, String[] objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String shop = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shooping_lists_item, parent, false);
        }

        TextView cb = (TextView) convertView.findViewById(R.id.shopping_list);
        cb.setText(shop);

        return convertView;
    }
}
