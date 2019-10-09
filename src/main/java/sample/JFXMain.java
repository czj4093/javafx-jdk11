package sample;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.function.Consumer;

public class JFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("hbck");
        MongoCollection<Document> collection = mongoDatabase.getCollection("bookSource");
        FindIterable<Document> documents = collection.find();
        VBox vBox = new VBox();
        documents.forEach((Consumer<? super Document>) d -> {
            Label label = new Label("bookSourceName1");
            TreeItem<String> rootItem = new TreeItem<>(d.getString("bookSourceName"), label);
            d.forEach((k, v) -> rootItem.getChildren().add(new TreeItem<String>(v.toString(), new Label(k))));
            TreeView<String> treeView = new TreeView<>(rootItem);
            System.out.println("treeView height "+treeView.getHeight());
            vBox.getChildren().add(treeView);
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(vBox, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
