package com.example.user.project1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //kode untuk mendaklarasikan button, teks view, dan toggle button
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button pick = (Button) view.findViewById(R.id.btnOpen);
        Button simpan = (Button) view.findViewById(R.id.btnSimpan);

        final TextView nama = (TextView) view.findViewById(R.id.tvNama);
        final TextView alamat = (TextView) view.findViewById(R.id.tvAlamat);
        final TextView nim = (TextView) view.findViewById(R.id.tvNIM);

        final ToggleButton toggle = (ToggleButton) view.findViewById(R.id.btnToggle);

        //kode untuk mematikan fungsi tombol dan textview
        pick.setEnabled(false);
        simpan.setEnabled(false);

        nama.setFocusable(false);
        nama.setFocusableInTouchMode(false);
        alamat.setFocusable(false);
        alamat.setFocusableInTouchMode(false);
        nim.setFocusable(false);
        nim.setFocusableInTouchMode(false);

        //kode untuk trigger jika button toggle di klik
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //jika tombol di klik maka menjalankan fungsi setForEditing
                setForEditing(toggle.isChecked());
            }
        });

        //kode untuk trigger button pick di klik
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //kode untuk membuka fragment DatePicker
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");

            }


        });

        //kode untuk trigger button simpan di klik
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //kode untuk mengambil isi teks pada nama, dan disimpan pada string nam
                String nam = nama.getText().toString();
                //--------------------------------
                //kode untuk menyimpan nam ke preferance
                Preferences.setRegisteredUser1(getActivity().getBaseContext(),nam);

                //kode untuk membuat popup "Tersimpan"
                Toast.makeText(getActivity(),"Tersimpan!",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //kode untuk fungsi SelectDateFragment
    public static class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            //kode untuk mengambil tanggal
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }
        //fungsi untuk set tanggal
        public void onDateSet(DatePicker view, int yy, int mm, int dd) {
            populateSetDate(yy, mm+1, dd);
        }
        //fungsi untuk set tanggal
        public void populateSetDate(int year, int month, int day) {
            //kode untuk mendeklarasikan teksview dan edittext
            TextView pick = (TextView) getActivity().findViewById(R.id.tvTanggal);
            EditText next = (EditText) getActivity().findViewById(R.id.tvNIM);
            //kode untuk merubah isi text pada pick
            pick.setText("Tanggal Lahir : "+day+"/"+month+"/"+year);
            //kode untuk fokus ke edit teks
            next.requestFocus();
        }

    }

    //fungsi untuk menghidupkan / mematikan edittext dan button
    public void setForEditing(boolean enabled){
        //kode untuk mendeklarasikan teksview dan edittext
        TextView nama = (TextView) getActivity().findViewById(R.id.tvNama);
        TextView alamat = (TextView) getActivity().findViewById(R.id.tvAlamat);
        TextView nim = (TextView) getActivity().findViewById(R.id.tvNIM);
        Button pick = (Button) getActivity().findViewById(R.id.btnOpen);
        Button simpan = (Button) getActivity().findViewById(R.id.btnSimpan);

        //kode untuk menghidupkan teksview dan edittext
        nama.setFocusableInTouchMode(true);
        nama.setFocusable(true);
        alamat.setFocusableInTouchMode(true);
        alamat.setFocusable(true);
        nim.setFocusableInTouchMode(true);
        nim.setFocusable(true);

        nama.setEnabled(enabled);
        alamat.setEnabled(enabled);
        nim.setEnabled(enabled);
        pick.setEnabled(enabled);
        simpan.setEnabled(enabled);

        //kode untuk fokus ke editteks nama
        if(enabled){
            nama.requestFocus();
        }
    }
}
