package com.firebasejava.dao;

import com.firebasejava.entidades.Estudiante;
import com.google.api.core.ApiFuture;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EstudianteDAO {

    private final DatabaseReference databaseReference;

    public EstudianteDAO() {
        FirebaseDatabase fd = FirebaseDatabase.getInstance();
        databaseReference = fd.getReference(Estudiante.class.getSimpleName());
    }

    public void AgregarEstudiante(Estudiante estudiante) {
        databaseReference.push().setValueAsync(estudiante);
    }

    public void ModificarEstudiante(String id, HashMap<String, Object> hashMap) {
        databaseReference.child(id).updateChildrenAsync(hashMap);
    }

    public void EliminarEstudiante(String id) {
        databaseReference.child(id).removeValueAsync();
    }
 
    public DefaultTableModel ListarEstudiantes(JTable tabla) {

        DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
        Object[] filas = new Object[4];

        databaseReference.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot ds, String string) {

                filas[0] = ds.getKey();
                filas[1] = ds.child("nombre").getValue();
                filas[2] = ds.child("semestre").getValue();
                filas[3] = ds.child("correo").getValue();

                dtm.addRow(filas);

            }

            @Override
            public void onChildChanged(DataSnapshot ds, String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onChildRemoved(DataSnapshot ds) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onChildMoved(DataSnapshot ds, String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onCancelled(DatabaseError de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        return dtm;

    }
}
