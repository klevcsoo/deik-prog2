# Magas szintű programozási nyelvek *(2022. ősz)*

## OOP alapelvek

### Egységbezárás *(encapsulation)*

Az adatszerkezetet és az azon végrehalytható metódusokat
egy egységbe zárjuk, amelynek a neve az **osztály**. Az
osztály két részből áll: mezőből és metódusokból. A
mezők írják le az adatszerkezetet és a és a metódusok
az mezőkön végrehajtható műveleteket, azaz a viselkedést.

### Öröklődés *(inheritance)*

Minden osztálynak van ősosztálya, a gyermek mindent
megörököl az őstől. Java-ban 4 láthatósági szint van:

- **package:** kulcsszava nincs, default az osztályoknak,
  metódusoknak és a mezőknek, csomagon belül látható
- **public:** bárki láthatja, bárki használhatja
- **protected:** csak az öröklődési láncon belül látható
- **private:** csak az adott osztály láthatja és
  használhatja

Legegészségesebb, ha minden private és az adatszerkezetet
kívülről nem módosítjuk.
A osztály felfelé örökli a mezőket és a metódusokat is.

### Többalakúság *(polymorphism)*

Az objektumoknak több típusa is van és mindegyik típusként
használható. Például egy kutyát használhatunk kutyaként,
háziállatként, állatként és élőlényként is.
Az öröklödési láncon felfelé az osztály minden típusként
használható, beleértve az interfészeket is *(egy példány
bármelyik felületén keresztül használható)*.

Java-ban egyszeres öröklődés van, ezért vannak az
interfészek *(interface)*. Az öröklődés kulcsszava
az `extends`, az
interfész megvalósításé az `implements`.

Szemantikai nézőpontból az osztálynak van felülete *(
interface)* és megvalósítása *(implementation)*.

## OOP tulajdonságai

```java
public class Kutya {
    private String nev;
    private double suly;

    public Kutya() {
        this.nev = "Buski";
        this.suly = 5.2;
    }

    public String getNev() {
        return this.nev;
    }
}

public class Prog2 {
    public static void main(String[] args) {
        Kutya k1 = new Kutya();
        System.out.println(k1.getNev());
    }
}
```

