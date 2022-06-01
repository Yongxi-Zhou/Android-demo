package edu.neu.presidentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<President> presidentList;
    Context context;

    public RecycleViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_presName.setText(presidentList.get(position).getName());
        holder.tv_date.setText(String.valueOf(presidentList.get(position).getDateOfElection()));
        Glide.with(context).load(presidentList.get(position).getImageURL()).into(holder.iv_presPic);
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_presPic;
        TextView tv_presName;
        TextView tv_date;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_presPic = itemView.findViewById(R.id.iv_presPic);
            tv_presName = itemView.findViewById(R.id.tv_presName);
            tv_date = itemView.findViewById(R.id.tv_date);
        }
    }
}
