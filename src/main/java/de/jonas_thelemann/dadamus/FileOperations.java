package de.jonas_thelemann.dadamus;

import java.io.FileWriter;

/**
 * @author Jonas Thelemann
 */
@SuppressWarnings("unused")
public class FileOperations {

  @SuppressWarnings("unused")
  static void createFile(String input) throws Exception {
    FileWriter fw = new FileWriter("index.html");
    fw.write(input);
    fw.close();
  }
}
