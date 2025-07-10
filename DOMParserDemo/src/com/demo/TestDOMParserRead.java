package com.demo;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.time.Year;

public class TestDOMParserRead {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 1️. Load XML file
        File xmlFile = new File("books.xml");

        if (!xmlFile.exists()) {
            System.out.println("File not found: " + xmlFile.getAbsolutePath());
            return;
        }

        // 2️. Create DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // 3️. Create DocumentBuilder
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // 4️. Parse XML and get Document
        Document doc = dBuilder.parse(xmlFile);

        // 5️. Normalize XML Structure
        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        // Get all book nodes
        NodeList bookList = doc.getElementsByTagName("book");
        System.out.println("------ Book Details ------");

        // Read all books from DOM
        for (int i = 0; i < bookList.getLength(); i++) {
            Node node = bookList.item(i);

            System.out.println("\nNode Name: " + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) { 
            	
                Element element = (Element) node;

                // Get attribute
                String category = element.getAttribute("category");
                // Get child elements
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String year = element.getElementsByTagName("year").item(0).getTextContent();
                String price = element.getElementsByTagName("price").item(0).getTextContent();

                System.out.println("Category   : " + category);
                System.out.println("Title  : " + title);
                System.out.println("Author : " + author);
                System.out.println("Year : " + year);
                System.out.println("Price  : $" + price);
            }
        }
    }
}
