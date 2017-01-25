package com.mah.newsma.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mah.newsma.Details;
import com.mah.newsma.MainActivity;
import com.mah.newsma.R;
import com.mah.newsma.dataprocess.DataEncap;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mah on 1/25/2017.
 */

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.ViewHolder> implements View.OnClickListener{

    ArrayList<DataEncap> arrayList;
    Context context;
    MainActivity mainActivity;
    DataEncap encap = new DataEncap();

    public AdapterNews(ArrayList<DataEncap> arrayList, Context context, MainActivity mainActivity) {
        this.arrayList = arrayList;
        this.context = context;
        this.mainActivity = mainActivity;
    }

    @Override
    public AdapterNews.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View Layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.items,parent,false);
        ViewHolder viewHolder = new ViewHolder(Layout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterNews.ViewHolder holder, int position) {

        encap = arrayList.get(position);

        holder.cardView.setTag(position);

        holder.textTitle.setText(encap.getTitle());
        holder.textDesc.setText(encap.getDisc());
        Picasso.with(context).load(encap.getImg()).into(holder.imageNews);
    }

    @Override
    public int getItemCount() {
        return  arrayList.size();
    }

    @Override
    public void onClick(View view) {

    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CardView cardView;
        ImageView imageNews;
        TextView textTitle;
        TextView textDesc;

        public ViewHolder(View layout) {
            super(layout);

            cardView = (CardView) layout.findViewById(R.id.list_row_container);
            imageNews = (ImageView) layout.findViewById(R.id.news_image);
            textTitle = (TextView) layout.findViewById(R.id.title_news);
            textDesc = (TextView) layout.findViewById(R.id.desc_news);
            cardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = (int) view.getTag();

            encap = arrayList.get(position);

            Intent intent = new Intent(mainActivity, Details.class);

            intent.putExtra("title", encap.getTitle());
            intent.putExtra("desc", encap.getDisc());
            intent.putExtra("image", encap.getImg());

            mainActivity.startActivity(intent);

        }

    }

}
