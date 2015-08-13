package com.logoocc.listviewpro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.logoocc.listviewpro.R;
import com.logoocc.listviewpro.entity.Contacts;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by samchen on 8/13/15.
 */
public class ContactsAdapter extends BaseAdapter {
    private LayoutInflater lif;
    private List<Contacts> contactses;
    private View.OnClickListener clickLis;

    public ContactsAdapter(Context context, List<Contacts> contactses, View.OnClickListener clickLis) {
        this.lif = LayoutInflater.from(context);
        if (contactses != null) {
            this.contactses = contactses;
        } else {
            this.contactses = new LinkedList<Contacts>();
        }

        this.clickLis = clickLis;
    }

    @Override
    public int getCount() {
        return contactses != null ? contactses.size() : 0;
    }

    @Override
    public Contacts getItem(int position) {
        return contactses.get(position);
    }

    @Override
    public long getItemId(int position) {
        int i = contactses.get(position).getId();
        return Long.valueOf(i);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        ViewHolder holder = null;
        if (v == null) {
            v = lif.inflate(R.layout.layout_item_info, null);
            holder = new ViewHolder();

            holder.imgDel = (ImageView) v.findViewById(R.id.item_delete);
            holder.tvName = (TextView) v.findViewById(R.id.item_name);
            holder.tvQq = (TextView) v.findViewById(R.id.item_qq);
            holder.tvTel = (TextView) v.findViewById(R.id.item_tel);
            holder.tvAddress = (TextView) v.findViewById(R.id.item_addr);

            holder.imgDel.setOnClickListener(clickLis);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        Contacts c = getItem(position);

        holder.tvName.setText(c.getName());
        holder.tvTel.setText(c.getTel());
        holder.tvAddress.setText(c.getAddress());
        holder.tvQq.setText(c.getQq());
        holder.imgDel.setTag(c.getId());

        return v;
    }

    class ViewHolder {
        TextView tvName;
        TextView tvQq;
        TextView tvTel;
        TextView tvAddress;
        ImageView imgDel;
    }

    public void addAll(List<Contacts> contactses) {
        this.contactses.addAll(contactses);
        notifyDataSetChanged();
    }

    public void clear() {
        this.contactses.clear();
    }
}
