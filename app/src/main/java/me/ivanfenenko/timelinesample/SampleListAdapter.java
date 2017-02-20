package me.ivanfenenko.timelinesample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.ivanfenenko.timeline.TimeLineAdapter;

/**
 * Created by klickrent on 17/02/2017.
 */

public class SampleListAdapter extends TimeLineAdapter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = getItemView(viewGroup, R.layout.item_content);
        return new ViewHolder(v);
    }

    protected class ViewHolder extends TimeLineAdapter.ViewHolder {

        TextView textView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public void onBindViewHolder(TimeLineAdapter.ViewHolder holder, int position) {
        ((ViewHolder) holder).textView.setText(((ListItem) getList().get(position)).text);
        super.onBindViewHolder(holder, position);
    }

}
