package com.demo;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
        
        double grandTotal = 0;
        
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
                String priceStr = element.getElementsByTagName("price").item(0).getTextContent();
                double price = Double.parseDouble(priceStr);
                grandTotal += price;

                System.out.println("Category   : " + category);
                System.out.println("Title  : " + title);
                System.out.println("Author : " + author);
                System.out.println("Year : " + year);
                System.out.println("Price  : $" + priceStr);
                
                
            }
        }
        
        System.out.printf("\n====== Grand Total: $%.2f ======\n", grandTotal);
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nChoose an option:");
        System.out.println("1. List of books published after 2015");
        System.out.println("2. List all books with price > $30");
        System.out.println("3. Exit");
        
        System.out.print("Enter your choice (1/2/3): ");
        int choice = scanner.nextInt();
        
        switch (choice) {
        case 1:
            System.out.println("\n📚 Books published after 2015:");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node node = bookList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    int year = Integer.parseInt(element.getElementsByTagName("year").item(0).getTextContent());
                    if (year > 2015) {
                        System.out.println("- " + title + " (" + year + ")");
                    }
                }
            }
            break;
         
        case 2:
            System.out.println("\n💲 Books with price greater than $30:");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node node = bookList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    double price = Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent());
                    if (price > 30.0) {
                        System.out.printf("- %s ($%.2f)%n", title, price);
                    }
                }
            }
            break;
            
        case 3:
            System.out.println("Goodbye!");
            break;
            
        default:
            System.out.println("Invalid choice. Exiting.");
            break;
        }
        
        scanner.close();
    }
    
}
