package com.my.book.dc;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

import java.io.*;
import java.util.List;

public class DatatoArff {
    //static String in;

    public void addAttribute(List<String> Scenic, int annotationCount, int h, String str) throws Exception {

        Instances data = new Instances(new BufferedReader(new FileReader("E:\\finalProject\\Beaches\\arffFiles\\trainingSample.arff")));
        Instances newData = null;
        newData = new Instances(data);

        Add filter;
        filter = new Add();
        filter.setAttributeIndex("last");
        filter.setNominalLabels("activity,scenic");
        filter.setAttributeName("NewNominal");
        filter.setInputFormat(newData);
        newData = Filter.useFilter(newData, filter);
        // System.out.println(newData);

        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\finalProject\\Beaches\\arffFiles\\beachModelCopy.arff"));
        writer.write(newData.toString());
        writer.flush();
        writer.close();


     // IOUtils.closeQuietly(data);
       addData(Scenic,annotationCount,h,str);


    }

    public void addData(List<String> Scenic, int annotationCount, int h, String str) throws Exception {
        String pathName ="Beaches";
        String fileName = "common7Copy";
        DataSource source = new DataSource("E:\\finalProject\\Beaches\\arffFiles\\beachModelCopy.arff");
        Instances trainDataset = source.getDataSet();
       // Instance inst = new Instance(2);
 /* for(int j=0;j<In.length;j++){
	//  System.out.println(In[j]);
  inst.setValue(trainDataset.attribute(0), In[j]);
  trainDataset.add(inst);
  }
 */
 int b = Scenic.size()-1;
        System.out.println(b);
        for(int i =b ;i>=0;i--){
            Instance inst = new Instance(2);
            String scenic = Scenic.get(i);
            inst.setValue(trainDataset.attribute(0),scenic);
            trainDataset.add(inst);
        }

      //  trainDataset.add(inst);


        //System.out.println(trainDataset);
        ArffSaver saver = new ArffSaver();
        saver.setInstances(trainDataset);
        saver.setFile(new File("E:\\finalProject\\Beaches\\arffFiles\\beachModelArff.arff"));
       // saver.setFile(new File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\b.arff"));
        saver.writeBatch();

        Writer output;
        FileOutputStream to;
        output = new BufferedWriter(new FileWriter("E:\\finalProject\\Beaches\\arffFiles\\common7.arff",true));  //clears file every time
        output.write("\r\n");
        for(int i=0; i<Scenic.size();i++) {
            output.append("'"+Scenic.get(i)+"',?");
            output.write("\r\n");
            output.flush();
        }
      // System.gc();
        output.close();
       // IOUtils.closeQuietly(output);
      File fl = new File("E:\\finalProject\\Beaches\\arffFiles\\common7Copy.arff");
        File f1l = new File("E:\\finalProject\\Beaches\\arffFiles\\common7.arff");



       // copyFileUsingStream(f1l, fl);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(f1l);
            os = new FileOutputStream(fl);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }

        ClassifierClass objCl = new ClassifierClass();
        objCl.m(annotationCount,Scenic,h,str,pathName,fileName);

    }

    public void addAtributeTwo(List<String> Scenic, int annotationCount, int h, String str) throws Exception {

        Instances data = new Instances(new BufferedReader(new FileReader("E:\\finalProject\\Architectrue\\arffFiles\\trainingSample.arff")));
        Instances newData = null;
        newData = new Instances(data);

        Add filter;
        filter = new Add();
        filter.setAttributeIndex("last");
        filter.setNominalLabels("SA,S&L");
        filter.setAttributeName("NewNominal");
        filter.setInputFormat(newData);
        newData = Filter.useFilter(newData, filter);
        // System.out.println(newData);

        BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\finalProject\\Architectrue\\arffFiles\\archiModelCopy.arff"));
        writer.write(newData.toString());
        writer.flush();
        writer.close();


        // IOUtils.closeQuietly(data);
        addDataTwo(Scenic,annotationCount,h,str);


    }

    public void addDataTwo(List<String> Scenic, int annotationCount, int h, String str) throws Exception {
         String pathName ="Architectrue";
         String fileName="commonTwo7Copy";

        DataSource source = new DataSource("E:\\finalProject\\Architectrue\\arffFiles\\archiModelCopy.arff");
        Instances trainDataset = source.getDataSet();
        // Instance inst = new Instance(2);
 /* for(int j=0;j<In.length;j++){
	//  System.out.println(In[j]);
  inst.setValue(trainDataset.attribute(0), In[j]);
  trainDataset.add(inst);
  }
 */
        int b = Scenic.size()-1;
        System.out.println(b);
        for(int i =b ;i>=0;i--){
            Instance inst = new Instance(2);
            String scenic = Scenic.get(i);
            inst.setValue(trainDataset.attribute(0),scenic);
            trainDataset.add(inst);
        }

        //  trainDataset.add(inst);


        //System.out.println(trainDataset);
        ArffSaver saver = new ArffSaver();
        saver.setInstances(trainDataset);
        saver.setFile(new File("E:\\finalProject\\Architectrue\\arffFiles\\archiModelArff.arff"));
        // saver.setFile(new File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\b.arff"));
        saver.writeBatch();

        Writer output;
        FileOutputStream to;
        output = new BufferedWriter(new FileWriter("E:\\finalProject\\Architectrue\\arffFiles\\commonTwo7.arff",true));  //clears file every time
        output.write("\r\n");
        for(int i=0; i<Scenic.size();i++) {
            output.append("'"+Scenic.get(i)+"',?");
            output.write("\r\n");
            output.flush();
        }
        // System.gc();
        output.close();
        // IOUtils.closeQuietly(output);
        File fl = new File("E:\\finalProject\\Architectrue\\arffFiles\\commonTwo7Copy.arff");
        File f1l = new File("E:\\finalProject\\Architectrue\\arffFiles\\commonTwo7.arff");



        // copyFileUsingStream(f1l, fl);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(f1l);
            os = new FileOutputStream(fl);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
      System.out.println("WWWWWWWWEEEEEE r from Archiiiiiiiii");
        ClassifierClass objCl = new ClassifierClass();
        objCl.m(annotationCount,Scenic,h,str,pathName,fileName);




    }
}