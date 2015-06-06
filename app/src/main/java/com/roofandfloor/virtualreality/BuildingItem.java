package com.roofandfloor.virtualreality;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.preference.PreferenceManager;

public class BuildingItem {
    public int x = 0;
    public Rect pos = new Rect();
    public Bitmap icon;
    public Bitmap iconGry;
    public String name = "";
    public int z = 10;
    public ApplicationInfo appInfo;
    private Intent launchIntent;
    private Context context;
    int builders=0;


    public BuildingItem(Rect pos, Bitmap icon, int type, Context context) {
        this.pos = pos;
        this.icon = icon;
        this.iconGry = getGrayscaleBitmap(this.icon);
        SharedPreferences prefs1= PreferenceManager.getDefaultSharedPreferences(context);
        builders=prefs1.getInt("Builder", 0);

        this.launchIntent = new Intent(context, photosphere_activity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        switch (type){
            case 0:
                this.name = "Hall";
                this.launchIntent.putExtra("Building", 1).putExtra("Builder",builders);
                break;
            case 1:
                this.name = "Bedroom 1";
                this.launchIntent.putExtra("Building",2).putExtra("Builder", builders);
                break;
            case 2:
                this.name = "Bedroom 2";
                this.launchIntent.putExtra("Building",3).putExtra("Builder", builders);
                break;
            case 3:
                this.name = "Bedroom 3";
                this.launchIntent.putExtra("Building",4).putExtra("Builder", builders);
                break;
            case 4:
                this.name = "Kitchen";
                this.launchIntent.putExtra("Building",5).putExtra("Builder", builders);
                break;
            case 5:
                this.name = "Bathroom";
                this.launchIntent.putExtra("Building",6).putExtra("Builder",builders);
                break;
            default:
                this.name = "Go Back";
                this.launchIntent=new Intent(context, BuildersActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                break;

        }

        this.context = context;
    }

    private Bitmap getGrayscaleBitmap(Bitmap color) {
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter colorMatrixFilter = new ColorMatrixColorFilter(colorMatrix);
        Bitmap grayscale = color.copy(Bitmap.Config.ARGB_8888, true);
        Paint paint = new Paint();
        paint.setColorFilter(colorMatrixFilter);
        Canvas canvas = new Canvas(grayscale);
        canvas.drawBitmap(grayscale, 0, 0, paint);
        return grayscale;
    }

    public void move (int deltaTime) {
        pos.left += deltaTime / 1000;
    }

    public void launch () {
        context.startActivity(launchIntent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }




}
