package com.ehoo.viewlibrary;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private final int header = 0;
    private final int normal = 1;
    private final int footer = 2;
    ArrayList<String> list = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        for (int i=0;i<30;i++){
            list.add(""+i);
        }
        recyclerView.setAdapter(new RecyclerView.Adapter() {



            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.v("recyclerview","oncreateviewholder");
                switch (viewType) {
                    case normal:
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, null);
                        MyViewHolder myViewHolder = new MyViewHolder(view);
                        myViewHolder.setTextView((TextView) view.findViewById(R.id.tv));
                        break;
                    case footer:
                        View fv=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,null);
                        FooterViewHolder fvh=new FooterViewHolder(fv);
                        fvh.setTextView((TextView) fv.findViewById(R.id.tv));
                        break;
                    case header:
                        View hv=LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item,null);
                        HeaderViewHolder hvh=new HeaderViewHolder(hv);
                        hvh.setTextView((TextView) hv.findViewById(R.id.tv));
                        break;
                }
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                 Log.v("recyclerview","onBindViewHolder<<<<<<<<"+position);
                  switch (holder.getItemViewType()){
                      case header:
                          HeaderViewHolder viewHolder_Header= (HeaderViewHolder) holder;
                          viewHolder_Header.getTextView().setText("header");
                          break;
                      case normal:
                          MyViewHolder viewHolder_normal= (MyViewHolder) holder;
                          viewHolder_normal.getTextView().setText(list.get(position));
                          break;
                      case footer:
                          FooterViewHolder viewHolder_footer= (FooterViewHolder) holder;
                          viewHolder_footer.getTextView().setText("footer");
                          break;
                  }


            }

            @Override
            public int getItemViewType(int position) {
                Log.v("recyclerview", "getItemViewType<<<<<<<<" + position);
                if (position == 0) return header;
                if (position == list.size()) return footer;
                return normal;
            }

            @Override
            public int getItemCount() {
                return list.size();
            }

            class  MyViewHolder extends RecyclerView.ViewHolder{
             private    TextView textView;

                public TextView getTextView() {
                    return textView;
                }

                public void setTextView(TextView textView) {
                    this.textView = textView;
                }

                public MyViewHolder(View itemView) {
                    super(itemView);
                }
            }

            class  FooterViewHolder extends  RecyclerView.ViewHolder{
              private   TextView textView;

                public void setTextView(TextView textView) {
                    this.textView = textView;
                }

                public TextView getTextView() {
                    return textView;
                }

                public FooterViewHolder(View itemView) {
                    super(itemView);
                }
            }

            class  HeaderViewHolder extends RecyclerView.ViewHolder{
              private   TextView textView;

                public TextView getTextView() {
                    return textView;
                }

                public void setTextView(TextView textView) {
                    this.textView = textView;
                }

                public HeaderViewHolder(View itemView) {
                    super(itemView);
                }
            }

        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
