package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class dance extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    PeopleAdapter peopleAdapter;
    private Button back;

    DanceDetails[] details={
            new DanceDetails("Bharathanatyam","Tamil Nadu","bridal dress","classical","Krishna Iyyer","bharatanatyam","bharatanatyam"),
            new DanceDetails("Mohiniyattam","Kerala","White saree","classical","Vyavaharamala","mohiniattam","mohiniattam"),
            new DanceDetails("Manipuri","Manipur","Innaphi","classical","Pakhangpa","manipuri","manipuri"),
            new DanceDetails("Kathak","North India","Chudidhar","Classical","Bindadin","kathak","kathak"),
            new DanceDetails("Odissi","Orissa","Pattasari","Classical","Kavichandra","odissi","odissi"),
            new DanceDetails("Yakshagana","Dakshina Kannada","Dhothi Pyjama","classical","Shivarama Hegde","yakshagana","yakshagana"),
            new DanceDetails("Kathakali","Kerala","Jackets","classical","Narayan Menon","kathakali","kathakali"),
            new DanceDetails("Kuchipudi","Andhra Pradesh","saree","classical","Ragini Devi","kuchipudi","kuchipudi"),

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dance);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),fistpage.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                i.putExtra("EXIT",true);
                startActivity(i);
                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Bundle extra=getIntent().getExtras();

        if(extra != null)
        {
            details=(DanceDetails[])extra.getSerializable("obj");
        }

        recyclerView=findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(recyclerView.getContext(),layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        peopleAdapter=new PeopleAdapter(details);
        recyclerView.setAdapter(peopleAdapter);
    }
}
