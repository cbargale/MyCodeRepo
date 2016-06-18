import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.ReplaceOneModel;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.exists;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.lte;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Sorts.descending;

public class MongoDBJDBC{
   
   public static void main( String args[] ){

        MongoClient mongoClient;

        if (args.length == 0) {
            // connect to the local database server
            mongoClient = new MongoClient();
        } else {
            mongoClient = new MongoClient(new MongoClientURI(args[0]));
        }

        // get handle to "mydb" database
        MongoDatabase database = mongoClient.getDatabase("trail_db");

        // get a handle to the collection
        MongoCollection<Document> collection = database.getCollection("sfWindows_team");

        // make a document and insert it
        Document doc = new Document("name", "Nilesh")
                       .append("Role", "QA")
                       .append("Project", "OF");

        collection.insertOne(doc);

        // get it (since it's the only one in there since we dropped the rest earlier on)
        //Document myDoc = collection.find().first();
        //System.out.println(myDoc.toJson());

        // now, lets add lots of little documents to the collection so we can explore queries and cursors
        //List<Document> documents = new ArrayList<Document>();
        //for (int i = 0; i < 100; i++) {
        //    documents.add(new Document("i", i));
        //}
        //collection.insertMany(documents);
        //System.out.println("total # of documents after inserting 100 small ones (should be 101) " + collection.count());

        // find first
        //myDoc = collection.find().first();
        //System.out.println(myDoc.toJson());

        // lets get all the documents in the collection and print them out
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        for (Document cur : collection.find()) {
            System.out.println(cur.toJson());
        }

        System.out.println("---------------------");

        // now use a query to get 1 document out
        Document myDoc = collection.find(eq("name", "Nilesh")).first();
        System.out.println(myDoc.toJson());

        // release resources
        mongoClient.close();

   }
}
