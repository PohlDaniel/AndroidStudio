package com.android.dragon;

import android.content.res.AssetManager;

public class NativeLibrary {

    static {
        System.loadLibrary("dragon");
    }

    public static native void init(int width, int height, AssetManager assetManager);
    public static native void step();
}
