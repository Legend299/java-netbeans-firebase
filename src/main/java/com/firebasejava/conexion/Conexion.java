package com.firebasejava.conexion;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Conexion {

    public Conexion() throws FileNotFoundException, IOException {
        FileInputStream serviceAccount = new FileInputStream("{nombre}.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://javafirebase-8de64-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }

}
