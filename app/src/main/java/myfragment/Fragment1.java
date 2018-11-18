package myfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.myapplication.Main2Activity;
import com.example.administrator.myapplication.MainActivity;
import com.example.administrator.myapplication.R;

public class Fragment1 extends android.support.v4.app.Fragment{
    private Button btnIntent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.view1,null);
        return view;
    }


}
