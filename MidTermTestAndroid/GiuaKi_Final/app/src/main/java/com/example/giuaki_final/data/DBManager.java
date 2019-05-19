package com.example.giuaki_final.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.giuaki_final.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static final String TAG = "Quản Lý Công Nhân";

    //Table SANPHAM
    public static final String TABLE_SANPHAM = "SANPHAM";
    public static final String COL_MASP = "MASP";
    public static final String COL_TENSP = "TENSP";
    public static final String COL_DVT = "DVT";
    public static final String COL_DONGIA = "DONGIA";

    //Table PHANXUONG
    public static final String TABLE_PHANXUONG = "PHANXUONG";
    public static final String COL_MAPX = "MAPX";
    public static final String COL_TENPX = "TENPX";
    public static final String COL_MASP_PX = COL_MASP;

    //Table CONGNHAN
    public static final String TABLE_CONGNHAN = "CONGNHAN";
    public static final String COL_MACN = "MACN";
    public static final String COL_HO = "HO";
    public static final String COL_TEN = "TEN";
    public static final String COL_PHAI = "PHAI";
    public static final String COL_NAMSINH = "NAMSINH";
    public static final String COL_NGAYNV = "NGAYNV";
    public static final String COL_LCB = "LCB";
    public static final String COL_MAPX_CN = COL_MAPX;

    //Table CHAMCONG
    public static final String TABLE_CHAMCONG = "CHAMCONG";
    public static final String COL_NGAY = "NGAY";
    public static final String COL_MACN_CC = COL_MACN;
    public static final String COL_SOGIOLAM = "SOGIOLAM";

    //Database
    public static final String DATABASE_NAME = "QL_CONGNHAN";
    public static final int DATABASE_VER = 1;

    //Create table SANPHAM
    public static final String SQL_CREATE_TABLE_SANPHAM = "CREATE TABLE " + TABLE_SANPHAM + " ("
            + COL_MASP + " INTEGER NOT NULL PRIMARY KEY, "
            + COL_TENSP + " TEXT NOT NULL, "
            + COL_DVT + " TEXT NOT NULL, "
            + COL_DONGIA + " INTEGER NOT NULL "
            + ");";

    //Create table PHANXUONG
    public static final String SQL_CREATE_TABLE_PHANXUONG = "CREATE TABLE " + TABLE_PHANXUONG + " ("
            + COL_MAPX + " INTEGER NOT NULL PRIMARY KEY, "
            + COL_TENPX + " TEXT NOT NULL, "
            + COL_MASP_PX + " INTEGER NOT NULL, "
            + "FOREIGN KEY(" + COL_MASP_PX + ") REFERENCES " + TABLE_SANPHAM + "(" + COL_MASP + ")"
            + ");";


    //Create table CONGNHAN
    public static final String SQL_CREATE_TABLE_CONGNHAN = "CREATE TABLE " + TABLE_CONGNHAN + " ("
            + COL_MACN + " INTEGER NOT NULL PRIMARY KEY, "
            + COL_HO + " TEXT NOT NULL, "
            + COL_TEN + " TEXT NOT NULL, "
            + COL_PHAI + " TEXT NOT NULL, "
            + COL_NAMSINH + " INTEGER NOT NULL, "
            + COL_NGAYNV + " TEXT NOT NULL, "
            + COL_LCB + " INTEGER NOT NULL, "
            + COL_MAPX_CN + " INTEGER NOT NULL, "
            + "FOREIGN KEY(" + COL_MAPX_CN + ") REFERENCES " + TABLE_PHANXUONG + "(" + COL_MAPX + ")"
            + ");";

    //Create table CHAMCONG
    public static final String SQL_CREATE_TABLE_CHAMCONG = "CREATE TABLE " + TABLE_CHAMCONG + " ("
            + COL_NGAY + " TEXT NOT NULL, "
            + COL_MACN_CC + " INTEGER NOT NULL, "
            + COL_SOGIOLAM + " INTEGER NOT NULL, "
            + "PRIMARY KEY(" + COL_NGAY + ", " + COL_MACN_CC + "),"
            + "FOREIGN KEY(" + COL_MACN_CC + ") REFERENCES " + TABLE_CONGNHAN + "(" + COL_MACN + ")"
            + ");";

    private Context context;

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
        Log.d(TAG, "DBManager: ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_SANPHAM);
        db.execSQL(SQL_CREATE_TABLE_PHANXUONG);
        db.execSQL(SQL_CREATE_TABLE_CONGNHAN);
        db.execSQL(SQL_CREATE_TABLE_CHAMCONG);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: ");
    }


}