Az öndokumentáló megjegyzés a programozói dokumentáció (
/**). A Java forrásból a JavaDoc HTML oldalt generál az
osztály API leírásához.
A Java a forrásból byte kódot fordít *(compile =
fordítás, `javac`-ben a "c" a compile-t jelenti)*. Ezután
a kódot egy JVM gép (Java Virtual Machine) futtatja
interpreter módon, azaz utasításról utasításra, azaz
menet közen interpretál. Emiatt a trükk miatt a
Javaból fordított kód nem közvetlenül a gépen fut,
hanem a gép oprendszere által futtatott VM-en.
Ez lehetővé teszi a hordozhatóságot,
platformfüggetlenséget. Így futhat különboző
architektúrákon. Ettől függetlenül a Java egy haldokló
nyelv.

### Belső állapot *(internal state)*

A belső állapot az a mezők pillanatnyi értéke. A felső
példában a k1.suly belső állapota 5.2. A belső állapot
kezdő értékét a constructor állítja be (kezdő állapot).
<br/>
Belső állapot szerint az osztály lehet:

- **stateless:** Állapot nélküli. Itt nincs egy mező sem.
- **immutable:** Megváltoztathatatlan. Itt vannak mezők,
  de csak a constructor állítja azokat.
- **mutable:** Megváltoztatható. Ha vannak setter-ek akkor
  mutable (de van kivétel).

> A `String` osztály immutable.

Ha módosítjuk az előző kódrészletet megfelelőképpen,
a `Kutya` osztályunk mutable lesz.

```java
public class Kutya {
    private String nev;
    private double suly;

    public Kutya() {
        this.nev = "Buski";
        this.suly = 5.2;
    }

    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}

public class Prog2 {
    public static void main(String[] args) {
        Kutya k1 = new Kutya();
        System.out.println(k1.getNev());
    }
}
```

Törekedni kell az osztályok megváltoztathatatlanságára.

### Viselkedés *(behaviour)*

Nem beszélünk viselkedésről, amíg nincs *if*. Ha nincs, a
megvalósítás és a viselkedés lényegében ugyanaz, de
mégsem. **
A megvalósítás a forráskód statikus vetülete, amíg a
viselkedés a forráskód dinamikus vetülete.** A
viselkedés a futó forráskód.
Mondjuk azt, hogy a kutya lehet mérges és nem mérges.

- mérges kutya: grrr grrr
- nem mérges kutya: vau vau

Ezek szerint módosíthatjuk a kódot.

```java
public class Kutya {
    private String nev;
    private double suly;
    private boolean merges;

    public Kutya() {
        this.nev = "Buski";
        this.suly = 5.2;
    }

    public String getNev() {
        return this.nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setMerges(boolean isMerges) {
        this.merges = isMerges;
    }

    public String ugat() {
        if (this.merges) {
            return "grrr grrr";
        } else {
            return "vau vau";
        }
    }
}

public class Prog2 {
    public static void main(String[] args) {
        Kutya k1 = new Kutya();
        System.out.println(k1.getNev());
        // > Buski

        k1.setMerges(true);
        System.out.println(k1.ugat());
        // > grrr grrr
    }
}
```

## A konstruktor *(constructor)*

A konstructor állítja be a kezdő állapotot. Olyan **
publikus** függvény, melynek a neve megegyezik az osztály
nevével és
visszatérési típusa nincs. Konstruktort nem kötelező írni,
de ha nem írunk akkor is van egy automatikus *(explicit)*
konstruktor képében, ami 0 paraméteres és egyetlen egy
dolgot csinál: az ős 0 paraméteres konstruktorát hívja. Ha
bármilyen konstruktort írunk, akkor explicit konstruktor
már nem él.

A konstruktorban illik minden mezőt beállítani, ugyanakkor
nem muszáj. Ha egy mezőnek nem adunk értéket
deklarációkor, és a konstruktorban sem, akkor a
mezőnek az értéke a típusának megfelelő
alapértelmezett érték lesz *( String: `null`, int: `0`,
boolean: `false`, double: `0.0`)*.

Különbség a lokális változó és a mező között: **lokális
változót érték nélkül nem lehet használni, viszont egy
mezőt igen**.

```java
class Main {
    public static void main(String[] args) {
        int i;
        System.out.println(i);
    }
}
// Hibaüzenet
```

Ha egy paraméter vagy egy locális változó megegyezik egy
mezővel, akkor a név mindig a paramétert vagy változóüt
fogja
jelenteni. Ennek kiküszöbölése képpen használjuk a `this`
kulcsszót. A `this` az aktuális példányra referál.
Ehhez hasonló a `super`, ami az aktuális példány
őspéldányára mutat.
A konstruktorokat hívási láncba lehet szervezni, a `this`
és a `super` kulcsszavak segítségével. Ilyenkor az egyik
kulcsszónak kell lennie az első szónak. Saját konstruktort
úgy kell hívni, hogy `this(current, parameter, list)`,
illetve ősnek konstruktorát úgy,
hogy `super(current, parameter, list)`.

Tegyük fel, hogy 4 mezőből 2 elhagyható. Ilyenkor szokás
csinálni egy 4 paraméteres konstruktort, illetve egy 2
paraméterest ami meghívja a 4 paraméterest.

Konstruktorból lehet konstruktort hívni, de csak az első
utasításként.

```java
class Rectangle {
    public double a, b, c, d;

    public Rectangle(
            double a, double b, double c, double d
    ) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    // Négyzetet hoz létre
    public Rectangle(double a) {
        this(a, a, a, a);

        // Nem szabad konstruktorban log-olni
        Logger.log("Új négyzet. Méret: " + a);
    }

    // Téglalapot hoz létre
    public Rectangle(double a, double b) {
        this(a, b);
    }
}
```

Általában vagy egy konstruktor ami beállítja az összes
mezőt, és azt azt követő kevesebb paraméterrel rendelkező
konstruktorok pedig azt hívják.

Példa:

```java
class Gerinces {
    protected double suly;

    public Gerinces(double suly) { // <- 2.
        this.suly = suly; // <- 3. (suly értéke 52.0)
    } // <- 4. (visszakapja a main)
}

class Kutya extends Gerinces {
    String nev;

    public Kutya(String nev, double suly) { // <- 8.
        this.nev = nev; // <- 9. (nev erteke "Buksi")
        super.suly = suly; // <- 10. (suly erteke 20.0)
        /*
         * De lehetne
         * this.suly = suly;
         * vagy
         * super(suly);
         */
    } // <- 11. (ismét visszakapja a main)

    public Kutya(String nev) { // <- 6.
        this(nev, 20.0); // <- 7.
    }
}

