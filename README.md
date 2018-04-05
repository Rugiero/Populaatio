Populaatio
==========
Version  1.0

Ohjelma toimii ainakin Ubuntussa. Windowsilla ei ole testattu. 

HUOM tärkeää!:
Ennen ohjelman suoritusta:

1. Varmista, että octave on asennettu koneeseesi. Octave on matlabin kaltainen ilmainen avoimen lähdekoodin numeeriseen laskemiseen tarkoitettu ohjelma. Ubuntussa 

>sudo apt-get install octave

Lisätietoja <https://www.gnu.org/software/octave/download.html>

2. (Netbeansissa ajaessa) Javaoctaven tietolähde tulee lisätä paikallisiin maven tietolähteisiin. Javaoctave toimii octaven ja javan välisenä siltana. Siirrä siis paketista löytyvä kansio 'JavaOctave' haluamaasi paikkaan ja suorita:

>mvn install:install-file -Dfile=~/JavaOctave/javaoctave-0.6.4.jar -DpomFile=~/JavaOctave/pom.xml

Lisätietoja <https://kenai.com/projects/javaoctave/pages/Home>

Käyttöohjeet löytyy erillisesta tiedostosta. Toimiva .jar tiedosto löytyy PopulaatioZippi.zip:stä. Pura se Pics- kansioineen johonkin. Ubuntulla aja >java -jar pop_ohjelma-1.0-SNAPSHOT-uber.jar.
