package com.example.giuaki_final.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.CongNhan;

import java.util.ArrayList;
import java.util.List;

public class CongNhanDAO {
    private DBManager dbManager;

    public CongNhanDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void themCongNhan(CongNhan congNhan) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbManager.COL_HO, congNhan.getmHo());
        values.put(dbManager.COL_TEN, congNhan.getmTen());
        values.put(dbManager.COL_PHAI, congNhan.getmPhai());
        values.put(dbManager.COL_NAMSINH, congNhan.getmNamSinh());
        values.put(dbManager.COL_NGAYNV, congNhan.getmNgayNV());
        values.put(dbManager.COL_LCB, congNhan.getmLuongCB());
        values.put(dbManager.COL_MAPX_CN, congNhan.getmMaPX());

        sqLiteDatabase.insert(dbManager.TABLE_CONGNHAN, null, values);
        sqLiteDatabase.close();

        Log.d(dbManager.TAG, "themCongNhan: Thành công");
    }

    public List<CongNhan> layDSCN() {
        List<CongNhan> listCN = new ArrayList<>();
        String querry = "SELECT * FROM " + dbManager.TABLE_CONGNHAN;

        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                CongNhan congNhan = new CongNhan();
                congNhan.setmMaCN(cursor.getInt(0));
                congNhan.setmHo(cursor.getString(1));
                congNhan.setmTen(cursor.getString(2));
                congNhan.setmPhai(cursor.getString(3));
                congNhan.setmNamSinh(cursor.getInt(4));
                congNhan.setmNgayNV(cursor.getString(5));
                congNhan.setmLuongCB(cursor.getInt(6));
                congNhan.setmMaPX(cursor.getInt(7));

                listCN.add(congNhan);

            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return listCN;
    }

    public int capNhatCN(CongNhan congNhan) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbManager.COL_HO, congNhan.getmHo());
        contentValues.put(dbManager.COL_TEN, congNhan.getmTen());
        contentValues.put(dbManager.COL_PHAI, congNhan.getmPhai());
        contentValues.put(dbManager.COL_NAMSINH, congNhan.getmNamSinh());
        contentValues.put(dbManager.COL_NGAYNV, congNhan.getmNgayNV());
        contentValues.put(dbManager.COL_LCB, congNhan.getmLuongCB());
        contentValues.put(dbManager.COL_MAPX_CN, congNhan.getmMaPX());

        return sqLiteDatabase.update(dbManager.TABLE_CONGNHAN, contentValues, dbManager.COL_MACN + "=?", new String[]{String.valueOf(congNhan.getmMaCN())});
    }

    public int xoaCN(int maCN) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        return sqLiteDatabase.delete(dbManager.TABLE_CONGNHAN, dbManager.COL_MACN + "=?", new String[]{String.valueOf(maCN)});
    }
    public List<Integer> layMaCN() {
        List<Integer> listMaCN = new ArrayList<>();
        String querry = "SELECT MACN FROM " + dbManager.TABLE_CONGNHAN;
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                listMaCN.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return listMaCN;
    }
}
