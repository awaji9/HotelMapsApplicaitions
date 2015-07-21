package jp.android.myapp.hotelmapsapplicaitions;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onStart() {
        super.onStart();

        Button btn = (Button) findViewById(R.id.regButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(RegisterActivity.this, AddressListActivity.class);

                EditText et = (EditText) findViewById(R.id.NameEdit);
                String text = et.getText().toString();
                EditText et2 = (EditText) findViewById(R.id.AddNameEdit);
                String text2 = et2.getText().toString();
                EditText et3 = (EditText) findViewById(R.id.TellEdit);
                String text3 = et3.getText().toString();
                EditText et4 = (EditText) findViewById(R.id.MoneyEdit);
                String text4 = et4.getText().toString();
                EditText et5 = (EditText) findViewById(R.id.ParkingLotEdit);
                String text5 = et5.getText().toString();

                intent.putExtra("text", text);
                intent.putExtra("text2", text2);
                intent.putExtra("text3", text3);
                intent.putExtra("text4", text4);
                intent.putExtra("text5", text5);
                startActivity(intent);
            }


        });


    }
}
