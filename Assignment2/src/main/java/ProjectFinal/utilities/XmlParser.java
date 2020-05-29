package ProjectFinal.utilities;

import ProjectFinal.model.Book;
import ProjectFinal.model.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;

public class XmlParser {
	public static String localDir=System.getProperty("user.dir");

	public static ArrayList<Book> getBooksFromXml() {
		ArrayList<Book> bookRepo= new ArrayList<Book>();
		try {
			File fXmlFile = new File(localDir + FileSystems.getDefault().getSeparator() + "books.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("book");
//			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
//				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
//					System.out.println("Id : " + eElement.getAttribute("id"));
//					System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
//					System.out.println("Genre : " + eElement.getElementsByTagName("genre").item(0).getTextContent());
//					System.out.println("Author : " + eElement.getElementsByTagName("author").item(0).getTextContent());
//					System.out.println("Price : " + eElement.getElementsByTagName("price").item(0).getTextContent());
//					System.out.println("Stock : " + eElement.getElementsByTagName("stock").item(0).getTextContent());
					bookRepo.add(new Book(
							Integer.parseInt(eElement.getAttribute("id")),
							eElement.getElementsByTagName("genre").item(0).getTextContent(),
							eElement.getElementsByTagName("title").item(0).getTextContent(),
							eElement.getElementsByTagName("author").item(0).getTextContent(),
							Double.parseDouble(eElement.getElementsByTagName("price").item(0).getTextContent()),
							Integer.parseInt(eElement.getElementsByTagName("stock").item(0).getTextContent())
					));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookRepo;
	}

	public static ArrayList<User> getUsersFromXml() {
		ArrayList<User> userRepo= new ArrayList<User>();
		try {
			File fXmlFile = new File(localDir + FileSystems.getDefault().getSeparator() + "users.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("user");
			System.out.println("----------------------------");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.println("Id : " + eElement.getAttribute("id"));
					System.out.println("Username : " + eElement.getElementsByTagName("username").item(0).getTextContent());
					System.out.println("Password : " + eElement.getElementsByTagName("password").item(0).getTextContent());
					System.out.println("Role : " + eElement.getElementsByTagName("role").item(0).getTextContent());
					System.out.println("Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
					userRepo.add(new User(
							Integer.parseInt(eElement.getAttribute("id")),
							eElement.getElementsByTagName("username").item(0).getTextContent(),
							eElement.getElementsByTagName("password").item(0).getTextContent(),
							eElement.getElementsByTagName("role").item(0).getTextContent(),
							eElement.getElementsByTagName("name").item(0).getTextContent()
					));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userRepo;
	}
}
