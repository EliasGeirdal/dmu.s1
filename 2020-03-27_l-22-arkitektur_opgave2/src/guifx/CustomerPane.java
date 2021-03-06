package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CustomerPane extends GridPane {
	private TextField txfName; // added
	private ListView<Customer> lvwCustomers;
	private ListView<Company> lvwCompany;

	public CustomerPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		Label lblComp = new Label("Employees");
		this.add(lblComp, 0, 0);

		lvwCustomers = new ListView<>();
		this.add(lvwCustomers, 0, 1, 1, 5);
		lvwCustomers.setPrefWidth(200);
		lvwCustomers.setPrefHeight(200);
		lvwCustomers.getItems().setAll(this.initAllEmpList());
		ChangeListener<Customer> listener = (ov, oldCustomer, newCustomer) -> this.selectedCustomerChanged();
		lvwCustomers.getSelectionModel().selectedItemProperty().addListener(listener);

		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setPrefWidth(200);
		txfName.setEditable(false);

		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 6, 3, 1);
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		if (lvwCustomers.getItems().size() > 0) {
			lvwCustomers.getSelectionModel().select(0);
		}
	}

	private ArrayList<Customer> initAllEmpList() {
		ArrayList<Customer> list = new ArrayList<>();
		for (Customer emp : Controller.getCustomers()) {
			list.add(emp);
		}
		return list;
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CustomerWindow dia = new CustomerWindow("Create Customer");
		dia.showAndWait();

		// Wait for the modal dialog to close

		lvwCustomers.getItems().setAll(this.initAllEmpList());
		this.updateControls();
	}

	private void updateAction() {
		Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
		if (customer == null) {
			return;
		}
//		Company company = lvwCompany.getSelectionModel().getSelectedItem();
		CustomerWindow dia = new CustomerWindow("Update Customer", customer);
		dia.showAndWait();

		// Wait for the modal dialog to close

		int selectIndex = lvwCustomers.getSelectionModel().getSelectedIndex();
		lvwCustomers.getItems().setAll(this.initAllEmpList());
		lvwCustomers.getSelectionModel().select(selectIndex);
	}

	private void deleteAction() {
		Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
		if (customer == null) {
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Customer");
		// alert.setContentText("Are you sure?");
		alert.setHeaderText("Are you sure?");
		Optional<ButtonType> result = alert.showAndWait();
		Company company = lvwCompany.getSelectionModel().getSelectedItem();

		// Wait for the modal dialog to close

		if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
			Controller.removeCustomerFromCompany(customer, company);
			lvwCustomers.getItems().setAll(this.initAllEmpList());
			this.updateControls();
		}
	}

	// -------------------------------------------------------------------------

	private void selectedCustomerChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Customer customer = lvwCustomers.getSelectionModel().getSelectedItem();
		if (customer != null) {
			txfName.setText(customer.getName());
		} else {
			txfName.clear();
		}
	}

}
