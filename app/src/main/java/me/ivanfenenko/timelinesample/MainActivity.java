package me.ivanfenenko.timelinesample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.SeekBar;

import me.ivanfenenko.timeline.TimeLineView;

public class MainActivity extends AppCompatActivity {

    SampleListAdapter sampleListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimeLineView timeLineView = (TimeLineView) findViewById(R.id.timeLineView);
        SeekBar seekBarRadius = (SeekBar) findViewById(R.id.seekBarRadius);
        SeekBar seekBarWidth = (SeekBar) findViewById(R.id.seekBarWidth);

        sampleListAdapter = new SampleListAdapter();
        timeLineView.setAdapter(sampleListAdapter);

        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FF2FD700", "succeeded"));
        timeLineView.addItem(new ListItem("#FFD70700", "failed"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));
        timeLineView.addItem(new ListItem("#FFBCBCBC", "hasn't happened"));

        seekBarRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i += 1;
                int val = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics()
                );
                sampleListAdapter.setDotRadius(val);
                sampleListAdapter.notifyDataSetChanged();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        seekBarWidth.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                i += 1;
                int val = (int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, i, getResources().getDisplayMetrics()
                );
                sampleListAdapter.setLineWidth(val);
                sampleListAdapter.notifyDataSetChanged();
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }
}
