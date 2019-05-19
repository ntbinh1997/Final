package com.example.giuaki_final.model;

public class ChamCong {
    private String mNgay;
    private int mMaCN;
    private int mSoGioLam;

    public String getmNgay() {
        return mNgay;
    }

    public void setmNgay(String mNgay) {
        this.mNgay = mNgay;
    }

    public int getmMaCN() {
        return mMaCN;
    }

    public void setmMaCN(int mMaCN) {
        this.mMaCN = mMaCN;
    }

    public int getmSoGioLam() {
        return mSoGioLam;
    }

    public void setmSoGioLam(int mSoGioLam) {
        this.mSoGioLam = mSoGioLam;
    }

    public ChamCong() {
    }

    public ChamCong(String mNgay, int mMaCN, int mSoGioLam) {
        this.mNgay = mNgay;
        this.mMaCN = mMaCN;
        this.mSoGioLam = mSoGioLam;
    }
}
