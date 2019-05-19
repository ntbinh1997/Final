package com.example.giuaki_final.model;

public class CongNhan {
    private int mMaCN;
    private String mHo;
    private String mTen;
    private String mPhai;
    private int mNamSinh;
    private String mNgayNV;
    private int mLuongCB;
    private int mMaPX;

    public CongNhan(String mHo, String mTen, String mPhai, int mNamSinh, String mNgayNV, int mLuongCB, int mMaPX) {
        this.mHo = mHo;
        this.mTen = mTen;
        this.mPhai = mPhai;
        this.mNamSinh = mNamSinh;
        this.mNgayNV = mNgayNV;
        this.mLuongCB = mLuongCB;
        this.mMaPX = mMaPX;
    }

    public CongNhan(int mMaCN, String mHo, String mTen, String mPhai, int mNamSinh, String mNgayNV, int mLuongCB, int mMaPX) {
        this.mMaCN = mMaCN;
        this.mHo = mHo;
        this.mTen = mTen;
        this.mPhai = mPhai;
        this.mNamSinh = mNamSinh;
        this.mNgayNV = mNgayNV;
        this.mLuongCB = mLuongCB;
        this.mMaPX = mMaPX;
    }

    public CongNhan() {
    }

    public int getmMaCN() {
        return mMaCN;
    }

    public void setmMaCN(int mMaCN) {
        this.mMaCN = mMaCN;
    }

    public String getmHo() {
        return mHo;
    }

    public void setmHo(String mHo) {
        this.mHo = mHo;
    }

    public String getmTen() {
        return mTen;
    }

    public void setmTen(String mTen) {
        this.mTen = mTen;
    }

    public String getmPhai() {
        return mPhai;
    }

    public void setmPhai(String mPhai) {
        this.mPhai = mPhai;
    }

    public int getmNamSinh() {
        return mNamSinh;
    }

    public void setmNamSinh(int mNamSinh) {
        this.mNamSinh = mNamSinh;
    }

    public String getmNgayNV() {
        return mNgayNV;
    }

    public void setmNgayNV(String mNgayNV) {
        this.mNgayNV = mNgayNV;
    }

    public int getmLuongCB() {
        return mLuongCB;
    }

    public void setmLuongCB(int mLuongCB) {
        this.mLuongCB = mLuongCB;
    }

    public int getmMaPX() {
        return mMaPX;
    }

    public void setmMaPX(int mMaPX) {
        this.mMaPX = mMaPX;
    }
}
