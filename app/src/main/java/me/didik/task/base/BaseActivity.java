package me.didik.task.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.Unbinder;


/**
 * Created by didik on 22/04/16.
 * Base
 */
public abstract class BaseActivity extends AppCompatActivity {
    public final static String DATA = "data";
    protected Context mContext;
    protected Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) unbinder.unbind();
    }

    protected void toast(String message, int length) {
        Toast.makeText(mContext, message, length).show();
    }

    protected void toast(String message) {
        toast(message, Toast.LENGTH_SHORT);
    }

   /* @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.scale_in, R.anim.slide_out_to_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.scale_in, R.anim.slide_out_to_right);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*@Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.scale_out);
    }*/
}
