package com.hackathon.anikids.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.hackathon.anikids.DrawActivity;
import com.hackathon.anikids.R;
import com.hackathon.anikids.model.Animal;
import com.hackathon.anikids.utils.Utils;
import com.hackathon.anikids.view.StoryActivity;
import com.hackathon.anikids.view.YoutubeActivity;

/**
 * Created by nguyennghia on 10/29/16.
 */
public class AnimalFragment extends Fragment {
    private static final String TAG = "AnimalFragment";

    private static final String TABLE_QUOTE = "Anikids";
    private static final String ID_COLUMN = "id";
    private static final String NAME_VN_COLUMN = "name_vn";
    private static final String NAME_US_COLUMN = "name_us";
    private static final String AUDIO_URL_COLUMNN = "audio_url";
    private static final String IMAGE_URL_COLUMN = "image_url";
    private static final String STORY_COLUMN = "story";
    private static final String QUESTION_COLUMN = "question";
    private static final String STATUS_COLUMN = "status";
    private View mRootView;
    private Animal mAnimal;
    private FrameLayout flFooter;

    private TextView tvNameVN;
    private TextView tvNameUS;
    private ImageView imvAnimal;
    private ImageView imvGame;
    private ImageView imvDraw;
    private ImageView imvStory;

    private MediaPlayer mMediaPlayer;


    public static AnimalFragment newInstance(Animal animal) {

        Bundle args = new Bundle();
        args.putInt(ID_COLUMN, animal.getId());
        args.putCharSequence(NAME_VN_COLUMN, animal.getNameVN());
        args.putCharSequence(NAME_US_COLUMN, animal.getNamveUS());
        args.putCharSequence(IMAGE_URL_COLUMN, animal.getImageUrl());
        args.putCharSequence(AUDIO_URL_COLUMNN, animal.getAudioUrl());
        args.putCharSequence(STORY_COLUMN, animal.getStory());
        args.putCharSequence(QUESTION_COLUMN, animal.getQuestion());
        args.putCharSequence(STATUS_COLUMN, animal.getStatus());

        AnimalFragment fragment = new AnimalFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        mAnimal = new Animal(bundle.getInt(ID_COLUMN), bundle.getCharSequence(NAME_VN_COLUMN).toString(), bundle.getCharSequence(NAME_US_COLUMN).toString()
                , bundle.getCharSequence(AUDIO_URL_COLUMNN).toString(), bundle.getCharSequence(IMAGE_URL_COLUMN).toString()
                , bundle.getCharSequence(STORY_COLUMN).toString(), bundle.getCharSequence(QUESTION_COLUMN).toString(), bundle.getString(STATUS_COLUMN));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_animal_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        flFooter = (FrameLayout) view.findViewById(R.id.fv_footer);

        FrameLayout.LayoutParams param = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                (int) (0.4 * Utils.getWidth(getActivity())));
        param.gravity = Gravity.BOTTOM;
        flFooter.setLayoutParams(param);


        //findViewById


        tvNameVN = (TextView) view.findViewById(R.id.tv_name_vn);
        tvNameUS = (TextView) view.findViewById(R.id.tv_name_us);
        imvAnimal = (ImageView) view.findViewById(R.id.imv_animal);
        imvStory = (ImageView) view.findViewById(R.id.imv_story);
        imvDraw = (ImageView) view.findViewById(R.id.imv_draw_color);
        imvGame = (ImageView) view.findViewById(R.id.imv_game);
        tvNameVN.setText(mAnimal.getNameVN());
        tvNameUS.setText("(" + (mAnimal.getNamveUS() + ")"));
        new LoadImageAsyncTask(getActivity(), imvAnimal).execute("images/" + mAnimal.getImageUrl());
        imvAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idAudioRaw = getActivity().getResources().getIdentifier(mAnimal.getAudioUrl().substring(0, mAnimal.getAudioUrl().length() - 4),
                        "raw", getActivity().getPackageName());

                mMediaPlayer = MediaPlayer.create(getActivity(), idAudioRaw);
                mMediaPlayer.setLooping(false);
                mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        if (!mediaPlayer.isPlaying()) {
                            mediaPlayer.start();
                        } else {
                            mediaPlayer.stop();
                            mediaPlayer.start();
                        }
                    }
                });

            }
        });


        imvStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), StoryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                int index = mAnimal.getStory().indexOf("\r\n");
                String title = mAnimal.getStory().substring(0, index);
                intent.putExtra("title", title);
                intent.putExtra("story", mAnimal.getStory());
                startActivity(intent);
            }

        });

        imvDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DrawActivity.class);
                startActivity(intent);
            }
        });

        imvGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), YoutubeActivity.class);
                intent.putExtra("videoId", mAnimal.getStatus());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.stop();
            mMediaPlayer = null;
        }

    }

    class LoadImageAsyncTask extends AsyncTask<String, Void, Bitmap> {

        private ImageView imvAnimal;
        private Context mContext;

        public LoadImageAsyncTask(Context context, ImageView imv) {
            imvAnimal = imv;
            mContext = context;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            return Utils.getBitmapFromAssets(mContext, strings[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imvAnimal.setImageBitmap(bitmap);
        }
    }


}
