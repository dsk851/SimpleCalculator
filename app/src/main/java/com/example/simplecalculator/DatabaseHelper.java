package com.example.simplecalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "clients.db";
    // Client table name
    private static final String TABLE_CLIENTS = "client";
    // Clients Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLIENTS_TABLE = "CREATE TABLE " + TABLE_CLIENTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " TEXT, "
                + KEY_EMAIL + " TEXT, "
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_CLIENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENTS);
        // Create tables again
        onCreate(db);
    }

    public void addClient(Client client) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
// client Name
        values.put(KEY_NAME, client.getName());
        values.put(KEY_EMAIL, client.getEmail());
        values.put(KEY_PASSWORD, client.getPassword());
// Inserting Row
        db.insert(TABLE_CLIENTS, null, values);
        db.close(); // Closing database connection
    }

    public Client getClient(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        // Query to retrieve the client by ID
        Cursor cursor = db.query(TABLE_CLIENTS, new String[]{KEY_ID, KEY_NAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        // Create a Client object from the retrieved data
        Client client = new Client(
                cursor.getInt(0),      // ID
                cursor.getString(1),   // Name
                cursor.getString(2),   // Email
                cursor.getString(3)    // Password
        );

        cursor.close(); // Close the cursor
        return client;
    }

    public Boolean valideClient(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {KEY_ID};
        String selection = KEY_EMAIL + " = ? AND " + KEY_PASSWORD + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(TABLE_CLIENTS, columns, selection, selectionArgs, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }




}