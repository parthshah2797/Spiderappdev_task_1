package com.student.spider_task_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.view.View;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    EditText name,roll_no;
    CheckBox ck1,ck2,ck3;
    Button b1;
    Switch s1;
    Spinner sp1;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editText);
        roll_no = (EditText) findViewById(R.id.editText2);
        ck1 = (CheckBox) findViewById(R.id.checkBox);
        ck2 = (CheckBox) findViewById(R.id.checkBox2);
        ck3 = (CheckBox) findViewById(R.id.checkBox3);
        b1 = (Button) findViewById(R.id.button);
        s1 = (Switch) findViewById(R.id.switch1);
        i=new Intent(this,NextPage.class);

        sp1 = (Spinner) findViewById(R.id.spinner);
        sp1.setOnItemSelectedListener(this);
        List<String> departments= new ArrayList<String>();
        departments.add("Architecture");
        departments.add("Chemical");
        departments.add("Civil");
        departments.add("CSE");
        departments.add("EEE");
        departments.add("ECE");
        departments.add("ICE");
        departments.add("Mechanical");
        departments.add("Metallurgy");
        departments.add("Production");

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,departments);//creating adapter for spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//For creating drop down menu
        sp1.setAdapter(dataAdapter);
    }

    public void Name(View view)
    {
        String name1=name.getText().toString();
        String rollno=roll_no.getText().toString();
        int flag=0;

        if(name1.length()==0)
        {
            Toast.makeText(this,"You did not enter your name", Toast.LENGTH_LONG).show();
            flag++;
        }
        if(rollno.length()==0)
        {
            Toast.makeText(this,"Enter Valid Roll No", Toast.LENGTH_LONG).show();
            flag++;
        }
        if((ck1.isChecked()||ck2.isChecked()||ck3.isChecked()))
        {

        }
        else
        {
            Toast.makeText(this,"Profiles Not Ticked", Toast.LENGTH_LONG).show();
            flag++;
        }
        if(flag==0)
        {
            startActivity(i);
            finish();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
