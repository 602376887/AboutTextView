package me.grantland.autofittextview.sample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by dengdun on 2016/2/26.
 */
public class MainActivity extends Activity {
    EditText et;
    TextView tv;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);
        tv1 = (TextView) findViewById(R.id.tv1);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                TextPaint paint = new TextPaint();
                tv1.setText(s.toString());
                int targetWidth = tv1.getWidth() - tv1.getPaddingLeft() - tv1.getPaddingRight();
                paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, tv1.getTextSize(),
                        tv1.getContext().getResources().getDisplayMetrics()));
                StaticLayout layout = new StaticLayout(s.toString(), paint, (int) targetWidth,
                        Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                if(layout.getLineCount() > 1){

                }
                tv.setText(layout.getLineCount() + "");
                int targetWidth1 = et.getWidth() - et.getPaddingLeft() - et.getPaddingRight();
                paint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, et.getTextSize(),
                        et.getContext().getResources().getDisplayMetrics()));
                StaticLayout layout1 = new StaticLayout(s.toString(), paint, (int) targetWidth,
                        Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                tv.setText(layout.getLineCount() + "");
                ((TextView)findViewById(R.id.tv2)).setText(layout1.getLineCount() + "");

            }
        });
    }
}
