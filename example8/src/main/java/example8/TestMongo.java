package example8;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class TestMongo {

	public static void main(String[] args) {

		// first we create the string connection to connect our Maven project
		// to the cloud MongoDB with
		// user and password generated at cloud and
		// remember to allow your IP
		MongoClientURI connectionString = new MongoClientURI(
				"mongodb+srv://viladoms:1234@clustertest.0h8fd.mongodb.net/test");

		// mongoClient object to handle requests and operations
		MongoClient mongoClient = new MongoClient(connectionString);

		// from mongoClient NOW so far we can work, for example get
		// the "city" db with their collections
		MongoDatabase db = mongoClient.getDatabase("city");

		// from db city we get authors collection of documents (each document is a
		// bson-author)
		MongoCollection<Document> collectionDocs = db.getCollection("authors");

		// just to check what is there ..
		//toPrint(collectionDocs);

		// Create a new document, first the id
		Document author = new Document("_id", new ObjectId());
		// and now we set the document with append
		author.append("name", "Josep").append("surname", "Pla").append("age", 82);
		// after the creation of the bson we insert the doc within the collection
		
		List<Document> booksObjdectJosepPla = new ArrayList<Document>();
		
		
		List<String> booksJosepPla = new ArrayList<String>();
		booksJosepPla.add("Quaden gris");
		booksJosepPla.add("Viatges");
		
		author.append("books",booksJosepPla);
		
		collectionDocs.insertOne(author);

		toPrint(collectionDocs);
		
		
		// another document
		Document author2 = new Document("_id", new ObjectId());
		author2.append("name", "Primo").append("surname", "Levi").append("age", 62).append("country", "Italy").append("me lo invento", 234123);
		collectionDocs.insertOne(author2);
		toPrint(collectionDocs);
		
		//findOneAndDelete
		collectionDocs.findOneAndDelete(author2);
		
		
		//toPrint(collectionDocs);

		mongoClient.close();

	}

	// just a static utility to print the collection
	public static void toPrint(MongoCollection<Document> collectionDocs) {

		for (Document docToPrint : collectionDocs.find()) {
			System.out.println(docToPrint.toJson());
		}

	}

}
