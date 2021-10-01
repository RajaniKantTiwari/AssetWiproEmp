package com.wipro.util;

import android.content.Context;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonParser {
    public static <T> T getAssetJsonData(Context context,String jsonFileName,Class<T> className) {
        try {
            InputStream inputStream = context.getAssets().open(jsonFileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            return new Gson().fromJson(new String(buffer, StandardCharsets.UTF_8),className);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
