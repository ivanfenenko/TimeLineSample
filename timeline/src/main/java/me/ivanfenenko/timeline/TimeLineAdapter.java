package me.ivanfenenko.timeline;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by klickrent on 17/02/2017.
 */

public abstract class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.ViewHolder> {

    private int dotRadius;
    private int lineWidth;

    protected List<TimeLineItem> list = new ArrayList<>();

    public void setDotRadius(int rad) {
        this.dotRadius = rad;
    }

    public void setLineWidth(int width) {
        this.lineWidth = width;
    }

    public List<TimeLineItem> getList() {
        return list;
    }

    public void addItem(TimeLineItem item) {
        list.add(item);
        notifyDataSetChanged();
    }

    public void setAllItems(List<TimeLineItem> items) {
        list.clear();
        list.addAll(items);
        notifyDataSetChanged();
    }

    public void sort(Comparator<? super TimeLineItem> comparator) {
        Collections.sort(list, comparator);
        notifyDataSetChanged();
    }

    public View getItemView(ViewGroup viewGroup, int childLayoutId) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_timeline, viewGroup, false);
        if (childLayoutId != -1) {
            ((FrameLayout) v.findViewById(R.id.content_container)).addView(
                    LayoutInflater.from(viewGroup.getContext()).inflate(childLayoutId, viewGroup, false)
            );
        }
        return v;
    }

    public abstract TimeLineAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);

    @Override
    public void onBindViewHolder(TimeLineAdapter.ViewHolder holder, int position) {
        TimeLineItem item = list.get(position);

        holder.itemView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        int width = Math.max(dotRadius*2, lineWidth);
        int height = holder.itemView.getMeasuredHeight();

        Log.d("TimeLine w h: ", String.valueOf(width) + " " +
                String.valueOf(height));

        Bitmap bitmap = Bitmap.createBitmap(
                width, // Width
                height, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        Canvas canvas = new Canvas(bitmap);

        // Initialize a new Paint instance to draw the Rectangle
        Paint rectStartColor = new Paint();
        rectStartColor.setStyle(Paint.Style.FILL);
        rectStartColor.setColor(item.color);
        rectStartColor.setAntiAlias(true);

        Paint rectEndColor = new Paint();
        rectEndColor.setStyle(Paint.Style.FILL);
        rectEndColor.setColor(getStripColor(position));
        rectEndColor.setAntiAlias(true);

        Paint dotColor = new Paint();
        dotColor.setStyle(Paint.Style.FILL);
        dotColor.setColor(item.color);
        dotColor.setAntiAlias(true);

        boolean noStart = getItemCount() == 1;
        boolean noTail = getItemCount() == 1;

        if (position == 0) {
            noStart = true;
        } else if (position == getItemCount() - 1) {
            noTail = true;
        }

        int lineLeft = (width - lineWidth) / 2;
        int lineRight = lineLeft + lineWidth;

//        if ((((int ) (canvas.getWidth()/4)*3) + ((int) rWidth/4)) < rWidth) {
//            lineEnd = lineEnd + (rWidth - (((int ) (canvas.getWidth()/4)*3) + ((int) rWidth/4)));
//        }

        Rect rectangleTop = new Rect(
                lineLeft, // Left
                0, // Top
                lineRight, // Right
                height/2// Bottom
        );

        Rect rectangleBottom = new Rect(
                lineLeft, // Left
                height/2, // Top
                lineRight, // Right
                height// Bottom
        );

        int rad = width / 2;

        if (!noStart) canvas.drawRect(rectangleTop, rectStartColor);
        if (!noTail) canvas.drawRect(rectangleBottom, rectEndColor);

        canvas.drawCircle(width/2, height/2, rad, dotColor);

        // Display the newly created bitmap on app interface
        holder.leftDrawable.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView leftDrawable;

        public ViewHolder(View itemView) {
            super(itemView);
            leftDrawable = (ImageView) itemView.findViewById(R.id.leftDrawable);
        }
    }

    protected int getStripColor(int position) {
        try {
            return list.get(position + 1).color;
        } catch (Exception ex) {}
        return list.get(position).color;
    }

}
