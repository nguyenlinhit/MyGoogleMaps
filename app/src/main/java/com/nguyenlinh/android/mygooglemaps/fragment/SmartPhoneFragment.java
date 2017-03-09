package com.nguyenlinh.android.mygooglemaps.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nguyenlinh.android.mygooglemaps.adapter.MarketAdapter;
import com.nguyenlinh.android.mygooglemaps.adapter.PhoneAdapter;
import com.nguyenlinh.android.mygooglemaps.app.R;
import com.nguyenlinh.android.mygooglemaps.database.SQLDatasource;
import com.nguyenlinh.android.mygooglemaps.model.Market;
import com.nguyenlinh.android.mygooglemaps.model.SmartPhone;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SmartPhoneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SmartPhoneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SmartPhoneFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListView lvPhone;
    private ArrayList<SmartPhone> dsPhone = null;
    private PhoneAdapter phoneAdapter;

    SQLDatasource db;

    public SmartPhoneFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SmartPhoneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SmartPhoneFragment newInstance(String param1, String param2) {
        SmartPhoneFragment fragment = new SmartPhoneFragment();
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
        View view = inflater.inflate(R.layout.fragment_smart_phone, container, false);
        db = new SQLDatasource(getContext().getApplicationContext());
        lvPhone = (ListView) view.findViewById(R.id.lvPhone);
        dsPhone = db.showAllPhone();
        phoneAdapter = new PhoneAdapter(getContext().getApplicationContext(),R.layout.adapter_smartphone,dsPhone);
        lvPhone.setAdapter(phoneAdapter);
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
