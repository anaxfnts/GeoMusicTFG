package models;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Emails {
	private final Properties props;
	
	public Emails() {
		props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		//Indicamos el usuario y contraseña desde donde se envian los emails
		props.put("from", "geomusic95@gmail.com");
		props.put("username", "geomusic95@gmail.com");
		props.put("password", "galletita7");
	}
	
	//M�todo para enviar correos electronicos
	public void enviar(String to, String asunto, String cuerpoMensaje) throws MessagingException{
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
			}
		});
		
		Message mensaje = new MimeMessage(session);
		mensaje.setFrom(new InternetAddress(props.getProperty("from")));
		mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		mensaje.setSubject(asunto);
		mensaje.setText(cuerpoMensaje);
		Transport.send(mensaje);
		
		System.out.println("Correo enviado.");
		}

	}

