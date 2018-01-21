package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
public class DsSV extends Application {
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MuhScene.fxml"));
	        primaryStage.setTitle("Danh Sach Sinh Vien");
	        primaryStage.setScene(new Scene(root));
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public ObservableList<Person> getPersonData() {
		return personData;
	}
	public static void main(String[] args) {
		launch(args);
	}
}