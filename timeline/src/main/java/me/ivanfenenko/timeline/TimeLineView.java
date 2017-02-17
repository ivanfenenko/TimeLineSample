package me.ivanfenenko.timeline;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.Comparator;
import java.util.List;

/**
 * Created by klickrent on 17/02/2017.
 */

public class TimeLineView extends RecyclerView {

    public TimeLineView(Context context) {
        super(context);
        init();
    }

    public TimeLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TimeLineView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setAdapter(TimeLineAdapter adapter) {
        super.setAdapter(adapter);
    }

    public TimeLineAdapter getAdapter() {
        if (super.getAdapter() != null && super.getAdapter() instanceof TimeLineAdapter) {
            return (TimeLineAdapter) super.getAdapter();
        } else return null;
    }

    public void addItem(TimeLineItem item) {
        if (super.getAdapter() != null && super.getAdapter() instanceof TimeLineAdapter) {
            ((TimeLineAdapter) super.getAdapter()).addItem(item);
        }
    }

    public void setItems(List<TimeLineItem> items) {
        if (super.getAdapter() != null && super.getAdapter() instanceof TimeLineAdapter) {
            ((TimeLineAdapter) super.getAdapter()).setAllItems(items);
        }
    }

    public void sortItems(Comparator<? super TimeLineItem> comparator) {
        if (getAdapter() != null && getAdapter() instanceof TimeLineAdapter) {
            ((TimeLineAdapter) super.getAdapter()).sort(comparator);
        }
    }

}
