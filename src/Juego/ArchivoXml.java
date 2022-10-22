package Juego;

import java.io.File;

import javax.lang.model.element.Element;
import javax.naming.spi.DirStateFactory.Result;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Text;

public class ArchivoXml {
	
	private Usuario users[];
	private Bot maquina;
	
	public ArchivoXml(Usuario users[], Bot maquina){
		
		this.users = users;
		this.maquina = maquina;
		
	}

	
	public void componentes(){
		try {
			System.out.println("MODODODO " + users[0].getModo());
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
			DocumentBuilder builder = factory.newDocumentBuilder();
			DOMImplementation implementation = builder.getDOMImplementation();
			
			Document documento = implementation.createDocument(null, "Juego", null);
			documento.setXmlVersion("1.0");
			
			org.w3c.dom.Element usuarios = documento.createElement("Usuarios");
			org.w3c.dom.Element usuario = documento.createElement("Usuario");
			org.w3c.dom.Element usuario2 = documento.createElement("Usuario2");
			
			org.w3c.dom.Element nombre = documento.createElement("Nombre");
			Text textNombre = documento.createTextNode(users[0].getNombre());
			nombre.appendChild(textNombre);
			usuario.appendChild(nombre);
			
			org.w3c.dom.Element puntuacion = documento.createElement("Puntuacion");
			Text textPuntuacion = documento.createTextNode(users[0].getPuntuacion());
			puntuacion.appendChild(textPuntuacion);
			usuario.appendChild(puntuacion);
			
			org.w3c.dom.Element estado = documento.createElement("Estado");
			Text textEstado = documento.createTextNode(users[0].getEstadoJuego());
			estado.appendChild(textEstado);
			usuario.appendChild(estado);
			//
			
			org.w3c.dom.Element tiempo = documento.createElement("Tiempo");
			Text textTiempo = documento.createTextNode(users[0].getMinutos() + ": " +users[0].getSegundos());
			tiempo.appendChild(textTiempo);
			usuario.appendChild(tiempo);
			
			org.w3c.dom.Element turnos = documento.createElement("Turnos");
			Text textTurno = documento.createTextNode(users[0].getTurnos());
			turnos.appendChild(textTurno);
			usuario.appendChild(turnos);
			
			if(users[0].getModo() == 2) {
				
				org.w3c.dom.Element nombre2 = documento.createElement("Nombre");
				Text textNombre2 = documento.createTextNode(users[1].getNombre());
				nombre2.appendChild(textNombre2);
				usuario2.appendChild(nombre2);
				
				org.w3c.dom.Element puntuacion2 = documento.createElement("Puntuacion");
				Text textPuntuacion2 = documento.createTextNode(users[1].getPuntuacion());
				puntuacion2.appendChild(textPuntuacion2);
				usuario2.appendChild(puntuacion2);
				
				org.w3c.dom.Element estado2 = documento.createElement("Estado");
				Text textEstado2 = documento.createTextNode(users[1].getEstadoJuego());
				estado2.appendChild(textEstado2);
				usuario2.appendChild(estado2);
				//
				
				org.w3c.dom.Element tiempo2 = documento.createElement("Tiempo");
				Text textTiempo2 = documento.createTextNode(users[1].getMinutos() + ": " +users[1].getSegundos());
				tiempo2.appendChild(textTiempo2);
				usuario2.appendChild(tiempo2);
				
				org.w3c.dom.Element turnos2 = documento.createElement("Turnos");
				Text textTurno2 = documento.createTextNode(users[1].getTurnos());
				turnos2.appendChild(textTurno2);
				usuario2.appendChild(turnos2);
				
				usuarios.appendChild(usuario2);
				
			}
			if(users[0].getModo() == 3) {
				org.w3c.dom.Element nombre2 = documento.createElement("Nombre");
				Text textNombre2 = documento.createTextNode(maquina.getNombre());
				nombre2.appendChild(textNombre2);
				usuario2.appendChild(nombre2);
				
				org.w3c.dom.Element puntuacion2 = documento.createElement("Puntuacion");
				Text textPuntuacion2 = documento.createTextNode(maquina.getPuntuacion());
				puntuacion2.appendChild(textPuntuacion2);
				usuario2.appendChild(puntuacion2);
				
				org.w3c.dom.Element estado2 = documento.createElement("Estado");
				Text textEstado2 = documento.createTextNode(maquina.getEstadoJuego());
				estado2.appendChild(textEstado2);
				usuario2.appendChild(estado2);
				usuarios.appendChild(usuario2);
			}
			
			usuarios.appendChild(usuario);
			
			documento.getDocumentElement().appendChild(usuarios);
			
			Source source = new DOMSource(documento);
			
			javax.xml.transform.Result result = new StreamResult(new File("archivoJuego.xml"));
			
			Transformer  transformer = TransformerFactory.newInstance().newTransformer();
			
			transformer.transform(source, result);
			
			
		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	
	}
	
}
