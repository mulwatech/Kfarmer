package Fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.mulwatech.k_farmer.R;

import java.util.ArrayList;

/**
 * Created by CJ-SERVER on 8/18/2015.
 */
public class DealerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DealerModel> dealer_list;

    public DealerAdapter(Context context, ArrayList<DealerModel> dealer_list) {

        System.err.println("Inafika");
        this.context = context;
        this.dealer_list = dealer_list;
    }

    @Override
    public int getCount() {
        return dealer_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return dealer_list.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        View view = convertView;

        if (view==null){
            view = LayoutInflater.from(context).inflate(R.layout.dealersearchholder,null);
            viewholder = new ViewHolder();

            viewholder.f_name = (TextView) view.findViewById(R.id.firmnameEditview1);
            viewholder.county = (EditText) view.findViewById(R.id.countyEditview1);
            viewholder.location = (EditText) view.findViewById(R.id.locationEditview1);
            viewholder.dealerof = (EditText) view.findViewById(R.id.dealerofEditview1);
            viewholder.mobile = (EditText) view.findViewById(R.id.mobileEditview1);

            view.setTag(viewholder);

        }else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        DealerModel model = dealer_list.get(position);
        System.err.println("Dealers Adapter " + model.getFirm_name());
        viewholder.f_name.setText(model.getFirm_name());
        viewholder.county.setText(model.getCounty());
        viewholder.location.setText(model.getLocation());
        viewholder.dealerof.setText(model.getDealer_of());
        viewholder.mobile.setText(model.getMobile());

        return view;
    }

    private static class ViewHolder{
        TextView f_name;
        EditText county;
        EditText location;
        EditText dealerof;
        EditText mobile;

    }

}
