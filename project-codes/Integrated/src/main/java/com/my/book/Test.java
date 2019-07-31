package com.my.book;

import gate.*;
import gate.corpora.RepositioningInfo;
import gate.creole.SerialAnalyserController;
import gate.util.GateException;
import gate.util.Out;
import gate.util.persistence.PersistenceManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static gate.Utils.stringFor;
import gate.*;
import gate.Annotation;
import gate.Document;
import gate.corpora.DocumentStaxUtils;
import gate.corpora.RepositioningInfo;
import gate.creole.SerialAnalyserController;
import gate.persist.SerialDataStore;
import gate.util.GateException;
import gate.util.GateRuntimeException;
import gate.util.InvalidOffsetException;
import gate.util.Out;
import gate.util.persistence.PersistenceManager;

//import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.*;
import java.util.*;

import static gate.Utils.stringFor;

public class Test  {

    int annotationCount;
    List<String> li = new ArrayList();
    private static  String docXMLString = null;

    private CorpusController annieController;

    public void initAnnie() throws GateException, IOException {
        Out.prln("Initialising ANNIE...");

        // load the ANNIE application from the saved state in plugins/ANNIE
        File pluginsHome = Gate.getPluginsHome();
        File anniePlugin = new File(pluginsHome, "ANNIE");
        File annieGapp = new File(anniePlugin, "ANNIE_with_defaults.gapp");
        annieController = (CorpusController) PersistenceManager
                .loadObjectFromFile(annieGapp);

        Out.prln("...ANNIE loaded");
    } // initAnnie()

    /** Tell ANNIE's controller about the corpus you want to run on */
    public void setCorpus(Corpus corpus) {
        annieController.setCorpus(corpus);
    } // setCorpus


    /** Run ANNIE */
    public void execute() throws GateException {
        Out.prln("Running ANNIE...");
        annieController.execute();
        Out.prln("...ANNIE complete");
    } // execute()

