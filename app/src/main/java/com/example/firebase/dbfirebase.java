package com.example.firebase;

import com.google.android.gms.gcm.Task;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class dbfirebase {
    private DatabaseReference databaseReference;

    dbfirebase() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Register.class.getSimpleName());
    }

    public Task<Void> add(Register register) {
        return databaseReference.push().setValue(register);
    }
    public  Task<Void> update(String key, HashMap<String,Object> hashMap)
    {
        return  databaseReference.child(key).updateChildren(hashMap);
    }
    public  Task<Void> remove(String key)
    {
        return  databaseReference.child(key).removeValue();
    }
}