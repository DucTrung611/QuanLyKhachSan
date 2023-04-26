package application;
	

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {
	 private ObservableList<Room> roomList = FXCollections.observableArrayList(
	            new Room("101", "Single", true, 500),
	            new Room("102", "Single", true, 700),
	            new Room("201", "Double", false, 300),
	            new Room("202", "Double", true, 500),
	            new Room("301", "Suite", false,400),
	            new Room("302", "Suite", false,600)
	    );

	    private TableView<Room> roomTable = new TableView<>();
	    private TextField roomNumberTextField = new TextField();
	    private TextField roomPriceTextField = new TextField();
	    private ComboBox<String> roomTypeComboBox = new ComboBox<>();
	    private CheckBox roomAvailabilityCheckBox = new CheckBox();

	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        BorderPane borderPane = new BorderPane();
	        HBox hBox = new HBox();
	        hBox.setSpacing(10);
	        hBox.setPadding(new Insets(10));
	        Button addRoomButton = new Button("Add Room");
	        Button updateRoomButton = new Button("Update Room");
	        Button deleteRoomButton = new Button("Delete Room");
	        hBox.getChildren().addAll(addRoomButton, updateRoomButton, deleteRoomButton);
	        borderPane.setTop(hBox);

	        //Table view for Rooms
	        roomTable.setItems(roomList);
	        TableColumn<Room, String> numberColumn = new TableColumn<>("Room Number");
	        numberColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoomNumber()));
	        
	        TableColumn<Room, String> priceColumn = new TableColumn<>("Price");
	        priceColumn.setCellValueFactory(cellData -> new SimpleStringProperty(Double.toString(cellData.getValue().getPrice())));
	        
	        TableColumn<Room, String> typeColumn = new TableColumn<>("Room Type");
	        typeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRoomType()));
	        
	        TableColumn<Room, String> availabilityColumn = new TableColumn<>("Availability");
	        availabilityColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().isRoomAvailable() ? "Available" : "Not Available"));
	        roomTable.getColumns().setAll(numberColumn, typeColumn, availabilityColumn, priceColumn);
	        borderPane.setCenter(roomTable);
	        
	        TableColumn<Room, String> nameColumn = new TableColumn<>("Name");
	        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerName()));
	        roomTable.getColumns().add(nameColumn);

	        TableColumn<Room, String> emailColumn = new TableColumn<>("Email");
	        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerEmail()));
	        roomTable.getColumns().add(emailColumn);

	        TableColumn<Room, String> phoneColumn = new TableColumn<>("Phone");
	        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomerPhone()));
	        roomTable.getColumns().add(phoneColumn);
	        
	        roomTable.setRowFactory(tv -> {
	            TableRow<Room> row = new TableRow<>();
	            row.setOnMouseClicked(event -> {
	                if (event.getClickCount() == 2 && !row.isEmpty()) {
	                    Room room = row.getItem();
	                    CustomerInfoWindow customerInfoWindow = new CustomerInfoWindow(room);
	                    customerInfoWindow.showAndWait();
	                    roomTable.refresh();
	                }
	            });
	            return row;
	        });
	        

	        // Form for Adding/Updating Room
	        GridPane roomForm = new GridPane();
	        roomForm.setPadding(new Insets(10));
	        roomForm.setHgap(10);
	        roomForm.setVgap(10);
	        Label roomNumberLabel = new Label("Room Number:");
	        roomForm.add(roomNumberLabel, 0, 0);
	        roomForm.add(roomNumberTextField, 1, 0);
	        Label roomPriceLabel = new Label("Price:");
	        roomForm.add(roomPriceLabel, 0, 1);
	        roomForm.add(roomPriceTextField, 1, 1);
	        Label roomTypeLabel = new Label("Room Type:");
	        roomForm.add(roomTypeLabel, 0, 2);
	        roomTypeComboBox.getItems().addAll("Single", "Double", "Suite");
	        roomForm.add(roomTypeComboBox, 1, 2);
	        Label roomAvailabilityLabel = new Label("Availability:");
	        roomForm.add(roomAvailabilityLabel, 0, 3);
	        roomForm.add(roomAvailabilityCheckBox, 1, 3);
	        Button saveRoomButton = new Button("Save");
	        roomForm.add(saveRoomButton, 1, 4);
	        borderPane.setBottom(roomForm);

	        // Add Room Button Action
	        addRoomButton.setOnAction(event -> {
	            roomNumberTextField.clear();
	            roomPriceTextField.clear();
	            roomTypeComboBox.getSelectionModel().clearSelection();
	            roomAvailabilityCheckBox.setSelected(false);
	        });
	     // Update Room Button Action
	        updateRoomButton.setOnAction(event -> {
	            Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
			if (selectedRoom != null) {
			roomNumberTextField.setText(selectedRoom.getRoomNumber());
			roomPriceTextField.setText( Double.toString(selectedRoom.getPrice()));
			roomTypeComboBox.getSelectionModel().select(selectedRoom.getRoomType());
			roomAvailabilityCheckBox.setSelected(selectedRoom.isRoomAvailable());
			} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("No Room Selected");
			alert.setHeaderText(null);
			alert.setContentText("Please select a room to update.");
			alert.showAndWait();
	}
	});
	    // Delete Room Button Action
	        deleteRoomButton.setOnAction(event -> {
	            Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
	            if (selectedRoom != null) {
	                if (selectedRoom.getCustomerName() != null || selectedRoom.getCustomerEmail() != null || selectedRoom.getCustomerPhone() != null || !selectedRoom.isRoomAvailable()) {
	                    Alert alert = new Alert(Alert.AlertType.WARNING);
	                    alert.setTitle("Cannot Delete Room");
	                    alert.setHeaderText(null);
	                    alert.setContentText("This room has customer information and cannot be deleted.");
	                    alert.showAndWait();
	                } else {
	                    roomList.remove(selectedRoom);
	                }
	            } else {
	                Alert alert = new Alert(Alert.AlertType.WARNING);
	                alert.setTitle("No Room Selected");
	                alert.setHeaderText(null);
	                alert.setContentText("Please select a room to delete.");
	                alert.showAndWait();
	            }
	        });

	    // Save Room Button Action
	    saveRoomButton.setOnAction(event -> {
	        String roomNumber = roomNumberTextField.getText();
	        double roomPrice = Double.parseDouble(roomPriceTextField.getText());
	        String roomType = roomTypeComboBox.getSelectionModel().getSelectedItem();
	        boolean roomAvailable = roomAvailabilityCheckBox.isSelected();
	        if (roomNumber != null && roomType != null) {
	            Room newRoom = new Room(roomNumber, roomType, roomAvailable, roomPrice);
	            if (roomTable.getSelectionModel().getSelectedItem() == null) {
	                roomList.add(newRoom);
	            } else {
	                Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
	                int selectedIndex = roomTable.getSelectionModel().getSelectedIndex();
	                newRoom.setCustomerName(selectedRoom.getCustomerName());
	                newRoom.setCustomerEmail(selectedRoom.getCustomerEmail());
	                newRoom.setCustomerPhone(selectedRoom.getCustomerPhone());
	                roomList.set(selectedIndex, newRoom);
	            }
	            roomNumberTextField.clear();
	            roomTypeComboBox.getSelectionModel().clearSelection();
	            roomAvailabilityCheckBox.setSelected(false);

	            
	        } else {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("Invalid Room Details");
	            alert.setHeaderText(null);
	            alert.setContentText("Please enter a room number and select a room type.");
	            alert.showAndWait();
	        }
	    });
	    
	 // Create Check Out Button
	    Button checkOutButton = new Button("Check Out");
	    checkOutButton.setOnAction(e -> {
	        Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
	        if (selectedRoom != null) {
	            selectedRoom.setCustomerName(null);
	            selectedRoom.setCustomerEmail(null);
	            selectedRoom.setCustomerPhone(null);
	            selectedRoom.setRoomAvailable(true);
	            roomTable.refresh();
	        } else {
	            Alert alert = new Alert(Alert.AlertType.WARNING);
	            alert.setTitle("No Room Selected");
	            alert.setHeaderText(null);
	            alert.setContentText("Please select a room to check out.");
	            alert.showAndWait();
	        }
	    });
	    
	 // Open customer information window
        Button bookRoomButton = new Button("Book Room");
        bookRoomButton.setOnAction(e -> {
            Room selectedRoom = roomTable.getSelectionModel().getSelectedItem();
            if (selectedRoom != null) {
                CustomerInfoWindow customerInfoWindow = new CustomerInfoWindow(selectedRoom);
                customerInfoWindow.showAndWait();
                selectedRoom.setCustomerName(customerInfoWindow.getCustomerName());
                selectedRoom.setCustomerEmail(customerInfoWindow.getCustomerEmail());
                selectedRoom.setCustomerPhone(customerInfoWindow.getCustomerPhone());
                roomTable.refresh();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("No Room Selected");
                alert.setHeaderText(null);
                alert.setContentText("Please select a room to book.");
                alert.showAndWait();
            }
        });
        roomForm.add(bookRoomButton, 2, 3);

	    // Add Check Out Button to Room Form
	    roomForm.add(checkOutButton, 3, 3);

	    Scene scene = new Scene(borderPane);
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Hotel Management");
	    primaryStage.show();
	}

	public static void main(String[] args) {
	    launch(args);
	}

	public class Room {
	    private final String roomNumber;
	    private final String roomType;
	    private boolean roomAvailable;
	    private String customerName;
	    private String customerEmail;
	    private String customerPhone;
	    private double price;
	    
	    public Room(String roomNumber, String roomType, boolean roomAvailable, double price) {
	        this.roomNumber = roomNumber;
	        this.roomType = roomType;
	        this.roomAvailable = roomAvailable;
	        this.price = price;
	    }

	    public String getRoomNumber() {
	        return roomNumber;
	    }
	    
	    public double getPrice() {
	        return price;
	    }

	    public String getRoomType() {
	        return roomType;
	    }

	    public boolean isRoomAvailable() {
	        return roomAvailable;
	    }

	    public void setRoomAvailable(boolean roomAvailable) {
	        this.roomAvailable = roomAvailable;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getCustomerEmail() {
	        return customerEmail;
	    }

	    public void setCustomerEmail(String customerEmail) {
	        this.customerEmail = customerEmail;
	    }

	    public String getCustomerPhone() {
	        return customerPhone;
	    }

	    public void setCustomerPhone(String customerPhone) {
	        this.customerPhone = customerPhone;
	    }

	    public String roomAvailabilityProperty() {
	        return roomAvailable ? "Available" : "Not Available";
	    }

	    public String roomNumberProperty() {
	        return roomNumber;
	    }

	    public String roomTypeProperty() {
	        return roomType;
	    }
	    
	    public static List<Room> readRoomsFromFile(String filename) throws IOException, ClassNotFoundException {
	        List<Room> rooms = new ArrayList<>();
	        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
	            while (true) {
	                Room room = (Room) ois.readObject();
	                rooms.add(room);
	            }
	        } catch (EOFException e) {
	            // end of file reached
	        }
	        return rooms;
	    }

	    public static void writeRoomsToFile(List<Room> rooms, String filename) throws IOException {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
	            for (Room room : rooms) {
	                oos.writeObject(room);
	            }
	        }
	    }
	}
}
