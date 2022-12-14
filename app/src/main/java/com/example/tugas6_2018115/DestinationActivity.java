package com.example.tugas6_2018115;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.example.tugas6_2018115.databinding.ActivityDestinationBinding;
import com.example.tugas6_2018115.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class DestinationActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private ActivityDestinationBinding binding;

    RecyclerView recylerView;

    String s1[], s2[],s3[];
    int images[] = {R.drawable.geprek,R.drawable.kecap,R.drawable.kunyit,R.drawable.logo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDestinationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        //action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_alarm){
                    Intent a = new Intent(DestinationActivity.this,
                            MainActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_reviews){
                    Intent a = new Intent(DestinationActivity.this,
                            DestinationActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_setting){
                    Intent a = new Intent(DestinationActivity.this,
                            setting.class);
                    startActivity(a);
                }
                return true;
            }
        });
        //recycle View
        recylerView = findViewById(R.id.recyclerView);
        s1 = getResources().getStringArray(R.array.Makanan);
        s2 = getResources().getStringArray(R.array.Deskripsi);
        s3 = getResources().getStringArray(R.array.Star);
        MakananAdapter appAdapter = new MakananAdapter(this,s1,s2,s3,images);
        recylerView.setAdapter(appAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(DestinationActivity.this,LinearLayoutManager.HORIZONTAL, false
        );
        recylerView.setLayoutManager(layoutManager);
        recylerView.setItemAnimator(new DefaultItemAnimator());

//        //work manager
//        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                WorkManager.getInstance().enqueueUniqueWork("Notifikasi", ExistingWorkPolicy.REPLACE, request);
//            }
//        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}