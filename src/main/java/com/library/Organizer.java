package com.library;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Kaszuba on 22.05.2017.
 */
public class Organizer {
    public static void writeAllDataToFile(List<Client> clients, String filename) throws IOException {
        PrintWriter pw;
        pw = new PrintWriter(new BufferedWriter(new FileWriter(filename, false)));
        for(int i=0;i<clients.size();i++) {
            pw.println(clients.get(i).getName()+" "+clients.get(i).getSurname());
                for(int j=0;j<clients.get(i).getBooks().size();j++){
                    pw.println("\tTitle: "+clients.get(i).getBooks().get(j).getTitle()+"|\tAuthor: "+clients.get(i).getBooks().get(j).getAuthor());
                    //pw.printf("\t%-20s %s\n",clients.get(i).getBooks().get(j).getTitle(),clients.get(i).getBooks().get(j).getAuthor());
                }
        }
        pw.close();
    }
}
