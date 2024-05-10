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

<<<<<<< HEAD
  public static boolean addFirebaseCuenta(Cuenta cuenta) {
=======
  public boolean addFirebaseCuenta(Cuenta cuenta) {
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
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
<<<<<<< HEAD
    // Validar que usuario no sea ni nulo ni vacío
    if (usuario == null || usuario.isEmpty()) {
      System.out.println("El nombre de usuario es nulo o vacío.");
      return ""; // O puedes lanzar una excepción aquí si lo prefieres
    }

=======
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String usuarioConsultado = "";
    try {
<<<<<<< HEAD
      document = future.get();
      if (document.exists()) {
        // El documento existe, ahora puedes acceder al campo "usuario"
        usuarioConsultado = document.getString("usuario");
        System.out.println("Usuario encontrado: " + usuarioConsultado);
      } else {
        usuarioConsultado = usuario;
        System.out.println("Usuario no encontrado, disponible: " + usuarioConsultado);

      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return usuarioConsultado;
  }

  public static String consultarPasswd(String usuario) {
    // Validar que la contraseña no sea ni nula ni vacía
    if (usuario == null || usuario.isEmpty()) {
      System.out.println("La contraseña es nula o vacía.");
      return "";
    }

    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
=======
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
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String passwdConsultado = "";
    try {
<<<<<<< HEAD
      document = future.get();
      if (document.exists()) {
        // El documento existe, ahora puedes acceder al campo "contraseña"
        passwdConsultado = document.getString("contraseña");
        System.out.println("Contraseña coincidente: " + passwdConsultado);
      } else {
        passwdConsultado = usuario;
        System.out.println("Contraseña no coincide, proporcionada: " + passwdConsultado);
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return passwdConsultado;
  }

  public static Cuenta obtenerDatosCuenta(String usuario) {
    if (usuario == null || usuario.isEmpty()) {
      System.out.println("La contraseña es nula o vacía.");
      return null;
    }

    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();

    DocumentSnapshot document;
    String nombreConsultado = "";
    String usuarioConsultado = "";
    String contraseñaConsultado = "";
    String ubicacionConsultado = "";
    String correoConsultado = "";
    String tipoConsultado = "";

    Cuenta cuenta = null;

    try {
      document = future.get();
      if (document.exists()) {
        nombreConsultado = document.getString("nombre");
        usuarioConsultado = document.getString("usuario");
        contraseñaConsultado = document.getString("contraseña");
        ubicacionConsultado = document.getString("ubicacion");
        correoConsultado = document.getString("correo");
        tipoConsultado = document.getString("tipo");

        cuenta = new Cuenta(nombreConsultado, usuarioConsultado, contraseñaConsultado, ubicacionConsultado,
            correoConsultado, tipoConsultado);

        System.out.println("Datos obtenidos" + cuenta.toString());
      } else {
        System.out.println("Datos no obtenidos: la cuenta no existe");
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }

    return cuenta;

  }
=======
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
>>>>>>> 68346f61d30bef8c28dd4ee2bd863c2173f2191e

}
