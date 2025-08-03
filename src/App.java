
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App  {
    public static void main(String[] args) {
        String connectionString = "mongodb+srv://aditisharma9104:KcNpBigIedQ6fnke@cluster0.ueepypg.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("uniconnect");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");

        // insert some records to insert
        MongoCollection<Document> collection = database.getCollection("users");
                  Document user1 = new Document("name", "John Doe")
                        .append("email", "john.doe@example.com")
                        .append("age", 30);
                Document user2 = new Document("name", "Jane Smith")
                        .append("email", "jane.smith@example.com")
                        .append("age", 25);
                Document user3 = new Document("name", "Paridhi Paliwal")
                        .append("email", "paridhi.paliwal.cs28@iilm.edu")
                        .append("age", 19);
                Document user4 = new Document("name", "Aditi Sharma")
                        .append("email", "adit.sharma.cs28@iilm.edu")
                        .append("age", 20);
                Document user5 = new Document("name", "Geetanshi Singh")
                        .append("email", "aditi.sharma.cs28@iilm.edu")
                        .append("age", 18);

                collection.insertOne(user1);
                collection.insertOne(user2); 
                collection.insertOne(user3);
                collection.insertOne(user4);    
                
                System.out.println("Records inserted successfully.");


            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
}

