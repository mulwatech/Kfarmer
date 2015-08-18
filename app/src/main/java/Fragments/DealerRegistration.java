package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;



/**
 * Created by CJ-SERVER on 7/28/2015.
 */
public class DealerRegistration extends FarmerRegistration {
    private  Spinner county_spinner,business_spinner;
    private ArrayAdapter adapter;
    private EditText firm_name,town,owner,phone_no,email,password, confirmation;
    private Button submit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.dealer_registration, container, false);




        county_spinner = (Spinner)view.findViewById(R.id.dealer_county);

        business_spinner =(Spinner)view.findViewById(R.id.business_nature);

        firm_name = (EditText) view.findViewById(R.id.firmname);
        town= (EditText) view.findViewById(R.id.dealer_town);
        owner= (EditText) view.findViewById(R.id.dealername);
        phone_no = (EditText) view.findViewById(R.id.dealer_phone_no);
        email = (EditText) view.findViewById(R.id.dealer_email);
        password = (EditText) view.findViewById(R.id.password);
        confirmation = (EditText) view.findViewById(R.id.password2);
        submit = (Button) view.findViewById(R.id.dealer_register);

        adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.county,android.R.layout.select_dialog_item);
        county_spinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.business_nature,android.R.layout.select_dialog_item);
        business_spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Validation()){
                    String name = firm_name.getText().toString().trim();
                    String mobile = phone_no.getText().toString().trim();
                    String mail = email.getText().toString().trim();


                }
            }
        });




        return view;
    }

    public boolean Validation(){

        if (firm_name.getText().length()==0){
            Toast.makeText(getActivity(),"Please Enter Firm Name",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (town.getText().length()==0){
            Toast.makeText(getActivity(), "Your firm Location", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (phone_no.getText().length()==0){
            Toast.makeText(getActivity(),"Enter Firm mobile number",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.getText().length()==0){
            Toast.makeText(getActivity(),"Enter Firm Email Address",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.getText().length()==0){
            Toast.makeText(getActivity(),"Enter Your Password",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (confirmation.getText().length()==0){
            Toast.makeText(getActivity(),"Confirm your Password",Toast.LENGTH_SHORT).show();
            return false;
        }
//        if (password.getText()!= confirmation.getText()){
//            Toast.makeText(getActivity(),"Password Mismatch",Toast.LENGTH_SHORT).show();
//            return false;
//        }
        if (owner.getText().length()==0){
            Toast.makeText(getActivity(),"Enter name of the owner",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
