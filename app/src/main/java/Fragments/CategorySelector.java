package Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

/**
 * Created by CJ-SERVER on 8/2/2015.
 */

public class CategorySelector extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mylist;
    private ArrayAdapter<String> adapter;
    private String []categories;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.cropcategory_list,container,false);

//        container.removeAllViews();
        mylist = (ListView) view.findViewById(R.id.list);

        categories = getResources().getStringArray(R.array.product_category);
        adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_expandable_list_item_1,categories);
        mylist.setAdapter(adapter);
        mylist.setOnItemClickListener(this);

        return view;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(),"you clickeed"+categories[position],Toast.LENGTH_SHORT).show();

        switch (categories[position]){

            case "Vegetables":
                Toast.makeText(getActivity(),"open farmer registration",Toast.LENGTH_SHORT).show();
                break;

        }

    }


}
