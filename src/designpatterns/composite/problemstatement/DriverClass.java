package designpatterns.composite.problemstatement;

public class DriverClass {
    public static void main(String[] args) {
        Directory directory = new Directory("Movies");
        File file = new File("file1");
        directory.add(file);

        Directory subDirectory = new Directory("Comedy Movies");
        File file2 = new File("file2");
        subDirectory.add(file2);
        directory.add(subDirectory);
        directory.ls();
    }
}
