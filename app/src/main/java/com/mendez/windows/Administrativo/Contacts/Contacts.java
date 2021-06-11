
package com.mendez.windows.Administrativo.Contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.mendez.windows.Administrativo.ModeloA.Usuario;
import com.mendez.windows.Administrativo.controller.HolderContactsAdmin;
import com.mendez.windows.R;


public class Contacts extends AppCompatActivity {

    private RecyclerView rvUsuarios;
    private FirebaseRecyclerAdapter adapter;

    /*
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    private RecyclerView rvContacts;
    private AdapterContacsAdmin adapterContacsAdmin;
    */
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        /*rvContacts = (RecyclerView) findViewById(R.id.contactsadminrecycler);

        ////////////////////////////////////////


        /////////////////////Recibir datos////////////////////////////
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Usuario");//Sala de chat (nombre) version 2



        adapterContacsAdmin = new AdapterContacsAdmin(this);
        LinearLayoutManager l = new LinearLayoutManager(this);
        rvContacts.setLayoutManager(l);
        rvContacts.setAdapter(adapterContacsAdmin);
        ////////////////////////////////////////////////

        ///////////////////////////////////////


        adapterContacsAdmin.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ContactsRecibir m = dataSnapshot.getValue(ContactsRecibir.class);
                adapterContacsAdmin.addContact(m);


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        verifyStoragePermissions(this);


    }
    private void setScrollbar() {
        rvContacts.scrollToPosition(adapterContacsAdmin.getItemCount() - 1);
    }

    public static boolean verifyStoragePermissions(Activity activity) {
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int REQUEST_EXTERNAL_STORAGE = 1;
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
            return false;
        } else {
            return true;
        }
    }
    @Override
    protected void onResume() {
        super.onResume();

    }

    private void returnLogin() {
        startActivity(new Intent(Contacts.this, LoginActivity.class));
        finish();
    }

*/


        rvUsuarios = findViewById(R.id.contactsadminrecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvUsuarios.setLayoutManager(linearLayoutManager);

        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("Usuario");

        FirebaseRecyclerOptions<Usuario> options =
                new FirebaseRecyclerOptions.Builder<Usuario>()
                        .setQuery(query, Usuario.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Usuario, HolderContactsAdmin>(options) {
            @Override
            public HolderContactsAdmin onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_contacts_administrativos, parent, false);
                return new HolderContactsAdmin(view);
            }

            @Override
            protected void onBindViewHolder(HolderContactsAdmin holder, int position, final Usuario model) {
                holder.getTxvcampus().setText(model.getCampus());
                holder.getTxvcargo().setText(model.getCargo());
                holder.getTxvcorreo().setText(model.getCorreo());
                holder.getTxvnombre().setText(model.getNombre());


            }
        };
        rvUsuarios.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}