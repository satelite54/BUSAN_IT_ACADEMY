package com.satelite54.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int code;
    String message;

    public SimpleData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public SimpleData(Parcel src) { //Pracel 객체에서 읽기
        code = src.readInt();
        message = src.readString();
    }
    // Parcelable 내부인터페이스 Creator 구현 생성자 호출
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public  SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(code);
        dest.writeString(message);
    }
}
