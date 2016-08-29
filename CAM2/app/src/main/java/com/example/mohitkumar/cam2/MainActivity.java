package com.example.mohitkumar.cam2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Button button1;
    ImageView imageView;
    static final int requestcode = 1;
    static final int requestcode1 = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.butt1);
       // textView = (TextView)findViewById(R.id.text_2);
        imageView = (ImageView)findViewById(R.id.img1);
        button1 = (Button)findViewById(R.id.butt2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,requestcode);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                File file = getfile2();
                cam_intent.putExtra(MediaStore.EXTRA_OUTPUT,Uri.fromFile(file));
                startActivityForResult(cam_intent,requestcode1);
            }
        });
    }

    private File getfile2()
    {
        File folder = new File("sdcard/cam_2");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File video_file = new File(folder,"video_file.mp4");
        return video_file;
    }

    private File getfile()
    {
        File folder = new File("sdcard/cam_2");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File image_file = new File(folder,"image_file.jpg");
        return image_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == requestcode) {
            String path = "sdcard/cam_2/image_file.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
        }
        else if(requestCode == requestcode1) {
            if(resultCode == RESULT_OK)
            Toast.makeText(getApplicationContext(), "Recording SUCCESSFUL", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(),"Recording Unsuccessful",Toast.LENGTH_SHORT).show();
        }
    }
}
