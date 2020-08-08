package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditDet extends AppCompatActivity {

    private EditText name,origin,attire,gener,nb;
    private DanceDetails[] dancedetails;
    private Button update;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_det);

        Bundle extra=getIntent().getExtras();
        if(extra!=null)
        {
            dancedetails=(DanceDetails[])extra.getSerializable("obj");
            position=extra.getInt("position");
            name=findViewById(R.id.name);
            origin=findViewById(R.id.origin);
            gener=findViewById(R.id.gener);
            attire=findViewById(R.id.attire);
            nb=findViewById(R.id.nameby);
            update=findViewById(R.id.update);

            name.setText(dancedetails[position].nam);
            origin.setText(dancedetails[position].ori);
            attire.setText(dancedetails[position].att);
            gener.setText(dancedetails[position].gen);
            nb.setText(dancedetails[position].nab);

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dancedetails[position].nam=name.getText().toString();
                    dancedetails[position].ori=origin.getText().toString();
                    dancedetails[position].att=attire.getText().toString();
                    dancedetails[position].gen=gener.getText().toString();
                    dancedetails[position].nab=nb.getText().toString();

                    Intent i=new Intent(EditDet.this,profiles.class);
                    i.putExtra("obj",dancedetails).putExtra("pos",position);
                    startActivity(i);
                    finish();
                }
            });
        }
    }
}
