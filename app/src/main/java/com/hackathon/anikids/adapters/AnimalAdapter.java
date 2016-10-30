package com.hackathon.anikids.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.anikids.R;
import com.hackathon.anikids.model.Animal;
import com.hackathon.anikids.utils.Utils;
import com.hackathon.anikids.view.DetailActivity;

import java.util.List;

/**
 * Created by nguyennghia on 10/27/16.
 */
public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private static final String TAG = "AnimalAdapter";
    private Context mContext;
    private List<Animal> mData;
//    private CacheBitmap[] mBitmap;


//    class CacheBitmap {
//        boolean isCache;
//        Bitmap mBitmap;
//    }

    public AnimalAdapter(Context context, List<Animal> data) {
        mContext = context;
        mData = data;
//        mBitmap = new CacheBitmap[mData.size()];
//        for (int i = 0; i < mData.size(); i++) {
//            mBitmap[i] = new CacheBitmap();
//        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item_layout, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Animal animal = mData.get(position);

//        if (mBitmap[position].isCache == false) {
//            mBitmap[position].isCache = true;
//            mBitmap[position].mBitmap = Utils.getBitmapFromAssets(mContext, "images/" + animal.getImageUrl());
//            Log.e(TAG, "onBindViewHolder: ");
//        }

//        holder.imvAnimal.setImageBitmap(mBitmap[position].mBitmap);
        new LoadImageBitmapAsync(mContext, holder.imvAnimal).execute(animal.getImageUrl());
        holder.tvAnimal.setText(animal.getNameVN());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imvAnimal;
        private TextView tvAnimal;

        public ViewHolder(View itemView) {
            super(itemView);
            imvAnimal = (ImageView) itemView.findViewById(R.id.imv_animal);
            tvAnimal = (TextView) itemView.findViewById(R.id.tv_animal);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DetailActivity.class);
                    intent.putExtra("currentIndex", getAdapterPosition());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    class LoadImageBitmapAsync extends AsyncTask<String, Void, Bitmap> {
        private Context mContext;
        private ImageView imvAnimal;

        public LoadImageBitmapAsync(Context context, ImageView imvAnimal) {
            mContext = context;
            this.imvAnimal = imvAnimal;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            return Utils.getBitmapFromAssets(mContext, "images/" + strings[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imvAnimal.setImageBitmap(bitmap);
        }
    }
}
