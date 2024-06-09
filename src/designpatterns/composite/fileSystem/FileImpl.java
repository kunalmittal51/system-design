package designpatterns.composite.fileSystem;

public class FileImpl implements FileSystem {
    String fileName;

    public FileImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ls() {
        System.out.println(fileName);
    }
}
