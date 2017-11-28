package com.example.ekasilabalexcdtb.androiddatabasesqlite3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes.DBHelper;
import com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes.MyAdapter;
import com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes.Person;

import java.util.ArrayList;
import java.util.List;

public class DisplayActivity extends AppCompatActivity {
    MyAdapter myAdapter;
    DBHelper dbHelper;
    Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        dbHelper = new DBHelper(DisplayActivity.this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        Log.v("Test", String.valueOf(dbHelper.numberOfRows()));

        List<Person> mPersonList = (ArrayList<Person>) dbHelper.getAllPersons();

        myAdapter = new MyAdapter(DisplayActivity.this, mPersonList);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        person = new Person();

        final DBHelper db = new DBHelper(this);


        if (id == R.id.action_settings) {


            AlertDialog alertDialog = new AlertDialog.Builder(DisplayActivity.this).create();
            alertDialog.setTitle("Update database");
            alertDialog.setMessage("Update your database here");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Udate",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db.updatePerson(person.getName());
                            Log.v("Update", "Updated" + db.updatePerson(person.getName()));
                            Intent intent = new Intent(DisplayActivity.this, UpdateActivity.class);
                            startActivity(intent);
                        }
                    });
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

