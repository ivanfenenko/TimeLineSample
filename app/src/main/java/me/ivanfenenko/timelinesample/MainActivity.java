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

        timeLineView.setAdapter(new SampleListAdapter());

        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FFD70700", "failed"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));
    }
}
