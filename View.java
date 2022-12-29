import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;

import static javafx.application.Application.launch;
import static javafx.application.Platform.exit;

/**
 * @author Harshadkumar Patel, 000852665
 */
public class View extends Application {

    /**
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(450, 350); // Set Canvas size in Pixels
        stage.setTitle("FXGraphicsTemplate"); // Set title of the window
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // YOUR CODE STARTS HERE
        System.out.println();
        System.out.println();
        // Print the available machines on the screen
        System.out.println("Machine 1 is colorful and has 5 wheels with 9 faces.");
        System.out.println("Machine 2 is monochrome and has 7 wheels with 7 faces.");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        do {
            // Ask user to choose machine
            System.out.print("Choose a machine: ");
            value = scanner.nextInt();
        } while (value != 1 && value != 2);

        SlotMachine slotMachine;
        // Select the machine based on the user input
        if(value == 1) {
            slotMachine = getSlotMachineWith5WheelsAnd9Faces();
        } else {
            slotMachine = getSlotMachineWith7WheelsAnd7Faces();
        }

        do {
            System.out.println();
            // Print the available option
            System.out.print("1: spin 2: lots a spins. 3: No more spins");
            System.out.println();
            // Ask user to choose one of the option
            System.out.print("Choose a option: ");
            value = scanner.nextInt();
            // Perform the operation based on user input
            if(value == 1) {
                slotMachine.spin();
            } else if(value == 2) {
                slotMachine.printHistogram();
            }
        } while (value != 3);

        // Exit from the program when user select option 3
        exit();

        // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * This function create and return the slot machine with the 5 wheel and 9 faces
     * @return the slot machine with the 5 wheel and 9 faces
     */
    public SlotMachine getSlotMachineWith5WheelsAnd9Faces() {
        // Create an array with 9 faces
        String[] facesOfTheWheel = new String[] {"Apple" , "Berry", "Cherry", "Dragon Fruit", "Elderberry", "Grape", "Honeydew", "Jack fruit", "Kiwi"};
        // Create slot machine with 5 wheels with 9 faces
        SlotMachine slotMachine = new SlotMachine(5, Arrays.stream(facesOfTheWheel).toList());
        return  slotMachine;
    }

    /**
     * This function create and return the slot machine with the 7 wheel and 7 faces
     * @return the slot machine with the 7 wheel and 7 faces
     */
    public SlotMachine getSlotMachineWith7WheelsAnd7Faces() {
        // Create an array with 7 faces
        String[] facesOfTheWheel = new String[] {"Lychee" , "Mulberry", "Nectarine", "Orange", "Peach"};
        // Create slot machine with 7 wheels with 5 faces
        SlotMachine slotMachine = new SlotMachine(7, Arrays.stream(facesOfTheWheel).toList());
        return slotMachine;
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}
