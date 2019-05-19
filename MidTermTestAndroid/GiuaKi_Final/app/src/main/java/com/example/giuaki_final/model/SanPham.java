package com.example.giuaki_final.model;

public class SanPham {
    private int mMaSP;
    private String mTenSP;
    private String mDVT;
    private Float mDonGia;

    public SanPham() {
    }

    public SanPham(String mTenSP, String mDVT, Float mDonGia) {
        this.mTenSP = mTenSP;
        this.mDVT = mDVT;
        this.mDonGia = mDonGia;
    }

    public SanPham(int mMaSP, String mTenSP, String mDVT, Float mDonGia) {
        this.mMaSP = mMaSP;
        this.mTenSP = mTenSP;
        this.mDVT = mDVT;
        this.mDonGia = mDonGia;
    }

    public int getmMaSP() {
        return mMaSP;
    }

    public void setmMaSP(int mMaSP) {
        this.mMaSP = mMaSP;
    }

    public String getmTenSP() {
        return mTenSP;
    }

    public void setmTenSP(String mTenSP) {
        this.mTenSP = mTenSP;
    }

    public String getmDVT() {
        return mDVT;
    }

    public void setmDVT(String mDVT) {
        this.mDVT = mDVT;
    }

    public float getmDonGia() {
        return mDonGia;
    }

    public void setmDonGia(Float mDonGia) {
        this.mDonGia = mDonGia;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "mMaSP=" + mMaSP +
                ", mTenSP='" + mTenSP + '\'' +
                ", mDVT='" + mDVT + '\'' +
                ", mDonGia=" + mDonGia +
                '}';
    }
}
