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
import com.example.giuaki_final.model.PhanXuong;
import com.example.giuaki_final.model.SanPham;

import java.util.List;

public class PhanXuongAdapter extends ArrayAdapter<PhanXuong> {
    private Context context;
    private int resource;
    private List<PhanXuong> listPX;

    public PhanXuongAdapter(Context context, int resource, List<PhanXuong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listPX = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_phanxuong_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvMaPX = convertView.findViewById(R.id.tv_mapx);
            viewHolder.tvTenPX = convertView.findViewById(R.id.tv_tenpx);
            viewHolder.tvMaSP = convertView.findViewById(R.id.tv_masp);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PhanXuong phanXuong = listPX.get(position);
        viewHolder.tvMaPX.setText(phanXuong.getmMaPX()+"");
        viewHolder.tvTenPX.setText(phanXuong.getmTenPX()+"");
        viewHolder.tvMaSP.setText(phanXuong.getmMaSP()+"");

        return convertView;
    }

    public class ViewHolder {
        private TextView tvMaPX;
        private TextView tvTenPX;
        private TextView tvMaSP;

    }
}
