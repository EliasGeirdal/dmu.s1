package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomerWindow extends Stage {
	private Customer customer;
	private Company company;

	public CustomerWindow(String title, Customer customer) {
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.company = company;

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public CustomerWindow(String title) {
		this(title, null);
	}

	// -------------------------------------------------------------------------

	private TextField txfName;
	private CheckBox chbCompany;
	private ComboBox<Company> cbbCompany;
	private Label lblError;

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		Label lblName = new Label("Name");
		pane.add(lblName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);
		txfName.setPrefWidth(200);

		chbCompany = new CheckBox("Company");
		pane.add(chbCompany, 0, 2);
		ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> selectedCompanyChanged(newValue);
		chbCompany.selectedProperty().addListener(listener);

		cbbCompany = new ComboBox<>();
		pane.add(cbbCompany, 0, 3);
		cbbCompany.getItems().addAll(Controller.getCompanies());
		cbbCompany.setDisable(true);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 4);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 0, 4);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setOnAction(event -> this.okAction());

		lblError = new Label();
		pane.add(lblError, 0, 5);
		lblError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	private void initControls() {
		if (customer != null) {
			txfName.setText(customer.getName());
			cbbCompany.getSelectionModel().select(0);
		} else {
			txfName.clear();
			cbbCompany.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void cancelAction() {
		this.hide();
	}

	private void okAction() {
		String name = txfName.getText().trim();
		if (name.length() == 0) {
			lblError.setText("Name is empty");
			return;
		}

		boolean companyIsSelected = chbCompany.isSelected();
		Company newCompany = cbbCompany.getSelectionModel().getSelectedItem();

		// Call controller methods
		if (newCompany != null) {
			if (companyIsSelected)
				Controller.createCustomer(newCompany, name);
		} else if (!companyIsSelected) {
			lblError.setText("Company not selected");
			return;
		}
		this.hide();
	}

	// -------------------------------------------------------------------------
	private void selectedCompanyChanged(boolean checked) {
		cbbCompany.setDisable(!checked);
	}
}
