package com.example.user.project1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment {

    public FavoriteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        //Kode untuk mendefinisi Text View tvNamafavorite
        final TextView nam = (TextView) view.findViewById(R.id.tvNamaFavorite);

        //kode untuk mengganti teks di nam menjadi nama yang telah di daftarkan
        nam.setText("Halo "+Preferences.getRegisteredUser1(getActivity().getBaseContext())+".");

        //kode untuk memasang gambar undip

        return view;
    }
}
