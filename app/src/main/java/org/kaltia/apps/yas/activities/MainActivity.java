package org.kaltia.apps.yas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.kaltia.apps.yas.R;
import org.kaltia.apps.yas.adapters.ShoppingListAdapter;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] lists = new String[]{"Fiesta de cumpleaños", "Escuela de Maria", "Utiles Escolares"};
        ListView sl = (ListView) findViewById(R.id.shopping_lists);
        ListAdapter shoppingListAdapter = new ShoppingListAdapter(getApplicationContext(), lists);
        Log.e("Null?", sl.toString());
        sl.setAdapter(shoppingListAdapter);

        sl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView msg = (TextView) ((LinearLayout) view).findViewById(R.id.shopping_list);
                Toast.makeText(getApplicationContext(), msg.getText(), Toast.LENGTH_LONG).show();
                Intent shoppingListIntent = new Intent(getApplicationContext(), ListItemsActivity.class);
                shoppingListIntent.putExtra(Intent.EXTRA_TEXT, msg.getText());
                startActivity(shoppingListIntent);
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global_menu, menu);
        return true;
    }
}