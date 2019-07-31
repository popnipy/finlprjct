package com.my.book;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Nifras on 6/2/2017.
 */
public class ABC {




    public void abc(){


        String s = null;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\b.arff"));
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        ArffLoader.ArffReader arff = null;
        try {
            arff = new ArffLoader.ArffReader(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Instances data = arff.getData();
        data.setClassIndex(data.numAttributes() - 1);
        int y=data.numInstances();
        System.out.println("The number of attributes is  : " +data.numAttributes());
        System.out.println("The number of attributes is  : " + y);


    }





}
