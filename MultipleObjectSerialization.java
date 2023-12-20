import java.io.*;

/**
 * Desrialization follows the order in which objects are serialized.
 */
public class MultipleObjectSerialization {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("multiple-objects.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(new Cat());
        objectOutputStream.writeObject(new Dog());
        objectOutputStream.writeObject(new Rat());

        //Deserialization
        FileInputStream fileInputStream = new FileInputStream("multiple-objects.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Cat cat = (Cat) objectInputStream.readObject();
        System.out.println(cat);
        Object dog = objectInputStream.readObject();
        System.out.println(dog);
    }
}


class Cat implements Serializable {
    String color = "red";

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                '}';
    }
}

class Rat implements Serializable {
    String color = "brown";

    @Override
    public String toString() {
        return "Rat{" +
                "color='" + color + '\'' +
                '}';
    }
}