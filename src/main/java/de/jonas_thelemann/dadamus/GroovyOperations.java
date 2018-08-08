package de.jonas_thelemann.dadamus;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.codehaus.groovy.control.CompilationFailedException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class GroovyOperations {
  static String getGroovyOutput() throws CompilationFailedException, IOException {
    Binding binding = new Binding();
    GroovyShell shell = new GroovyShell(binding);

    return (String) shell.evaluate(readFile("D:/Dokumente/Java/eclipse/workspace/Dadamus/groovy/parseMusicXML.groovy", StandardCharsets.UTF_8));
  }

  private static String readFile(String path, Charset encoding) throws IOException {
    byte[] encoded = Files.readAllBytes(Paths.get(path));
    return new String(encoded, encoding);
  }
}