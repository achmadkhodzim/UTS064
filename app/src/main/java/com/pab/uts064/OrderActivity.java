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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{
public EditText nama,jumlah;
public EditText note;
public Spinner spinner;
int harga;
    String spinnerLabel;
String Exnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        nama=findViewById(R.id.name_text);
        jumlah=findViewById(R.id.jumlah_text);
        harga = intent.getIntExtra("EXTRA_HARGA",0);
        Exnama = intent.getStringExtra("EXTRA_NAMA");
        String isinya= Exnama + " harga per kg : Rp. "+harga+"\n minimal 1kg, maksimal 4 kg";
        TextView textView = findViewById(R.id.textView5);
        textView.setText(isinya);

        spinner = findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.labels_array,
                android.R.layout.simple_spinner_item);

         adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView,
                               View view, int i, long l) {
        spinnerLabel = adapterView.getItemAtPosition(i).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // Do nothing.
    }

    public void clickOrder(View view) {
         RadioGroup radioBayarGroup;

         RadioButton radioTipeButton;
        radioBayarGroup = (RadioGroup) findViewById(R.id.radioTipe);
        int selectedId = radioBayarGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        radioTipeButton = (RadioButton) findViewById(selectedId);
            int total = Integer.parseInt(spinnerLabel)*harga;
            String asd= "Pesanan untuk " + nama.getText()+ " sedang diproses \n"+ " -- detail pemesanan -- \n"+ " pilihan buah : " + Exnama +"\n total harga : "+ total+ "\n metode pembayaran : " +
                    radioTipeButton.getText();
        TextView textView = findViewById(R.id.textView6);
        textView.setText(asd);
    }
}
