package de.jonas_thelemann.dadamus;

public class DadaOperations {
  static String getDadaSong(int paragraphLength, int sentenceLength) {
    String title = "<h1>Dadamus</h1>";
    String refrain = "\n\n<h2>Refrain</h2>\n" + getDadaParagraph(paragraphLength, sentenceLength);
    String bridge = "\n\n<h2>Bridge</h2>\n" + getDadaParagraph(paragraphLength, sentenceLength);

    return title + "\n\n<h2>Verse</h2>\n" + getDadaParagraph(paragraphLength, sentenceLength) + refrain + "\n\n<h2>Verse</h2>\n" + getDadaParagraph(paragraphLength, sentenceLength) + bridge + refrain;
  }

  private static String getDadaParagraph(int length, int sentenceLength) {
    StringBuilder result = new StringBuilder();

    for (int i = 1; i <= length; i++) {
      result.append("\n");
      result.append(getDadaSentence(sentenceLength));

      if (i < length) {
        result.append(",<br>");
      } else {
        result.append(".<br>");
      }
    }

    return result.toString();
  }

  private static String getDadaSentence(int length) {
    StringBuilder result = new StringBuilder(LetterOperations.getRandomWord());
    result = new StringBuilder(result.substring(0, 1).toUpperCase() + result.substring(1));

    for (int i = 1; i < length; i++) {
      result.append(" ").append(LetterOperations.getRandomWord());
    }

    return result.toString();
  }
}
