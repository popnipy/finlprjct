package com.my.book;

//import org.apache.commons.io.input.ReversedLinesFileReader;

import java.io.*;
import java.util.List;

/**
 * Created by Nifras on 6/1/2017.
 */
public class ReadFiles {


    public ReadFiles() throws IOException {
    }

    public void reads(List li) throws IOException {

        File tmp = File.createTempFile("tmp", "");
        File f = new File("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.txt");

        FileWriter writer = new FileWriter("output2.txt");
        //BufferedReader brr = new BufferedReader(new FileReader("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.txt"));
      /*  ReversedLinesFileReader brrr = new ReversedLinesFileReader(f);
          String reivies = brrr.readLine();
          writer.write(reivies);
          writer.flush();
          writer.close()*/;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        int o = li.size()-1;
        for(int i=0;i<o;i++){
            bw.write(String.format("%s%n", br.readLine()));

        }
        br.close();
        bw.close();
        File oldFile = new File("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.txt");
        if (oldFile.delete())
            tmp.renameTo(oldFile);


    }






}
