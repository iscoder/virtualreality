package com.roofandfloor.virtualreality;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.rajawali3d.cardboard.RajawaliCardboardRenderer;

import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Sphere;

public class MyRenderer extends RajawaliCardboardRenderer {
    int building_images=0;
    int builders=0;
    Sphere sphere;
    public MyRenderer(Context context) {
        super(context);



    }

    @Override
    protected void initScene() {

        SharedPreferences prefs1= PreferenceManager.getDefaultSharedPreferences(getContext());
        building_images=prefs1.getInt("Building",0);
        builders=prefs1.getInt("Builder",0);

        switch (builders){
            case 1://bbcl
                switch(building_images) {
                    case 1:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.hall_main));//hall
                        getCurrentScene().addChild(sphere);
                    case 2:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom1_main));//bed1
                        getCurrentScene().addChild(sphere);
                        break;
                    case 3:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom2_main));//bed2
                        getCurrentScene().addChild(sphere);
                        break;
                    case 4:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom3_main));//bed3
                        getCurrentScene().addChild(sphere);
                        break;
                    case 5:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.kitchen_main));//kitchen
                        getCurrentScene().addChild(sphere);
                        break;
                    case 6:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bathroom_main));//bathroom
                        getCurrentScene().addChild(sphere);
                        break;
                }
                break;

            case 2:
                switch(building_images) {
                    case 1:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.hall_main));//hall
                        getCurrentScene().addChild(sphere);
                    case 2:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom1_main));//bed1
                        getCurrentScene().addChild(sphere);
                        break;
                    case 3:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom2_main));//bed2
                        getCurrentScene().addChild(sphere);
                        break;
                    case 4:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom3_main));//bed3
                        getCurrentScene().addChild(sphere);
                        break;
                    case 5:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.kitchen_main));//kitchen
                        getCurrentScene().addChild(sphere);
                        break;
                    case 6:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bathroom_main));//bathroom
                        getCurrentScene().addChild(sphere);
                        break;
                }
                break;
            case 3:
                switch(building_images) {
                    case 1:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.hall_main));//hall
                        getCurrentScene().addChild(sphere);
                    case 2:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom1_main));//bed1
                        getCurrentScene().addChild(sphere);
                        break;
                    case 3:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom2_main));//bed2
                        getCurrentScene().addChild(sphere);
                        break;
                    case 4:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom3_main));//bed3
                        getCurrentScene().addChild(sphere);
                        break;
                    case 5:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.kitchen_main));//kitchen
                        getCurrentScene().addChild(sphere);
                        break;
                    case 6:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bathroom_main));//bathroom
                        getCurrentScene().addChild(sphere);
                        break;
                }
                break;
            case 4:
                switch(building_images) {
                    case 1:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.hall_main));//hall
                        getCurrentScene().addChild(sphere);
                    case 2:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom1_main));//bed1
                        getCurrentScene().addChild(sphere);
                        break;
                    case 3:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom2_main));//bed2
                        getCurrentScene().addChild(sphere);
                        break;
                    case 4:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bedroom3_main));//bed3
                        getCurrentScene().addChild(sphere);
                        break;
                    case 5:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.kitchen_main));//kitchen
                        getCurrentScene().addChild(sphere);
                        break;
                    case 6:
                        sphere = createPhotoSphereWithTexture(new Texture("photo", R.drawable.bathroom_main));//bathroom
                        getCurrentScene().addChild(sphere);
                        break;
                }
                break;
        }



        getCurrentCamera().setPosition(Vector3.ZERO);
        getCurrentCamera().setFieldOfView(100);

    }

    private static Sphere createPhotoSphereWithTexture(ATexture texture) {

        Material material = new Material();
        material.setColor(0);

        try {
            material.addTexture(texture);
        } catch (ATexture.TextureException e) {
            throw new RuntimeException(e);
        }

        Sphere sphere = new Sphere(50, 100, 50);
        sphere.setScaleX(-1);
        sphere.setMaterial(material);

        return sphere;
    }
}
