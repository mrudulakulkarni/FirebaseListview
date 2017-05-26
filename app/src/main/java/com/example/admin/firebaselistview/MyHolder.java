package com.example.admin.firebaselistview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 5/26/2017.
 */

public class MyHolder {

    TextView nameTxt;
    ImageView img;
    public MyHolder(View itemView) {


        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        img=(ImageView) itemView.findViewById(R.id.dogimage);


    }
}
