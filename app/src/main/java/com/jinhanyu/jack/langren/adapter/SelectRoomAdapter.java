package com.jinhanyu.jack.langren.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jinhanyu.jack.langren.MainApplication;
import com.jinhanyu.jack.langren.MarqueenTextView;
import com.jinhanyu.jack.langren.R;
import com.jinhanyu.jack.langren.entity.RoomInfo;
import com.jinhanyu.jack.langren.ui.RoomActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anzhuo on 2016/9/9.
 */
public class SelectRoomAdapter extends CommonAdapter<RoomInfo> {


    public SelectRoomAdapter(Context context, List<RoomInfo> data) {
        super(context, data);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.select_room_item, null);
            viewHolder = new ViewHolder();
            viewHolder.roomName = (TextView) view.findViewById(R.id.tv_room_name);
            viewHolder.peopleNum = (TextView) view.findViewById(R.id.tv_room_peopleNum);
            viewHolder.totalNum = (TextView) view.findViewById(R.id.tv_room_totalNum);
            viewHolder.roomTypes = (MarqueenTextView) view.findViewById(R.id.tv_room_types);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final RoomInfo roomInfo = data.get(i);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roomInfo.getCurrentCount()==roomInfo.getMaxCount())
                    Toast.makeText(context, "房间已满", Toast.LENGTH_SHORT).show();
                else {
                    MainApplication.roomInfo = roomInfo;
                    context.startActivity(new Intent(context, RoomActivity.class));
                }
            }
        });

        viewHolder.peopleNum.setText(roomInfo.getCurrentCount()+"");
        viewHolder.totalNum.setText(roomInfo.getMaxCount()+"");
        viewHolder.roomName.setText(roomInfo.getName());
        List<String> news =new ArrayList<>();
        news.add(roomInfo.getTypesString());
        viewHolder.roomTypes.setData(news);
        return view;
    }



    class ViewHolder {
        TextView roomName;
        TextView peopleNum;
        TextView totalNum;
        MarqueenTextView roomTypes;
    }
}
