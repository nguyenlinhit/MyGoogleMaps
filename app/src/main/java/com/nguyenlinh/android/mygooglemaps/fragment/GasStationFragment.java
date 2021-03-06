package com.nguyenlinh.android.mygooglemaps.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nguyenlinh.android.mygooglemaps.adapter.GasStationAdapter;
import com.nguyenlinh.android.mygooglemaps.app.AlternativeDirectionMapsActivity;
import com.nguyenlinh.android.mygooglemaps.app.R;
import com.nguyenlinh.android.mygooglemaps.database.SQLDatasource;
import com.nguyenlinh.android.mygooglemaps.model.GasStation;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GasStationFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GasStationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GasStationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView lvGas;
    private ArrayList<GasStation> dsGasStations = null;
    private GasStationAdapter gasStationAdapter;

    SQLDatasource db;

    public GasStationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GasStationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GasStationFragment newInstance(String param1, String param2) {
        GasStationFragment fragment = new GasStationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gas_station, container, false);
        db = new SQLDatasource(getContext().getApplicationContext());
        lvGas = (ListView) view.findViewById(R.id.lvGas);
        dsGasStations = db.showAllGas();
        gasStationAdapter = new GasStationAdapter(getContext().getApplicationContext(),R.layout.adapter_gasstation,dsGasStations);
        lvGas.setAdapter(gasStationAdapter);

        lvGas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int ma = dsGasStations.get(position).getMa();
                int requestCode = 7;
                Intent intent = new Intent(getContext().getApplicationContext(), AlternativeDirectionMapsActivity.class);
                intent.putExtra("MA",ma);
                intent.putExtra("CODE",requestCode);
                startActivity(intent);
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
