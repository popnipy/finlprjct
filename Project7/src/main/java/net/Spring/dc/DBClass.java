package net.Spring.dc;

import com.mongodb.*;
import net.Spring.asr.Data_Common;
//import com.my.book.asr.Data_Common;

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

    public void insertMongoDocuments(List<String> pli, List<String> cli, String str){
       //  DBClass dbobj = new DBClass();
        BasicDBObject document = new BasicDBObject();
        BasicDBObject document1 = new BasicDBObject();
      //  if(!dbobj.collectionExists("Bentota"));

             collection = db.getCollection("BeachTest2");


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

                    document.append("Type", "Beach");
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

          // Data_Common dd = new Data_Common();







    public boolean gettingFromMongo() throws Exception {

        List<String> reviewLIst = new ArrayList();
        List<String> beachLIst = new ArrayList();
        List<String> architecturalLIst = new ArrayList();
        List<String> historicalLIst = new ArrayList();
        List<String> natuelLIst = new ArrayList();
        List<String> alllLIst = new ArrayList();

        reviewLIst.add("Beach");



        beachLIst.add("Bentota");
        beachLIst.add("Galle Face");
        beachLIst.add("Mount Lavinia");
        beachLIst.add("Mirissa");
        beachLIst.add("Hikkaduwa");






        alllLIst.addAll(beachLIst);
        alllLIst.addAll(natuelLIst);
        alllLIst.addAll(architecturalLIst);
        alllLIst.addAll(historicalLIst);
        int myCount =5;
        int y=0;
        int gg=0;
        FeatureExtraction mobj = new FeatureExtraction();
        DatatoArff dobj = new DatatoArff();



            DBCollection collection = db.getCollection("Beach");
            BasicDBObject allQuery = new BasicDBObject();
            BasicDBObject fields = new BasicDBObject();
            //BasicDBObject names = new BasicDBObject();




            int i = 0;
            List<String> list = new ArrayList();
            for (int x = y; x < myCount; x++) {
              //  System.out.println("WRIUTTTTTing" + beachLIst.get(x));
                allQuery.put("Name", beachLIst.get(x));
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
                    String str = beachLIst.get(x);
                    writer.write(str1);
                    writer.close();
                    bentotaList = mobj.m();
                    annotationCount = mobj.annotationCount;
                    //  int u=y;

                        dobj.addAttribute(bentotaList, annotationCount,str);



                    i++;

                }
                cursor.close();

                System.out.println("BEFOREEE");
                System.out.println(alllLIst.get(x));
            }
            System.out.println("AFFFFTTERRR");


        gg++;





       // System.out.println(list.toString());
       /* FileWriter writer = new FileWriter("output1.txt");

        for(String str: list) {
            writer.write(str);
            writer.write("\r\n");
        }
        writer.close();*/
        Data_Common d = new Data_Common();
        d.common("Beach","Activity","Scenic");
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
