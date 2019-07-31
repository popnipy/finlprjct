package com.my.book;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.StreamHandler;

import static com.mongodb.client.model.Projections.excludeId;

public class MongoDBJDBC {
    int reviewCount = 1;
   int annotationCount;
    List<String>  bentotaList = new ArrayList<String>();

    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    // Now connect to your databases
    DB db = mongoClient.getDB( "test" );
    public static void main( String args[] ) {
        try{
// To connect to mongodb server
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
// Now connect to your databases
            DB db = mongoClient.getDB( "test" );
            System.out.println("Connect to database successfully");
          DBCollection coll =db.getCollection("nipy");
            coll.save(new BasicDBObject("key" , "value"));

            System.out.println("Collection created successfully");
           // boolean auth = db.authenticate(myUserName, myPassword);
         //   System.out.println("Authentication: "+auth);

            BasicDBObject doc = new BasicDBObject("title", "MongoDB").
                    append("description", "database").
                    append("likes", 100).
                    append("url", "http://www.tutorialspoint.com/mongodb/").
                    append("by", "tutorials point");
          //  coll.insert(doc);
            //System.out.println("Document inserted successfully");

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void insertMongoDocuments(List<String> pli, List<String> cli){

        DBCollection collection = db.getCollection("beaches");
       // collection.drop();
        BasicDBObject document = new BasicDBObject();
        BasicDBObject document1 = new BasicDBObject();

        for(int i=pli.size()-1;i>=0;i--){

            document1.put(cli.get(i), pli.get(i));

        }
        document.append("ReviewCount",reviewCount);
         document.append("Type","Beach");
        document.append("BeachName","Bentota");
         document.append("Phrases",
                new BasicDBObject(document1));
        collection.insert(document);
        System.out.println("Success");
      reviewCount++;
    }

    public void gettingFromMongo() throws Exception {

        DBCollection collection = db.getCollection("Beach");
        BasicDBObject document = new BasicDBObject();
       // DBCursor cursor = collection.find({Name:Bentota},{Review:1,Name:0,Type:0,id:0});
      //  FindIterable it = collection.find().projection(excludeId());
        BasicDBObject allQuery = new BasicDBObject();
        BasicDBObject fields = new BasicDBObject();
        allQuery.put("Name", "Bentota");
        fields.put("Review", 1);
        fields.put("_id", 0);
       // fields.put("Name", 0);
        //fields.put("Name", "Bentota");

        DBCursor cursor = collection.find(allQuery, fields);
       // DBCursor c = collection.find
Test mobj = new Test();
DatatoArff dobj = new DatatoArff();
        List<String>  list = new ArrayList();
        int i =0;
        while (cursor.hasNext()) {

            list.add(cursor.next().toString());

            FileWriter writer = new FileWriter("outputA.txt");
            writer.write(list.get(i));
            writer.close();
            bentotaList= mobj.m();
            annotationCount = mobj.annotationCount;
            dobj.addAttribute(bentotaList,annotationCount);

            System.out.println("We are now from" + i);
            System.out.println("AnnotationListCount" + annotationCount);
           i++;

        }
       // System.out.println(list.toString());
        FileWriter writer = new FileWriter("output1.txt");

       /* writer.write(list.get(1));
        list.remove(1);*/
        for(String str: list) {
            writer.write(str);
            writer.write("\r\n");
        }
        writer.close();
      //  MongoDBJDBC mo = new MongoDBJDBC();
     //   mo.reads(list);
    }


   /* public void reads(List li) throws IOException {

        File tmp = File.createTempFile("tmp", "");

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.text"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
        int o = li.size()-1;
        for(int i=0;i<o;i++){
            bw.write(String.format("%s%n", br.readLine()));

        }
        br.close();
        bw.close();
        File oldFile = new File("C:\\Users\\Nifras\\IdeaProjects\\MongoDBJDBC\\output1.text");
        if (oldFile.delete())
            tmp.renameTo(oldFile);


    }
*/




    }
