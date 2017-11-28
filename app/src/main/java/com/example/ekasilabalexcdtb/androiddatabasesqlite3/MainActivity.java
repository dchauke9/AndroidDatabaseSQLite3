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

public class MainActivity extends AppCompatActivity {



    EditText id;
    EditText name;
    EditText surname;
    EditText gender;
    EditText age;
    Button button;
    Person person;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DBHelper db=new DBHelper(this);

        // ArrayList<Person> personArrayList = db.getAllPersons();

      //  Log.v("List", String.valueOf(db.numberOfRows()));

        id=(EditText) findViewById(R.id.idNumber);
        name=(EditText) findViewById(R.id.name);
        surname=(EditText) findViewById(R.id.surname);
        gender=(EditText) findViewById(R.id.gender);
        age=(EditText) findViewById(R.id.age);
        button=(Button) findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person();

                person.setIdNumber(id.getText().toString());
                person.setName(name.getText().toString());
                person.setSurname(surname.getText().toString());
                person.setGender(gender.getText().toString());
                person.setAge(age.getText().toString());

                db.insertPerson(person.getIdNumber(),person.getName(),person.getSurname(),person.getGender(),person.getAge());

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);

            }
        });

    }



}
