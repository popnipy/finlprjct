package net.Spring.asr;

//import java.util.ArrayList;
//import java.util.List;

import com.mongodb.*;

public class Rating {

	public void agg(DBCollection col, DB db, String Category, String Subject1, String Subject2) {
		// DBCursor cursor1 = col.find();
		double[] Actvity = null;
		double[] Scenic = null;
		int rowcount = 0;
		// double A=0;
		// double B=0;
		// ouble sum_actvity=0;
		// double sum_natural=0;
		long a = col.count();
		String[] places = new String[(int) a];
		DBCursor cursor1 = col.find();
		BasicDBList placeList = null;
		DBCollection agg = db.getCollection("Agg_" + Category);

		boolean ce = db.collectionExists("Agg_" + Category);
		// System.out.println("Asir");
		if (ce == true) {
			// System.out.println("Asir");
			BasicDBObject document = new BasicDBObject();
			agg.remove(document);

		}

		for (int j = 0; j < a; j++) {
			BasicDBObject obj = (BasicDBObject) cursor1.next();
			places[j] = obj.getString("Name");
			try {
				BasicDBObject query = new BasicDBObject();
				query.put("Name", places[j]);
				DBCursor cursor = col.find(query);
				while (cursor.hasNext()) {
					DBObject theObj = cursor.next();
					placeList = (BasicDBList) theObj.get("Review");
					rowcount = placeList.size();

					Actvity = new double[placeList.size()];
					Scenic = new double[placeList.size()];

				}
				for (int i = 0; i < rowcount; i++) {

					BasicDBObject placeObj = (BasicDBObject) placeList.get(i);

					Actvity[i] = placeObj.getDouble(Subject1);
					Scenic[i] = placeObj.getDouble(Subject2);

					// System.out.println(Natural[i]);
					// System.out.println(Actvity[i]);

				}

			}

			catch (Exception ex) {
				System.out.println(ex);

			}
			double sum_actvity = 0;
			double sum_Scenic = 0;

			for (int n = 0; n < rowcount; n++) {

				sum_actvity += Actvity[n];
				sum_Scenic += Scenic[n];

			}
			try {

				double agg_actvity = sum_actvity / rowcount;
				double agg_Scenic = sum_Scenic / rowcount;

				System.out.println(places[j]);
				System.out.println(Subject1 + " : " + " " + agg_actvity);
				System.out.println(Subject2 + ":  " + " " + agg_Scenic);
				BasicDBObject ab = new BasicDBObject();
				db.getCollection("Agg_" + Category).createIndex(new BasicDBObject("Name", 1),
						new BasicDBObject("unique", true));
				ab.put("Category", Category);
				ab.put("Name", places[j]);
				// List<DBObject> documents = new ArrayList<DBObject>();
				DBObject cj = new BasicDBObject();
				cj.put(Subject1, agg_actvity);
				cj.put(Subject2, agg_Scenic);
				// ab.put(cj);
				ab.put("Rating", cj);
				agg.insert(ab);

			}

			catch (Exception ex) {
				System.out.println(ex);
			}

			/*
			 * System.out.println(places[j]); System.out.println("Actvity"+""+
			 * A/rowcount); System.out.println("Natural"+""+ B/rowcount);
			 */

		}

	}

}