package com.example.giuaki_final.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.giuaki_final.R;
import com.example.giuaki_final.model.CongNhan;

import java.util.List;

public class CongNhanAdapter extends ArrayAdapter<CongNhan> {
    private Context context;
    private int resource;
    private List<CongNhan> listCN;

    public CongNhanAdapter(Context context, int resource, List<CongNhan> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listCN = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_congnhan_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvMaCN = convertView.findViewById(R.id.tv_macn);
            viewHolder.tvHoTen = convertView.findViewById(R.id.tv_hoten);
            viewHolder.tvPhai = convertView.findViewById(R.id.tv_phai);
            viewHolder.tvNamSinh = convertView.findViewById(R.id.tv_namsinh);
            viewHolder.tvNgayNV = convertView.findViewById(R.id.tv_ngaynv);
            viewHolder.tvLuongCB = convertView.findViewById(R.id.tv_luongcb);
            viewHolder.tvMaPX = convertView.findViewById(R.id.tv_mapx);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CongNhan congNhan = listCN.get(position);
        viewHolder.tvMaCN.setText(congNhan.getmMaCN() + "");
        viewHolder.tvHoTen.setText(congNhan.getmHo() + " " + congNhan.getmTen());
        viewHolder.tvPhai.setText(congNhan.getmPhai() + "");
        viewHolder.tvNamSinh.setText(congNhan.getmNamSinh() + "");
        viewHolder.tvNgayNV.setText(congNhan.getmNgayNV() + "");
        viewHolder.tvLuongCB.setText(congNhan.getmLuongCB() + "");
        viewHolder.tvMaPX.setText(congNhan.getmMaPX() + "");

        return convertView;
    }

    public class ViewHolder {
        private TextView tvMaCN;
        private TextView tvHoTen;
        private TextView tvPhai;
        private TextView tvNamSinh;
        private TextView tvNgayNV;
        private TextView tvLuongCB;
        private TextView tvMaPX;
    }
}
