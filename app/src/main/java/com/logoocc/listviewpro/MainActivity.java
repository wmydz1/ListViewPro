package com.logoocc.listviewpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.logoocc.listviewpro.adapter.ContactsAdapter;
import com.logoocc.listviewpro.entity.Contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ContactsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.main_list);

        adapter = new ContactsAdapter(this, null, clickLis);
        loadData();
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(itemClickListener);
    }

    private View.OnClickListener clickLis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.item_delete:
                    Integer id = (Integer) v.getTag();
                    Toast.makeText(getApplicationContext(), "删除的Id是" + id, Toast.LENGTH_SHORT).show();
                    break;
            }


        }
    };


    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getApplicationContext(), "点击的Id是" + id, Toast.LENGTH_SHORT).show();
        }
    };

    private void loadData() {
        List<Contacts> lists = new ArrayList<Contacts>();

        //int id, String name, String qq, String tel, String address
        Contacts c = new Contacts(100, "aaa", "bbb", "ccc", "dddd");
        Contacts c2 = new Contacts(200, "aaa2", "bbb2", "ccc2", "dddd2");
        Contacts c3 = new Contacts(300, "aaa3", "bbb3", "ccc3", "dddd3");
        Contacts c4 = new Contacts(400, "aaa4", "bbb4", "ccc4", "dddd4");
        Contacts c5 = new Contacts(500, "aaa5", "bbb5", "ccc5", "dddd5");

        lists.add(c);
        lists.add(c2);
        lists.add(c3);
        lists.add(c4);
        lists.add(c5);

        adapter.addAll(lists);

    }

}
