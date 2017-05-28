package hu.unideb.sleepysam.controller;

import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;

import java.util.Random;

/**
 * Created by vtibi on 5/21/2017.
 */
public class SituationFactory {
    public static Situation getRandomSituation() {
        Random rand = new Random();
        int r = rand.nextInt(6);
        int index = 0;

        switch (r) {
            // Aszteroida
            case 0: {
                return new Situation(
                        "Az utad egy aszteroida-mezőn keresztül vezet. Áthaladni rajta veszélyes, de az a legrövidebb út, viszont van más lehetőség is.",
                        new Option(
                                "Áthaladsz az aszteroida-mezőn.",
                                "A merészségnek ára van. Egy aszteroida nekicsapódott a hajónak és a legénység egy tagja életét vesztette.",
                                0, 0, -1
                        ),
                        new Option(
                                "Kikerülöd a mezőt, a hosszabb utat választva.",
                                "Biztonságban kikerülted a mezőt, de ez az üzemanyag kárára ment.",
                                -2, 0, 0
                        ),
                        new Option(
                                "A hajó fegyverzetét felhasználva áttörsz az aszteroidákon.",
                                "Sikeresen utat törtél az aszteroidák között, így biztonságban áthaladhadtál.",
                                -1, 0, 0
                        )
                );
            }
            // Benzinkut_jo
            case 1: {
                return new Situation(
                        "Egy intergalaktikus benzinkúthoz érkeztél, mely a Scion 7 bolygó körül kering.",
                        new Option(
                                "Csak arra koncentrálsz, hogy benzint vegyél.",
                                "Továbbhaladsz...",
                                1, 0, 0
                        ),
                        new Option(
                                "Megpróbálsz lealkudni a benzin árából.",
                                "Szerencsére szimpatizált veled a benzinkutas, így engedett a benzin árából.",
                                2, 0, -1
                        ),
                        new Option(
                                "Úgy ítéled meg, hogy nincs szükséged benzinre.",
                                "Továbbhaladsz...",
                                0, 0, 0
                        )
                );
            }
            //Benzinkut_rossz
            case 2: {
                return new Situation(
                        "Egy intergalaktikus benzinkúthoz érkeztél, mely a Xeutera bolygó körül kering.",
                        new Option(
                                "Csak arra koncentrálsz, hogy benzint vegyél.",
                                "Továbbhaladsz...",
                                1, 0, 0
                        ),
                        new Option(
                                "Megpróbálsz lealkudni a benzin árából.",
                                "A kutas nem veszi jó néven ezt. Hívja a biztonságiakat, azok pedig kidobnak az állomásról.",
                                -1, 0, 0
                        ),
                        new Option(
                                "Úgy ítéled meg, hogy nincs szükséged benzinre.",
                                "Továbbhaladsz...",
                                0, 0, 0
                        )
                );
            }
            // Benzinkut_tamadas
            case 3: {
                return new Situation(
                        "Egy intergalaktikus benzinkúthoz érkeztél, mely a Frutoria bolygó körül kering. A benzinkút éppen kalózok támadása alatt áll.",
                        new Option(
                                "Az egész legénységgel közbeavatkoztok, megpróbáljátok megállítani a kalózokat.",
                                "Sikeresen megállítottátok a támadást, viszont ez a legénység egy emberének életébe került. A munkások megjutalmaznak hősies cselekdeteidért. ",
                                0, 0, -1
                        ),
                        new Option(
                                "Megpróbálod diplomatikusan elrendezni a konfliktust.",
                                "Sikeresen meggyőzöd a kalózokat arról, hogy térjenek jó útra. Elhagyják az állomást. A munkások megjutalmaznak hősies cselekedeteidért. ",
                                0, 1, 0
                        ),
                        new Option(
                                "Nem avatkozol közbe, folytatod utadat.",
                                "Továbbhaladsz...",
                                0, 0, 0
                        )
                );
            }
            // Urallomas
            case 4: {
                return new Situation(
                        "Egy Intergalaktikus Űrállomás jelét fogja be a radar. Úgy döntesz, hogy szükség van egy pihenőre egy biztonságos helyen.",
                        new Option(
                                "Beállsz a sorba az ételcsomag-osztáshoz.",
                                "Továbbhaladsz...",
                                0, 1, 0
                        ),
                        new Option(
                                "Megnézed az önkéntesek listáját és kiválasztod az egyik dolgozni vágyó embert.",
                                "Továbbhaladsz...",
                                0, 0, 1
                        ),
                        new Option(
                                "Megtöltöd a tankot benzinnel.",
                                "Továbbhaladsz...",
                                1, 0, 0
                        )
                );
            }
            // Kocsma
            case 5: {
                return new Situation(
                        "A legénységnek kijár a szórakozás. Útbaejtesz egy űrkocsmát.",
                        new Option(
                                "Beszélgetésbe elegyedsz a kocsmában lévőkkel.",
                                "Meghívnak egy közös falatozásra, a maradékot pedig elteszed rosszabb időkre.",
                                0, 1, 0
                        ),
                        new Option(
                                "Együtt töltöd el az estét a legénységgel.",
                                "Pohár poharat követ, aminek fejfájós másnaposság a következménye. Ennek a kezelésére pedig extra adag ételre van szükség.",
                                0, -1, 0
                        ),
                        new Option(
                                "Hagyod, hogy a legénység szórakozzon.",
                                "Az este során a hangulat bedurvul, a legénység egyik viccét túl komolyan veszik. Kocsmai verekedés robban ki, mely során az egyik embered életét is veszti.",
                                0, 0, -1
                        )
                );
            }
        }
        return null;
    }
}