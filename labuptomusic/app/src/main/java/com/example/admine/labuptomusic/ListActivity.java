package com.example.admine.labuptomusic;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
public class ListActivity extends AppCompatActivity {
    private static String[] NAMES = {"Usama", "Hamza", "PIA", "RESCUE", "Kamran",
            "Kiran", "Saba", "Adeel",
            "Usama", "Hamza", "PIA", "RESCUE", "Kamran", "Kiran", "Saba", "Adeel"};
    private RecyclerView rcvContacts;
    private ArrayList<ContactsModal> contactsList = null;
    private ContactsAdapter contactsAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        rcvContacts = findViewById(R.id.rcv_list_contacts);
        rcvContacts.setLayoutManager(new LinearLayoutManager(this));
        if (contactsAdapter == null) {
            contactsAdapter = new ContactsAdapter(this, new ArrayList<ContactsModal>());
            rcvContacts.setAdapter(contactsAdapter);
        }
        initList();
        initListeners();
    }
    private void initList() {
        contactsList = new ArrayList<>();
        for (int i = 0; i < NAMES.length; i++) {
            contactsList.add(new ContactsModal(R.drawable.ic_launcher_foreground, NAMES[i]));
        }
        contactsAdapter.addItems(contactsList);
    }
    private void initListeners() {
        contactsAdapter.SetOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, ArrayList<ContactsModal> modelList) {Toast.makeText(ListActivity.this, "Position: " + position + "\nName: " + modelList.get(position).contactName, Toast.LENGTH_LONG).show();
            }
        });
    }
}