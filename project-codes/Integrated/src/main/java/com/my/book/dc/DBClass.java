package com.my.book.dc;

import com.mongodb.*;
import com.my.book.asr.Data_Common;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class DBClass {
    int reviewCount = 1;
   int annotationCount;
    List<String>  bentotaList = new ArrayList<String>();
    DBCollection collection;
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    // Now connect to your databases
    DB db = mongoClient.getDB( "test" );
    public  void main(  ) {
        try{
// To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
// Now connect to your databases
            DB db = mongoClient.getDB( "test" );
            System.out.println("Connect to database successfully");
          DBCollection coll =db.getCollection("nipy");
            coll.save(new BasicDBObject("key" , "value"));

            System.out.println("Collection created successfully");

            BasicDBObject doc = new BasicDBObject("title", "MongoDB").
                    append("description", "database").
                    append("likes", 100).
                    append("url", "http://www.tutorialspoint.com/mongodb/").
                    append("by", "tutorials point");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void insertMongoDocuments(List<String> pli, List<String> cli, String str, int h){
       //  DBClass dbobj = new DBClass();
        BasicDBObject document = new BasicDBObject();
        BasicDBObject document1 = new BasicDBObject();
      //  if(!dbobj.collectionExists("Bentota"));
        if(h==0) {
             collection = db.getCollection("BeachTest1");
        }
        if(h==1) {
            collection = db.getCollection("NaturalTest1");
        }

        for(int i=pli.size()-1;i>=0;i--){
            if(i>2){

                break;
            }
            String  clclass = cli.get(i);
            String phr = pli.get(i);
            int count = pli.size();

            if(cli.get(i).equals(null)){
               System.out.println("DDDFFFFF");
                document1.put("Activity", "");
                document1.put("Scenic", "");

            }

            switch (count) {

               /* case 0: {
                    System.out.println("DDDFFFFF");
                    document1.put("Activity", "");
                    document1.put("Scenic", "");
                    break;
                }*/
                case 1: {
                    if (clclass.equals("activity")) {
                        document1.put("Activity", phr);
                        document1.put("Scenic", "");
                    } else {

                        document1.put("Scenic", phr);
                        document1.put("Activity", "");
                    }
                    break;
                }

                case 2: {
                    String first = cli.get(1);
                    String second =cli.get(0);
                    if(first.equals(second)){
                        if (first.equals("activity")) {
                            document1.put("Activity", phr);
                            document1.put("Scenic", "");
                        }
                        else {

                            document1.put("Activity","");
                            document1.put("Scenic", phr);
                        }


                    }

                    else {

                    if (clclass.equals("activity")) {
                        document1.put("Activity", phr);

                    } else {

                        document1.put("Scenic", phr);

                    }}
                    break;
                }
                case 3: {
                    String first = cli.get(1);
                    String second =cli.get(0);
                    if(first.equals(second)){
                        if (first.equals("activity")) {
                            document1.put("Activity", phr);
                            document1.put("Scenic", "");
                        }
                        else {

                            document1.put("Activity","");
                            document1.put("Scenic", phr);
                        }


                    }

                    else {

                        if (clclass.equals("activity")) {
                            document1.put("Activity", phr);

                        } else {

                            document1.put("Scenic", phr);

                        }}
                    break;
                }
            }




            //document1.put(cli.get(i), pli.get(i));

        }

        int co= pli.size();
        if(co<=2){

            if(document1.isEmpty()){
                document1.put("Activity", "");
                document1.put("Scenic", "");


            }
                if(h==0) {
                    document.append("Type", "Beach");
                    document.append("Name", str);
                    // document.append("ReviewCount",collection.find().count()+1);

                    document.append("Phrases",
                            new BasicDBObject(document1));
       /* collection.update(doc1,new BasicDBObject("$set",doc));*/
                    collection.insert(document);
                }
                if(h==1){

                    document.append("Type", "Nature");
                    document.append("Name", str);
                    // document.append("ReviewCount",collection.find().count()+1);

                    document.append("Phrases",
                            new BasicDBObject(document1));
       /* collection.update(doc1,new BasicDBObject("$set",doc));*/
                    collection.insert(document);

                }
            System.out.println("Success");
            reviewCount++;
        }

        if(h==0){

            Data_Common d = new Data_Common();
            d.common("Beach","Activity","Scenic");

        }
        if(h==1){
            Data_Common d1 = new Data_Common();
            d1.common("Nature","Activity","Scenic");

        }


    }


    public void insertMongoArchitecturalDocuments(List<String> pli, List<String> cli, String str, int h){
        //  DBClass dbobj = new DBClass();
        BasicDBObject document = new BasicDBObject();
        BasicDBObject document1 = new BasicDBObject();
        //  if(!dbobj.collectionExists("Bentota"));

        if (h==2) {
             collection = db.getCollection("ArchitecturalTest1");
        }
        else if (h==3){
             collection = db.getCollection("HistoricatTest1");

        }

      /*  BasicDBObject doc = new BasicDBObject();
        BasicDBObject doc1 = new BasicDBObject("BeachName","Bentota");*/

        for(int i=pli.size()-1;i>=0;i--){
            if(i>2){

                break;
            }
            String  clclass = cli.get(i);
            String phr = pli.get(i);
            int count = pli.size();

            /*if(cli.get(i).equals(null)){
                System.out.println("DDDFFFFF");
                document1.put("Activity", "");
                document1.put("Scenic", "");

            }*/

            switch (count) {

               /* case 0: {
                    System.out.println("DDDFFFFF");
                    document1.put("Activity", "");
                    document1.put("Scenic", "");
                    break;
                }*/
                case 1: {
                    if (clclass.equals("SA")) {
                        document1.put("SA", phr);
                        document1.put("S&L", "");
                    } else {

                        document1.put("S&L", phr);
                        document1.put("SA", "");
                    }
                    break;
                }

                case 2: {
                    String first = cli.get(1);
                    String second =cli.get(0);
                    if(first.equals(second)){
                        if (first.equals("SA")) {
                            document1.put("SA", phr);
                            document1.put("S&L", "");
                        }
                        else {

                            document1.put("SA","");
                            document1.put("S&L", phr);
                        }


                    }

                    else {

                        if (clclass.equals("SA")) {
                            document1.put("SA", phr);

                        } else {

                            document1.put("S&L", phr);

                        }}
                    break;
                }
                default: {


                }
            }
        }

        int co= pli.size();
        if(co<=2){

            if(document1.isEmpty()){
                document1.put("SA", "");
                document1.put("S&L", "");


            }
            if(h==2) {
                document.append("Type", "Architectural");
                document.append("Name", str);
                // document.append("ReviewCount",collection.find().count()+1);

                document.append("Phrases",
                        new BasicDBObject(document1));
       /* collection.update(doc1,new BasicDBObject("$set",doc));*/
                collection.insert(document);
                System.out.println("Success");
                reviewCount++;
            }
            if(h==3){
                document.append("Type", "Historical");
                document.append("Name", str);
                // document.append("ReviewCount",collection.find().count()+1);

                document.append("Phrases",
                        new BasicDBObject(document1));
       /* collection.update(doc1,new BasicDBObject("$set",doc));*/
                collection.insert(document);
                System.out.println("Success");
                reviewCount++;
            }

        }
        if(h==2){
            Data_Common d2 = new Data_Common();
            d2.common("Architectural","SA","S&L");
        }

        if(h==3){
            Data_Common d3 = new Data_Common();
            d3.common("Historical","SA","S&L");

        }



    }





    public boolean gettingFromMongo() throws Exception {

        List<String> reviewLIst = new ArrayList();
        List<String> beachLIst = new ArrayList();
        List<String> architecturalLIst = new ArrayList();
        List<String> historicalLIst = new ArrayList();
        List<String> natuelLIst = new ArrayList();
        List<String> alllLIst = new ArrayList();

        reviewLIst.add("Beach");
        reviewLIst.add("Nature");
        reviewLIst.add("Architectural");
        reviewLIst.add("Historical");


        beachLIst.add("Bentota");
        beachLIst.add("Galle Face");
        beachLIst.add("Mount Lavinia");
        beachLIst.add("Mirissa");
        beachLIst.add("Hikkaduwa");

        architecturalLIst.add("Ruwanwelisaya Dagoba");
        architecturalLIst.add("Polonnaruwa");
        architecturalLIst.add("Galle Fort");
        architecturalLIst.add("Gal Vihara");
        architecturalLIst.add("Bahiravokanda Vihara Buddha Statue");
        natuelLIst.add("Yala National Park");
        natuelLIst.add("World's End");
        natuelLIst.add("Ella Rock");
        natuelLIst.add("Adam's Peak");
        natuelLIst.add("Kandy Lake");
        historicalLIst.add("The Golden Temple");
        historicalLIst.add("Sigiriya Lion Rock");
        historicalLIst.add("Koneswaram Temple");
        historicalLIst.add("Mihintale");
        historicalLIst.add("Temple of the Tooth Sri_Dalada Maligawa");






        alllLIst.addAll(beachLIst);
        alllLIst.addAll(natuelLIst);
        alllLIst.addAll(architecturalLIst);
        alllLIst.addAll(historicalLIst);
        int myCount =5;
        int y=0;
        int gg=0;
        FeatureExtraction mobj = new FeatureExtraction();
        DatatoArff dobj = new DatatoArff();

        for(int h=0;h<4;h++) {

            DBCollection collection = db.getCollection(reviewLIst.get(h));
            BasicDBObject allQuery = new BasicDBObject();
            BasicDBObject fields = new BasicDBObject();
            //BasicDBObject names = new BasicDBObject();



            if(h==0){
                y=0;
                myCount=5;
                        }
              else if(h==1){
                y=5;
                myCount=10;
            }
            else if(h==2){
                y=10;
                myCount=15;
            }
            else if(h==3){
                y=15;
                myCount=20;
            }

            int i = 0;
            List<String> list = new ArrayList();
            for (int x = y; x < myCount; x++) {
              //  System.out.println("WRIUTTTTTing" + beachLIst.get(x));
                allQuery.put("Name", alllLIst.get(x));
                fields.put("Review", 1);
                fields.put("_id", 0);


                DBCursor cursor = collection.find(allQuery, fields);



                while (cursor.hasNext()) {
                    System.out.println("READDDDDing");
                    list.add(cursor.next().toString());
                    //cursor.close();
                    FileWriter writer = new FileWriter("E://finalProject//Beaches//reviewFile//beach.txt");
                    // File f1l = new File("C:\\Users\\Nifras\\Desktop\\ML\\New folder\\outB.txt");
                    String str1 = list.get(i).replace("n't", "");
                    str1.replace("\r\n","");
                    str1.replace("\n","");
                    String str = alllLIst.get(x);
                    writer.write(str1);
                    writer.close();
                    bentotaList = mobj.m();
                    annotationCount = mobj.annotationCount;
                    //  int u=y;
                    if(h==0) {
                        dobj.addAttribute(bentotaList, annotationCount, h, str);

                    }
                     if(h==1) {
                        dobj.addAttribute(bentotaList, annotationCount, h, str);
                         System.out.println("asir");

                    }
                     if(h==2){
                        dobj.addAtributeTwo(bentotaList, annotationCount, h, str);
                         System.out.println("mohamed");
                    }
                    if(h==3){
                        dobj.addAtributeTwo(bentotaList, annotationCount, h, str);
                    }
                    System.out.println("We are now from" + i);
                    System.out.println("AnnotationListCount" + annotationCount);
                    i++;

                }
                cursor.close();

                System.out.println("BEFOREEE");
                System.out.println(alllLIst.get(x));
            }
            System.out.println("AFFFFTTERRR");
        gg++;

        }



       // System.out.println(list.toString());
       /* FileWriter writer = new FileWriter("output1.txt");

        for(String str: list) {
            writer.write(str);
            writer.write("\r\n");
        }
        writer.close();*/

        return true;
    }

   /* public boolean collectionExists(final String collectionName) {
        Set<String> collectionNames = db.getCollectionNames();
        for (final String name : collectionNames) {
            if (name.equalsIgnoreCase(collectionName)) {
                return true;
            }
        }
        return false;
    }
*/

    }
