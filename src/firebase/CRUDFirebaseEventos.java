package firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import models.Evento;

public class CRUDFirebaseEventos {

  private static Evento evento = null;
  private static Firestore bd = null;

  public CRUDFirebaseEventos() {
    ConexionFirebase conexionFirebase = new ConexionFirebase();
    bd = conexionFirebase.iniciarFirebase();
  }

  public static List<Evento> consultarEventos() {
    ApiFuture<QuerySnapshot> future = bd.collection("Eventos").get();

    List<Evento> listaEventos = new ArrayList<>();

    try {
      QuerySnapshot querySnapshot = future.get();

      for (QueryDocumentSnapshot document : querySnapshot) {
        Evento evento = document.toObject(Evento.class);
        listaEventos.add(evento);
        System.out.println(evento.toString());
      }
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    }
    return listaEventos;
  }

}
