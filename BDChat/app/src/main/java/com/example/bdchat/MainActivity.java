package com.example.bdchat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bdchat.Adapter.FragmentsAdapter;
import com.example.bdchat.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.example.bdchat.R;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();
        binding.viewPager.setAdapter(new FragmentsAdapter(getSupportFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

      if(item.getItemId()==R.id.settings)
      {
          Toast.makeText(this, "Setting is clicked", Toast.LENGTH_SHORT).show();

      }
      else if(item.getItemId()==R.id.groupChat)
      {
          Toast.makeText(this, "Group chat is Started", Toast.LENGTH_SHORT).show();
      }
      else if(item.getItemId()==R.id.logout)
      {
          mAuth.signOut();
          Intent intent=new Intent(MainActivity.this,SignInActivity.class);
          startActivity(intent);
      }


        return super.onOptionsItemSelected(item);
    }
}

// this is main activity.