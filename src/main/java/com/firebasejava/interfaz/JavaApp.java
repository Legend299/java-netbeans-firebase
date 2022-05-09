package com.firebasejava.interfaz;

import com.firebasejava.conexion.Conexion;
import java.io.IOException;

public class JavaApp {

    public static void main(String[] args) throws IOException {

        new Conexion();
        new JFListaEstudiantes().setVisible(true); 
    }

}
