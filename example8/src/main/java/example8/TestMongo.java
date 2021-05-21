package example8;

import org.bson.Document;
import org.bson.types.ObjectId;

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
		
		for (Document docToPrint :  collectionDocs.find()) {
		
			System.out.println(docToPrint.toJson());
		}
		
		
		//Create a new document
		
		Document author = new Document("_id", new ObjectId());
		
		author.append("name", "Josep").append("surname" ,"Pla").append("age", 82);
		
		collectionDocs.insertOne(author);
		
		for (Document docToPrint :  collectionDocs.find()) {
			
			System.out.println(docToPrint.toJson());
		}
		
		Document author2 = new Document("_id", new ObjectId());
		
		author2.append("name", "Primo").append("surname" ,"Levi").append("age", 62).append("country", "Italy");
		
		collectionDocs.insertOne(author2);
		
		//mongoClient.close();

	}

}
