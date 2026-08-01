// Serializble square

import java.io.*;

public class Square implements Serializable {
    // No mehtods to implement, but this means "it's OK to serialize objects of this type"

    private int width;
    private int height;

    public Square(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Square mySquare  = new Square(50, 20);

        try { // I/O operations can throw exceptions
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(mySquare);
            os.close();            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

