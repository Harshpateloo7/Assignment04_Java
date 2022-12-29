import java.util.List;
import java.util.Random;
/**
 * @author Harshadkumar Patel, 000852665
 */
public class Wheel {

    // Use to store set of faces in the machine
    private List<String> setOfFaces;
    // Use to store the selected random face index position
    private int selectedFaceIndex;

    /**
     * This is the constructor of the class
     * @param setOfFaces Initialize the set of faces on the wheel
     */
    public Wheel(List<String> setOfFaces) {
        this.setOfFaces = setOfFaces;
        spin();
    }

    /**
     * @return the selected face of the wheel
     */
    public String getSelectedFace() {
        return setOfFaces.get(selectedFaceIndex);
    }

    /**
     * Spin the wheel and select the random face index
     */
    public void spin() {
        selectedFaceIndex = getRN();
    }

    /**
     * Generate random number between 1 to size of the faces
     * Generate random number to select random face from the list
     * @return random number between 1 to size of the faces
     */
    public int getRN() {
        return new Random().nextInt( setOfFaces.size() - 0) + 0;
    }

    /**
     *
     * @return the string of wheel object in a readable format
     */
    @Override
    public String toString() {
        return "Wheel{" +
                "setOfFaces=" + setOfFaces +
                ", selectedFaceIndex=" + selectedFaceIndex +
                '}';
    }
}
