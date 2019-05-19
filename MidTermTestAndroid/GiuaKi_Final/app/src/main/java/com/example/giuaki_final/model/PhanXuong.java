package com.example.giuaki_final.model;

public class PhanXuong {
    private int mMaPX;
    private String mTenPX;
    private int mMaSP;

    public PhanXuong() {
    }

    public PhanXuong(int mMaPX, String mTenPX, int mMaSP) {
        this.mMaPX = mMaPX;
        this.mTenPX = mTenPX;
        this.mMaSP = mMaSP;
    }

    public PhanXuong(String mTenPX, int mMaSP) {
        this.mTenPX = mTenPX;
        this.mMaSP = mMaSP;
    }

    public int getmMaPX() {
        return mMaPX;
    }

    public void setmMaPX(int mMaPX) {
        this.mMaPX = mMaPX;
    }

    public String getmTenPX() {
        return mTenPX;
    }

    public void setmTenPX(String mTenPX) {
        this.mTenPX = mTenPX;
    }

    public int getmMaSP() {
        return mMaSP;
    }

    public void setmMaSP(int mMaSP) {
        this.mMaSP = mMaSP;
    }

    @Override
    public String toString() {
        return "PhanXuong{" +
                "mMaPX=" + mMaPX +
                ", mTenPX='" + mTenPX + '\'' +
                ", mMaSP=" + mMaSP +
                '}';
    }
}
