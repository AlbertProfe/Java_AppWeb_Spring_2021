package example8;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {
		
		MongoClientURI connectionString = new MongoClientURI("mongodb+srv://viladoms:1234@clustertest.0h8fd.mongodb.net/test");
		
		MongoClient mongoClient = new MongoClient (connectionString);
		
		MongoDatabase db = mongoClient.getDatabase("city");
		
		MongoCollection<Document> collectionDocs = db.getCollection("authors");
		
		for (Document docToPrint :  collectionDocs.find() )
		
			System.out.println(docToPrint.toJson());
		

	}

}
