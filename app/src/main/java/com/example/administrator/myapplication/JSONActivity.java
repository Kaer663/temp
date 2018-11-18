package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class JSONActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getJSONContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getJSONContent()throws Exception{
        StringBuilder sb=new StringBuilder();
       InputStream is= getResources().openRawResource(R.raw.person);
       int len=0;
       byte []data=new byte[1024];
       while((len=is.read(data,0,data.length))!=-1){
           String s=new String(data,0,len);
           sb.append(s);
       }
        JSONObject jobj=new JSONObject(sb.toString());

       StringBuilder sbt=new StringBuilder();


      String fristName= jobj.getString("fristName");
      String lastName= jobj.getString("LastName");
       sbt.append(fristName).append(lastName);

        JSONObject information=jobj.getJSONObject("information");
        String school= information.getString("school");
        String home= information.getString("home");
        String stree= information.getString("stree");
        sbt.append(school).append(home).append(stree);

      JSONArray array= jobj.getJSONArray("phone");
      for(int index=0;index<array.length();index++){
          JSONObject phones=array.getJSONObject(index);
          String phone=phones.getString("phone");
          String mobilePhone=phones.getString("mobilePhone");
         sbt.append(phone).append(mobilePhone);
         Toast.makeText(JSONActivity.this,sbt.toString(),Toast.LENGTH_LONG).show();
      }
    }
}
