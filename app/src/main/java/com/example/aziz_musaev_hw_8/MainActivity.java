package com.example.aziz_musaev_hw_8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etPolicy,etProductCategory,etOriginCategory,etBrand;
    private Button btnExportAsCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPolicy = findViewById(R.id.policy);
        etProductCategory = findViewById(R.id.product_category);
        etOriginCategory = findViewById(R.id.origin_country);
        etBrand = findViewById(R.id.brand);
        btnExportAsCSV = findViewById(R.id.export_as_CSV);
        onTextChange(etPolicy,etProductCategory,etOriginCategory,etBrand);
        onClicker();
    }
    private void onTextChange(EditText... editTexts) {
        for(EditText et:editTexts){
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (ifEditTextsNotEmpty(editTexts)) {
                        btnExportAsCSV.getBackground().setColorFilter(getResources().getColor(R.color.red), PorterDuff.Mode.SRC_ATOP);
                    }else{
                        btnExportAsCSV.getBackground().setColorFilter(getResources().getColor(R.color.gray), PorterDuff.Mode.SRC_ATOP);
                    }
                }

                @Override
                public void afterTextChanged(Editable editable) {
                }
            });
        }
    }

    private boolean ifEditTextsNotEmpty(EditText... editTexts){
        for(EditText et:editTexts){
            if(et.getText().length()==0){
                return false;
            }
        }
        return true;
    }
    public void onClicker(){
btnExportAsCSV.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        Integer numberOne = Integer.parseInt(etPolicy.getText().toString()) + Integer.parseInt(etProductCategory.getText().toString());
        String text2 = numberOne.toString();
        String text1 = etOriginCategory.getText().toString() + etBrand.getText().toString();
        intent.putExtra("Miku",text1);
        intent.putExtra("Miku2",text2);
        startActivity(intent);
    }
});
    }
}

