package com.example.googleeb.td1.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.googleeb.td1.Data.Db;
import com.example.googleeb.td1.Data.PersonneContract;

import java.util.ArrayList;

import static com.example.googleeb.td1.Data.PersonneContract.PersonneTable.*;

/**
 * Created by googleeb on 3/14/18.
 */

public class Personne  {

    private String firstName, lastName;
    private int id, age;

    private String[] columns = {
            COLUMN_ID,
            COLUMN_FIRST_NAME,
            COLUMN_LAST_NAME,
            COLUMN_AGE
    };

    public Personne(){

    }

    public Personne(int id, String firstName, String lastName, int age){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age =age;
    }

    public static void addPersonne(String firstName, String lastName, int age){
        ContentValues newPersonne = new ContentValues();
        newPersonne.put(COLUMN_FIRST_NAME, firstName);
        newPersonne.put(COLUMN_LAST_NAME, lastName);
        newPersonne.put(COLUMN_AGE, age);
        Db.insertNewCV(NAME, newPersonne);
    }

    public void add(){
        ContentValues newPersonne = new ContentValues();
        newPersonne.put(COLUMN_FIRST_NAME, this.firstName);
        newPersonne.put(COLUMN_LAST_NAME, this.lastName);
        newPersonne.put(COLUMN_AGE, this.age);
        Db.insertNewCV(NAME, newPersonne);
    }


    public ArrayList<Personne> getAllPersonne(){
        ArrayList<Personne> list = new ArrayList<>();
        Cursor cursor = Db.getAll(NAME, columns);
        Personne p;
        while(cursor.moveToNext()){
            p = new Personne(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getInt(4));
            list.add(p);
        }
        return list;
    }


    public Personne firsNamr(String fisrtName){
        this.firstName = firstName;
        return this;
    }

    public Personne lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public Personne age(int age){
        this.age = age;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
