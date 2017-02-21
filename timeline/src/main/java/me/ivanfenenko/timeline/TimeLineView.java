package me.ivanfenenko.timeline;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.TypedValue;

import java.util.Comparator;
import java.util.List;

/**
 * Created by klickrent on 17/02/2017.
 */

public class TimeLineView extends RecyclerView {

    private int dotRadius;
    private int lineWidth;

    public TimeLineView(Context context) {
        super(context);
        init(context, null);
    }

    public TimeLineView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TimeLineView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs) {
        dotRadius = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 8, context.getResources().getDisplayMetrics()
        );
        lineWidth = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, context.getResources().getDisplayMetrics()
        );
        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    R.styleable.TimeLineView,
                    0, 0);
            try {
                dotRadius = (int) a.getDimension(R.styleable.TimeLineView_dotRadius, dotRadius);
                lineWidth = (int) a.getDimension(R.styleable.TimeLineView_lineWidth, lineWidth);
            } finally {
                a.recycle();
            }
        }

        setOverScrollMode(OVER_SCROLL_NEVER);
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void setAdapter(TimeLineAdapter adapter) {
        adapter.setDotRadius(dotRadius);
        adapter.setLineWidth(lineWidth);
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
