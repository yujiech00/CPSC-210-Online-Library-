package model;

import java.io.IOException;
import java.util.ArrayList;

public interface Loadable {
    ArrayList<BookRecord> load1(String fileName) throws IOException;

    void load(String fileName) throws IOException;
}
