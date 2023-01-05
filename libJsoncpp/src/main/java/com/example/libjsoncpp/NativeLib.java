package com.example.libjsoncpp;

public class NativeLib {

    // Used to load the 'libjsoncpp' library on application startup.
    static {
        System.loadLibrary("libjsoncpp");
    }

    /**
     * A native method that is implemented by the 'libjsoncpp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}