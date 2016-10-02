package com.apps.akhilsreekar.frontend;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsActivivty extends Activity {

    private ImageView imgDrawable;
    int position;
    private TextView tvGameName;
    private TextView tvGameCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details_activivty);
        position = getIntent().getIntExtra("position",0);
        imgDrawable = (ImageView) findViewById(R.id.imgImage);
        tvGameName = (TextView) findViewById(R.id.tvGameName);
        tvGameCount = (TextView) findViewById(R.id.tvGamesCount);
        imgDrawable.setBackground(ContextCompat.getDrawable(this,Data.getData().get(position).imageId));
        tvGameName.setText(Data.getData().get(position).title);
        tvGameCount.setText("2 Games");
    }
}
