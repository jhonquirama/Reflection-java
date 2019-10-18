/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Lenovo
 */
public class Reflecion {

    Class clase;
    Method method;
    Field field;
    private String paquete;
    private final String punto = ".";

    public DefaultComboBoxModel cargar(String paquete) {
        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        cb.addElement("seleccione las clases");

        this.paquete = paquete;

        try {
            ClassPath classpath = ClassPath.from(Thread.currentThread().getContextClassLoader());
            ImmutableSet<ClassPath.ClassInfo> clases = classpath.getTopLevelClasses(this.paquete);
            if (clases.isEmpty()) {
                return null;
            }
            clases.forEach((info) -> {
                cb.addElement(info.getSimpleName());
            });

        } catch (IOException ex) {
            Logger.getLogger(Reflecion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cb;

    }

    public ComboBoxModel cargarLosAtributos(String nombre) {

        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        cb.addElement("seleccione los atributos");

        try {
            clase = Class.forName(this.paquete + this.punto + nombre);

        } catch (Exception e) {
            Logger.getLogger(Reflecion.class.getName()).log(Level.SEVERE, null, e);
            return cb;

        }

        Field[] userFields = clase.getDeclaredFields();
        for (int i = 0; i < userFields.length; i++) {
            field = userFields[i];
            cb.addElement(field.getName());
            System.out.println("campo: " + field.getName());

        }
        userFields = clase.getFields();
        for (int i = 0; i < userFields.length; i++) {
            field = userFields[i];
            cb.addElement(field.getName());
            System.out.println("campo: " + field.getName());

        }
        return cb;
    }

    public ComboBoxModel cargarLosMetodos(String nombre) {

        DefaultComboBoxModel cb = new DefaultComboBoxModel();
        cb.addElement("seleccione los metodos");

        Set<String> nombresMetodos = new HashSet<>();

       

        try {
            clase = Class.forName(this.paquete + this.punto + nombre);
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Reflecion.class.getName()).log(Level.SEVERE, null, e);
            return cb;
        }

        Method[] metodos = clase.getDeclaredMethods();

        for (int i = 0; i < metodos.length; i++) {
            Method metodo = metodos[i];
            nombresMetodos.add(metodo.getName());
        }

        metodos = clase.getMethods();

        for (int i = 0; i < metodos.length; i++) {
            Method metodo = metodos[i];
            nombresMetodos.add(metodo.getName());
        }

        nombresMetodos.forEach((nombreMetodo) -> {
            cb.addElement(nombreMetodo);
        });

        return cb;
    }
}
