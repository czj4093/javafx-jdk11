package sample;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Stage;
import org.bson.Document;

import java.util.function.Consumer;

public class JFXMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        JSONObject fieldConfig = JSON.parseObject(getClass().getResourceAsStream("/fieldConfig.json"), JSONObject.class);
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("hbck");
        MongoCollection<Document> collection = mongoDatabase.getCollection("bookSource");
        FindIterable<Document> documents = collection.find();
        TreeItem<String> rootItem = new TreeItem<>();
        rootItem.setExpanded(true);
        documents.forEach((Consumer<? super Document>) d -> {
            Label label1 = new Label(d.getString("bookSourceName"));
            TreeItem<String> treeItem1 = new TreeItem<>(d.getString("bookSourceName"), label1);
            rootItem.getChildren().add(treeItem1);
            d.forEach((k, v) -> {
                if (!k.equals("_id")) {
                    treeItem1.getChildren().add(new TreeItem<>(v.toString(), new Label(fieldConfig.getString(k))));
                }
            });
        });
        TreeView<String> treeView = new TreeView<>(rootItem);
        primaryStage.setTitle("书源");
        primaryStage.setScene(new Scene(treeView, 500, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
