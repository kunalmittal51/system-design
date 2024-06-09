package designpatterns.composite.fileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements  FileSystem {
    private String directoryName;
    private List<FileSystem> fileSystemList = new ArrayList<>();

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public void ls() {
        System.out.println(directoryName);
        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }
}
