package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mainactivity.DanceDetails;
import com.example.mainactivity.EditDet;
import com.example.mainactivity.R;
import com.example.mainactivity.dance;

public class profiles extends AppCompatActivity {
    DanceDetails[] dancedetails;
    int position;
    private TextView name,origin,attire,gener,namedby;
    ImageView profileimage;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        Bundle extra=getIntent().getExtras();

        if(extra!=null)
        {
            dancedetails=(DanceDetails[])extra.getSerializable("obj");
            position=extra.getInt("pos");
        }

        name=findViewById(R.id.n);
        origin=findViewById(R.id.origin);
        gener=findViewById(R.id.g);
       attire=findViewById(R.id.attire);
       namedby=findViewById(R.id.nb);
        profileimage=findViewById(R.id.iv_profile);
        back=findViewById(R.id.back);

        name.setText(dancedetails[position].nam);
        origin.setText(dancedetails[position].ori);
        attire.setText(dancedetails[position].att);
        gener.setText(dancedetails[position].gen);
        namedby.setText(dancedetails[position].nab);
        int resID=getResources().getIdentifier(dancedetails[position].imageName,"mipmap",getPackageName());
        profileimage.setImageBitmap(BitmapFactory.decodeResource(getResources(),resID));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(profiles.this, dance.class);
                i.putExtra("obj",dancedetails);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //to clear simply written details in frofiles page
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.editdetails,menu);  //to create the editdetails 3 dots
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==R.id.ed)
        {
            Intent i=new Intent(profiles.this, EditDet.class);
            i.putExtra("obj",dancedetails).putExtra("position",position); //go to next page after clicking editdetails
            startActivity(i);
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

}
