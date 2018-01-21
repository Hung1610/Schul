package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SvArray  implements Initializable {
	@FXML
	private ListView<String> NameTable;
	@FXML
	private Label DTBLabel;
	@FXML
	private Label XLLabel;
	@FXML
	private Label KQLabel;
	@FXML
	private TextField NameField;
	@FXML
	private Label dauText;
	@FXML
	private Label rotText;
	@FXML
	private Label TBCLabel;
	@FXML
	private ObservableList<Person> personData = FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		NumberFormat formatter = new DecimalFormat("#0.00"); 
		try {
			FileReader f= new FileReader("sv.txt");
			BufferedReader r= new BufferedReader(f);
			while(true) {
				String st=r.readLine();
				if(st==""||st==null) break;
				String[] ds=st.split("[;]");
				personData.add(new Person(ds[1],Double.parseDouble(ds[4]),ds[5],ds[6]));
			}
			r.close();
		}catch(Exception tt) {
			System.out.println("Loi o ham TaoDanhSach:"+ tt.getMessage());
		}
		
		int n= personData.size();
		Double s=0.0;
		int dau=0;int rot=0;
		for(int i=0;i<n;i++) {
    		NameTable.getItems().add(personData.get(i).getName());
    		s=s+personData.get(i).getdtb();
    		if (personData.get(i).getdtb()<5) rot++;
    		else dau++;
    	}
		Double tbc=s/n;
		String daust= Integer.toString(dau);
		String rotst= Integer.toString(rot);
		rotText.setText(rotst);
		dauText.setText(daust);
		TBCLabel.setText(formatter.format(tbc).toString());
		showPersonDetails(null);
		NameTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
		        showPersonDetails(PSearch(newValue));
			}
		});
	}
	private void showPersonDetails(Person person) {
	    if (person != null) {
	        DTBLabel.setText(person.getdtb().toString());
	        XLLabel.setText(person.getXL());
	        KQLabel.setText(person.getKQ());
	    } else {
	    	DTBLabel.setText("");
	        XLLabel.setText("");
	        KQLabel.setText("");
	    }
	}
	public Person PSearch(String a) {
		int n= personData.size();
		for (int i=0;i<n;i++) {
			if(personData.get(i).getName().equals(a))
				return personData.get(i);
		}
		return null;
	}
	@FXML
	public void clickSearch(ActionEvent event) {
		String name=NameField.getText();
		int n= personData.size();
		if(name.isEmpty()) {
			for(int i=0;i<n;i++) {
	    		NameTable.getItems().add(personData.get(i).getName());
	    	}
		}
		else {
			NameTable.getItems().clear();
			for (int i=0;i<n;i++) {
				if(personData.get(i).getName().contains(name))
					NameTable.getItems().add(personData.get(i).getName());
			}
		}
	}
}
