package com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by eKasiLab Alex CDTB on 13 Nov 2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "AndroidDatabaseSQLite3";
    public static final String PERSON_TABLE_NAME = "Person";
    public static final String PERSON_COLUMN_ID = "id";
    public static final String PERSON_COLUMN_NAME = "name";
    public static final String PERSON_COLUMN_SURNAME = "surname";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_AGE = "age";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table person " +
                "(id Integer primary key AutoIncrement, idNumber text, name text, surname text, gender text, age text);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Person");
        onCreate(db);
    }

    public void insertPerson(String name,String surname,  String gender, String idNUmber,String  age){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idNumber", idNUmber);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("gender", gender);
        contentValues.put("age", age);
        db.insert("Person", null, contentValues);
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, "Person");
        return numRows;
    }
    public ArrayList<Person> getAllPersons(){
        ArrayList<Person> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Person", null);
        res.moveToFirst();


        while (res.isAfterLast() == false){
           arrayList.add(new Person(res.getString(0),
                   res.getString(1),res.getString(2),
                   res.getString(3),  res.getString(4)));
           res.moveToNext();
        }
        return arrayList;
    }
    public Integer deletePerson (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("person",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
    public boolean updatePerson(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("name", name);

        db.update("Person", contentValues, "id = ? ", new String[] { (name) } );
        return true;
    }



}
