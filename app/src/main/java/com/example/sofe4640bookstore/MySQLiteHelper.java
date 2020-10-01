package com.example.sofe4640bookstore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bookstore.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "id";
    private static final String COL_2 = "firstName";
    private static final String COL_3 = "lastName";
    private static final String COL_4 = "userName";
    private static final String COL_5 = "passowrd";
    private static final String COL_6 = "email";
    private static final String COL_7 = "status";



    public MySQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_1 + " Integer PRIMARY KEY AUTOINCREMENT," +
                COL_2 +  " Text NOT NULL," +
                COL_3 +  " Text NOT NULL," +
                COL_4 +  " Text NOT NULL," +
                COL_5 +  " Text NOT NULL," +
                COL_6 +  " Text NOT NULL," +
                COL_7 + " number DEFAULT 0)" + ";" ;

        Log.d("DBText","createTable: "+createTable);
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop table " + TABLE_NAME + ";" );
        this.onCreate(sqLiteDatabase);
    }

    public boolean addRecord(Users users){
        ContentValues values= new ContentValues();
        values.put(COL_2,users.getFirstName());
        values.put(COL_3,users.getLastName());
        values.put(COL_4,users.getUserName());
        values.put(COL_5,users.getPassword());
        values.put(COL_6,users.getEmail());
        values.put(COL_7,"1");

        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(TABLE_NAME,null,values);
        db.close();

        if (result ==0) return false;
        else
            return true;
    }


    public boolean checkUsers(String userNameStr, String passwordStr) {
        SQLiteDatabase db = getReadableDatabase();
        String query = "select * from " + TABLE_NAME
                       + " where " + COL_4 + " = " + "'" +userNameStr + "'" +
                          " and " +  COL_5 + " = " + "'" +passwordStr+"'" +" ; ";

        Log.d("query",query);
        Cursor c = db.rawQuery(query,null);
        int rowsCount= c.getCount();
        c.close();
        if (rowsCount>0) return true;
        else return false;

    }
}