    public List m() throws Exception {
// initialise the GATE library
        Out.prln("Initialising GATE...");
        Gate.init();
        Out.prln("...GATE initialised");
// load ANNIE plugin - you must do this before you can create tokeniser
// or JAPE transducer resources.
        Gate.getCreoleRegister().registerDirectories(
                new File(Gate.getPluginsHome(), "ANNIE").toURI().toURL());





        DatatoArff arff = new DatatoArff();
        String Name="Galle Face";
        String phrase="clean";
        String Natural="Beautiful";



        // Build the pipeline
        SerialAnalyserController pipeline =
                (SerialAnalyserController) Factory.createResource(
                        "gate.creole.SerialAnalyserController");
        LanguageAnalyser tokeniser = (LanguageAnalyser)Factory.createResource(
                "gate.creole.tokeniser.DefaultTokeniser");

        LanguageAnalyser gazetter = (LanguageAnalyser)Factory.createResource(
                "gate.creole.gazetteer.DefaultGazetteer");
        LanguageAnalyser pos = (LanguageAnalyser)Factory.createResource(
                "gate.creole.POSTagger");
        LanguageAnalyser splitter = (LanguageAnalyser)Factory.createResource(
                "gate.creole.splitter.SentenceSplitter");
        LanguageAnalyser jape = (LanguageAnalyser)Factory.createResource(
                "gate.creole.Transducer", Utils.featureMap(
                        "grammarURL", new
                                File("C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\new 2.jape").toURI().toURL(),
                        "encoding", "UTF-8")); // ensure this matches the file
        pipeline.add(tokeniser);
        pipeline.add(splitter);
        pipeline.add(pos);
        pipeline.add(gazetter);

        pipeline.add(jape);


        Corpus corpus = Factory.newCorpus("JAPE corpus");

        //Corpus corpus = gate.Factory.newCorpus(null);
        // Document doc = gate.Factory.newDocument("Who is author of Inception");


        URL u = new URL("file:C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\outputA.txt");
        FeatureMap params = Factory.newFeatureMap();
        params.put("sourceUrl", u);
        params.put("preserveOriginalContent", new Boolean(true));
        params.put("collectRepositioningInfo", new Boolean(true));
        Out.prln("Creating doc for " + u);
        Document doc = (Document)
                Factory.createResource("gate.corpora.DocumentImpl", params);
        corpus.add(doc);
        pipeline.setCorpus(corpus);


        File newFile = new File(String.valueOf(u));


        // run it
        pipeline.execute();




// extract results
        System.out.println("Found annotations of the following types: " +
                doc.getAnnotations().getAllTypes());



        Iterator iter = corpus.iterator();
        int count = 0;
        String startTagPart_1 = "<span GateID=\"";
        String startTagPart_2 = "\" title=\"";
        String startTagPart_3 = "\" style=\"background:Red;\">";
        String endTag = "</span>";


        while(iter.hasNext()) {
            doc = (Document) iter.next();
            AnnotationSet defaultAnnotSet = doc.getAnnotations();
            AnnotationSet defaultAnnotSet1 = doc.getAnnotations();
            Set annotTypesRequired = new HashSet();
            annotTypesRequired.add("Person");
            annotTypesRequired.add("Sport");
            annotTypesRequired.add("City");
            annotTypesRequired.add("location");
            annotTypesRequired.add("Waves");
            annotTypesRequired.add("Test");
            annotTypesRequired.add("BeachPhrases");
            annotTypesRequired.add("SubjectivePhrases");
            annotTypesRequired.add("ThingOfQualityPhrases");
            AnnotationSet f = defaultAnnotSet.get("BeachPhrases");
            Set<Annotation> peopleAndPlaces =
                    new HashSet<Annotation>(defaultAnnotSet.get(annotTypesRequired));
            System.out.println(defaultAnnotSet.get(String.valueOf(f.toArray())));
            System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyy");

            System.out.println(annotTypesRequired.add("SubjectivePhrases"));


            AnnotationSet persSet =defaultAnnotSet.get("BeachPhrases");

            ArrayList persList = new ArrayList(persSet);
            Collections.sort(persList, new  gate.util.OffsetComparator());



//Iterate
            Iterator  persIter = persList.iterator();
            while(persIter.hasNext()){
                Annotation temp=(Annotation)persIter.next();
//                String  nameOfAnnotation=temp.getType();
//      annotationSets.add(doc.getAnnotations((String)persIter.next()));
                String content = stringFor(doc, temp);
            }



            FeatureMap features = doc.getFeatures();
            String originalContent = (String)
                    features.get(GateConstants.ORIGINAL_DOCUMENT_CONTENT_FEATURE_NAME);
            RepositioningInfo info = (RepositioningInfo)
                    features.get(GateConstants.DOCUMENT_REPOSITIONING_INFO_FEATURE_NAME);


            ++count;
            File file = new File("StANNIE_" + count + ".HTML");
            Out.prln("File name: '"+file.getAbsolutePath()+"'");
            if(originalContent != null && info != null) {
                Out.prln("OrigContent and reposInfo existing. Generate file...");

                Iterator it = peopleAndPlaces.iterator();
                Annotation currAnnot;
                SortedAnnotationList sortedAnnotations = new SortedAnnotationList();

                while(it.hasNext()) {
                    currAnnot = (Annotation) it.next();
                    sortedAnnotations.addSortedExclusive(currAnnot);
                } // while

                StringBuffer editableContent = new StringBuffer(originalContent);
                long insertPositionEnd;
                long insertPositionStart;
                // insert anotation tags backward
                Out.prln("Unsorted annotations count: "+peopleAndPlaces.size());
                Out.prln("Sorted annotations count: "+sortedAnnotations.size());
                for(int i=sortedAnnotations.size()-1; i>=0; --i) {
                    currAnnot = (Annotation) sortedAnnotations.get(i);
                    insertPositionStart =
                            currAnnot.getStartNode().getOffset().longValue();
                    insertPositionStart = info.getOriginalPos(insertPositionStart);
                    insertPositionEnd = currAnnot.getEndNode().getOffset().longValue();
                    insertPositionEnd = info.getOriginalPos(insertPositionEnd, true);
                    if(insertPositionEnd != -1 && insertPositionStart != -1) {
                        editableContent.insert((int)insertPositionEnd, endTag);
                        editableContent.insert((int)insertPositionStart, startTagPart_3);
                        editableContent.insert((int)insertPositionStart,
                                currAnnot.getType());
                        editableContent.insert((int)insertPositionStart, startTagPart_2);
                        editableContent.insert((int)insertPositionStart,
                                currAnnot.getId().toString());
                        editableContent.insert((int)insertPositionStart, startTagPart_1);
                    } // if
                } // for

                FileWriter writer = new FileWriter(file);
                writer.write(editableContent.toString());
                writer.close();
            } // if - should generate
            else if (originalContent != null) {
                Out.prln("OrigContent existing. Generate file...");

                Iterator it = peopleAndPlaces.iterator();
                Annotation currAnnot, myAnnots;
                SortedAnnotationList sortedAnnotations = new SortedAnnotationList();

                while(it.hasNext()) {
                    currAnnot = (Annotation) it.next();
                    sortedAnnotations.addSortedExclusive(currAnnot);
                } // while

                StringBuffer editableContent = new StringBuffer(originalContent);


                long insertPositionEnd;
                long insertPositionStart;
                // insert anotation tags backward
                Iterator its = sortedAnnotations.iterator();

                int review =1;
                while(its.hasNext()){
                    Annotation temp=(Annotation) its.next();
                    String content = stringFor(doc, temp);
                    li.add(content);
                    // System.out.println("scenic,'"+content+"'");
                    //System.out.println("ggg");
                    // String Scenic = content;
                    // arff.addAttribute(Name,review,phrase,Scenic,Natural);

                    review++;
                }
                 annotationCount=sortedAnnotations.size();

                //  CSVUTILLSXAMPLE.getM(li);

                List<String> nm = new ArrayList();
                for(int y=0;y<li.size();y++){

                    String ff=("'"+li.get(y)+"',?");
                    nm.add(ff);
                }

                Out.prln("Unsorted annotations count:ee "+peopleAndPlaces.size());
                Out.prln("Sorted annotations count: "+sortedAnnotations.size());
                for(int i=sortedAnnotations.size()-1; i>=0; --i) {
                    currAnnot = (Annotation) sortedAnnotations.get(i);
                    insertPositionStart =
                            currAnnot.getStartNode().getOffset().longValue();
                    insertPositionEnd = currAnnot.getEndNode().getOffset().longValue();
                    if(insertPositionEnd != -1 && insertPositionStart != -1) {
                        editableContent.insert((int)insertPositionEnd, endTag);
                        editableContent.insert((int)insertPositionStart, startTagPart_3);
                        editableContent.insert((int)insertPositionStart,
                                currAnnot.getType());
                        editableContent.insert((int)insertPositionStart, startTagPart_2);
                        editableContent.insert((int)insertPositionStart,
                                currAnnot.getId().toString());
                        editableContent.insert((int)insertPositionStart, startTagPart_1);
                    } // if
                } // for

                FileWriter writer = new FileWriter(file);
                writer.write(editableContent.toString());
                writer.close();
            }
            else {
                Out.prln("Content : "+originalContent);
                Out.prln("Repositioning: "+info);
            }

            //System.out.print(doc);
        } // for each doc



        class  SortedAnnotationList extends Vector
        {
            public SortedAnnotationList() {
                super();
            } // SortedAnnotationList
            public boolean addSortedExclusive(Annotation annot) {
                Annotation currAnot = null;

                // overlapping check
                for (int i=0; i<size(); ++i) {
                    currAnot = (Annotation) get(i);
                    if(annot.overlaps(currAnot)) {
                        return false;
                    } // if
                } // for
                long annotStart = annot.getStartNode().getOffset().longValue();
                long currStart;
                // insert
                for (int i=0; i < size(); ++i) {
                    currAnot = (Annotation) get(i);
                    currStart = currAnot.getStartNode().getOffset().longValue();
                    if(annotStart < currStart) {
                        insertElementAt(annot, i);
          /*
           Out.prln("Insert start: "+annotStart+" at position: "+i+" size="+size());
           Out.prln("Current start: "+currStart);
           */
                        return true;
                    } // if
                } // for

                int size = size();
                insertElementAt(annot, size);
//Out.prln("Insert start: "+annotStart+" at size position: "+size);
                return true;
            } // addSorted
        } // SortedAnnotationList
    return li;
    }}
