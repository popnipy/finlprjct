package net.Spring.asr;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import weka.classifiers.functions.LinearRegression;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.util.ArrayList;
import java.util.List;

//import com.mongodb.DBCursor;
//import weka.classifiers.Evaluation;
//import weka.classifiers.functions.SMOreg;

public class Classiffy {
	double roundOff;
	double roundOff2;

	public void test(String[] actvity, String[] Scenic, long rowcount, String places, DBCollection col, DB db,
			String Category, String Subject1, String Subject2) throws Exception {

		BasicDBObject ab = new BasicDBObject();
		db.getCollection("Rates_" + Category).createIndex(new BasicDBObject("Name", 1),
				new BasicDBObject("unique", true));
		ab.put("Category", Category);
		ab.put("Name", places);
		List<DBObject> documents = new ArrayList<DBObject>();

		DataSource source = new DataSource("E:\\finalProject\\New folder\\_test.arff");
		Instances trainDataset = source.getDataSet();
		// String[] opt=new String[]{"-R","1-2"};

		StringToWordVector filter = new StringToWordVector();

		filter.setInputFormat(trainDataset);
		// filter.setInputFormat(trainDataset);
		Instances filterTrainDataset = Filter.useFilter(trainDataset, filter);

		filterTrainDataset.setClassIndex(0);
		// Evaluation eval = new Evaluation(filterTrainDataset);
		//SMOreg nb = new SMOreg();
		 LinearRegression nb = new LinearRegression ();
		nb.buildClassifier(filterTrainDataset);

		for (int j = 1; j < 2 * (rowcount) + 1; j += 2) {
			// System.out.println("Asir");
			Instance newInst1 = filterTrainDataset.instance(filterTrainDataset.numInstances() - (j + 1));// actvity
			Instance newInst2 = filterTrainDataset.instance(filterTrainDataset.numInstances() - j);// natural
			String a = newInst1.toString();
			String b = newInst2.toString();
			if (a.equals("{0 ?}") && !b.equals("{0 ?}")) {
				roundOff = 5;
				double predNB2 = nb.classifyInstance(newInst2);
				roundOff2 = Math.round(predNB2 * 100.0) / 100.0;

			} else if (b.equals("{0 ?}") && !a.equals("{0 ?}")) {
				roundOff2 = 5;
				double predNB = nb.classifyInstance(newInst1);
				roundOff = Math.round(predNB * 100.0) / 100.0;

			} else if (a.equals("{0 ?}") && b.equals("{0 ?}")) {
				roundOff2 = 5;
				roundOff = 5;
			}

			else {
				double predNB = nb.classifyInstance(newInst1);
				double predNB2 = nb.classifyInstance(newInst2);
				roundOff = Math.round(predNB * 100.0) / 100.0;
				roundOff2 = Math.round(predNB2 * 100.0) / 100.0;
			}

			try {

				DBObject cj = new BasicDBObject();
				cj.put(Subject1, roundOff);
				cj.put(Subject2, roundOff2);
				cj.put("_id", j);
				// System.out.println(roundOff);
				// System.out.println(roundOff2);
				documents.add(cj);

			}

			catch (Exception ex) {
				System.out.println(ex);
			}

		}
		ab.put("Review", documents);
		col.insert(ab);

	}

}
