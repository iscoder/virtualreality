package com.roofandfloor.virtualreality;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.google.vrtoolkit.cardboard.CardboardActivity;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;
import org.rajawali3d.cardboard.RajawaliCardboardView;


public class photosphere_activity extends CardboardActivity  {



int building_value;
    int builder_value;
    private Intent launchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Bundle n = getIntent().getExtras();
        if(n!=null) {



            building_value = n.getInt("Building");
            builder_value = n.getInt("Builder");


        }
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=prefs.edit();
        editor.putInt("Builder",builder_value);
        editor.putInt("Building", building_value);
        editor.commit();

        RajawaliCardboardView view = (RajawaliCardboardView)findViewById(R.id.cardboard_view1);
        setCardboardView(view);

        RajawaliCardboardRenderer renderer;


        renderer = new MyRenderer(this);
        view.setRenderer(renderer);
        view.setSurfaceRenderer(renderer);

Log.e("Builder value", " " + builder_value);
        Log.e("Building value", " " + building_value);



    }


@Override
public void onBackPressed() {
    super.onBackPressed();
    Bundle n = getIntent().getExtras();
    if(n!=null) {



        building_value = n.getInt("Building");
        builder_value = n.getInt("Builder");


    }
    Log.e("Builderrrrr value", "" + builder_value);
    startActivity(new Intent(getApplicationContext(), InnerBuildingActivity.class).putExtra("Builder", builder_value).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    android.os.Process.killProcess(android.os.Process.myPid());
}

    @Override
    public void onCardboardTrigger() {
        super.onCardboardTrigger();
        Bundle n = getIntent().getExtras();
        if(n!=null) {



            building_value = n.getInt("Building");
            builder_value = n.getInt("Builder");


        }
        Log.e("Builderrrrr value", "" + builder_value);
        startActivity(new Intent(getApplicationContext(), InnerBuildingActivity.class).putExtra("Builder", builder_value).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
