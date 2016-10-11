package com.lol.myscanbardemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.rock.qrcodelibrary.CaptureActivity;
import com.zxing.encoding.EncodingHandler;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEditText = (EditText) findViewById(R.id.et_main);
        mImageView = (ImageView) findViewById(R.id.img_main);
    }

    public void onClick(View view) {
        String str = mEditText.getText().toString().trim();
        Bitmap bitmap = null;
        if (!TextUtils.isEmpty(str)) {
            switch (view.getId()) {
                case R.id.btn_tiao:
                    bitmap = EncodingHandler.creatBarcode(this, str, mImageView.getWidth(), mImageView.getHeight(), true);
                    break;
                case R.id.btn_two:
                    bitmap = EncodingHandler.createQRCode(str, mImageView.getWidth());
                    break;
                case R.id.btn_logotwo:
                    Bitmap logo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                    bitmap = EncodingHandler.createQrCodeLogo(str, mImageView.getWidth(), logo);
                    break;
                case R.id.btn_find:
                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                    startActivityForResult(intent, 0);
                default:
                    break;
            }
        } else {
            Toast.makeText(this, "str为null", Toast.LENGTH_SHORT).show();
        }
        if (bitmap != null) {
            mImageView.setImageBitmap(bitmap);
        } else {
            mImageView.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == RESULT_OK) {
            String result = data.getExtras().getString("result");
            if (!TextUtils.isEmpty(result)) {
                mEditText.setText(result);
            }
        }
    }
}
