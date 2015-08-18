package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

/**
 * Created by CJ-SERVER on 8/5/2015.
 */
public class Userselection extends Fragment implements View.OnClickListener {

    //fragments
    private final FarmerRegistration farmerRegistration = new FarmerRegistration();
    private final DealerRegistration DRegistration = new DealerRegistration();
    private final Expert expert = new Expert();


    private ImageButton farmer_registration,dealer_registration,expert_registration;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.userselection,container,false);

        farmer_registration  = (ImageButton) view.findViewById(R.id.register_as_farmer);
        dealer_registration  = (ImageButton) view.findViewById(R.id.register_as_dealer);
        expert_registration = (ImageButton) view.findViewById(R.id.as_expert);

        farmer_registration.setOnClickListener(this);
        dealer_registration.setOnClickListener(this);
        expert_registration.setOnClickListener(this);


        return  view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_as_farmer:
//                Toast.makeText(getActivity(), "register as farmer", Toast.LENGTH_SHORT).show();
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.content,farmerRegistration )
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.register_as_dealer:
//                Toast.makeText(getActivity(),"register as dealer",Toast.LENGTH_SHORT).show();
               this.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content, DRegistration)
                        .commit();
                break;
            case R.id.as_expert:
                Toast.makeText(getActivity(),"register as expert",Toast.LENGTH_SHORT).show();
                this.getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content,expert)
                        .commit();
                break;





        }

    }

}
