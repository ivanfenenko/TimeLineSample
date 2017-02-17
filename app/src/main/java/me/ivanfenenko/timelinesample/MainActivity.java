package me.ivanfenenko.timelinesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.ivanfenenko.timeline.TimeLineView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeLineView timeLineView = (TimeLineView) findViewById(R.id.timeLineView);

        timeLineView.setAdapter(new DatesListAdapter());

        timeLineView.addItem(new ListItem("#FF2FD700"));
        timeLineView.addItem(new ListItem("#FF2FD700"));
        timeLineView.addItem(new ListItem("#FF2FD700"));
        timeLineView.addItem(new ListItem("#FFD70700"));
        timeLineView.addItem(new ListItem("#FFD70700"));
    }
}
