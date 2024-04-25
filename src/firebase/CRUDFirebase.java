package firebase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

import models.Cuenta;

public class CRUDFirebase {

  private static Firestore bd = null;

  public CRUDFirebase() {
    ConexionFirebase conexionFirebase = new ConexionFirebase();
    bd = conexionFirebase.iniciarFirebase();
  }

  public boolean addFirebase(Cuenta cuenta) {
    boolean key = false;
    Map<String, Object> docCuenta = new HashMap<>();
    docCuenta.put("idCuenta", cuenta.getIdCuenta());
    docCuenta.put("nombre", cuenta.getNombre());
    docCuenta.put("usuario", cuenta.getUsuario());
    docCuenta.put("contraseña", cuenta.getContraseña());
    docCuenta.put("ubicacion", cuenta.getUbicacion());
    docCuenta.put("correo", cuenta.getCorreo());
    docCuenta.put("tipo", cuenta.getTipo());
    docCuenta.put("es_administrador", cuenta.getEs_administrador());

    ApiFuture<WriteResult> future = bd.collection("Cuentas").document(UUID.randomUUID().toString()).set(docCuenta);
    // ...
    try {
      System.out.println("Update time : " + future.get().getUpdateTime());
      key = true;
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return key;

  }
}
