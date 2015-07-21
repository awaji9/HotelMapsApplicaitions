package jp.android.myapp.hotelmapsapplicaitions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


public class AddressListActivity extends Activity {

    private ListView myListView;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
    }


    @Override
    public void onStart() {
        super.onStart();

        myListView = (ListView)findViewById(R.id.listView);

        MyDbHelper dbHelper = new MyDbHelper(this);
        db = dbHelper.getWritableDatabase();

        //String id = MyDbHelper.ID;

        Button btn = (Button) findViewById(R.id.transRegButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(AddressListActivity.this, RegisterActivity.class);
                startActivity(intent);
            }


        });


        String[] regData = new String[5];
        Intent regIntent = getIntent();
        if(regIntent != null) {
            regData[0] = regIntent.getStringExtra("text");
            regData[1] = regIntent.getStringExtra("text2");
            regData[2] = regIntent.getStringExtra("text3");
            regData[3] = regIntent.getStringExtra("text4");
            regData[4] = regIntent.getStringExtra("text5");

            if(regData[0] != null) {

                AlertDialog.Builder ab = new AlertDialog.Builder(AddressListActivity.this);
                ab.setTitle("Intent");
                ab.setMessage(regIntent.getStringExtra("text") + "\n");
                ab.show();

            }
        }
        try{

            //deleteToDB(id);

            insertToDB(regData);

            Cursor c = searchToDB();

            String[] from = {
                    MyDbHelper.NAME,
                    MyDbHelper.ADD_NAME,
                    MyDbHelper.TELL,
                    MyDbHelper.MONEY,
                    MyDbHelper.PARKING_LOT
            };

            int[] to = {
                    R.id.tName,
                    R.id.tAddName,
                    R.id.tTell,
                    R.id.tMoney,
                    R.id.tParkingLot
            };

            SimpleCursorAdapter adapter =
                    new SimpleCursorAdapter(this,R.layout.listitem_layout,c,from,to,0);

            myListView.setAdapter(adapter);

            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view,int i,long l){

                    Intent intent = new Intent(AddressListActivity.this, MapsActivity.class);

                    String s1 = ((TextView)view.findViewById(R.id.tAddName)).getText().toString();
                    intent.putExtra("name", s1);
                    startActivity(intent);
                }
            });
        }catch (Exception e){
            AlertDialog.Builder ab = new AlertDialog.Builder(AddressListActivity.this);
            ab.setTitle("ERROR");
            ab.setMessage("It's The Error." + "\n");
            ab.show();
            e.printStackTrace();

        }finally {

            db.close();

        }
    }

    private void insertToDB(String[] regData)throws Exception{

        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('ダイワロイネットホテル盛岡','岩手県盛岡市 大通１－８－１０','019-604-2155','￥9100~','￥1000/1拍')"
        );
        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('スーパーホテル盛岡','岩手県盛岡市盛岡駅前北通１０−３８','019-621-9000','￥4600~','￥500/1拍')"
        );
        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('ホテル紫苑','岩手県盛岡市繋湯ノ舘７４−２','019-689-2288','￥13200~','無料')"
        );
        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('ホテルメトロポリタン盛岡 ニューウイング','岩手県盛岡市盛岡駅前北通２−２７','019-625-1211','￥14400~','￥600/1拍')"
        );
        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('ホテルパールシティ盛岡','岩手県盛岡市大通３丁目７−１９','019-625-3311','￥7000~','￥700/1拍')"
        );
        db.execSQL("insert into myData("
                + MyDbHelper.NAME + ","
                + MyDbHelper.ADD_NAME + ","
                + MyDbHelper.TELL + ","
                + MyDbHelper.MONEY + ","
                + MyDbHelper.PARKING_LOT
                +")values('" + regData[0] + "','" + regData[1] + "','" + regData[2] + "','" + regData[3] + "','" + regData[4] + "')"
        );

    }

    private Cursor searchToDB() throws Exception {

        Cursor c = db.rawQuery("select * from " + MyDbHelper.TABLE_NAME, null);

        return c;
    }

    /*
    public void deleteToDB(String id){
        db.execSQL("delete from " + MyDbHelper.TABLE_NAME
        + " where "
        + MyDbHelper.ID + " = " + id + "'");
    }*/


}
