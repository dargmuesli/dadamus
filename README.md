# dadamus
A [MusicXML](https://www.musicxml.com/de/) to [Dada](https://en.wikipedia.org/wiki/Dada) speech converter.

_dadamus_ creates a verbal Dada representation of sheet music.
It turns machine readable musical notation into senseless, but spoken words. 

The program parses a MusicXML file¹ and creates a Dada word for each tone, following probabilities for successive letters in the German language.
It adjusts the Dada words' amount of letters in relation to the tone's duration.
Then, the word is converted to an audio stream using [MaryTTS](http://mary.dfki.de/).
The audio stream's length is then, again, adjusted in relation to the represented tone's duration using the [Sonic algorithm](https://github.com/waywardgeek/sonic).
Finally, all audio streams are concatenated and such streams for each sheet music's part are saved as .wav files.
An example output can be found under [example/](example/).

The idea for this proof of concept came into being as the second part of a project for my music lessons just before my high school graduation at [Friedrichsgymnasium Kassel](http://www.fg-kassel.de/).
At the time, we studied [Dada](https://en.wikipedia.org/wiki/Dada) sound media and literature.
Unfortunately there was not enough time to finish this part of the project in time for the presentation I held at the end of this project.
Thus, the presentation was only about this school project's first part: [dargmuesli/dadasong](https://github.com/dargmuesli/dadasong/).

Of course there is room for improvements.
For example, there is currently no support for tones with a "#" or "b" annotation and possible tone lengths are restricted to a few supported values.
As said, this project is only a proof of concept and exists because of the general concept only. 

---

¹ Most music notation programs should be able to export sheet music to MusicXML files.