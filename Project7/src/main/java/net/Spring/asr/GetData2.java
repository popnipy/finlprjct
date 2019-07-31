package net.Spring.asr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class GetData2 {

    public String results;
    public String dummy;
    int point;
    List<Double> intValueList = new ArrayList<>();
    List<String> dummyList = new ArrayList<>();
    public List getData() {
        String Category = "Beach";
        String Subject = "Scenic";
        List<String> mlist = new ArrayList();
        try {
            @SuppressWarnings("deprecation")
            Mongo m = new Mongo();
            @SuppressWarnings("deprecation")
            DB db = m.getDB("test");
            DBCollection c = db.getCollection("Agg_" + Category);
            long count = c.distinct("Name").size();
            List<String> places = c.distinct("Name");
            BasicDBObject query = new BasicDBObject();
            //query.put("Name", "");
            DBCursor cursor = c.find(query);

            for (int i = 0; i < count; i++) {
                DBObject theObj = cursor.next();
                //BasicDBObject name = new BasicDBObject();
                BasicDBObject obj = (BasicDBObject) theObj.get("Rating");
                // String Name1=name.getString("Name");
                double Name2 = obj.getDouble(Subject);
                System.out.println(places.get(i));
                System.out.println(Name2);
                dummyList.add(places.get(i));
                String adds = places.get(i).toString() + " : " + Name2;
                mlist.add(adds);
                intValueList.add(Name2);
                System.out.println(mlist.get(i));

                //mlist.add(mlist.get(i));

                //json = new Gson().toJson(mlist);

            }



            Double i = Collections.max(intValueList);

            System.out.println(i);
            for(int y=0;y<intValueList.size();y++){
                if(i==intValueList.get(y)){
                    point=y;
                }

            }

            results = mlist.get(point);
            System.out.println(results);
            dummy = dummyList.get(point);
            System.out.println(dummy);

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return mlist;
    }

//	public String resultValue(String )


}