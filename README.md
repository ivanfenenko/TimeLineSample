# TimeLineSample
RecyclerView based Timeline for android 

![alt tag](https://github.com/ivanfenenko/TimeLineSample/blob/master/photo_2017-02-17_16-42-28.jpg)

How to use?

1. Add view to your layout file

```
<me.ivanfenenko.timeline.TimeLineView
        android:id="@+id/timeLineView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

2. Create an adapter which extends `TimeLineAdapter` 

```
public class SampleListAdapter extends TimeLineAdapter {

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // IMPORTANT!!: call method "getItemView" to inject your content view into timeline list item
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
```

3. Add set adapter to TimelineView and add your objects to the view 

`color` property in TimelineItem defines the color of timeline indicator

```
TimeLineView timeLineView = (TimeLineView) findViewById(R.id.timeLineView);

timeLineView.setAdapter(new SampleListAdapter());

timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FFD70700"));
timeLineView.addItem(new ListItem("#FFD70700"));
```
