package com.uatx.app.correos.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uatx.app.correos.model.User;
import com.uatx.app.correos.repository.UsuarioRepository;
import com.uatx.app.correos.service.CorreoService;


@Service
public class CorreosServiceImpl implements CorreoService{
	
	@Autowired
	private UsuarioRepository usuario;
	
	
	private List usuarios;
	
	@Override
	public void enviarConGMail(String destinatario, String asunto, String cuerpo) {

	    String remitente = "uatxpagu";  

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "uatx123xD");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente,"uatx123xD");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
	
	


	@Override
	public List<User> fyndTarget() {
		usuarios = new ArrayList<User>();
		
		usuarios = usuario.findAll();

		return usuarios;
	}
	
	@Override
	public void mandarCorreos() {
		List usuarios = new ArrayList();
		usuarios = fyndTarget();



		if(usuarios.isEmpty()){
			System.out.println("No hay usuarios en la BD");
		}else{

			for(int i=0;i<=(usuarios.size()-1);i++) {
				User u = (User)usuarios.get(i);

				if(u.getLastDay()-obtenerDia() >= 2 ) {
					enviarConGMail(u.getCorreo(), "No nos olvides!!", "Hola "+u.getNombre()+" "
							+ "parece que no has visitado nuestra pagina web por mas de dos dias");

					System.out.println(u.getCorreo());
				}
			}

		}
	}
	
	@Override
	public int obtenerDia() {
		
		Date hoy=new Date();
        int numeroDia=0;
        Calendar cal= Calendar.getInstance();
        cal.setTime(hoy);
        numeroDia=cal.get(Calendar.DAY_OF_WEEK);

		return numeroDia;
		
	}
	
	
	
}
