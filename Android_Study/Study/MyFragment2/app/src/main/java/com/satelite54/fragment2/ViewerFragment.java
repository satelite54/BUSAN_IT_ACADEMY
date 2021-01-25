package com.satelite54.fragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false); //메모리에 올릴때 root의 자식뷰로 추가할 것인가? 아니요
        imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }
}
