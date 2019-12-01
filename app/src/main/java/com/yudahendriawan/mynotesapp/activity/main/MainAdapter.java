package com.yudahendriawan.mynotesapp.activity.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.yudahendriawan.mynotesapp.R;
import com.yudahendriawan.mynotesapp.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<Note> notes;
    private ItemClickListener itemClickListener;

    public MainAdapter(Context context, List<Note> notes, ItemClickListener itemClickListener) {
        this.context = context;
        this.notes = notes;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MainAdapter.RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_note,parent,false);
        return new RecyclerViewAdapter(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.RecyclerViewAdapter holder, int position) {

        Note note = notes.get(position);
//        Date dateMu = null;
//
//        String dateKu = note.getDate();
//
////        Date d = null;
//        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+7:00"));
////        try {
////            d = dateFormat.parse(note.getDate());
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//        try {
//            dateMu = dateFormat.parse(dateKu);
//            String dateGmt = dateFormat.format(dateMu);
//            holder.tv_date.setText(dateGmt);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = null;
//        try {
//            date = format.parse(note.getDate());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        format.setTimeZone(TimeZone.getTimeZone("GMT+07"));
//        String dateKu = String.valueOf(format.format(date));
//
//        double hours = date.getYear();
//        String hoursString = String.valueOf(hours);
//        Log.d(TAG, "YEARS : "+hoursString);

//
//        int years = d.getYear();
//        int month = d.getMonth();
//        int day = d.getDay();
//
//        int hours = d.getHours()+7;
//        int minutes = d.getMinutes();
//        int sekon = d.getSeconds();


        //String date = note.getDate();

        holder.tv_title.setText(note.getTitle());
        holder.tv_note.setText(note.getNote());
//        holder.tv_date.setText(years+ "-"+month+"-"+day+" "+hours+":"+minutes+":"+sekon);
        holder.tv_date.setText(note.getDate());
        holder.card_item.setCardBackgroundColor(note.getColor());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tv_title, tv_note, tv_date;
        CardView card_item;
        ItemClickListener itemClickListener;

        public RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {

            super(itemView);
            this.itemClickListener = itemClickListener;
            tv_title = itemView.findViewById(R.id.title);
            tv_note = itemView.findViewById(R.id.note);
            tv_date = itemView.findViewById(R.id.date);
            card_item = itemView.findViewById(R.id.card_item);

            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onItemClick(v,getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view, int position);
    }
}
