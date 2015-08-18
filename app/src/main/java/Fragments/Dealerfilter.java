package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

/**
 * Created by CJ-SERVER on 8/13/2015.
 */

public class Dealerfilter extends Fragment implements View.OnClickListener {
    private Button bydealername,dealerlocation,wholesalers;

    private final Search_dealerby_location searchdealerlocation = new Search_dealerby_location();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dealerselecter,container,false);

        bydealername = (Button) view.findViewById(R.id.search_dealer_name);
        dealerlocation = (Button) view.findViewById(R.id.dealerlocation);
        wholesalers = (Button) view.findViewById(R.id.wholesallers);

        bydealername.setOnClickListener(this);
        dealerlocation.setOnClickListener(this);
        wholesalers.setOnClickListener(this);



        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_dealer_name:
                Toast.makeText(getActivity(),"seaching dealer by name",Toast.LENGTH_SHORT).show();
                break;

            case R.id.dealerlocation:
                this.getFragmentManager().beginTransaction()
                        .replace(R.id.content,searchdealerlocation)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.wholesallers:
                Toast.makeText(getActivity(),"seaching for wholesallers",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
