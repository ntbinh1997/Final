package com.example.giuaki_final.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.ChamCong;
import com.example.giuaki_final.model.PhanXuong;

import java.util.ArrayList;
import java.util.List;

public class ChamCongDAO {
    private DBManager dbManager;

    public ChamCongDAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }

    public void themChamCong(ChamCong chamCong) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbManager.COL_NGAY, chamCong.getmNgay());
        values.put(dbManager.COL_MACN_CC, chamCong.getmMaCN());
        values.put(dbManager.COL_SOGIOLAM, chamCong.getmSoGioLam());

        sqLiteDatabase.insert(dbManager.TABLE_CHAMCONG, null, values);
        sqLiteDatabase.close();

        Log.d(dbManager.TAG, "themChamCong: Thành công");
    }

    public List<ChamCong> layDSCC() {
        List<ChamCong> listCC = new ArrayList<>();
        String querry = "SELECT * FROM " + dbManager.TABLE_CHAMCONG;

        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(querry, null);
        if (cursor.moveToFirst()) {
            do {
                ChamCong chamCong = new ChamCong();
                chamCong.setmNgay(cursor.getString(0));
                chamCong.setmMaCN(cursor.getInt(1));
                chamCong.setmSoGioLam(cursor.getInt(2));

                listCC.add(chamCong);

            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        return listCC;
    }

    public int capNhatCC(ChamCong chamCong) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbManager.COL_SOGIOLAM, chamCong.getmSoGioLam());
//        String querry = "UPDATE " + dbManager.TABLE_CHAMCONG + " SET " + dbManager.COL_SOGIOLAM + " WHERE "
        return sqLiteDatabase.update(dbManager.TABLE_CHAMCONG, contentValues, dbManager.COL_NGAY + "=? AND " + dbManager.COL_MACN_CC + "=?", new String[]{String.valueOf(chamCong.getmNgay()), String.valueOf(chamCong.getmMaCN())});
    }

    public int xoaCC(String ngay, int maCN) {
        SQLiteDatabase sqLiteDatabase = dbManager.getWritableDatabase();
        return sqLiteDatabase.delete(dbManager.TABLE_CHAMCONG, dbManager.COL_NGAY + "=? AND " + dbManager.COL_MACN_CC + "=?", new String[]{ngay, String.valueOf(maCN)});
    }

}
