package net.Spring.asr;

import com.mongodb.*;

import java.util.List;

//import com.mongodb.BasicDBList;
//import java.awt.List;

public class Data_Common {

	public void common (String Type,String sub1,String sub2) {
		String Category = Type;
		@SuppressWarnings("deprecation")
		Mongo m = new Mongo();
		@SuppressWarnings("deprecation")
		DB db = m.getDB("test");
		DBCollection c = db.getCollection(Category+"Test2");
		long count = c.distinct("Name").size();
		// System.out.println(count);
		// DBCursor cursor1 = c.find();
		// BasicDBObject s = new BasicDBObject();
		long sizea = 0;
		DataToarff1 arff = new DataToarff1();
		String[] Actvity = null;
		String[] Entertainment = null;
		Rating rating = new Rating();
		// String[] places=new String[(int) count];
		@SuppressWarnings("rawtypes")
		List places = c.distinct("Name");

		String Subject1 = sub1;
		String Subject2 = sub2;

		DBCollection col = db.getCollection("Rates_" + Category);
		boolean ce = db.collectionExists("Rates_" + Category);
		if (ce == true) {
			BasicDBObject document = new BasicDBObject();
			col.remove(document);

		}

		for (int i = 0; i < count; i++) {
			// System.out.println(places.get(i));
			try {
				BasicDBObject query = new BasicDBObject();
				query.put("Name", places.get(i));
				DBCursor cursor = c.find(query);
				Actvity = new String[cursor.count()];
				Entertainment = new String[cursor.count()];
				sizea = cursor.size();
				// System.out.println(cursor.size());
				for (int j = 0; j < sizea; j++) {
					DBObject theObj = cursor.next();
					// DBObject placeList = (DBObject) theObj.get("Review");
					BasicDBObject obj = (BasicDBObject) theObj.get("Phrases");
					// System.out.println(obj.getString("Activity"));

					Actvity[j] = obj.getString(Subject1);
					Entertainment[j] = obj.getString(Subject2);
					// System.out.println(Actvity[j]);
					// System.out.println(Natural[j]);

				}

			} catch (Exception ex) {
				System.out.println(ex);
			}

			try {
				arff.addData(Actvity, Entertainment, (String) places.get(i), (int) sizea, col, db, Category, Subject1,
						Subject2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		rating.agg(col, db, Category, Subject1, Subject2);
	}

}
