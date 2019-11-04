/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pab.uts064;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
            "com.example.android.droidcafeinput.extra.MESSAGE";

    private String mOrderMessage;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }



    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    public void clickDonut(View view) {
        mOrderMessage = getString(R.string.donut_order_message);

        Intent intent = new Intent(MainActivity.this,
                OrderActivity.class);
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);

        intent.putExtra("EXTRA_HARGA", 5000);

        intent.putExtra("EXTRA_NAMA", "Jeruk Oren");
        startActivity(intent);
    }


    public void clickIceCream(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);

        Intent intent = new Intent(MainActivity.this,
                OrderActivity.class);
        intent.putExtra("EXTRA_HARGA", 10000);

        intent.putExtra("EXTRA_NAMA", "Pear Export");
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
    public void clickFroyo(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);

        Intent intent = new Intent(MainActivity.this,
                OrderActivity.class);
        intent.putExtra("EXTRA_HARGA", 15000);

        intent.putExtra("EXTRA_NAMA", "Apel Merah");
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
    public void clickAnggur(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);

        Intent intent = new Intent(MainActivity.this,
                OrderActivity.class);
        intent.putExtra("EXTRA_HARGA", 10000);

        intent.putExtra("EXTRA_NAMA", "Anggur Manis");
        intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
        startActivity(intent);
    }
    public void artikel1(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        String URL = "https://www.kompasiana.com/expesibblenob6387/5ba1157bc112fe62b01f0cd3/tubuh-butuh-vitamin-jeruk-simak-manfaat-jeruk-bagi-kesehatan?page=all";
        browserIntent.setData(Uri.parse(URL));
        startActivity(browserIntent);
    }
    public void artikel2(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        String URL = "https://hellosehat.com/hidup-sehat/fakta-unik/manfaat-buah-pir/";
        browserIntent.setData(Uri.parse(URL));
        startActivity(browserIntent);
    }
    public void artikel3(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        String URL = "https://www.alodokter.com/jarang-bertemu-dokter-berkat-manfaat-apel";
        browserIntent.setData(Uri.parse(URL));
        startActivity(browserIntent);
        startActivity(browserIntent);
    }
    public void artikel4(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        String URL = "https://brilicious.brilio.net/kuliner-kesehatan/12-manfaat-anggur-bagi-tubuh-bisa-membuat-wajah-awet-muda-190225h.html";
        browserIntent.setData(Uri.parse(URL));
        startActivity(browserIntent);
    }
}
