package me.ivanfenenko.timeline;

import android.graphics.Color;

/**
 * Created by klickrent on 17/02/2017.
 */

public class TimeLineItem {

    public int color;

    public TimeLineItem() {}

    public TimeLineItem(int color) {
        this.color = color;
    }

    public TimeLineItem(String color) {
        this.color = Color.parseColor(color);
    }

}
