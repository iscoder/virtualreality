package com.roofandfloor.virtualreality;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;

public class BuilderItem {
    public int x = 0;
    public Rect pos = new Rect();
    public Bitmap icon;
    public Bitmap iconGry;
    public String name = "";
    public int z = 10;
    public ApplicationInfo appInfo;
    private Intent launchIntent;
    private Context context;



    public BuilderItem(Rect pos, Bitmap icon, int type, Context context) {
        this.pos = pos;
        this.icon = icon;
        this.iconGry = getGrayscaleBitmap(this.icon);
        this.launchIntent = new Intent(context, InnerBuildingActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        switch (type){
            case 0:
                this.name = "BBCL Stanburry";
                this.launchIntent.putExtra("Builder",1);
                break;
            case 1:
                this.name = "Navin's Starwood";
                this.launchIntent.putExtra("Builder",2);
                break;
            case 2:
                this.name = "PBEL CITY";
                this.launchIntent.putExtra("Builder",3);
                break;
            case 3:
                this.name = "Urban Tree Oxygen";
                this.launchIntent.putExtra("Builder",4);
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