class Main {
    public static void main(String[] args) {
        Gerinces g1 = new Gerinces(52); // <- 1.
        Kutya k1 = new Kutya("Buksi"); // <- 5.
    } // <- 12. (vége a programnak)
}
```

Azt a `Kutya`-t amit létrehozunk, használhatjuk `Gerinces`
-ként is, és `Object`-ként is a többalakúság miatt.

## Megváltoztathatóság *(mutability)*

Általában minden mezőhöz csinálunk *getter*-t és *setter*
-t. Ha egy mező neve `suly` akkor a getter `getSuly` és a
setter neve `setSuly`.

```java
class Kutya {
    public String getNev() {
        return this.nev;
    }
}
```

```java
class Kutya {
    public void setNev(String nev) {
        this.nev = nev;
    }
}
```

Ennek az az értelme, hogy a belső állapotot felülírom. **
Csak saját metódussal, belülről módosíthatom a belső
állapotot,
mert az egységbezárás miatt védenem kell az adatot.**
Érdemes nem minden érdemes nem statikus, publicus mezőt
csinálni.
Onnantól kezdve, hogy vagy egy setter az osztályon belül,
az adott osztály már nem immutable. Ha egy olyan osztályt
kell létre hozni amit meg lehet változtatni, de mégis
immutable, akkor egy trükköt kell alkalmazni. A trükk
pedig az, hogy új példányt hozok létre a `new`
kulcsszóval. Szintaxis: `new Osztaly();`.
Itt a setter visszaadja az új, módosított osztályt.

```java
class Kutya {
    public Kutya setNev(String nev) {
        return new Kutya(nev, this.suly);
    }
}
```

**A `new` kuclsszó megfelelő mennyiségű helyet foglal a
dinamikus memóriában.** Pontosan annyi helyet foglal, ami
megfelelő az adott adattípusnak. Java-ban a `new`-nak
nincs párja, ami felszabadítja a memóriát, ehelyett, a
szemétgyűjtő *(garbage collector)* szabadítja fel. Az
indok erre az egyszerűség.
A `new` lefutattja ezután a konstruktort, aztán visszaadja
a referenciát a lefoglalt területre.

> ### Feladat
> Esszé: **Programming in small vs. programming in large**

### Automatikus memória allokáció a Java-ban:

| Technikai név | Magyar név | Tartalom              |
|---------------|------------|-----------------------|
| STACK         | verem      | pl.: lokális változók |
| HEAP          | halom      | dinamikus memória     |

## Öröklődés részletesebben

Java-ban minden osztálynak van ősosztálya, ezalól
kivétel `Object` osztály. **Java-ban minden metódus
virtuális azaz felülírható**, erre külön kulcssó nincs.
A virtuális metódusok kötése késői kötéssel történik
_(late binding)_. Az számít, hogy a referencia hova
mutat, nem az, hogy hol van.

```java
class Main {
    public static void main(String[] args) {
        Kutya k1 = new Vadaszkutya();
    }
}
```

A felső részlet akkor helyes, ha a `Vadászkutya`
gyermeke a `Kutya` osztálynak. Ez a részlet létre hoz
egy referenciát a `k1`-re. A `new Vadaszkutya()` lefoglal
a
dinamikus memóriában egy `Vadaszkutya` példányt, ahol
ennek a `Vadaszkutya` példánynak a belső állapotát
tárolja.
Visszaadja a referenciát erre a memóriaterületre, amit
megkap a `k1`; Így a példányt a `Kutya` felületén
keresztül nézem, de attól még a példány `Vadászkutya`;

```java
class Main {
    public static void main(String[] args) {
        Kutya k1 = new Vadaszkutya();
        k1.ugat();
    }
}
```

Ha körai kötés lenne, azaz az `ugat` metódis nem lenne
virtuális, akkor a `Kutya` osztály `ugat` metódusa futna
le. De mivel Java-ban minden metódus virtuális, ezért a
`Vadaszkutya`-nak az `ugat` metódusa fut le.

- milyen felületen keresztül nézem: **statikus**
- milyen felületre mutat: **dinamikus**

> Ismétlés: `new` után constructor hívás

A fennti példában `k1`:

- statikus típusa: **`Kutya`**
- dinamikus típusa: **`Vadaszkutya`**

```java
class Main {
    public static void main(String[] args) {
        Kutya k1 = new Vadaszkutya();
        k1.ugat();

        k1 = new Oleb();
        k1.ugat();
    }
}
```

A legutóbbi példában a `k1`:

- statikus típusa: **`Kutya`**
- dinamikus típusa: **`Oleb`**

Az `ugat` metódus az `Oleb` osztályból fut le, mert
késői kötés van.

### @Override

> Java régebbi verzióiban nem volt `@Override`, ezért ez
> nem kulcsszó, hanem programozói paradigma _(annotation)_
> .

```java
class Kutya {
    public String ugat() {
        return "vau vau";
    }
}

