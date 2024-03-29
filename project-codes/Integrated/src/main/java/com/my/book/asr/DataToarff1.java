package com.my.book.asr;

import java.io.BufferedWriter;
import java.io.FileWriter;

import com.mongodb.DB;
import com.mongodb.DBCollection;
//import com.project.ClassiffyIn;

import com.my.book.asr.Classiffy;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class DataToarff1 {

	public void addData(String[] Actvity, String[] Scenic, String places, int rowcount, DBCollection col, DB db,
			String Category, String Subject1, String Subject2) throws Exception {

		 System.out.println(Category);
		DataSource source = new DataSource("E:\\finalProject\\Newfolder" +Category+ ".arff");
		Instances trainDataset = source.getDataSet();
		Instance inst = new Instance(2);
		Instance inst2 = new Instance(2);
		for (int j = 0; j < rowcount; j++) {
			// System.out.println("Asir"+Scenic[j]);
			inst.setValue(trainDataset.attribute(0), Actvity[j]);
			inst2.setValue(trainDataset.attribute(0), Scenic[j]);
			trainDataset.add(inst);
			trainDataset.add(inst2);
		}
		// System.out.println(trainDataset);
		// int i =1;

		// File f = new File("D://Academic//Project//i.arff");

		BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\finalProject\\Newfolder" + Category + "_test.arff"));
		writer.write(trainDataset.toString());
		writer.flush();
		writer.close();
		Classiffy c = new Classiffy();
		c.test(Actvity, Scenic, rowcount, places, col, db, Category, Subject1, Subject2);

	}

}
