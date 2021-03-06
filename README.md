# TimeLineSample
RecyclerView based Timeline for android 

<img src="https://github.com/ivanfenenko/TimeLineSample/blob/master/screenshots/sample.jpg" width="200">

How to use?

### Add view to your layout file

``` xml
<me.ivanfenenko.timeline.TimeLineView
        android:id="@+id/timeLineView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

### Adjust size of dot and line 

Defaults are:
```
        app:dotRadius="8dp"
        app:lineWidth="4dp"
```

#### Create an adapter which extends `TimeLineAdapter` 

``` java
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

### Add set adapter to TimelineView and add your objects to the view 

`color` property in TimelineItem defines the color of timeline indicator

``` java
TimeLineView timeLineView = (TimeLineView) findViewById(R.id.timeLineView);

timeLineView.setAdapter(new SampleListAdapter());

timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FF2FD700"));
timeLineView.addItem(new ListItem("#FFD70700"));
timeLineView.addItem(new ListItem("#FFD70700"));
```
