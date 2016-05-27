package org.kaltia.apps.yas.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.kaltia.apps.yas.R;


public class ListItemsAdapter extends ArrayAdapter<String> {


    public ListItemsAdapter(Context context, String[] objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.shooping_list_item, parent, false);
        }

        CheckBox item = (CheckBox) convertView.findViewById(R.id.shopping_list_item_checkbox);
        TextView itemText = (TextView) convertView.findViewById(R.id.shopping_list_item_text);

        SharedPreferences preference = ((Activity) getContext()).getPreferences(Context.MODE_PRIVATE);
        Boolean checked = preference.getBoolean(getItem(position), false);
        item.setChecked(checked);

        itemText.setText(getItem(position));

        item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences preference = ((Activity) getContext()).getPreferences(Context.MODE_APPEND);
                SharedPreferences.Editor editor = preference.edit();
                editor.putBoolean(getItem(position), isChecked);
                editor.commit();
                Log.d("Verify checked", String.valueOf(isChecked));
            }
        });
        return convertView;
    }
}
