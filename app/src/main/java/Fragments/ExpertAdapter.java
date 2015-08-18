package Fragments;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.mulwatech.k_farmer.R;

import java.util.ArrayList;

/**
 * Created by CJ-SERVER on 8/17/2015.
 */
public  class ExpertAdapter extends BaseAdapter {
    private ArrayList<ExpertModel> experts;
    private Context context;

    public ExpertAdapter(Context context, ArrayList<ExpertModel> experts) {
        this.experts = experts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return experts.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return experts.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view = convertView;

        if (view ==null){
            view = LayoutInflater.from(context).inflate(R.layout.expert_byname,parent,false);

            viewHolder = new ViewHolder();

            viewHolder.txtname = (TextView) view.findViewById(R.id.expertname);
            viewHolder.txtlocation = (TextView) view.findViewById(R.id.expertlocation);
            viewHolder.txteducation = (TextView) view.findViewById(R.id.experteducation);
            viewHolder.txtmobile = (TextView) view.findViewById(R.id.expertmobile);
            viewHolder.txtspecialization = (TextView) view.findViewById(R.id.expertspecialization);

            view.setTag(viewHolder);


        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ExpertModel model = experts.get(position);
        viewHolder.txtname.setText(model.getName());
        viewHolder.txtlocation.setText(model.getLocation());
        viewHolder.txteducation.setText(model.getEducation());
        viewHolder.txtmobile.setText(model.getMobile());
        viewHolder.txtspecialization.setText(model.getSpecialization());

        return view;
    }
    private static class ViewHolder {
        TextView txtname,txtlocation,txteducation,txtspecialization,
                txtmobile,txtid,txtemail;
    }


}