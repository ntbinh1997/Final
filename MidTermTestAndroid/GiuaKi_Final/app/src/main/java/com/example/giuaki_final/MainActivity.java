package com.example.giuaki_final;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.giuaki_final.model.ChamCong;
import com.example.giuaki_final.model.CongNhan;
import com.example.giuaki_final.model.PhanXuong;
import com.example.giuaki_final.model.SanPham;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView congNhan, sanPham, chamCong, phanXuong,exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        congNhan = (CardView) findViewById(R.id.congnhan_card);
        sanPham = (CardView) findViewById(R.id.sanpham_card);
        chamCong = (CardView) findViewById(R.id.chamcong_card);
        phanXuong = (CardView) findViewById(R.id.phanxuong_card);
        exit = (CardView) findViewById(R.id.exit_card);
        // Add Click listener
        congNhan.setOnClickListener(this);
        sanPham.setOnClickListener(this);
        chamCong.setOnClickListener(this);
        phanXuong.setOnClickListener(this);
        exit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
    switch (v.getId()){
        case R.id.chamcong_card : i = new Intent(this, ChamCongActivity.class); startActivity(i);break;
        case R.id.sanpham_card : i = new Intent(this, SanPhamActivity.class);startActivity(i);break;
        case R.id.phanxuong_card : i = new Intent(this, PhanXuongActivity.class);startActivity(i);break;
        case R.id.congnhan_card : i = new Intent(this, CongNhanActivity.class);startActivity(i);break;
        case R.id.exit_card :{
            finish();
        }
        default:break;
    }

    }
}
