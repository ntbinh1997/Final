package com.example.giuaki_final;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.giuaki_final.adapter.CongNhanAdapter;
import com.example.giuaki_final.dao.CongNhanDAO;
import com.example.giuaki_final.dao.PhanXuongDAO;
import com.example.giuaki_final.data.DBManager;
import com.example.giuaki_final.model.CongNhan;

import java.util.ArrayList;
import java.util.List;

public class CongNhanActivity extends AppCompatActivity {
    private EditText edtMaCN;
    private EditText edtHo;
    private EditText edtTen;
    private EditText edtPhai;
    private EditText edtNamSinh;
    private EditText edtNgayNV;
    private EditText edtLuongCB;
    private Spinner spnMaPX;
    private Button btnThem;
    private Button btnCapNhat;
    private ListView lvCongNhan;
    private DBManager dbManager;
    private CongNhanAdapter congNhanAdapter;
    private CongNhanDAO congNhanDAO;
    private List<CongNhan> danhSachCN;
    private PhanXuongDAO phanXuongDAO;

    private int maPX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congnhan);
        dbManager = new DBManager(this);
        initWidget();
        congNhanDAO = new CongNhanDAO(dbManager);
        phanXuongDAO = new PhanXuongDAO(dbManager);
        danhSachCN = congNhanDAO.layDSCN();

        List<Integer> listSpn = phanXuongDAO.layMaPX();
        List<String> listSpinner = new ArrayList<>(listSpn.size());
        for (Integer myInt : listSpn) {
            listSpinner.add(String.valueOf(myInt));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listSpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnMaPX.setAdapter(adapter);
        spnMaPX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maPX = Integer.parseInt(spnMaPX.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        setAdapter();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CongNhan congNhan = taoCongNhan(maPX);
                if (congNhan != null) {
                    congNhanDAO.themCongNhan(congNhan);
                }
                capNhatDSCN();
                setAdapter();
            }
        });
        lvCongNhan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CongNhan congNhan = danhSachCN.get(position);
                edtMaCN.setText(String.valueOf(congNhan.getmMaCN()));
                edtHo.setText(congNhan.getmHo());
                edtTen.setText(congNhan.getmTen());
                edtPhai.setText(congNhan.getmPhai());
                edtNamSinh.setText(congNhan.getmNamSinh()+"");
                edtNgayNV.setText(congNhan.getmNgayNV());
                edtLuongCB.setText(congNhan.getmLuongCB()+"");
                btnThem.setEnabled(false);
                btnCapNhat.setEnabled(true);
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CongNhan congNhan = new CongNhan();
                congNhan.setmMaCN(Integer.parseInt(String.valueOf(edtMaCN.getText())));
                congNhan.setmHo(edtHo.getText()+"");
                congNhan.setmTen(edtTen.getText()+"");
                congNhan.setmPhai(edtPhai.getText()+"");
                congNhan.setmNamSinh(Integer.parseInt(edtNamSinh.getText().toString()));
                congNhan.setmNgayNV(edtNgayNV.getText()+"");
                congNhan.setmLuongCB(Integer.parseInt(edtLuongCB.getText().toString()));
                congNhan.setmMaPX(maPX);

                int result = congNhanDAO.capNhatCN(congNhan);
                if(result>0){
                    capNhatDSCN();
                }
                btnThem.setEnabled(true);
                btnCapNhat.setEnabled(false);
            }
        });

        lvCongNhan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                CongNhan congNhan = danhSachCN.get(position);
                int result = congNhanDAO.xoaCN(congNhan.getmMaCN());
                if(result>0){
                    Toast.makeText(CongNhanActivity.this, "Delete successfuly", Toast.LENGTH_SHORT).show();
                    capNhatDSCN();
                }else{
                    Toast.makeText(CongNhanActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }



    private void initWidget(){
        edtMaCN = findViewById(R.id.edt_macn);
        edtHo = findViewById(R.id.edt_ho);
        edtTen = findViewById(R.id.edt_ten);
        edtPhai = findViewById(R.id.edt_phai);
        edtNamSinh = findViewById(R.id.edt_namsinh);
        edtNgayNV = findViewById(R.id.edt_ngaynv);
        edtLuongCB = findViewById(R.id.edt_luongcb);
        spnMaPX = findViewById(R.id.spn_mapx);
        btnThem = findViewById(R.id.btn_them);
        btnCapNhat = findViewById(R.id.btn_capnhat);
        lvCongNhan = findViewById(R.id.lv_congnhan);
    }
    private void setAdapter() {
        if (congNhanAdapter == null) {
            congNhanAdapter = new CongNhanAdapter(this, R.layout.item_congnhan_layout, danhSachCN);
            lvCongNhan.setAdapter(congNhanAdapter);
        }else{
            congNhanAdapter.notifyDataSetChanged();
            lvCongNhan.setSelection(congNhanAdapter.getCount()-1);
        }
    }

    private CongNhan taoCongNhan(int maPX) {
        String ho = edtHo.getText().toString();
        String ten = edtTen.getText().toString();
        String phai = edtPhai.getText().toString();
        int namSinh = Integer.parseInt(edtNamSinh.getText().toString());
        String ngayNV = edtNgayNV.getText().toString();
        int luongCB = Integer.parseInt(edtLuongCB.getText().toString());
        CongNhan congNhan = new CongNhan(ho, ten, phai, namSinh, ngayNV, luongCB, maPX);
        return congNhan;
    }
    public void capNhatDSCN(){
        danhSachCN.clear();
        danhSachCN.addAll(congNhanDAO.layDSCN());
        if(congNhanAdapter!= null){
            congNhanAdapter.notifyDataSetChanged();
        }
    }
}
