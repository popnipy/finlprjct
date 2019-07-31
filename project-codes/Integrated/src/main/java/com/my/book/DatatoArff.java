package com.my.book;

//import org.apache.commons.compress.utils.IOUtils;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.core.converters.Loader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Add;

import java.io.*;
import java.util.Iterator;
import java.util.List;

public class DatatoArff {
    //static String in;

    public void addAttribute(List<String> Scenic, int annotationCount) throws Exception {
        //this.in=in;
        // String i[] =In;

        Instances data = new Instances(new BufferedReader(new FileReader("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\t1.arff")));
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
        ArffSaver saver = new ArffSaver();
        saver.setInstances(newData);
        saver.setFile(new File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\m1.arff"));
        saver.writeBatch();
     // IOUtils.closeQuietly(data);
        addData(Scenic,annotationCount);


    }

    public static  void addData(List<String> Scenic, int annotationCount) throws Exception {
        DataSource source = new DataSource("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\m1.arff");
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
        saver.setFile(new File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\m2.arff"));
       // saver.setFile(new File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\b.arff"));
        saver.writeBatch();
       // ClassiffyIn c = new ClassiffyIn();
        //Classifiers cl = new Classifiers();
       // cl.N();
       // c.test(Name,review,Scenic,Natural);
      //  Classify cll = new Classify();
      //  cll.f();

        Writer output;
        FileOutputStream to;
        output = new BufferedWriter(new FileWriter("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\b.arff",true));  //clears file every time
        output.write("\r\n");
        for(int i=0; i<Scenic.size();i++) {
            output.append("'"+Scenic.get(i)+"',?");
            output.write("\r\n");
            output.flush();
        }
        System.gc();
        output.close();
        //IOUtils.closeQuietly(output);
      File fl = new File("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\dd.arff");
        File f1l = new File("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\b.arff");



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

        Cl objCl = new Cl();
        objCl.m(annotationCount,Scenic);

    }



           // System.gc();


/*public static void main(String[] args) throws Exception
{
	addAttribute();
	addData();

}*/


}