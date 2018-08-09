package m.srinivas.cocola;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Outlet extends Activity implements View.OnClickListener {
    Button submit_outlet;
    ImageView image1, image2, image3;
    String selected = "no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outlet);
        submit_outlet = (Button) findViewById(R.id.submit_outlet);
        submit_outlet.setOnClickListener(this);
        image1 = findViewById(R.id.image1);
        image1.setOnClickListener(this);
        image2 = findViewById(R.id.image2);
        image2.setOnClickListener(this);
        image3 = findViewById(R.id.image3);
        image3.setOnClickListener(this);

    }

    public void showDialog(Activity activity, String msg, final String status) {
        final Dialog dialog = new Dialog(activity, R.style.PauseDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = dialog.findViewById(R.id.text_dialog);
        text.setText(msg);

        ImageView b = dialog.findViewById(R.id.b);
        if (status.equals("yes")) {
            b.setVisibility(View.VISIBLE);
        } else {
            b.setVisibility(View.GONE);
        }
        Button dialogButton = dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status.equals("yes")) {
                    dialog.dismiss();

                } else {
                    dialog.dismiss();
                }
            }
        });
        dialog.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_outlet:
                 if (selected.equals("no")){
                     showDialog(Outlet.this,"Please take outlet photo","no");
                 }else if (selected.equals("image1")){
                     showDialog(Outlet.this,"Please take area photo","no");
                 }else if (selected.equals("image2")){
                     showDialog(Outlet.this,"Please take signing photo","no");
                 }else {
                     showDialog(Outlet.this,"Successfully outlet uploaded to server thankyou","yes");
                 }
                break;
            case R.id.image1:
                selected = "image1";
                break;
            case R.id.image2:
                selected = "image2";
                break;
            case R.id.image3:
                selected = "image3";
                break;
        }
    }
}
