package com.example.bannerusingrecyclerview;

import android.graphics.drawable.Drawable;

public class UserData {
    public Drawable profileImg;

    public Drawable getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(Drawable profileImg) {
        this.profileImg = profileImg;
    }

    public UserData(Drawable profileImg) {
        this.profileImg = profileImg;
    }
}
