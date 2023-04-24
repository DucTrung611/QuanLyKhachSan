package application;
import application.Main.Room;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CustomerInfoWindow extends javafx.stage.Stage{
    private Room room;
    private TextField customerNameTextField;
    private TextField customerEmailTextField;
    private TextField customerPhoneTextField;

    public CustomerInfoWindow(Room room) {
        this.room = room;

        setTitle("Customer Information");
        setWidth(400);
        setHeight(300);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label roomNumberLabel = new Label("Room Number:");
        TextField roomNumberTextField = new TextField(room.getRoomNumber());
        roomNumberTextField.setEditable(false);
        gridPane.add(roomNumberLabel, 0, 0);
        gridPane.add(roomNumberTextField, 1, 0);

        Label roomTypeLabel = new Label("Room Type:");
        TextField roomTypeTextField = new TextField(room.getRoomType());
        roomTypeTextField.setEditable(false);
        gridPane.add(roomTypeLabel, 0, 1);
        gridPane.add(roomTypeTextField, 1, 1);

        Label customerNameLabel = new Label("Customer Name:");
        customerNameTextField = new TextField();
        gridPane.add(customerNameLabel, 0, 2);
        gridPane.add(customerNameTextField, 1, 2);

        Label customerEmailLabel = new Label("Customer Email:");
        customerEmailTextField = new TextField();
        gridPane.add(customerEmailLabel, 0, 3);
        gridPane.add(customerEmailTextField, 1, 3);

        Label customerPhoneLabel = new Label("Customer Phone:");
        customerPhoneTextField = new TextField();
        gridPane.add(customerPhoneLabel, 0, 4);
        gridPane.add(customerPhoneTextField, 1, 4);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            saveCustomerInfoToRoom();
            close();
        });

        gridPane.add(saveButton, 1, 5);

        setScene(new javafx.scene.Scene(gridPane));
    }

    public String getCustomerName() {
        return customerNameTextField.getText();
    }

    public String getCustomerEmail() {
        return customerEmailTextField.getText();
    }

    public String getCustomerPhone() {
        return customerPhoneTextField.getText();
    }

    public void saveCustomerInfoToRoom() {
        room.setCustomerName(getCustomerName());
        room.setCustomerEmail(getCustomerEmail());
        room.setCustomerPhone(getCustomerPhone());
        if (room.isRoomAvailable()) {
            room.setRoomAvailable(false);
        }
    }
}