import java.util.ArrayList;

public class Startup {
    private String name;
    private ArrayList<String> locationCells;

    public Startup (String name){
        this.name = name;
    }

    public void setLocationCells(ArrayList<String> locs) {
        locationCells = locs;
    }

    public void setName(String n) {
        name = n;
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
