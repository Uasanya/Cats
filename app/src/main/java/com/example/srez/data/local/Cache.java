package com.example.srez.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.srez.data.model.CatResponsePOJO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class Cache {
    private final SharedPreferences preferences;
    private final SharedPreferences.Editor editor;
    private final Gson gson = new Gson();

    private final String PREF_KEY_IMAGES = "PREF_KEY_IMAGES";
    private final String PREF = "PREF_FILE";

    public Cache(Context context) {
        preferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void putCatImages(List<CatResponsePOJO> list) {
        String json = gson.toJson(list);
        editor.putString(PREF_KEY_IMAGES, json);
        editor.apply();
    }

    public List<CatResponsePOJO> getCatsImages() {
        String serializedObject = preferences.getString(PREF_KEY_IMAGES, "");
        Type type = new TypeToken<List<CatResponsePOJO>>() {
        }.getType();
        return gson.fromJson(serializedObject, type);
    }

}
