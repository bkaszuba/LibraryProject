package com.library;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaszuba on 22.05.2017.
 */
public class Organizer {
    public static void writeAllDataToFile(List<Client> clients, String filename) throws IOException {
        PrintWriter pw;
        pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)));
        for (int i = 0; i < clients.size(); i++) {
            pw.println(clients.get(i).getName() + " " + clients.get(i).getSurname());
            for (int j = 0; j < clients.get(i).getBooks().size(); j++) {
                pw.println("\tTitle: " + clients.get(i).getBooks().get(j).getTitle() + "|\tAuthor: " + clients.get(i).getBooks().get(j).getAuthor());
                //pw.printf("\t%-20s %s\n",clients.get(i).getBooks().get(j).getTitle(),clients.get(i).getBooks().get(j).getAuthor());
            }
        }
        pw.close();
    }

    public static void XMLSerialize(List<Client> clientList) {
        XMLEncoder encoder = null;
        try {
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("serializedData.xml")));
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: While Creating or Opening the File serializedData.xml");
        }
        encoder.writeObject(clientList);
        encoder.close();
    }

    public static List<Client> XMLDeserialize(){
        List<Client> clientList = new ArrayList<Client>();
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("serializedData.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File serializedData.xml not found");
        }
        clientList = (List) decoder.readObject();
        System.out.println(clientList.size());
        return clientList;
    }
}