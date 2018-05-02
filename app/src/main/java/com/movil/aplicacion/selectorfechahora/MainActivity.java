package com.movil.aplicacion.selectorfechahora;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText fecha;
    private  int ano,mes,dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecha=(EditText)findViewById(R.id.fecha);
        fecha.setOnClickListener(this);
    }

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    @Override
    public void onClick(View v) {
        if(v==fecha){
            final Calendar c= Calendar.getInstance();
            ano=c.get(Calendar.YEAR);
            mes=c.get(Calendar.MONTH);
            dia=c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    fecha.setText(year+"/"+twoDigits(monthOfYear+1)+"/"+twoDigits(dayOfMonth));
                }
            }
            ,ano,mes,dia);
            datePickerDialog.show();
        }
    }
}
