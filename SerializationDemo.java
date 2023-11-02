import java.io.*;

public class SerializationDemo {

    public static void main(String[] args) throws Exception {

        Dog dog1 = new Dog();

        //Serialization
        FileOutputStream fileOutputStream = new FileOutputStream("serialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dog1);

        //Deserialization
        FileInputStream fileInputStream = new FileInputStream("serialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog desrializedDog = (Dog) objectInputStream.readObject();

        System.out.println(desrializedDog.toString());

    }
}

/*
    If a variable is declared as transient, while serializing JVM will ignore that value and will replace it with
    the default value of that variable type.
 */
class Dog implements Serializable {
    int age = 10;
    transient String colour = "Brown";

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", colour='" + colour + '\'' +
                '}';
    }
}
