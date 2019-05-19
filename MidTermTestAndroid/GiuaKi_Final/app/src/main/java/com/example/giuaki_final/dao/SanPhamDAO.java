package com.example.giuaki_final.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private DBManager dbManager;

    public SanPhamDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void themSanPham(SanPham sanPham) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbManager.COL_TENSP, sanPham.getmTenSP());
        values.put(dbManager.COL_DVT, sanPham.getmDVT());
        values.put(dbManager.COL_DONGIA, sanPham.getmDonGia());

        sqLiteDatabase.insert(dbManager.TABLE_SANPHAM, null, values);
        sqLiteDatabase.close();

        Log.d(dbManager.TAG, "themSanPham: Thành công");
    }

    public List<SanPham> layDSSP() {
        List<SanPham> listSP = new ArrayList<>();
        String querry = "SELECT * FROM " + dbManager.TABLE_SANPHAM;

        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                SanPham sanPham = new SanPham();
                sanPham.setmMaSP(cursor.getInt(0));
                sanPham.setmTenSP(cursor.getString(1));
                sanPham.setmDVT(cursor.getString(2));
                sanPham.setmDonGia(cursor.getFloat(3));

                listSP.add(sanPham);

            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return listSP;
    }

    public int capNhatSP(SanPham sanPham) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbManager.COL_TENSP, sanPham.getmTenSP());
        contentValues.put(dbManager.COL_DVT, sanPham.getmDVT());
        contentValues.put(dbManager.COL_DONGIA, sanPham.getmDonGia());

        return sqLiteDatabase.update(dbManager.TABLE_SANPHAM, contentValues, dbManager.COL_MASP + "=?", new String[]{String.valueOf(sanPham.getmMaSP())});
    }

    public int xoaSP(int maSP) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        return sqLiteDatabase.delete(dbManager.TABLE_SANPHAM, dbManager.COL_MASP + "=?", new String[]{String.valueOf(maSP)});
    }

    public List<Integer> layMaSP() {
        List<Integer> listMaSP = new ArrayList<>();
        String querry = "SELECT MASP FROM " + dbManager.TABLE_SANPHAM;
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                listMaSP.add(cursor.getInt(0));
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return listMaSP;
    }
}
