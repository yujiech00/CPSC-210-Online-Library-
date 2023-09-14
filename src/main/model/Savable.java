package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface Savable {
    void save1(String fileName) throws IOException;
}
