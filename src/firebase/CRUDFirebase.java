package firebase;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.UnavailableException;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import io.grpc.StatusRuntimeException;
import javafx.scene.control.Alert;
import models.Cuenta;
import models.Evento;

public class CRUDFirebase {

  private static Firestore bd = null;

  public CRUDFirebase() {
    ConexionFirebase conexionFirebase = new ConexionFirebase();
    bd = conexionFirebase.iniciarFirebase();
  }

  public static boolean addFirebaseCuenta(Cuenta cuenta) {
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
    // Validar que usuario no sea ni nulo ni vacío
    if (usuario == null || usuario.isEmpty()) {
        System.out.println("El nombre de usuario es nulo o vacío.");
        return ""; // O puedes lanzar una excepción aquí si lo prefieres
    }

    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String usuarioConsultado = "";
    try {
        document = future.get();
        if (document.exists()) {
            // El documento existe, ahora puedes acceder al campo "usuario"
            usuarioConsultado = document.getString("usuario");
            System.out.println("Usuario encontrado: " + usuarioConsultado);
        } else {
            usuarioConsultado = usuario;
            System.out.println("Usuario no encontrado, disponible: " + usuarioConsultado);
        }
    } catch (ExecutionException e) {
        Throwable cause = e.getCause();
        if (cause instanceof UnavailableException) {
            System.err.println("Firestore no está disponible: " + cause.getMessage());
            alertaError();
            if (cause.getCause() instanceof UnknownHostException) {
                System.err.println("No se pudo resolver el host: " + cause.getCause().getMessage());
                alertaError();
            }
        } else if (cause instanceof StatusRuntimeException) {
            System.err.println("Error de estado de gRPC: " + cause.getMessage());
            alertaError();
            if (cause.getCause() instanceof UnknownHostException) {
                System.err.println("No se pudo resolver el host: " + cause.getCause().getMessage());
                alertaError();
            }
        } else {
            System.err.println("Error de ejecución: " + e.getMessage());
            alertaError();
        }
    } catch (ApiException e) {
        System.err.println("Error de API: " + e.getMessage());
        alertaError();
    } catch (Exception e) {
        System.err.println("Se produjo un error inesperado: " + e.getMessage());
        alertaError();
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
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String passwdConsultado = "";
    try {
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
      alertaError();

    }
    return passwdConsultado;
  }

  
  
  public static String consultarUbicacion(String usuario) {
    // Validar que la contraseña no sea ni nula ni vacía
    if (usuario == null || usuario.isEmpty()) {
      System.out.println("La ubicación es nula o vacía.");
      return "";
    }

    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String ubicacionConsultado = "";
    try {
      document = future.get();
      if (document.exists()) {
        // El documento existe, ahora puedes acceder al campo "contraseña"
        ubicacionConsultado = document.getString("ubicacion");
        System.out.println("Ubicación: " + ubicacionConsultado);
      } else {
        ubicacionConsultado = usuario;
        System.out.println("Contraseña no coincide, proporcionada: " + ubicacionConsultado);
      }
    } catch (InterruptedException | ExecutionException e) {
      alertaError();
      e.printStackTrace();
    }
    return ubicacionConsultado;
  }
  
  public static String consultarCorreo(String usuario) {
    // Validar que la contraseña no sea ni nula ni vacía
    if (usuario == null || usuario.isEmpty()) {
      System.out.println("El correo es nulo o vacío.");
      return "";
    }

    DocumentReference docRef = bd.collection("Cuentas").document(usuario);
    ApiFuture<DocumentSnapshot> future = docRef.get();
    DocumentSnapshot document;
    String correoConsultado = "";
    try {
      document = future.get();
      if (document.exists()) {
        // El documento existe, ahora puedes acceder al campo "contraseña"
        correoConsultado = document.getString("correo");
        System.out.println("Correo: " + correoConsultado);
      } else {
        correoConsultado = usuario;
        System.out.println("Correo no coincide, proporcionada: " + correoConsultado);
      }
    } catch (InterruptedException | ExecutionException e) {
      alertaError();
      e.printStackTrace();
    }
    return correoConsultado;
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
  
  public static List<Evento> consultarEventos(String ubicacion) {
    ApiFuture<QuerySnapshot> future = bd.collection("Eventos").get();

    List<Evento> listaEventos = new ArrayList<>();

    try {
      QuerySnapshot querySnapshot = future.get();

      for (QueryDocumentSnapshot document : querySnapshot) {
        Evento evento = document.toObject(Evento.class);

        if (evento.getUbicacion().equals(ubicacion)) {
          listaEventos.add(evento);
          System.out.println(evento.toString());
        }
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return listaEventos;
}
  
  public static String consultarNombreEvento(String nombreEvento) {
    ApiFuture<QuerySnapshot> future = bd.collection("Eventos").get();
    try {
        QuerySnapshot querySnapshot = future.get();
        for (QueryDocumentSnapshot document : querySnapshot) {
            Evento evento = document.toObject(Evento.class);
            if (evento.getNombreEvento().equals(nombreEvento)) {
                return evento.getNombreEvento();  // Devuelve el nombre del evento encontrado
            }
        }
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
    return null;  // Retorna null si no se encuentra el evento
}
  public static void alertaError() {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Error");
    alert.setContentText("Hay un error de conexión. Inténtalo de nuevo más tarde");
    alert.showAndWait();

  }

}
