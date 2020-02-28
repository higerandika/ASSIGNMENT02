package com.example.asst_tg_2016_106;


import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.asst_tg_2016_106.DatabaseHelper.DATABASE_NAME;


public class second_fragment extends Fragment{
    DatabaseHelper db;
    Button button;

    public static second_fragment newInstance(){
        second_fragment fragmentTwo = new second_fragment();
        return fragmentTwo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.acivity_second,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        db=new DatabaseHelper(getContext(),DATABASE_NAME,null,1);
        button=(Button)view.findViewById(R.id.vbtn);

        retrieveAll();


    }
    public void retrieveAll(){
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res=db.viewData();
                        if (res.getCount()==0){
                            notification("Error","Database Empty or Something Wrong!");
                            return;
                        }
                        StringBuffer buffer=new StringBuffer();
                        while (res.moveToNext()){
                            buffer.append("Index :"+res.getString(0)+"\n");
                            buffer.append("Name  :"+res.getString(1)+"\n");
                            buffer.append("Age   :"+res.getString(2)+"\n");
                            buffer.append("Marks :"+res.getString(3)+"\n");
                        }

                        notification("Information",buffer.toString());
                    }
                }
        );
    }
    public  void notification(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}