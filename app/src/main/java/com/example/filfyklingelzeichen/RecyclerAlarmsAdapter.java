package com.example.filfyklingelzeichen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.switchmaterial.SwitchMaterial;

import com.example.filfyklingelzeichen.db.Alarm;

import java.util.List;

public class RecyclerAlarmsAdapter extends RecyclerAdapter {
    private final List<Alarm> alarms;
    private final Toolbox.CallbackOne<Integer> onclick;

    public RecyclerAlarmsAdapter(RecyclerView recyclerView, List<Alarm> alarms, Toolbox.CallbackOne<Integer> onclick) {
        super(recyclerView);
        this.alarms = alarms;
        itemLayout = R.layout.recyclable_alarm_template;
        this.onclick = onclick;
    }

    @Override
    void fillItemWithData(ViewGroup item, int position) {
        Alarm alarm = alarms.get(position);

        ((TextView) item.findViewById(R.id.nameText)).setText(alarm.name);
        ((TextView) item.findViewById(R.id.timeText)).setText(alarm.hour + ":" + alarm.minute);
        ((SwitchMaterial) item.findViewById(R.id.statusSwitch)).setChecked(alarm.isActive);
        item.setOnClickListener((view) -> onclick.invoke(alarm.id));

         // Hide divider on last element
         if (position == getItemCount() - 1)
             item.findViewById(R.id.recycler_divider).setVisibility(View.GONE);

        fadeAddAnimate(item, position);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }
}

