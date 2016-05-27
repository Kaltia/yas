package org.kaltia.apps.yas.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ListView;

import org.kaltia.apps.yas.R;
import org.kaltia.apps.yas.adapters.ListItemsAdapter;


public class ListItemsActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {
    SharedPreferences preferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shooping_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] items = new String[]{"Jugo Boing", "Lata de Chiles chipotles"};
        ListItemsAdapter itemsAdapter = new ListItemsAdapter(this, items);

        ListView listItems = (ListView) findViewById(R.id.list_items);
        listItems.setAdapter(itemsAdapter);

        if (getIntent() != null && getIntent().hasExtra(Intent.EXTRA_TEXT)) {
            getSupportActionBar().setTitle(getIntent().getStringExtra(Intent.EXTRA_TEXT));
        }
        listItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Verify checked", String.valueOf(position));
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

    }
}
