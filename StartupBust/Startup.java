import java.util.ArrayList;

class Startup {
    private ArrayList<String> locationCells;

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput); // Get index of userInput from list of strings

        if (index >= 0) { //if userInput not in locationCells, indexOf will return -1
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "kill";
            } else {
                result = "hit";
            } // end if
        } // end outer if
        return result;
    } // end method
} // close class
