package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*switch(fab.getId()){
            case R.id.fab_phone:
                String tel="0981575389";
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel,null));
                startActivity(intent1);
                return true;
            case R.id.fab_gmail:
                String mail="chinhsg12@gmail.com";
                Intent intent2 = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",mail,null));
                startActivity(intent2);
                return true;

            case R.id.fab_messager:
                String FbUserID="zlbkz";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + FbUserID));
                startActivity(intent3);
                return true;

            default:
                return false;*/

        setSupportActionBar(binding.appBarMain.toolbar);
        supportOnClick();


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile, R.id.nav_news, R.id.nav_music,R.id.nav_youtube)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void supportOnClick(){
        binding.appBarMain.fabPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tel="0934810941";
                Intent intent1 = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", tel,null));
                startActivity(intent1);
            }
        });

        binding.appBarMain.fabGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail="newsic.customersup@gmail.com";
                String password="asdasd@12";
                Intent intent2 = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",mail,null));
                startActivity(intent2);
            }
        });
        binding.appBarMain.fabMessager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FbUserID="zlbkz";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://messaging/" + FbUserID));
                startActivity(intent3);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuAbout:
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.menuABC:
                Intent intent2 = new Intent(MainActivity.this, TestActivity.class);
                startActivity(intent2);
                return true;
            case R.id.menuExit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you want to Logout & Exit?").setCancelable(false).setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent3);
                    }
                }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Logout & Exit");
                alertDialog.show();
                return true;
//            case R.id.menuExit2:
//                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
//                builder2.setMessage("Are you want to Exit?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        System.exit(0);}
//                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.cancel();
//                    }
//                });
//                AlertDialog alertDialog2 = builder2.create();
//                alertDialog2.setTitle("Exit");
//                alertDialog2.show();
//                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }




}