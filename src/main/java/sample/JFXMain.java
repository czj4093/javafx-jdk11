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

/**
 * {
 *  "bookSourceName":"书源名称",
 *  "bookSourceGroup":"书源分组",
 *  "bookSourceUrl":"书源URL",
 *  "loginUrl":"登录URL",
 *  "checkUrl":"检测URL",
 *  "httpUserAgent":"User-Agent",
 *  "ruleFindUrl":"发现规则",
 *  "ruleSearchUrl":"搜索地址",
 *  "ruleSearchList":"搜索结果列表规则",
 *  "ruleSearchName":"搜索结果书名规则",
 *  "ruleSearchAuthor":"搜索结果作者规则",
 *  "ruleSearchCoverUrl":"搜索结果封面规则",
 *  "ruleSearchKind":"搜索结果分类规则",
 *  "ruleSearchLastChapter":"搜索结果最新章节规则",
 *  "ruleSearchNoteUrl":"搜索结果书籍URL规则",
 *  "ruleBookUrlPattern":"书籍详情URL正则",
 *  "ruleBookName":"书名规则",
 *  "ruleBookAuthor":"作者规则",
 *  "ruleCoverUrl":"封面规则",
 *  "ruleBookKind":"分类规则",
 *  "ruleBookLastChapter":"最新章节规则",
 *  "ruleChapterUrl":"目录URL规则",
 *  "ruleChapterUrlNext":"章节列表下一页规则",
 *  "ruleIntroduce":"简介规则",
 *  "ruleChapterList":"目录列表规则",
 *  "ruleChapterName":"章节名规则",
 *  "ruleContentUrl":"章节URL规则",
 *  "ruleContentUrlNext":"正文下一页URL规则",
 *  "ruleBookContent":"正文规则"}
 */
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
