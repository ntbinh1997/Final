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
import com.example.giuaki_final.model.SanPham;

import java.util.List;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {

    private Context context;
    private int resource;
    private List<SanPham> listSP;

    public SanPhamAdapter(Context context, int resource, List<SanPham> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listSP = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sanpham_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvMaSP = convertView.findViewById(R.id.tv_masp);
            viewHolder.tvTenSP = convertView.findViewById(R.id.tv_tensp);
            viewHolder.tvDVT = convertView.findViewById(R.id.tv_dvt);
            viewHolder.tvDonGia = convertView.findViewById(R.id.tv_dongia);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        SanPham sanPham = listSP.get(position);
        viewHolder.tvMaSP.setText(sanPham.getmMaSP()+"");
        viewHolder.tvTenSP.setText(sanPham.getmTenSP());
        viewHolder.tvDVT.setText(sanPham.getmDVT());
        viewHolder.tvDonGia.setText(sanPham.getmDonGia()+"");

        return convertView;
    }

    public class ViewHolder {
        private TextView tvMaSP;
        private TextView tvTenSP;
        private TextView tvDVT;
        private TextView tvDonGia;

    }
}
