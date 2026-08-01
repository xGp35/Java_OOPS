import java.io.*;

class ReadAFile {
    public static void main(String[] args) {
        try {
            File myFile = new File("MyText.txt");
            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);
            // Chain the FileReader to a BufferedReader for more efficient reading.
            // It'll go back to the file to read only when the buffer is empty. 
            // Buffer reads much ahead. like 8KB when we want one character.

            String line;
            // Maka a string variable to hold each line as the line is read
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}