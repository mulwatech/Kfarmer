package Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

import java.util.ArrayList;


/**
 * Created by CJ-SERVER on 8/11/2015.
 */
public class Expert extends Fragment {

    private EditText name,area,education,specialization,phone,email,password,confirmation;
    private Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.expert,container,false);


        name = (EditText) view.findViewById(R.id.expertname);
        area = (EditText) view.findViewById(R.id.expert_location);
        education = (EditText) view.findViewById(R.id.education);
        specialization = (EditText) view.findViewById(R.id.specialization);
        phone = (EditText) view.findViewById(R.id.expert_phone_no);
        email = (EditText) view.findViewById(R.id.expert_email);
        password = (EditText) view.findViewById(R.id.pass);
        confirmation= (EditText) view.findViewById(R.id.pass2);
        submit = (Button) view.findViewById(R.id.expert_registration);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validation()){
                    String ename = name.getText().toString().trim();
                    String e_area = area.getText().toString().trim();
                    String e_education = education.getText().toString().trim();
                    String e_specialization = specialization.getText().toString().trim();
                    String mobile = phone.getText().toString().trim();
                    String e_email = email.getText().toString().trim();
                    String e_password = password.getText().toString().trim();


                }
            }
        });
        return view;
    }
    private boolean Validation(){
        if (name.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide Name",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (area.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide your area of Operation",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (education.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide your Level of Education",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (specialization.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide your Field of specialization",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phone.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide your Mobile No",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.getText().length()==0){
            Toast.makeText(getActivity(),"Please provide Email Address",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.getText().length()==0){
            Toast.makeText(getActivity(),"Please enter your passwod",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (confirmation.getText().length()==0){
            Toast.makeText(getActivity(),"Confirm your password",Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (password.getText().toString()!= confirmation.getText().toString()){
//            Toast.makeText(getActivity(),"Your Password didn't match",Toast.LENGTH_SHORT).show();
//            return false;
//        }
        return true;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