class VadaszKutya extends Kutya {
    @Override
    public String ugat() {
        return "vau vau vau";
    }
}

class Main {
    public static void main(String[] args) {
        Kutya k1 = new VadaszKutya();
        System.out.println(k1.ugat());
//        vau vau vau
    }
}
```

**Amit most csináltunk, az megszegi az OCP alapelveit.**
Az OCP alapelv az a SOLID alapelvek egyike. Az OCP
azt mondja:<br/>
_"Ne használd a ~~kibaszott~~ @Override annotációt,
mert ~~kibaszott~~ veszélyes, csak absztrakt metódus és
hook felülírására használd."_

> A hook metódus olyan metódus aminek van törzse, de a
> törzse üres, vagy csak egy return van benne. A hook-ba
> tesszük az opcionális viselkedést.

Az @Override-ot használni azért veszélyes, mert az
**öröklődés a legerősebb kapcsolat ami két osztály között
lehetséges**. Ami megkeseríti az életünket, az az
implemetation dependency. **Ha ez egyik osztályt
megváltoztatom, és vele implementációs függőségben van
egy másik osztály, akkor azt a másik osztályt is meg
kell változtatni.**

Az öröklődést szokták **"fehérdobozos
újrahasznosításnak"**
hívni _(white box reuse)_. Az OOP alapértéke az
újrahasznosíthatóság. Ha megírunk egy osztályt, aminek
kicsi mellékhatása van, akkor azt fel lehet használni
más helyeken is.

Akkor mondjuk, hogy **white box**, ha ismerjük a
forráskódot, ezzel ellentétben a **black box** esetén
nem ismerjük a forráskódot. Testing esetén mindkét
esetben ismerem a specifikációt.

Az a baj, hogy általában ismerem az ősnek a forráskódját,
szóval a gondolkodásmenet: rövid és gyorsan futó
programot szeretnék, amit elegánsnak érzek. **De attól a
perctől, hogy kihasználom, hogy az ős hogyan van
implementálva, attól a perctől a két osztály
implementációs függőségben van.**

Erre a megoldást úgy nevezik, hogy **GOF1** _(gang of
four)_.

> A GOF könyv alatt a _Programtervezési minták_ című
> könyvet
> értjük. Magyarul: _"méhecskés könyv"_.

**GOF1:** programozz felületre megvalósítás helyett, azaz
programozz úgy, hogy nem ismernéd a program többi
részének nem ismernéd a forráskódját, csak a felületét.

> Ebben a félévben az öröklődés a legjobb dolog a
> világon. Utána szar lesz.

**Az `@Override`-ot könnyű összekeverni az
_overloading_-al. Overloading esetén más lesz a
szignatúra.** Ha a szignatúrája alapjána fordító meg
tudja különböztetni akkor szabad.<br/>
Az overload-nak nincs kulcsszava, egész egyszerűen
újra írom a függvényt más szignatúrával.<br/>
**Az override-nak sem muszáj használni az annotációját,
nem generál error-t, csak warning-ot.**

A _long literal_ úgy néz ki, hogy `0L`, azaz szám után
egy nagy L betű.

### Az öröklődés megtiltása

Java-ban az öröklődést megtilthatom a `final`
kulcsszóval. Ha azt mondom, hogy `final class Kutya {}`,
akkor a `Kutya`-nak nem lehetnek leszármazottjai.

> Ha egy mező elé írjuk, hogy `final`, akkor az a mező
> konstans. C#-ban úgy mondjuk, hogy _le van pecsételve_
> az osztály, azaz _the class is **sealed**_.

Például `String`-ből nem lehet örökölni. A polimofizmus
miatt bármelyik alosztályt lehetne adni oda, ahol valami
`String`-et vár. Ez nem biztonságos.

Ha nem `final` az osztály, akármennyi gyermeke lehet.

## Absztrakt osztály

Absztrakt osztály szintaxisa: `abstract class Kutya`.
Ezekből nem lehet származtatni más osztályt, de ettől
még lehet konstruktora.

Kettő tulajdonsága van:

- van felülete
- és **lehet** megvalósítása

A különbség a _lehet_ szóban van, az absztrakt
osztálynak nem muszáj, megvalósítást létrehozni.
Absztrakt osztályban lehet absztrakt metódus. Ennek
ugyanúgy a kulcsszava az `abstract`, nincs törzse csak
feje.

```java
public abstract class Kutya {
    public abstract String ugat();
}
```

A viselkedés kidolgozását ráhagytam a
gyermekosztályokra. Csak azt mondtam meg, hogy a kutya
tud ugatni, de azt nem, hogy hogyan. **A nem absztrakt
gyermekosztályoknak az ős minden absztrakt metódusát
ki kell dolgoznia**, azaz a `VadászKutya`-nak meg kell
mondania, hogy ő hogyan ugat, az `@Override` annotáció
segítségével.

- A `VadaszKutya`-nak ki kell dolgoznia az `ugat`
  metódust.
- A `VadaszKutya`-nak meg kell adnia az `ugat` metódus
  viselkedését.

Egy absztrakt osztályban lehet absztrakt és
kidolgozott metódus is, de absztrakt metódus csak
absztrakt osztályban lehetséges. Ez azt jelenti, hogy
a metódusnak van szerződése, törzse nincs.

### Szerződés alapú programozás

**DESIGN BY CONTRACT**<br/>
Minden metódusnak van elő- és utófeltétele. Az
előfeltétel megmondja, milyen paramétereket vár, az
utófeltétel megmondja, milyen értéket ad vissza.

### Az `Object` főosztály

Az `Object`-ból rengeteg dolgot örököl az osztály.
Minden hierarchia tetején az `Object` osztály áll.

- **`toString`**: a belső állapotot `String` ként
  reprezentálva visszaadja
- **`equals`**: két objektum összehasonlítása, akkor
  ad igazat, ha a két példány belső állapota ugyan az
  (`Object`-et kap paraméterként)
- **`hashCode`**
- **`clone`**: létrehozz egy ugyan olyan belső
  állapotú objektumot, de egy másik memóriaterületen
  (`Object`-et ad visszatérési értékként)

## Belső osztály

```java
class A {
    class B {
    }
}
```

Külső osztály lehet `public` és `package` láthatósági
szintű, külső osztály nem lehet `private` sem `protected`,
sem statikus. Ugyanakkor, a külső osztály lehet
`abstract` és `final`.

> #### Vizsgakérdés:
> **Lehet-e külső osztály `final abstract`?**<br/>
> Nem, mert a külső osztály ha nincs kidolgozva és a
> gyermekre marad a kidolgozás, akkor nem lehet
> `final`, mert annak nem lehet gyermeke.

A `final` kulcsszóval

- konstansot lehet vele csinálni, ha mező előtt áll
- lezárt osztályt lehet csinálni vele, aminek nem
  lehet gyermeke
- olyan metódust lehet csinálni vele, amit nem lehet
  felülírni.

A konstans létrehozása: `public static final`. Azért
nem csinálunk `public` mezőt, hogy véletlenül nehogy
globális változót csináljunk. Ha valami `public
static`, akkor az globális változó.

```java
class SzorosKiskutya {
    public static final int I;
}

