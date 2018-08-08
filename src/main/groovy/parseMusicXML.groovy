import de.jonas_thelemann.dadamus.LetterOperations

def data = new XmlSlurper()
data.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
data.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false)
data = data.parseText(new File('D:/Dokumente/Java/eclipse/workspace/Dadamus/groovy/nachtmusik_short.xml').text)

def map = ["Cb1": LetterOperations.getRandomWord(50), //1
           "C1" : LetterOperations.getRandomWord(50),
           "C#1": LetterOperations.getRandomWord(50),
           "Db1": LetterOperations.getRandomWord(50),
           "D1" : LetterOperations.getRandomWord(50),
           "D#1": LetterOperations.getRandomWord(50),
           "Eb1": LetterOperations.getRandomWord(50),
           "E1" : LetterOperations.getRandomWord(50),
           "E#1": LetterOperations.getRandomWord(50),
           "Fb1": LetterOperations.getRandomWord(50),
           "F1" : LetterOperations.getRandomWord(50),
           "F#1": LetterOperations.getRandomWord(50),
           "Gb1": LetterOperations.getRandomWord(50),
           "G1" : LetterOperations.getRandomWord(50),
           "G#1": LetterOperations.getRandomWord(50),
           "Ab1": LetterOperations.getRandomWord(50),
           "A1" : LetterOperations.getRandomWord(50),
           "A#1": LetterOperations.getRandomWord(50),
           "Bb1": LetterOperations.getRandomWord(50),
           "B1" : LetterOperations.getRandomWord(50),
           "B#1": LetterOperations.getRandomWord(50),
           "Cb2": LetterOperations.getRandomWord(50), //2
           "C2" : LetterOperations.getRandomWord(50),
           "C#2": LetterOperations.getRandomWord(50),
           "Db2": LetterOperations.getRandomWord(50),
           "D2" : LetterOperations.getRandomWord(50),
           "D#2": LetterOperations.getRandomWord(50),
           "Eb2": LetterOperations.getRandomWord(50),
           "E2" : LetterOperations.getRandomWord(50),
           "E#2": LetterOperations.getRandomWord(50),
           "Fb2": LetterOperations.getRandomWord(50),
           "F2" : LetterOperations.getRandomWord(50),
           "F#2": LetterOperations.getRandomWord(50),
           "Gb2": LetterOperations.getRandomWord(50),
           "G2" : LetterOperations.getRandomWord(50),
           "G#2": LetterOperations.getRandomWord(50),
           "Ab2": LetterOperations.getRandomWord(50),
           "A2" : LetterOperations.getRandomWord(50),
           "A#2": LetterOperations.getRandomWord(50),
           "Bb2": LetterOperations.getRandomWord(50),
           "B2" : LetterOperations.getRandomWord(50),
           "B#2": LetterOperations.getRandomWord(50),
           "Cb3": LetterOperations.getRandomWord(50), //3
           "C3" : LetterOperations.getRandomWord(50),
           "C#3": LetterOperations.getRandomWord(50),
           "Db3": LetterOperations.getRandomWord(50),
           "D3" : LetterOperations.getRandomWord(50),
           "D#3": LetterOperations.getRandomWord(50),
           "Eb3": LetterOperations.getRandomWord(50),
           "E3" : LetterOperations.getRandomWord(50),
           "E#3": LetterOperations.getRandomWord(50),
           "Fb3": LetterOperations.getRandomWord(50),
           "F3" : LetterOperations.getRandomWord(50),
           "F#3": LetterOperations.getRandomWord(50),
           "Gb3": LetterOperations.getRandomWord(50),
           "G3" : LetterOperations.getRandomWord(50),
           "G#3": LetterOperations.getRandomWord(50),
           "Ab3": LetterOperations.getRandomWord(50),
           "A3" : LetterOperations.getRandomWord(50),
           "A#3": LetterOperations.getRandomWord(50),
           "Bb3": LetterOperations.getRandomWord(50),
           "B3" : LetterOperations.getRandomWord(50),
           "B#3": LetterOperations.getRandomWord(50),
           "Cb4": LetterOperations.getRandomWord(50), //4
           "C4" : LetterOperations.getRandomWord(50),
           "C#4": LetterOperations.getRandomWord(50),
           "Db4": LetterOperations.getRandomWord(50),
           "D4" : LetterOperations.getRandomWord(50),
           "D#4": LetterOperations.getRandomWord(50),
           "Eb4": LetterOperations.getRandomWord(50),
           "E4" : LetterOperations.getRandomWord(50),
           "E#4": LetterOperations.getRandomWord(50),
           "Fb4": LetterOperations.getRandomWord(50),
           "F4" : LetterOperations.getRandomWord(50),
           "F#4": LetterOperations.getRandomWord(50),
           "Gb4": LetterOperations.getRandomWord(50),
           "G4" : LetterOperations.getRandomWord(50),
           "G#4": LetterOperations.getRandomWord(50),
           "Ab4": LetterOperations.getRandomWord(50),
           "A4" : LetterOperations.getRandomWord(50),
           "A#4": LetterOperations.getRandomWord(50),
           "Bb4": LetterOperations.getRandomWord(50),
           "B4" : LetterOperations.getRandomWord(50),
           "B#4": LetterOperations.getRandomWord(50),
           "Cb5": LetterOperations.getRandomWord(50), //5
           "C5" : LetterOperations.getRandomWord(50),
           "C#5": LetterOperations.getRandomWord(50),
           "Db5": LetterOperations.getRandomWord(50),
           "D5" : LetterOperations.getRandomWord(50),
           "D#5": LetterOperations.getRandomWord(50),
           "Eb5": LetterOperations.getRandomWord(50),
           "E5" : LetterOperations.getRandomWord(50),
           "E#5": LetterOperations.getRandomWord(50),
           "Fb5": LetterOperations.getRandomWord(50),
           "F5" : LetterOperations.getRandomWord(50),
           "F#5": LetterOperations.getRandomWord(50),
           "Gb5": LetterOperations.getRandomWord(50),
           "G5" : LetterOperations.getRandomWord(50),
           "G#5": LetterOperations.getRandomWord(50),
           "Ab5": LetterOperations.getRandomWord(50),
           "A5" : LetterOperations.getRandomWord(50),
           "A#5": LetterOperations.getRandomWord(50),
           "Bb5": LetterOperations.getRandomWord(50),
           "B5" : LetterOperations.getRandomWord(50),
           "B#5": LetterOperations.getRandomWord(50),
           "Cb6": LetterOperations.getRandomWord(50), //6
           "C6" : LetterOperations.getRandomWord(50),
           "C#6": LetterOperations.getRandomWord(50),
           "Db6": LetterOperations.getRandomWord(50),
           "D6" : LetterOperations.getRandomWord(50),
           "D#6": LetterOperations.getRandomWord(50),
           "Eb6": LetterOperations.getRandomWord(50),
           "E6" : LetterOperations.getRandomWord(50),
           "E#6": LetterOperations.getRandomWord(50),
           "Fb6": LetterOperations.getRandomWord(50),
           "F6" : LetterOperations.getRandomWord(50),
           "F#6": LetterOperations.getRandomWord(50),
           "Gb6": LetterOperations.getRandomWord(50),
           "G6" : LetterOperations.getRandomWord(50),
           "G#6": LetterOperations.getRandomWord(50),
           "Ab6": LetterOperations.getRandomWord(50),
           "A6" : LetterOperations.getRandomWord(50),
           "A#6": LetterOperations.getRandomWord(50),
           "Bb6": LetterOperations.getRandomWord(50),
           "B6" : LetterOperations.getRandomWord(50),
           "B#6": LetterOperations.getRandomWord(50),
           "Cb7": LetterOperations.getRandomWord(50), //7
           "C7" : LetterOperations.getRandomWord(50),
           "C#7": LetterOperations.getRandomWord(50),
           "Db7": LetterOperations.getRandomWord(50),
           "D7" : LetterOperations.getRandomWord(50),
           "D#7": LetterOperations.getRandomWord(50),
           "Eb7": LetterOperations.getRandomWord(50),
           "E7" : LetterOperations.getRandomWord(50),
           "E#7": LetterOperations.getRandomWord(50),
           "Fb7": LetterOperations.getRandomWord(50),
           "F7" : LetterOperations.getRandomWord(50),
           "F#7": LetterOperations.getRandomWord(50),
           "Gb7": LetterOperations.getRandomWord(50),
           "G7" : LetterOperations.getRandomWord(50),
           "G#7": LetterOperations.getRandomWord(50),
           "Ab7": LetterOperations.getRandomWord(50),
           "A7" : LetterOperations.getRandomWord(50),
           "A#7": LetterOperations.getRandomWord(50),
           "Bb7": LetterOperations.getRandomWord(50),
           "B7" : LetterOperations.getRandomWord(50),
           "B#7": LetterOperations.getRandomWord(50)]

static def testSwitch(val, text) {
    def result
    switch (val) {
        case "120":
            result = text.substring(50)
            break
        case "240":
            result = text.substring(49)
            break
        case "360":
            result = text.substring(48)
            break
        case "480":
            result = text.substring(47)
            break
        case "720":
            result = text.substring(45)
            break
        case "960":
            result = text.substring(43)
            break
        case "1440":
            result = text.substring(39)
            break
        case "1920":
            result = text.substring(35)
            break
        case "2880":
            result = text.substring(27)
            break
        case "3840":
            result = text.substring(19)
            break
        case "5760":
            result = text.substring(3)
            break
        default:
            result = 'Default'
            break
    }
    result
}

def output = ""

data.part.each { part ->

    part.measure.note.each { note ->

        def shift = ""
        if (note.pitch.alter.text() == "-1") {
            shift = "b"
        } else if (note.pitch.alter.text() == "1") {
            shift = "#"
        }

        def key = "${note.pitch.step.text()}$shift${note.pitch.octave.text()}"

        if ("${map[key as String]}" != "null") {
            output += "(${testSwitch("${note.duration.text()}", "${map[key as String]}")})"
        } else {
            output += "(pause[${note.duration.text()}])"
        }
    }

    output += "\n"

}

return output
