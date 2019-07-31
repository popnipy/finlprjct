package com.my.book.dc;

import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ClassifierClass {
    List<String> cli = new ArrayList<String>();
    List<String> pli = new ArrayList<String>();
    public  void m(int r, List<String> ri, int h, String str,String pathName,String fileName) throws Exception {

        DataSource source = new DataSource("E:\\finalProject\\"+pathName+"\\arffFiles\\"+fileName+".arff");
        Instances trainDataset = source.getDataSet();
        //String[] opt=new String[]{"-R","1-2"};

        StringToWordVector filter = new StringToWordVector();

        filter.setInputFormat(trainDataset);
        //filter.setInputFormat(trainDataset);
        Instances filterTrainDataset= Filter.useFilter(trainDataset, filter);

        filterTrainDataset.setClassIndex(0);
        Evaluation eval = new Evaluation(filterTrainDataset);

		/*//Save
		ArffSaver saver = new ArffSaver();
		saver.setInstances(filterTrainDataset);
        saver.setFile(new File("C:/Users/Asir ABM/Desktop/aasir.arff"));
        saver.writeBatch();
		*/


        int numberClasses = filterTrainDataset.numClasses();
        //System.out.println(numberClasses);
        for(int i=0;i<numberClasses;i++){
            String classValue=filterTrainDataset.classAttribute().value(i);
            System.out.println("class value "+i+ " is " + classValue);


        }

        NaiveBayes nb = new NaiveBayes();
        //J48 nb = new J48();
        //LibSVM nb = new LibSVM();
        //LinearRegression nb = new LinearRegression();
        // SMOreg nb = new SMOreg();
        nb.buildClassifier(filterTrainDataset);

       // DataSource source1=new DataSource("E:\\finalProject\\Beaches\\arffFiles\\beachCopy.arff");
        DataSource source1=new DataSource("E:\\finalProject\\Beaches\\arffFiles\\beachCopy.arff");
        Instances testDataset =source1.getDataSet();
        //String[] opt1=new String[]{"-R","1-2"};

        StringToWordVector filterTest = new StringToWordVector();
        //filterTest.setOptions(opt1);
        filterTest.setInputFormat(testDataset);
        Instances filterTestDataset= Filter.useFilter(testDataset, filterTest);
        filterTestDataset.setClassIndex(0);
        Collections.reverse(ri);
        for(int i=1;i<r+1;i++) {
            Instance newInst = filterTrainDataset.instance(filterTrainDataset.numInstances() - i);
            Instance newInst1 = filterTrainDataset.instance(filterTrainDataset.numInstances() - 2);

            double predNB = nb.classifyInstance(newInst);
            String predString = filterTrainDataset.classAttribute().value((int) predNB);
             String rt = ri.get(i-1);
            cli.add(predString);
            pli.add(rt);

           // pli.add(phrase1);

            System.out.println(rt);
            System.out.println(predString);

        }
        DBClass m = new DBClass();
        if(h==0||h==1) {

            m.insertMongoDocuments(pli, cli,str,h);
        }
        else if (h==2||h==3){
            m.insertMongoArchitecturalDocuments(pli,cli,str,h);
        }

       // testDataset.delete();
		/*System.out.println("Actual Class,NB Predicted:");
		/*for(int i=0;i<filterTestDataset.numInstances();i++){
			double actualClass=filterTestDataset.instance(i).classValue();
			String actual=filterTestDataset.classAttribute().value((int) actualClass);
			Instance newInst = filterTestDataset.instance(i);
			double predNB =nb.classifyInstance(newInst);
			String predString = filterTestDataset.classAttribute().value((int) predNB);
			System.out.println(actual+ "," + predString);

		}*/

		/*eval.evaluateModel(nb,filterTestDataset);
		System.out.println(eval.toMatrixString("=== Confusion matrix for Naive Bayes"));
		System.out.println("Correctly Classified Instances: " + eval.correct());
		System.out.println("Incorrectly Classified Instances: " + eval.incorrect());
		System.out.println("Percentage of Correctly Classified Instances: " + eval.pctCorrect() + "%");
		//System.out.println("Correctly Classified Instances: " + eval.correlationCoefficient());
		System.out.println("Mean absolute error: " + eval.meanAbsoluteError());
		System.out.println("Root mean squared error: " + eval.rootMeanSquaredError());
		System.out.println("Relative absolute error: " + eval.relativeAbsoluteError());
		System.out.println("Root relative squared error : " + eval.rootRelativeSquaredError());
		System.out.println("Percentage of Correctly Classified Instances: " + eval.pctCorrect() + "%");

		*/
        //System.out.println(eval.toSummaryString("Evalution results:\n",false));

    }

}