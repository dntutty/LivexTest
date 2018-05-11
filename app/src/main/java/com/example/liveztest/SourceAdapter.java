package com.example.liveztest;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import com.example.liveztest.LiveSource;


public class SourceAdapter extends RecyclerView.Adapter<SourceAdapter.ViewHolder> {

    private ArrayList<LiveSource> sources;//存放要展示的数据集
    
    //用以保存Recycle
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView sourceName;
        //构造ViewHolder时保存ItemView中的控件
        public ViewHolder(View view) {
            super(view);
            sourceName = (TextView) view.findViewById(R.id.source_name);
        }
    }

    /**
     * 
     * @param sources 构造Adapter时初始化数据集
     */
    public SourceAdapter(ArrayList<LiveSource> sources) {
        this.sources = sources;
    }

    /**
     * 获取数据集子项个数
     * @return
     */
    // TODO: 2018/5/11 猜想在创建ViewHolder和绑定ViewHolder时都会调用
    @Override
    public int getItemCount() {
        return sources.size();
    }
    
    
    /**
     * 在recyclerView填充ItemView
     * @param parent 要填充的recyclerView
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.source_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * 将数据集中对应子项的数据绑定到ViewHolder中的控件
     * @param holder
     * @param position
     */
    // TODO: 2018/5/11 猜测应该会根据Item的个数n调用n次 
    @Override
    public void onBindViewHolder(ViewHolder holder,int position) {
        LiveSource source = sources.get(position);
        holder.sourceName.setText(source.getName());
    }

    public void setItems(ArrayList<LiveSource> sources) {
        this.sources = sources;
    }

   
}
