package com.abc.pay_atm;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment implements View.OnClickListener{
    private Button bnView,bnSave,bnUpdate,bnDelete;
    OnDbOpListner dbOpListner;


    public UserFragment() {
        // Required empty public constructor
    }

    public interface OnDbOpListner{
        public void dBOpePerformed(int method);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        bnSave = view.findViewById(R.id.bn_add_user);
        bnSave.setOnClickListener(this);
        bnView=view.findViewById(R.id.bn_view_user);
        bnView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){

            case R.id.bn_add_user:
                dbOpListner.dBOpePerformed(0);
                break;
            case R.id.bn_view_user:
                dbOpListner.dBOpePerformed(1);
                break;

        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    Activity activity = (Activity) context;
    try{
        dbOpListner = (OnDbOpListner) activity;
    }
    catch(ClassCastException e){
        throw new ClassCastException(activity.toString()+"Must implements the interface method..");
    }
    }
}
