package com.example.giuaki_final.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.PhanXuong;
import com.example.giuaki_final.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class PhanXuongDAO {
    private DBManager dbManager;

    public PhanXuongDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void themPhanXuong(PhanXuong phanXuong) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbManager.COL_TENPX, phanXuong.getmTenPX());
        values.put(dbManager.COL_MASP_PX, phanXuong.getmMaSP());

        sqLiteDatabase.insert(dbManager.TABLE_PHANXUONG, null, values);
        sqLiteDatabase.close();

        Log.d(dbManager.TAG, "themPhanXuong: Thành công");
    }

    public List<PhanXuong> layDSPX() {
        List<PhanXuong> listPX = new ArrayList<>();
        String querry = "SELECT * FROM " + dbManager.TABLE_PHANXUONG;

        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                PhanXuong phanXuong = new PhanXuong();
                phanXuong.setmMaPX(cursor.getInt(0));
                phanXuong.setmTenPX(cursor.getString(1));
                phanXuong.setmMaSP(cursor.getInt(2));

                listPX.add(phanXuong);

            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return listPX;
    }

    public int capNhatPX(PhanXuong phanXuong) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbManager.COL_TENPX, phanXuong.getmTenPX());
        contentValues.put(dbManager.COL_MASP_PX, phanXuong.getmMaSP());

        return sqLiteDatabase.update(dbManager.TABLE_PHANXUONG, contentValues, dbManager.COL_MAPX + "=?", new String[]{String.valueOf(phanXuong.getmMaPX())});
    }

    public int xoaPX(int maPX) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        return sqLiteDatabase.delete(dbManager.TABLE_PHANXUONG, dbManager.COL_MAPX + "=?", new String[]{String.valueOf(maPX)});
    }

    public List<Integer> layMaPX() {
        List<Integer> listMaPX = new ArrayList<>();
        String querry = "SELECT MAPX FROM " + dbManager.TABLE_PHANXUONG;
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                listMaPX.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return listMaPX;
    }
}
