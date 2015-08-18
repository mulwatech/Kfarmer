package Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.mulwatech.k_farmer.R;

/**
 * Created by CJ-SERVER on 8/6/2015.
 */
public class Chat extends Fragment {

    private ChatArrayadapter adapter;
    private ListView list;
    Intent intent;
    private Button send;
    private EditText message;
    private boolean side = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chat, container, false);



        send = (Button) view.findViewById(R.id.btnsend);
        message = (EditText) view.findViewById(R.id.chat);

        list = (ListView) view.findViewById(R.id.listview);
        adapter = new ChatArrayadapter(getActivity(),R.layout.chat);
//         message.setOnKeyListener(new View.OnKeyListener() {
//             @Override
//             public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                 if(event.getAction() == KeyEvent.ACTION_DOWN && (keyCode == KeyEvent.KEYCODE_ENTER))
//                 {
//                     return SendMessage();
//                 }
//
//                 return false;
//             }
//         });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"Message send",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

//    private boolean SendMessage() {
//
//        adapter.add(new ChatMessage(side,message.getText().toString()));
//        return false;
//    }
}
