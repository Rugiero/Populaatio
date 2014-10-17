Aihe: Toteutetaan ohjelma, mikä laskee annetun populaation kehityksen.
Ohjelma laskee taudin leviämisen laajuutta populaatiossa -- syntyykö siihen epidemia
, eli sairastuuko kaikki -- vai pysyykö tauti "kurissa". Alkuarvoissa annetaan
populaation koko, taudin leviämisalttius, ja parantumistodennäköisyys. Toisena
ominaisuutena ohjelma laskee annetuista peto- ja saaliseläinkannoista eläinten
populaation kehityksen eristetyssä ympäristössä, sekä ilmoittaa tasoittuuko populaatio "stabiiliin" tilassa,
vai onko pitkän aikavälin populaation kehitys ns. epästabiili, eli peto- ja 
saaliseläinkannat vaihtelevat pitkälläkin aikavälillä.

Käyttäjät: Opiskelija ja Kurssin vetäjät

Kaikkien käyttäjien toiminnot:
Anna populaatioiden parametrit, joihin kuuluu ainakin:
-Saaliseläinten, petoeläinten tai ihmisten määrä alussa.
-Populaation tiheys
-Saaliseläinten "tehokkuus"
-Lisääntymistahti
-taudin leviämisalttius


Pysäytä ohjelma





Rakennekuvaus:

Main- luokka käynnistää päävalikon. Päävalikosta voi valita SIR/SIS, peto-saaliseläin tilanteen, help tai poistu. SIR/SIS ja petosaalis käynnistää omat valikkonsa. Valikoihin voi asettaa haluamansa arvot ja laskea haluamansa tulokset.
"Piirrä käyrä" laskee ensin tulokset matematiikkaluokalla, minkä jälkeen se syöttää tulokset PiirraKayra- luokalle. Tämä piirtää JFreeChart- kirjastoa hyväksi käyttäen tuloksista käyrän. "Piirrä faasi" vastaavasti piirtää käyrän josta aika on redusoitu pois. Muut painikkeet käyttävät niin ikään matematiikka- luokkaa hyväksi. Syötteiden tulee olla numeroita nollasta ylöspäin, muuten ohjelma ei suostu laskemaan arvoja.


