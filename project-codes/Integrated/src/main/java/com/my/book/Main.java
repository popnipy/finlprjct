package com.my.book;

import com.my.book.dc.DBClass;
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

import gate.Annotation;
import gate.Document;

//import javax.xml.stream.XMLStreamException;

import static gate.Utils.stringFor;

public class Main  {



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


    /**
     * Run from the command-line, with a list of URLs as argument.
     * <P>
     * <B>NOTE:</B><BR>
     * This code will run with all the documents in memory - if you want to
     * unload each from memory after use, add code to store the corpus in a
     * DataStore.
     */
    public static void main(String args[]) throws Exception {
/*
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


        URL u = new URL("file:C:\\Users\\Nifras\\Documents\\EGDownloads\\gate-nlp\\Tutorial\\Tutorial\\Examples\\Example1\\new11.txt");
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



        Document persistentDoc = myDataStore.adopt(doc, mySecurity);
        myDataStore.sync(persistentDoc);

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


            AnnotationSet persSet = defaultAnnotSet1.get("BeachPhrases");
            List persList = new ArrayList(persSet);
            Collections.sort(persList, new  gate.util.OffsetComparator());
           // Annotation personAnn= (Annotation) doc.getAnnotations("BeachPhrases");
          Set<Annotation>  personAnn1= new HashSet<>(defaultAnnotSet.get("BeachPhrases"));
            Set<Annotation> personAnn = personAnn1;
            Iterator tokIter = personAnn.iterator();
            String text = "";
            while(tokIter.hasNext())
                text += (String)((Annotation)tokIter.next()).toString();
            stringFor(doc,)


            String  personStr = doc.getContent().getContent(
                    personAnn.getStartNode().getOffset(),
                    personAnn.getEndNode().getOffset()).toString();
                // System.out.println(content);
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
                List<String> li = new ArrayList();
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
                int annotationCount=sortedAnnotations.size();

              //  CSVUTILLSXAMPLE.getM(li);

                List<String> nm = new ArrayList();
                for(int y=0;y<li.size();y++){

                    String ff=("'"+li.get(y)+"',?");
                    nm.add(ff);
                }
               // Collections.reverse(li);
               // arff.addAttribute(Name,review,phrase,li,Natural,annotationCount);
                Cl bb = new Cl();
               // bb.m(sortedAnnotations.size(),li);
                RemoveDAta n = new RemoveDAta();
               // n.removeStrings(nm);

              MongoDBJDBC m = new MongoDBJDBC();
                m.gettingFromMongo();

                ReadFiles r = new ReadFiles();
               // r.reads(m.list);
      ABC a = new ABC();
               // a.abc();

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







          String fileName1 = new String("my.txt");
          HashSet mySet = new HashSet();
            FileWriter myWriter ;



           mySet.add(peopleAndPlaces);
            try{
                myWriter = new FileWriter(fileName1,true);
                myWriter.write(String.valueOf(mySet));
                myWriter.close();
            }
            catch (Exception e){

            }
*/
            DBClass b= new DBClass();
            b.gettingFromMongo();


/*
            File outputFile = new File("new.gate.xml");
            DocumentStaxUtils.writeDocument(doc, outputFile);






             //String f = doc.toString(peopleAndPlaces,false);
            String xmlDocument = doc.toXml(peopleAndPlaces, false);
            String fileName = new String("StANNIE_toXML_" + count + ".HTML");
            FileWriter writer = new FileWriter(fileName);
            writer.write(xmlDocument);
            //Writer.writer(peopleAndPlaces);
            writer.close();
            System.out.println("ooooooooooooooooooooooooooooooooooooooo");
            System.out.println(doc.getSourceUrl());*/
            //System.out.print(doc);
        } // for each doc





        // main
























































































































/*


    private static org.apache.log4j.Logger log = Logger.getLogger(Gate.class);
    public static void main(String[] args) throws Exception{
        if(Gate.getGateHome() == null)
            Gate.setGateHome(new File("C:/Program Files/GATE_Developer_8.2"));
        if(Gate.getPluginsHome() == null)
            Gate.setPluginsHome(new File("C:/Program Files/GATE_Developer_8.2/plugins"));

        Gate.init();
        SwingUtilities.invokeAndWait(new Runnable() {
 public void run() {
        MainFrame.getInstance().setVisible(true);
     FeatureMap params = Factory.newFeatureMap();
     try {
         params.put(Document.DOCUMENT_URL_PARAMETER_NAME,
                  new URL("http://stackoverflow.com/questions/28313692/gate-dgate-plugins-home-option-in-your-start-up-script"));
         params.put(Document.DOCUMENT_ENCODING_PARAMETER_NAME,
                  "UTF-8");
     } catch (MalformedURLException e) {
         e.printStackTrace();
     }

     FeatureMap feats = Factory.newFeatureMap();
     feats.put("createdBy", "me!");
     feats.put("date", new Date());
     try {
         Factory.createResource("gate.corpora.DocumentImpl",params, feats, "My first document");


         Document doc = null;
         try {
             doc = Factory.newDocument(new URL("http://stackoverflow.com/questions/28313692/gate-dgate-plugins-home-option-in-your-start-up-script"), "UTF-8");
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }

         Map<String, AnnotationSet> namedASes =doc.getNamedAnnotationSets();
         System.out.println("No. of named Annotation Sets:" + namedASes.size());

         for (String setName : namedASes.keySet()) {
             AnnotationSet aSet = namedASes.get(setName);
             System.out.println("No. of Annotations for " + setName + ":" + aSet.size());

             Set<String> annotTypes = aSet.getAllTypes();


             for(String aType : annotTypes) {

                 System.out.println(" " + aType + ": " + aSet.get(aType).size());

             }
         }

       //obtain the Original markups annotation set
         AnnotationSet origMarkupsSet = doc.getAnnotations("Original markups");
         //obtain annotations of type ’a’
         AnnotationSet anchorSet = origMarkupsSet.get("a");
         //iterate over each annotation
         //obtain its features and print the value of href feature
         for (Annotation anchor : anchorSet) {
             String href = (String) anchor.getFeatures().get("href");
             if(href != null) {
                 try {
                     // resolving href value against the document&rsquo;s url
                     System.out.println(new URL(doc.getSourceUrl(), href));
                 } catch (MalformedURLException e) {
                     e.printStackTrace();
                 }
             }
             }

/////////////////////////////////////////////////////////////////////////////////////////

             // get the root plugins dir

         File pluginsDir = Gate.getPluginsHome();
      // Let’s load the ANNIE plugin
         File aPluginDir = new File(pluginsDir, "ANNIE");
      // load the plugin.
         try {
             Gate.getCreoleRegister().registerDirectories(aPluginDir.toURI().toURL());
             // create tokenizer
             LanguageAnalyser pr = (LanguageAnalyser)Factory.createResource("gate.creole.tokeniser.DefaultTokeniser");
             // create serialAnalyzerController
             SerialAnalyserController controller = (SerialAnalyserController) Factory.createResource("gate.creole.SerialAnalyserController");
             // add pr to the corpus
             controller.add(pr);


             //create a corpus
             Corpus corpus = Factory.newCorpus("corpus");
             corpus.add(doc); // add document to the corpus
             controller.setCorpus(corpus); // set corpus
             controller.execute(); // execute the corpus
         } catch (GateException e) {
             e.printStackTrace();
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }

     } catch (ResourceInstantiationException e) {
         e.printStackTrace();
     }
System.out.print("helll");
    }});
}}
*/


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
    }
