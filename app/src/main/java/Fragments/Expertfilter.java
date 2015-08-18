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
public class Expertfilter extends Fragment implements View.OnClickListener {


    private final SearchExpert_by_name ExpertName = new SearchExpert_by_name();
    private Button byname, bylocation,byrate;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.locate_expert,container,false);

        byname = (Button) view.findViewById(R.id.search_expert_name);
        bylocation = (Button) view.findViewById(R.id.expertbylocation);
        byrate = (Button) view.findViewById(R.id.expertbyrate);
        byname.setOnClickListener(this);
        bylocation.setOnClickListener(this);
        byrate.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_expert_name:

                this.getFragmentManager().beginTransaction()
                        .replace(R.id.content,ExpertName )
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.expertbylocation:
                Toast.makeText(getActivity(),"search Location",Toast.LENGTH_SHORT).show();
                break;
            case R.id.expertbyrate:
                Toast.makeText(getActivity(),"search with the highest  rate",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
