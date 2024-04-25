package firebase;

import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class ConexionFirebase {

  public Firestore iniciarFirebase() {
    try {

      FirebaseOptions options;
      options = new FirebaseOptions.Builder()
          .setCredentials(GoogleCredentials
              .fromStream(getClass().getResourceAsStream("geomusic-95f90-firebase-adminsdk-66j1w-5a398500e4.json")))
          .setDatabaseUrl("https://geomusic-95f90-default-rtdb.europe-west1.firebasedatabase.app/").build();

      FirebaseApp.initializeApp(options);

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return FirestoreClient.getFirestore();
  }
}
