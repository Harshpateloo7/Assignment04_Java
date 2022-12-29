import java.util.*;

/**
 * @author : Harshadkumar Patel, 000852665
 *
 */

public class SlotMachine {
    // Number of wheel in the slot machine
    int wheels;
    // Number of faces on each wheel
    List<String> faces;
    // Use to store number of wheels in the machine
    private List<Wheel> arrayOfWheel = new ArrayList<>();
    // Use to store the payout occurrence after machine spin
    private Map<Integer,Integer> payoutOccurrence = new HashMap<>();

    /**
     * This is the constructor of the class
     * @param wheels pass the number of the wheel in the slot machine
     * @param faces pass the number of faces in each wheel on the slot machine
     */
    SlotMachine(int wheels, List<String> faces) {
        this.wheels = wheels;
        this.faces= faces;
        // Add number of wheels in the slot machine
        for (int i = 0 ; i < wheels ; i++) {
            // Initialize the wheel with the same faces
            arrayOfWheel.add(new Wheel(faces));
            // Initialize the payout occurrence with zero value
            payoutOccurrence.put(i, 0);
        }
    }

    /**
     * Spin all the wheels and select the random face index on each wheel
     */
    public void spin() {
        int lastPayout = 0;
        List<String> lastSelectedFaceListOfTheWheel = new ArrayList<>();
        System.out.println("SlotMachine! (" + wheels + " wheels, " + faces.size() + " faces)");
        for (int counter = 0 ; counter < 1000000; counter++) {
            // Create selectedFaceListOfTheWheel to store each wheel value of the machine
            List<String> selectedFaceListOfTheWheel = new ArrayList<>();
            for (int i = 0 ; i < arrayOfWheel.size() ; i++) {
                // Get each wheel of the slot machine
                Wheel wheel = arrayOfWheel.get(i);
                // Spin each wheel on the slot machine
                wheel.spin();
                // Store the selected face of each wheel
                selectedFaceListOfTheWheel.add(wheel.getSelectedFace());
                // Print the selected wheel in the list
                // System.out.println(wheel.getSelectedFace());
            }
            // Sort the selectedFaceListOfTheWheel list
            Collections.sort(selectedFaceListOfTheWheel);
            // Print the selectedFaceListOfTheWheel
            // System.out.println("Wheels: " + selectedFaceListOfTheWheel);
            // Create variable to find payout value based on maximum number of occurrences
            int payoutValue = 0;
            for (int i = 0 ; i < selectedFaceListOfTheWheel.size() ; i++) {
                // This is used to find the number of times the face repeat in the selected wheel
                int maxPayoutValue = Collections.frequency(selectedFaceListOfTheWheel, selectedFaceListOfTheWheel.get(i));
                // By pass the maxPayoutValue for 1 because each face has minimum 1 time occurrence in the list
                // Second condition is used to check the maximum occurrence of the face
                if(maxPayoutValue > 1 && maxPayoutValue > payoutValue) {
                    // Store and replace the maximum occurrence face value with number of times face repeat in the wheel
                    payoutValue = maxPayoutValue;
                }
            }
            // Increment and update the value of the payout based on the face occurrences
            if(payoutValue > 0) {
                payoutValue = payoutValue - 1;
            }
            int value = payoutOccurrence.get(payoutValue);
            value++;
            payoutOccurrence.replace(payoutValue, value);
            lastSelectedFaceListOfTheWheel = selectedFaceListOfTheWheel;
            lastPayout = payoutValue;
        }
        System.out.println("Wheels: " + lastSelectedFaceListOfTheWheel);
        System.out.println("Payout: " + lastPayout);
    }

    /**
     * Print the payout occurrence and print its values in the proper format
     */
    public void printHistogram() {
        // Reset the histogram data
        resetHistogramData();
        // Spin the wheels a million times and store its history
        spin();
        // Get all the payout occurrence and print its values in the proper format
        Set<Integer> payoutKeys = payoutOccurrence.keySet();
        System.out.println();
        System.out.println("Payout Occurrences");
        for(Integer key: payoutKeys) {
            System.out.format("%2d", key);
            System.out.print(" : ");
            System.out.format("%12d", payoutOccurrence.get(key));
            System.out.println();
        }
    }

    /**
     * This function is used to reset the histogram data
     */
    public void resetHistogramData() {
        // Get all the payout occurrence and print its values in the proper format
        Set<Integer> payoutKeys = payoutOccurrence.keySet();
        for(Integer key: payoutKeys) {
            payoutOccurrence.replace(key, 0);
        }
    }

    /**
     *
     * @return the string of slot machine object in a readable format
     */
    @Override
    public String toString() {
        return "SlotMachine{" +
                "wheels=" + wheels +
                ", faces=" + faces +
                ", arrayOfWheel=" + arrayOfWheel +
                ", payoutOccurrence=" + payoutOccurrence +
                '}';
    }
}
