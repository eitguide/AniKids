package com.hackathon.anikids.view;

import android.os.Bundle;
import android.widget.TextView;

import com.hackathon.anikids.R;
import com.hackathon.anikids.control.KarateTextView;
import com.hackathon.anikids.widget.SwipeBackActivity;
import com.hackathon.anikids.widget.SwipeBackLayout;

public class StoryActivity extends SwipeBackActivity {
    KarateTextView tvTitle;
    TextView tvStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        String title = getIntent().getStringExtra("title");
        String story = getIntent().getStringExtra("story");
        tvTitle = (KarateTextView) findViewById(R.id.tvTitle);
        tvStory = (TextView) findViewById(R.id.tvStory);
        tvTitle.setText(title);
        tvStory.setText(story);

        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }
}
