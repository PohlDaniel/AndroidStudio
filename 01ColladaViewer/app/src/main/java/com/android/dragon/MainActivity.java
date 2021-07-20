package com.android.dragon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.TextView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity {

    AppView appView;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        appView = new  AppView(getApplication());
        appView.setRenderer(new Renderer(getAssets()));
        setContentView(appView);

        //setContentView(R.layout.activity_main);
        //TextView tv = findViewById(R.id.sample_text);
        //tv.setText(NativeLibrary.stringFromJNI());
    }

    @Override
    protected void onPause() {
        super.onPause();
        //appView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //appView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

class Renderer implements GLSurfaceView.Renderer {

    AssetManager assetManager;

    Renderer(AssetManager assetManager){
        this.assetManager=assetManager;
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        NativeLibrary.step();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        NativeLibrary.init(width, height, assetManager);
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
    }
}