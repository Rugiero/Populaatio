
<h1>Populaatio</h1>

Populaatio- ohjelma laskee populaatioiden kehitystä annetuista alkuarvoista suljetussa systeemissä. Ohjelma approksimoi numeerisesti differentiaaliyhtälöite Runge-Kutan menetelmällä octavessa. Valittavana on influenssan kehitys tai peto- saaliskantojen kehitys.

Ohjelma käyttää matematiikassa apuna octavea, joten ennen kuin ajat ohjelman varmista että sinulla on octave asennettuna. Käyrien piirtoon käytetään apuna JFreeGarph- nimistä kirjastoa, mutta se on sisällytetty pakettiin. Katso ReadMe.

<h2>Mallit:</h2>

<h3>SIS</h3> – Laskee taudin kehityksen annetuista alkuarvoista. Populaation jäsenet kuuluvat joko luokkaan 'sairastuneet' (I) tai 'sairaudelle alttiit' (S).  Jäsenet siirtyvät siis luokissa S → I → S → I jne.

<h3>SIR</h3> – Laskee taudin kehityksen annetuista alkuarvoista kun populaation jäsenet saavat taudin sairastettuaan pysyvän immuniteetin, ja siirtyvät siis sairastuneiden luokasta (I) immuniteetin saaneiden luokkaan  S → I → R. Lisätietoja SIR ja SIS- malleista englanniksi <http://en.wikipedia.org/wiki/Epidemic_model>


<ul>

Alkuarvot:

<li>N – Populaation koko.</li>
<li>I – Sairastuneita aluksi.</li>
<li>a – Parantumistodennäköisyys aikayksikköä kohden.</li>
<li>B – Tarttumisintesiteetti.</li>
</ul>

<ul>
Valinnat:

<li>R – Laskee kuinka monta henkilöä keskimäärin yksi sairastunut sairastuttaa.</li>
<li>Näytä kehitys – Piirtää diagrammin lasketuista arvoista ajan funktiona.</li>
<li>Laske raja-arvo – SIS- mallissa antaa sairastuneiden määrän kun aika menee äärettömään. SIR- mallissa laskee sairastuneiden määrän kokonaisuudessaan kun aika menee äärettömään. Huom: SIR- mallin raja-arvo ei ole eksakti vaan voi riippua valitsemastasi ajasta.</li>
<li>Laske sairastuneita enimmillään – Laskee sairastuneiden suurimman 'piikin'. Voi riippua valitsemastasi ajasta.</li>
<li>Näytä faasidiagrammi – Piirtää faasidiagrammin (S,I) lasketuista arvoista.</li>
</ul>

Arvoiksi voi valita minkä tahansa reaaliluvun tasan tai yli nolla. Biologista tulkintaa tosin ei tietenkään löydy jos esimerkiksi I >N. Arvot ovat tässä yksiköttömiä. 
Infektoitumisvoima F = B*I on määritelmän mukaan alttiin yksilön todennäköisyys tulla tartutetuksi aikayksikköa kohti. Tämä vastaa kemiallisen kinetiikan massavaikutuksen lakia.

Esimerkkiavoja:  N=50 I=1 B=0.015 a=0.1


<h3>Lotkan ja Volterran peto-saalismalli</h3>
Laskee petoeläinten ja saalieläinten kantojen kehityksen suljetussa populaatiossa. Oletuksena saaliilla on ravintoa mielivaltaisen paljon. Lisätietoja  
<http://fi.wikipedia.org/wiki/Lotkan%E2%80%93Volterran_yht%C3%A4l%C3%B6>

<ul>
Alkuarvot:

<li>F – Petojen määrä alussa.</li>
<li>R – Saaliiden määrä alussa.</li>
<li>a – Saaliiden lisääntymistahti.</li>
<li>b – Petojen tehokkuus suhteessa saaliiden määrään.</li>
<li>c – Petojen lisääntymistahti suhteessa saaliiden määrään.</li>
<li>d – Petojen kuolleisuus.</li>
</ul>

<ul>
Valinnat:

<li>Laske tasapainopiste – Laskee populaatioiden tasapainopisteen annetuilla alkuarvoilla.</li>
<li>Näytä Faasi ­– Piirtää faasidiagrammin (F,R)</li>
<li>Näytä kehitys – Piirtää diagrammin lasketuista arvoista ajan funktiona.</li>
<li>Laske Min/max pedot – Laskee petojen maksimimäärän lasketuista arvoista.</li>
<li>Laske Min/max saaliit – Laskee saaliiden maksimimäärän lasketuista arvoista.</li>
</ul>



Arvoiksi voi jälleen valita minkä tahansa reaaliluvun tasan tai yli nolla. Arvot ovat tässä yksiköttömiä.
Arvoilla F = 0 saaliiden määrä kasvaa eksponentiaalisesti. Arvolla R =0 pedot kuolevat sukupuuttoon. Sukupuuttokuolema ei ole tässä teoriassa muuten mahdollinen.

Esimerkkiarvoja:
 F=3.5 R=1.8 a=0.3 b=0.1 c=0.1 d=0.2
