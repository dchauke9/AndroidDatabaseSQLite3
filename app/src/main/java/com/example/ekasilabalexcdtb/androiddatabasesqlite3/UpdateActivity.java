package com.example.ekasilabalexcdtb.androiddatabasesqlite3;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes.DBHelper;
import com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes.Person;

public class UpdateActivity extends AppCompatActivity {

    Person person;
    DBHelper dbHelper;

    EditText id;
    EditText name;
    EditText surname;
    EditText gender;
    EditText age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        EditText updateName = (EditText)findViewById(R.id.update_name);
        Button update = (Button)findViewById(R.id.update_data);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(UpdateActivity.this).create();
                alertDialog.setTitle("Update database");
                alertDialog.setMessage("Update your database here");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Udate",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dbHelper.updatePerson(person.getName());
                                Log.v("Update", "Updated" + dbHelper.updatePerson(person.getName()));

                            }
                        });
                alertDialog.show();
            }
        });
    }


}
