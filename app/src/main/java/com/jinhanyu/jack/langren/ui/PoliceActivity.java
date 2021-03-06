package com.jinhanyu.jack.langren.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.jinhanyu.jack.langren.ActionPerformer;
import com.jinhanyu.jack.langren.Constants;
import com.jinhanyu.jack.langren.MainApplication;
import com.jinhanyu.jack.langren.R;
import com.jinhanyu.jack.langren.TickTimer;
import com.jinhanyu.jack.langren.adapter.GameRoleCommonAdapter;
import com.jinhanyu.jack.langren.entity.GameRole;

/**
 * Created by anzhuo on 2016/9/26.
 */
public class PoliceActivity extends AppCompatActivity implements ActionPerformer {

    private GameRoleCommonAdapter adapter;
    private ListView listView;
    private TextView time_label;
    private TickTimer tickTimer;
    private String newPoliceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.police);
        listView = (ListView) findViewById(R.id.police_listView);
        adapter = new GameRoleCommonAdapter(this, MainApplication.roomInfo.getAliveUsers(), GameRole.Type.Police);
        listView.setAdapter(adapter);
        time_label = (TextView) findViewById(R.id.time_label);
        listView.setAdapter(adapter);
        tickTimer = new TickTimer(time_label, Constants.POLICE_SECONDS, adapter) {
            @Override
            protected void onTimeEnd() {
                super.onTimeEnd();
                MainApplication.socket.emit("deliverPolice", MainApplication.roomInfo.getRoomId(), newPoliceId);
                finish();
            }
        };
        tickTimer.startTick();
    }

    @Override
    public void doAction(Object... params) {
        newPoliceId = (String) params[0];
    }
}
