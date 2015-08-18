package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
 * Created by CJ-SERVER on 7/27/2015.
 */
public class FarmerRegistration extends Fragment {
    private Spinner spinner;
    private ArrayAdapter adapter;

    private EditText fname, lastname,phoneno,county,district,email,password, confirmation;
    private Button submit;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        container.removeAllViews();


        View view= inflater.inflate(R.layout.farmer_registration,container,false);

        fname = (EditText) view.findViewById(R.id.fname);
        lastname = (EditText) view.findViewById(R.id.s_name);
        phoneno = (EditText) view.findViewById(R.id.phone_no);
        district = (EditText) view.findViewById(R.id.district);
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        confirmation = (EditText) view.findViewById(R.id.password2);
        submit = (Button) view.findViewById(R.id.farmer_registration);



        spinner = (Spinner)view.findViewById(R.id.farmer_county);
        adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.county,android.R.layout.select_dialog_item);
        spinner.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Registering farmer",Toast.LENGTH_SHORT).show();
                Validate();
            }
        });



        return view;


    }

    public boolean Validate(){

        if (fname.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your name",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (lastname.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your surname",Toast.LENGTH_SHORT).show();
            return false;

        }
        if (phoneno.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your mobile no",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (district.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your district",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (email.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your email address",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (password.getText().length()==0){
            Toast.makeText(getActivity(),"please enter your password",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (confirmation.getText().length()==0){
            Toast.makeText(getActivity(),"please confirm your passeord",Toast.LENGTH_SHORT).show();
            return false;
        }
        if (confirmation.getText()!= password.getText()){
            Toast.makeText(getActivity(),"Password did not match",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
