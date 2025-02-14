import java.io.*;

public class Handler implements Serializable, Writable { 
    @Override
    public void save(Serializable serializable) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(serializable);

        objectOutputStream.close();
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Object tree = objectInputStream.readObject();
        objectInputStream.close();
        for (Person p: (FamilyTree)tree){
            System.out.println(p);
        }
        return tree;
    }
}