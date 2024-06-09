package designpatterns.composite.fileSystem;


public class DriverClass {
    public static void main(String[] args) {
        Directory directory = new Directory("Movies");
        FileImpl file = new FileImpl("file1");
        directory.add(file);

        Directory subDirectory = new Directory("Comedy Movies");
        FileImpl file2 = new FileImpl("file2");
        subDirectory.add(file2);
        directory.add(subDirectory);
        directory.ls();
    }
}
