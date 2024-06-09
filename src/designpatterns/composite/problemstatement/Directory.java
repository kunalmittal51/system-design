package designpatterns.composite.problemstatement;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    String directoryName;
    List<Object> objectsList = new ArrayList<>();

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    public void ls() {
        System.out.println(directoryName);
        for (Object object : objectsList) {
            if (object instanceof File) {
                ((File) object).ls();
            } else if (object instanceof Directory) {
                ((Directory) object).ls();
            }
        }
    }

    public void add(Object obj) {
        objectsList.add(obj);
    }
}
