package utils;

import com.mailersend.sdk.*;
import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.exceptions.MailerSendException;

public class EmailUtility {

  // Claves de API y detalles de correo electrónico predeterminados
  private static final String API_KEY = "mlsn.07e6ff2617401dc7d9aa06345085527e3d2da7553e2b6a58618b3b646e1a1e6b";
  private static final String FROM_EMAIL = "reminder@trial-z3m5jgryn104dpyo.mlsender.net";
  private static final String FROM_NAME = "Ana";

  // Método para enviar un correo electrónico.
  public static void sendEmail(String recipientEmail, String subject, String plainText, String htmlContent) {
    Email email = new Email();

    // Configura el remitente y el destinatario
    email.setFrom(FROM_NAME, FROM_EMAIL);
    email.addRecipient("", recipientEmail);

    // Configura el asunto y el contenido del correo electrónico
    email.setSubject(subject);
    email.setPlain(plainText);
    email.setHtml(htmlContent);

    // Inicializa MailerSend y envía el correo electrónico
    MailerSend ms = new MailerSend();
    ms.setToken(API_KEY);

    try {
      MailerSendResponse response = ms.emails().send(email);
      System.out.println("Email enviado correctamente, mensaje ID = " + response.messageId);
    } catch (MailerSendException e) {
      System.err.println("Fallo al enviar el correo electrónico");
      e.printStackTrace();
    }
  }
}
