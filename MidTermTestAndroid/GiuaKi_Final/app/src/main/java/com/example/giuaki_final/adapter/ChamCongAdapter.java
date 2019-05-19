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
import com.example.giuaki_final.model.ChamCong;
import com.example.giuaki_final.model.PhanXuong;

import java.util.List;

public class ChamCongAdapter extends ArrayAdapter<ChamCong> {
    private Context context;
    private int resource;
    private List<ChamCong> listCC;

    public ChamCongAdapter(Context context, int resource, List<ChamCong> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.listCC = objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_chamcong_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvNgay = convertView.findViewById(R.id.tv_ngay);
            viewHolder.tvMaCN = convertView.findViewById(R.id.tv_macn);
            viewHolder.tvSoGioLam = convertView.findViewById(R.id.tv_sogiolam);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ChamCong chamCong = listCC.get(position);
        viewHolder.tvNgay.setText(chamCong.getmNgay()+"");
        viewHolder.tvMaCN.setText(chamCong.getmMaCN()+"");
        viewHolder.tvSoGioLam.setText(chamCong.getmSoGioLam()+"");

        return convertView;
    }

    public class ViewHolder {
        private TextView tvNgay;
        private TextView tvMaCN;
        private TextView tvSoGioLam;
    }
}
