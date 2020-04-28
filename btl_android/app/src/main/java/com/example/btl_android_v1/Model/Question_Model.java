package com.example.btl_android_v1.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.btl_android_v1.Databases.Theory_Database;
import com.example.btl_android_v1.Object.Quetion;

import java.util.ArrayList;
import java.util.List;

public class Question_Model {
    Theory_Database lyThuyetDatabase;
    SQLiteDatabase database;
    public Question_Model(Context context){
        lyThuyetDatabase = new Theory_Database(context);
    }
    public void open(){
        database = lyThuyetDatabase.getReadableDatabase();
    }
    public void close(){
        lyThuyetDatabase.close();
    }
    public List<Quetion> getListCauHoi(int i){
        List<Quetion> listCauHoi = new ArrayList<>();
        open();
        String cauTruyVan = "select * from CAUHOI where id between "+((i-1)*25+1)+" and "+(i*25)+"";
        //between chọn giữa trong khoảng 2 giá trị

        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String cauHoi = cursor.getString(1);
            int anh = cursor.getInt(2);
            String A = cursor.getString(3);
            String B = cursor.getString(4);
            String C = cursor.getString(5);
            String D = cursor.getString(6);
            String dapAn = cursor.getString(7);
            Quetion cauhoi = new Quetion(id,cauHoi,anh,A,B,C,D,dapAn);
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        Log.d("SIZE = ",listCauHoi.size()+"");
        return listCauHoi;
    }
    public List<Quetion> getListCauHoi(){
        List<Quetion> listCauHoi = new ArrayList<>();
        open();
        String cauTruyVan = "select * from CAUHOI";
        Cursor cursor = database.rawQuery(cauTruyVan,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String cauHoi = cursor.getString(1);
            int anh = cursor.getInt(2);
            String A = cursor.getString(3);
            String B = cursor.getString(4);
            String C = cursor.getString(5);
            String D = cursor.getString(6);
            String dapAn = cursor.getString(7);
            Quetion cauhoi = new Quetion(id,cauHoi,anh,A,B,C,D,dapAn);
            listCauHoi.add(cauhoi);
            cursor.moveToNext();
        }
        cursor.close();
        close();
        Log.d("SIZE = ",listCauHoi.size()+"");
        return listCauHoi;
    }
}
