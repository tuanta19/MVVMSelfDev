package com.tuantran.mvvm_selfdev.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tuantran.mvvm_selfdev.R;
import com.tuantran.mvvm_selfdev.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    Context mContext;
    List<NicePlace> mNicePlaces=new ArrayList<>();

    public RecyclerViewAdapter(Context context, List<NicePlace> nicePlaces) {
        mContext = context;
        mNicePlaces = nicePlaces;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder holder=new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");

        holder.imageName.setText(mNicePlaces.get(position).getImageName());

        Glide.with(mContext)
                .asBitmap()
                .load(mNicePlaces.get(position).getImageUrl())
                .into(holder.mCircleImageView);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mNicePlaces.get(position).getImageName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView mCircleImageView;
        TextView imageName;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageName=itemView.findViewById(R.id.imageName);
            relativeLayout=itemView.findViewById(R.id.relativeLayout);
            mCircleImageView=itemView.findViewById(R.id.circleImage);
        }
    }

}