class Main {
    public static void main(String[] args) {
        System.out.println(SzorosKiskutya.I);
    }
}
```

Ha egy globális változó értékét megváltoztatjuk, akkor
az **mellékhatás**, ami nehezen megtalálható hibákhoz
vezethet.

Ha példány szintű konstanst csinálunk, akkor nem kell
`static` elé. Ilyenkor nem muszáj megadni az értékét
egyből, az történhet a konstruktorban is.

A statikus
blokk kulcsszava a `static`, de utána egyből `{`
karakter indul. Ez lefut az osztály betöltődésekor, de
csak akkor (program futása kezdetén). Ezt arra
használjuk, hogy a statikus mezőknek értéket adjunk.

```java
class Kutya {

    // osztály szintű konstans
    public static final int LABAK_SZAMA;

    static {
        LABAK_SZAMA = 4;
    }
}
```

Absztakt esetben:

```java
abstract class Cica {
    private String nyavogas;
    private double ehsegSzint;

    public Cica() {
        this.ehsegSzint = 10;
    }

    public abstract void setNyavogas(String x);
}

class Main {
    public static void main(String[] args) {
        Cica c1 = new Cica(); // hiba
        // Absztrakt osztályból nem lehet példányt 
        // csinálni

        Cica c2 = new Cica() {
            @Override
            public void setNyavogas(String x) {
                System.out.println("miau");
            }
        };
    }
}
```

**Absztakt osztályból, ha példányosítani akarunk, akkor
a példány deklarálásának konstruktora után felül kell
írni az absztakt metódusokat.**

### Ténylegesen akkor a belső osztályokról

Belső osztályt azért hozzuk létre, mert kell egy
adatszerkezet, amelyhez senkinek semmi köze.

**Például:**<br/>
Kivülről vannak _x_ és _y_ koordinátáim, amik
nincsenek összefogva kívülről, de belülről igen.

Akkor érdemes **nem** statikussá tenni a belső
osztályt, ha nem kell, hogy hozzáférjen a külső
osztály belső állapotához. **De amúgy mindig jobb ötlet
valamilyen módon statikus belső osztályt csinálni.**

```java
import java.util.ArrayList;
import java.util.List;

class Gorbe {
    private static class Pont {
        // mivel nem tárolunk semmit itt ami a Gorbe
        // osztály belső állapotához kapcsolódna,
        // ez az osztály lehet static
        public double x, y;
    }

    private List<Pont> feszitoPontok = new ArrayList<>();

    public void ujFeszitopont(double x, double y) {
        Pont p1 = new Pont();
        p1.x = x;
        p1.y = y;
        this.feszitoPontok.add(p1);
    }
}
```

> Belső osztályban nyugodtan lehet publikus mezőt
> csinálni főleg, ha a belső osztály privát.

Jövőbe tekintve fontos:

- generikus adatszerkezet: `GenericClass<Type>`
- `Collection`
- konténerosztály

#### Csináljunk hülyeséget!

Rákényszerítjuk a program többi részét, hogy a `Pont`
osztályt használja két `double` helyett.

1. Publikussá teszem a belső, `Pont` osztályt
2. Nem statikussá teszem a `Pont` osztályt
3. Az `ujFeszitopont` metódus paramétere `Pont` típusú
   lesz

```java
import java.util.ArrayList;
import java.util.List;

class Gorbe {
    public class Pont {
        public double x, y;
    }

    private List<Pont> feszitoPontok = new ArrayList<>();

    public void ujFeszitopont(Gorbe.Pont p) {
        this.feszitoPontok.add(p);
    }
}

class Main {
    public static void main(String[] args) {
        Gorbe g1 = new Gorbe();

        // nem statikus belső osztály
        // rákényszerítem a belső állapotot a világra
        // hülyeség, undorító syntax
        Gorbe.Pont p1 = g1.new Pont();
        p1.x = 3.0;
        p1.y = 2.0;

        g1.ujFeszitopont(p1);
    }
}
```

#### Mi van akkor, ha nem lehet statikus a belső osztály?

```java
class Kiskutya {
    class X {
        public double c;
        public long tick;

        public void update() {
            // emiatt nem lehet X statikus,
            // felhasználja a külső osztály ezen 
            // példányának belső állapotát (a és b mező)
            this.c = a + b;
        }
    }

    private double a, b;

    // ha nem initializáljuk az ido mezőt,
    // akkor NullPointerException-t kapunk
    private X ido = new X();

    public void tellikAzIdo() {
        this.ido.tick++;
        this.ido.update();
    }
}
```

> #### Vizsgakérdés:
> **Mit jelent az, hogy a felületre ki van vezetve egy
> szolgáltatás?**<br/>
> A felületre ki van vezetve egy publikus szolgáltatás
> metódus.

## Kivételkezelés

## Generikus osztályok

## Konténerek
