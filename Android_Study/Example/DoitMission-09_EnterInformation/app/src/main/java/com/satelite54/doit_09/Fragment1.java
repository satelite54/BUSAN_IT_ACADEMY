package com.satelite54.doit_09;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.widget.AppCompatEditText;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

import com.satelite54.doit_09.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fragment1 extends Fragment {
    EditText nameInput;
    EditText ageInput;

    Button birthButton;

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

    Date selectedDate;

    public Fragment1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);


        nameInput = rootView.findViewById(R.id.nameInput);
        ageInput = rootView.findViewById(R.id.ageInput);

        birthButton = rootView.findViewById(R.id.birthButton);
        birthButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDateDialog();
            }
        });

        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nameStr = nameInput.getText().toString();
                String ageStr = ageInput.getText().toString();
                if(ageStr.length() > 3) {
                    Toast.makeText(getContext(), "나이는 3자리까지 입력 가능합니다.", Toast.LENGTH_LONG).show();
                } else {
                    String birthStr = birthButton.getText().toString();
                    Toast.makeText(getContext(), "이름 : " + nameStr + ", 나이 : " + ageStr + ", 생년월일 : " + birthStr, Toast.LENGTH_SHORT).show();
                }
            }
        });


        // set selected date using current date
        Date curDate = new Date();
        setSelectedDate(curDate);

        return rootView;
    }

    private void showDateDialog() {
        String birthDateStr = birthButton.getText().toString();

        Calendar calendar = Calendar.getInstance();
        Date curBirthDate = new Date();
        try {
            curBirthDate = dateFormat.parse(birthDateStr);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        calendar.setTime(curBirthDate);

        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH);
        int curDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(),  birthDateSetListener,  curYear, curMonth, curDay);
        dialog.show();
    }

    private DatePickerDialog.OnDateSetListener birthDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Calendar selectedCalendar = Calendar.getInstance();
            selectedCalendar.set(Calendar.YEAR, year);
            selectedCalendar.set(Calendar.MONTH, monthOfYear);
            selectedCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            Date curDate = selectedCalendar.getTime();
            setSelectedDate(curDate);
        }
    };

    private void setSelectedDate(Date curDate) {
        selectedDate = curDate;

        String selectedDateStr = dateFormat.format(curDate);
        birthButton.setText(selectedDateStr);
    }

}