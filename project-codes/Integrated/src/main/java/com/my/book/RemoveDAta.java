package com.my.book;



import java.io.*;
import java.util.List;

/**
 * Created by Nifras on 5/2/2017.
 */
public class RemoveDAta {

    public void removeStrings(List<String> li) throws IOException {

        String lineToRemove = "'perfect for standing',?";

        try {

            File inFile = new File("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\b.arff");
           // File inFile2 = new File("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\bb.arff");
            if (!inFile.isFile()) {
                System.out.println("Parameter is not an existing file");
                return;
            }

            //Construct the new file that will later be renamed to the original filename.
            File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\b.arff"));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;

            //Read from the original file and write to the new
            //unless content matches data to be removed.
            while ((line = br.readLine()) != null) {
                 int s= li.size();
                //System.out.println("ggggggg"+s);
                    switch (s) {
                        case 1: {
                            if (!line.trim().equals(li.get(0))) {

                                pw.println(line);
                                pw.flush();
                            }
                             break;
                        }
                        case 2: {
                            if (!line.trim().equals(li.get(0)) && (!line.trim().equals(li.get(1)))) {
                               // System.out.println("lllll"+s);
                                pw.println(line);
                                pw.flush();
                            }
                           break;
                        }

                        case 3 : {

                            if (!line.trim().equals(li.get(0)) && (!line.trim().equals(li.get(1)))&&(!line.trim().equals(li.get(2)))){
                                System.out.println("ggggggg"+s);
                                pw.println(line);
                                pw.flush();
                            }
                            break;
                           }

                        case 4 : {

                            if (!line.trim().equals(li.get(0)) && (!line.trim().equals(li.get(1)))&&(!line.trim().equals(li.get(2)))&&(!line.trim().equals(li.get(3)))){
                               // System.out.println("jjjjjj"+s);
                                pw.println(line);
                                pw.flush();

                            }
                            break;
                        }
                        case 5 : {

                            if (!line.trim().equals(li.get(0)) && (!line.trim().equals(li.get(1))) && (!line.trim().equals(li.get(2))) && (!line.trim().equals(li.get(3))) && (!line.trim().equals(li.get(4)))) {

                                pw.println(line);
                                pw.flush();
                            }
                            break;
                        }

                        default:
                            System.out.println("Invalid grade");
                   /* String tempString = li.get(i);
                    if (!line.trim().equals(li.get(i))) {

                        pw.println(line);
                        pw.flush();
                    }*/
                }            }
            pw.close();
            br.close();

            //Delete the original file
          //  inFile.delete();
           // inFile.setWritable(true);
            //file.delete()
            if (!inFile.delete()) {
                System.out.println("Could not delete file");
                return;


            }
            //inFile=null;

            //Rename the new file to the filename the original file had.
            if (!tempFile.renameTo(inFile))
                System.out.println("Could not rename file");

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}