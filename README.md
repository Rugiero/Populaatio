Populaatio
==========
Version  0.7
Counts development of population from given values.

Esimerkkiavoja: SIR/SIS N=50 I0=1 B=0.015 a=0.1
Peto- saalis  F0=3.5 R0=1.8 a=0.3 b=0.1 c=0.1 d=0.2

HUOM tärkeää!:
Ennen ohjelman suoritusta:


1. Varmista, että octave on asennettu koneeseesi. Octave on matlabin kaltainen ilmainen avoimen lähdekoodin numeeriseen laskemiseen tarkoitettu ohjelma. Ubuntussa 

>sudo apt-get install octave

Lisätietoja <https://www.gnu.org/software/octave/download.html>

2. Javaoctaven tietolähde tulee lisätä paikallisiin maven tietolähteisiin. Javaoctave toimii octaven ja javan välisenä siltana. Siirrä siis paketista löytyvä kansio 'JavaOctave' haluamaasi paikkaan ja suorita:

>mvn install:install-file -Dfile=~/JavaOctave/javaoctave-0.6.4.jar -DpomFile=~/JavaOctave/pom.xml

Lisätietoja <https://kenai.com/projects/javaoctave/pages/Home>
