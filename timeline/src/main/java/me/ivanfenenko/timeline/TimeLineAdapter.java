package me.ivanfenenko.timeline;

import android.support.v7.widget.RecyclerView;
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

    private int childLayoutId = -1;

    protected List<TimeLineItem> list = new ArrayList<>();

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
        if (position == 0) {
            holder.leftDrawable.setImageDrawable(
                    holder.itemView.getContext().getResources().getDrawable(R.drawable.ic_tl_top)
            );
            holder.leftDrawable.setColorFilter(item.color);
        } else if (position == getItemCount() - 1) {
            holder.leftDrawable.setImageDrawable(
                    holder.itemView.getContext().getResources().getDrawable(R.drawable.ic_tl_bottom)
            );
            holder.leftDrawable.setColorFilter(item.color);
        } else {
            holder.leftDrawable.setImageDrawable(
                    holder.itemView.getContext().getResources().getDrawable(R.drawable.ic_tl_middle)
            );
            holder.leftDrawable.setColorFilter(item.color);
        }
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
}
