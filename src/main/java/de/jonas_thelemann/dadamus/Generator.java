package de.jonas_thelemann.dadamus;

/**
 * @author Jonas Thelemann
 */
public class Generator {

  public static void main(String[] args) throws Exception {
    //String dadaParagraph = DadaOperations.getDadaParagraph(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    //String noHTMLdadaParagraph = dadaParagraph.replaceAll("\\<.*?>","");
    //SoundOperations.maryIt(noHTMLdadaParagraph);
    //FileOperations.createFile(dadaParagraph);

    String groovyOut = GroovyOperations.getGroovyOutput();

    SoundOperations.maryIt(groovyOut);

    System.out.println(groovyOut);
  }
}