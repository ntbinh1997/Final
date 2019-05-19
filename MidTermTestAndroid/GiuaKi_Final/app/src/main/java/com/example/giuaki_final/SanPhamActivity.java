package com.example.giuaki_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.giuaki_final.adapter.SanPhamAdapter;
import com.example.giuaki_final.dao.SanPhamDAO;
import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.SanPham;

import java.util.List;

public class SanPhamActivity extends AppCompatActivity {

    private EditText edtMaSP;
    private EditText edtTenSP;
    private EditText edtDVT;
    private EditText edtDonGia;
    private Button btnLuu;
    private Button btnCapNhat;
    private ListView lvSanPham;
    private DBManager dbManager;
    private SanPhamAdapter sanPhamAdapter;
    private List<SanPham> danhSachSP;
    private SanPhamDAO sanPhamDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham);
        dbManager = new DBManager(this);
        sanPhamDAO = new SanPhamDAO(dbManager);
        initWidget();
        danhSachSP = sanPhamDAO.layDSSP();
        setAdapter();
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SanPham sanPham = taoSanPham();
                if (sanPham != null) {
                    sanPhamDAO.themSanPham(sanPham);
                }
                capNhatDSSP();
                setAdapter();
            }
        });

        lvSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SanPham sanPham = danhSachSP.get(position);
                System.out.println(sanPham);
                edtMaSP.setText(String.valueOf(sanPham.getmMaSP()));
                edtTenSP.setText(sanPham.getmTenSP());
                edtDVT.setText(sanPham.getmDVT());
                edtDonGia.setText(String.valueOf(sanPham.getmDonGia()));
                btnLuu.setEnabled(false);
                btnCapNhat.setEnabled(true);
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sanPham = new SanPham();
                sanPham.setmMaSP(Integer.parseInt(String.valueOf(edtMaSP.getText())));
                sanPham.setmTenSP(edtTenSP.getText()+"");
                sanPham.setmDVT(edtDVT.getText()+"");
                sanPham.setmDonGia(Float.parseFloat(edtDonGia.getText().toString()));
                int result = sanPhamDAO.capNhatSP(sanPham);
                if(result>0){
                    capNhatDSSP();
                }
                btnLuu.setEnabled(true);
                btnCapNhat.setEnabled(false);
            }
        });

        lvSanPham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                SanPham sanPham = danhSachSP.get(position);
                int result = sanPhamDAO.xoaSP(sanPham.getmMaSP());
                if(result>0){
                    Toast.makeText(SanPhamActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    capNhatDSSP();
                }else{
                    Toast.makeText(SanPhamActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private SanPham taoSanPham() {
        String tenSP = edtTenSP.getText().toString();
        String dVT = edtDVT.getText().toString();
        float donGia = Float.valueOf(edtDonGia.getText().toString());
        SanPham sanPham = new SanPham(tenSP, dVT, donGia);
        return sanPham;
    }

    private void initWidget() {
        edtMaSP = findViewById(R.id.edt_masp);
        edtTenSP = findViewById(R.id.edt_tensp);
        edtDVT = findViewById(R.id.edt_dvt);
        edtDonGia = findViewById(R.id.edt_dongia);
        btnLuu = findViewById(R.id.btn_luu);
        btnCapNhat = findViewById(R.id.btn_capnhat);
        lvSanPham = findViewById(R.id.lv_sanpham);
    }

    private void setAdapter() {
        if (sanPhamAdapter == null) {
            sanPhamAdapter = new SanPhamAdapter(this, R.layout.item_sanpham_layout, danhSachSP);
            lvSanPham.setAdapter(sanPhamAdapter);
        }else{
            sanPhamAdapter.notifyDataSetChanged();
            lvSanPham.setSelection(sanPhamAdapter.getCount()-1);
        }
    }

    public void capNhatDSSP(){
        danhSachSP.clear();
        danhSachSP.addAll(sanPhamDAO.layDSSP());
        if(sanPhamAdapter!= null){
            sanPhamAdapter.notifyDataSetChanged();
        }
    }
}
