package firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import models.Cuenta;

public class CRUDFirebaseCuentas {

  private static Firestore bd = null;

  public CRUDFirebaseCuentas() {
    ConexionFirebase conexionFirebase = new ConexionFirebase();
    bd = conexionFirebase.iniciarFirebase();
  }

  public boolean addFirebaseCuenta(Cuenta cuenta) {
    boolean key = false;
    Map<String, Object> docCuenta = new HashMap<>();
    docCuenta.put("idCuenta", cuenta.getIdCuenta());
    docCuenta.put("nombre", cuenta.getNombre());
    docCuenta.put("correo", cuenta.getCorreo());
    docCuenta.put("contraseña", cuenta.getContraseña());
    docCuenta.put("ubicacion", cuenta.getUbicacion());
    docCuenta.put("usuario", cuenta.getUsuario());
    docCuenta.put("es_administrar", cuenta.getEs_administrador());

    // UUID.randomUUID().toString()
    ApiFuture<WriteResult> future = bd.collection("Cuentas").document(cuenta.getUsuario()).set(docCuenta);
    // ...
    try {
      System.out.println("Update time : " + future.get().getUpdateTime());
      key = true;
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return key;

  }

  public static String consultarUsuario(String usuario) {
    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String usuarioConsultado = "";
    try {
        document = future.get();
        if (document.exists()) {
            // Obtener el valor del campo "usuario"
            Object usuarioObject = document.get("usuario");
            if (usuarioObject != null) {
                // Convertir el valor a String
                usuarioConsultado = usuarioObject.toString();
                System.out.println("Usuario encontrado: " + usuarioConsultado);
            } else {
                System.out.println("Usuario no encontrado");
            }
        } else {
            System.out.println("Documento no encontrado");
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
    return usuarioConsultado;
}


  public static String consultarPasswd(String passwd) {
    DocumentReference docRef = bd.collection("Cuentas").document(passwd);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String passwdConsultado = "";
    try {
        document = future.get();
        if (document.exists()) {
            // Obtener el valor del campo "contraseña"
            Object passwdObject = document.get("contraseña");
            if (passwdObject != null) {
                // Convertir el valor a String
                passwdConsultado = passwdObject.toString();
                System.out.println("Contraseña encontrada: " + passwdConsultado);
            } else {
                System.out.println("Contraseña no encontrada");
            }
        } else {
            System.out.println("Documento no encontrado");
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
    return passwdConsultado;
}

}
