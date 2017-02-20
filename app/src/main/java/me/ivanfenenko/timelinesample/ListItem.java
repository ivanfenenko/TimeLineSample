package me.ivanfenenko.timelinesample;

import me.ivanfenenko.timeline.TimeLineItem;

/**
 * Created by klickrent on 17/02/2017.
 */

public class ListItem extends TimeLineItem {

    public String text;

    public ListItem(String color, String text) {
        super(color);
        this.text = text;
    }

}
