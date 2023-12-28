package com.example.mypetapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mypetapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);

        if(auth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Espere, usted ya está conectado", Toast.LENGTH_SHORT).show();
        }
    }

    public void login(View view) {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    public void registration(View view) {
        startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
    }
}