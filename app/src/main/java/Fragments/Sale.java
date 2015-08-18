package Fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v4.app.*;
import com.mulwatech.k_farmer.R;

import java.io.InputStream;

/**
 * Created by CJ-SERVER on 7/29/2015.
 */
public class Sale extends Fragment implements View.OnClickListener {
    public static final int REQUEST_CODE = 10;
    public static final int REQUEST_IMAGE = 0;
    private Spinner spinner;
    private ArrayAdapter adapter;
    private ImageButton camera, gallery;
    private Button submit;
    private ImageView image;
    private EditText productName, productAmount, productDescription,quantity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        container.removeAllViews();
         View view = inflater.inflate(R.layout.sale,container,false);

        camera = (ImageButton)view.findViewById(R.id.takephoto);
        gallery = (ImageButton)view.findViewById(R.id.choosephoto);
        submit = (Button)view.findViewById(R.id.submit);

        camera.setOnClickListener(this);
        gallery.setOnClickListener(this);
        submit.setOnClickListener(this);

        image = (ImageView)view.findViewById(R.id.productimage);
        productName = (EditText) view.findViewById(R.id.productname);
        productAmount = (EditText) view.findViewById(R.id.product_amount);
        productDescription = (EditText) view.findViewById(R.id.product_description);
        quantity = (EditText) view.findViewById(R.id.product_quantity);



        spinner = (Spinner)view.findViewById(R.id.product_category);

        adapter = ArrayAdapter.createFromResource(view.getContext(),R.array.product_category,android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.takephoto:
                Toast.makeText(getView().getContext(),"taking photo comming soon",Toast.LENGTH_SHORT).show();

                Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera, REQUEST_CODE);

                break;
            case R.id.choosephoto:
                Toast.makeText(getView().getContext(),"choose from gallery comming soon",Toast.LENGTH_SHORT).show();
                ChoseImage();
                break;
            case R.id.submit:
                Toast.makeText(getView().getContext(),"Submit form commin soon",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            if(resultCode == Activity.RESULT_OK){
//                Toast.makeText(getView().getContext(),"clicked ok",Toast.LENGTH_SHORT).show();

                image.setBackgroundColor(0);
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                image.setImageBitmap(bitmap);
            }
        }else if(requestCode==REQUEST_IMAGE){
//            Uri imageurl = data.getData();
//            InputStream inputStream = getCo
            Toast.makeText(getView().getContext(),"picture launcher",Toast.LENGTH_SHORT).show();




        }



    }

    public void ValidateInput(){
        

    }
    public void ChoseImage(){

        Intent selectimage = new Intent(Intent.ACTION_PICK);
        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
        Uri imagedirectory = Uri.parse(path);
        selectimage.setDataAndType(imagedirectory,"image/*");
        startActivityForResult(selectimage, REQUEST_IMAGE);



    }
}
