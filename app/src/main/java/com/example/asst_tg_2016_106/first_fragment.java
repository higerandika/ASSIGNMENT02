package com.example.asst_tg_2016_106;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.example.asst_tg_2016_106.DatabaseHelper.DATABASE_NAME;
import static com.example.asst_tg_2016_106.DatabaseHelper.DB_VERSION;

public class first_fragment extends Fragment {
    private static first_fragment newInstance = null;

    DatabaseHelper databaseHelper;
    EditText editName;
    EditText editAge;
    EditText editMarks;
    Button buttonAdd;

    public static first_fragment newInstance(){
        first_fragment  FirstFragment = new first_fragment();
        return FirstFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_first, container, false);

        databaseHelper = new DatabaseHelper(getContext());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        editName = view.findViewById(R.id.edit_name);
        editAge = view.findViewById(R.id.edit_age);
        editMarks = view.findViewById(R.id.edit_marks);
        buttonAdd = view.findViewById(R.id.button_add);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(editName.getText().toString().equals("") || editAge.getText().toString().equals("") || editMarks.getText().toString().equals(""))){
                String name = editName.getText().toString();
                String age = editAge.getText().toString();
                String marks = editMarks.getText().toString();

                Add(name, age, marks);
                }
            }
        });
    }

    public void Add(String name, String age, String marks) {
       String ans = databaseHelper.AddData(name, age, marks);
        if (ans.equals("Pass")){
            editName.setText("");
            editAge.setText("");
            editMarks.setText("");
        }
    }
/*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.activity_first, container, false);




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        databaseHelper = new DatabaseHelper(getContext(),
                DATABASE_NAME, null, DB_VERSION);

       editName = view.findViewById(R.id.edit_name);
       editAge = view.findViewById(R.id.edit_age);
       editMarks = view.findViewById(R.id.edit_marks);

        buttonAdd.setOnClickListener(
                new View.OnClickListener(){


                    @Override
                    public void onClick(View v) {
                         databaseHelper.AddData(editName.getText().toString(), editAge.getText().toString(), editMarks.getText().toString());
                       /* if(isInserted = true)
                            Toast.makeText(first_fragment.this, "Data Inseretd", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inseretd", Toast.LENGTH_LONG).show();
                    }
                }
        );
    } */


}
