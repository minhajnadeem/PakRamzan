package com.example.minhajlib.pakramzan;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minhajlib.pakramzan.modal.TimeModalBahawalpur;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    CalendarView calendarView;
    AdView mAdView;
    String dateToday;

    Map<String, TimeModalBahawalpur> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-4227861033559247~9244340618");
        mAdView = (AdView) findViewById(R.id.ad_view);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        map = new HashMap<>();
        map.put("285", new TimeModalBahawalpur("1", "03:39 AM", "07:12 PM"));
        map.put("295", new TimeModalBahawalpur("2", "03:38 AM", "07:13 PM"));
        map.put("305", new TimeModalBahawalpur("3", "03:38 AM", "07:13 PM"));
        map.put("315", new TimeModalBahawalpur("4", "03:37 AM", "07:13 PM"));
        map.put("16", new TimeModalBahawalpur("5", "03:37 AM", "07:14 PM"));
        map.put("26", new TimeModalBahawalpur("6", "03:37 AM", "07:14 PM"));
        map.put("36", new TimeModalBahawalpur("7", "03:36 AM", "07:15 PM"));
        map.put("46", new TimeModalBahawalpur("8", "03:36 AM", "07:15 PM"));
        map.put("56", new TimeModalBahawalpur("9", "03:36 AM", "07:16 PM"));
        map.put("66", new TimeModalBahawalpur("10", "03:36 AM", "07:17 PM"));
        map.put("76", new TimeModalBahawalpur("11", "03:36 AM", "07:17 PM"));
        map.put("86", new TimeModalBahawalpur("12", "03:35 AM", "07:18 PM"));
        map.put("96", new TimeModalBahawalpur("13", "03:35 AM", "07:18 PM"));
        map.put("106", new TimeModalBahawalpur("14", "03:35 AM", "07:19 PM"));
        map.put("116", new TimeModalBahawalpur("15", "03:35 AM", "07:19 PM"));
        map.put("126", new TimeModalBahawalpur("16", "03:35 AM", "07:20 PM"));
        map.put("136", new TimeModalBahawalpur("17", "03:35 AM", "07:20 PM"));
        map.put("146", new TimeModalBahawalpur("18", "03:35 AM", "07:21 PM"));
        map.put("156", new TimeModalBahawalpur("19", "03:35 AM", "07:21 PM"));
        map.put("166", new TimeModalBahawalpur("20", "03:35 AM", "07:22 PM"));
        map.put("176", new TimeModalBahawalpur("21", "03:35 AM", "07:23 PM"));
        map.put("186", new TimeModalBahawalpur("22", "03:35 AM", "07:24 PM"));
        map.put("196", new TimeModalBahawalpur("23", "03:35 AM", "07:24 PM"));
        map.put("206", new TimeModalBahawalpur("24", "03:35 AM", "07:25 PM"));
        map.put("216", new TimeModalBahawalpur("25", "03:35 AM", "07:25 PM"));
        map.put("226", new TimeModalBahawalpur("26", "03:35 AM", "07:25 PM"));
        map.put("236", new TimeModalBahawalpur("27", "03:35 AM", "07:25 PM"));
        map.put("246", new TimeModalBahawalpur("28", "03:35 AM", "07:25 PM"));
        map.put("256", new TimeModalBahawalpur("29", "03:36 AM", "07:25 PM"));
        map.put("266", new TimeModalBahawalpur("30", "03:36 AM", "07:25 PM"));

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        Calendar maxDate = Calendar.getInstance();
        maxDate.set(Calendar.DAY_OF_MONTH, 26);
        maxDate.set(Calendar.MONTH, 5);
        maxDate.set(Calendar.YEAR, 2017);
        maxDate.set(Calendar.HOUR_OF_DAY, 23);
        maxDate.set(Calendar.MINUTE, 59);
        maxDate.set(Calendar.SECOND, 59);
        long longMaxDate = maxDate.getTimeInMillis();
        calendarView.setMaxDate(longMaxDate);

        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int year = cal.get(Calendar.YEAR);
        cal.set(year, month, dayOfMonth);

        showRamzanTimeDialog(month, dayOfMonth, year);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                showRamzanTimeDialog(month, dayOfMonth, year);
            }
        });
    }

    private void showRamzanTimeDialog(final int month, int dayOfMonth, int year) {
        TimeModalBahawalpur modal;
        String key = dayOfMonth + "" + (month + 1);
        dateToday = dayOfMonth + "/" + (month + 1) + "/" + year;
        modal = map.get(key);
        if (modal == null){
            modal = map.get("266");
        }

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        View v = LayoutInflater.from(this).inflate(R.layout.custome_dialog, null);
        dialog.setView(v);
        TextView tvDate = (TextView) v.findViewById(R.id.tvDate);
        TextView tvRoza = (TextView) v.findViewById(R.id.tvRamzan);
        TextView tvSaher = (TextView) v.findViewById(R.id.tvSeharTIme);
        TextView tvIftar = (TextView) v.findViewById(R.id.tvIftarTime);
        Button btnShareTime = (Button) v.findViewById(R.id.btnShareTime);
        final TimeModalBahawalpur finalModal = modal;
        btnShareTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startShareTimeIntent(finalModal.getRoza(), finalModal.getSaherTime(), finalModal.getIftarTime());
            }
        });
        tvDate.setText(dateToday);
        tvRoza.setText("Ramzan " + modal.getRoza());
        tvSaher.setText("ختم سحری: " + modal.getSaherTime());
        tvIftar.setText("وقت فطار: " + modal.getIftarTime());
        dialog.show();
    }

    private void startShareTimeIntent(String roza, String saherTime, String iftarTime) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String shareMessage =
                "Today's Ramzan Time:\n"
                        + dateToday + "\n" +
                        "Ramzan " + roza + "\n " +
                        "ختم سحری:" + saherTime + "\n " +
                        "وقت فطار:" + iftarTime
                +"\nTo download this app:\n"+"https://drive.google.com/open?id=0B6iUuRlTmpP8LXZJSFVUZ3p5cXc \n";
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,shareMessage);
        startActivity(Intent.createChooser(intent, "Select to share"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        int imageRes = R.drawable.dua;
        if(id == R.id.dua){
            imageRes = R.drawable.dua;
        }else if (id == R.id.taraveeh){
            imageRes = R.drawable.dua2;
        }else if (id == R.id.share){
            startShareAppIntent();
            return true;
        }else if (id == R.id.email){
            startEmailIntent();
            return true;
        }
        Intent intent = new Intent(this,Gallery.class);
        intent.putExtra("res",imageRes);
        startActivity(intent);
        return true;
    }

    private void startEmailIntent() {
     Intent intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"minhaj.lib@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Pak Ramzan");
        startActivity(Intent.createChooser(intent,"select email App"));
    }

    private void startShareAppIntent() {
        String shareStr = "Download Bahawalpur Ramzan timings 2017 Pak Ramzan App:\n" +
                "https://drive.google.com/open?id=0B6iUuRlTmpP8LXZJSFVUZ3p5cXc";

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,shareStr);
        startActivity(Intent.createChooser(intent, "Select to share"));
    }
}