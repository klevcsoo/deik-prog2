# Magas szintű programozási nyelvek *(2022. ősz)*

## OOP alapelvek

### Egységbezárás *(encapsulation)*

Az adatszerkezetet és az azon végrehalytható metódusokat egy
egységbe zárjuk, amelynek a neve az **osztály**. Az osztály
két részből áll: mezőből és metódusokból. A mezők írják le
az adatszerkezetet és a és a metódusok az mezőkön
végrehajtható műveleteket, azaz a viselkedést.

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
    public static void main() {
        Kutya k1 = new Kutya();
        System.out.println(k1.getNev());
    }
}
```

Az öndokumentáló megjegyzés a programozói dokumentáció (/**)
. A Java forrásból a JavaDoc HTML oldalt generál az
osztály API leírásához.
A Java a forrásból byte kódot fordít *(compile =
fordítás, `javac`-ben a "c" a compile-t jelenti)*. Ezután a
kódot egy
JVM gép (Java Virtual Machine) futtatja interpreter módon,
azaz utasításról utasításra, azaz menet közen interpretál.
Emiatt a trükk miatt a Javaból fordított kód nem közvetlenül
a gépen fut, hanem a gép oprendszere által futtatott VM-en.
Ez lehetővé teszi a hordozhatóságot, platformfüggetlenséget.
Így futhat különboző architektúrákon.
Ettől függetlenül a Java egy haldokló nyelv.

### Belső állapot *(internal state)*

A belső állapot az a mezők pillanatnyi értéke. A felső
példában a k1.suly belső állapota 5.2. A belső állapot kezdő
értékét a constructor állítja be (kezdő állapot).<br/>
Belső állapot szerint az osztály lehet:

- **stateless:** Állapot nélküli. Itt nincs egy mező sem.
- **immutable:** Megváltoztathatatlan. Itt vannak mezők, de
  csak a constructor állítja azokat.
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
    public static void main() {
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
viselkedés a forráskód dinamikus vetülete.** A viselkedés a
futó
forráskód.
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
    public static void main() {
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
bármilyen konstruktort írunk, akkor explicit konstruktor már
nem él.

A konstruktorban illik minden mezőt beállítani, ugyanakkor
nem muszáj. Ha egy mezőnek nem adunk értéket deklarációkor,
és a konstruktorban sem, akkor a mezőnek az értéke a
típusának megfelelő alapértelmezett érték lesz *(
String: `null`,
int: `0`, boolean: `false`, double: `0.0`)*.

Különbség a lokális változó és a mező között: **lokális
változót érték nélkül nem lehet használni, viszont egy mezőt
igen**.

```java
class Main {
    public static void main() {
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
A konstruktorokat hívási láncba lehet szervezni, a `this` és
a `super` kulcsszavak segítségével. Ilyenkor az egyik
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

    public Rectangle(double a, double b, double c, double d) {
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

Általában minden mezőhöz csinálunk *getter*-t és *setter*-t.
Ha egy mező neve `suly` akkor a getter `getSuly` és a setter
neve `setSuly`.

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
Onnantól kezdve, hogy vagy egy setter az osztályon belül, az
adott osztály már nem immutable. Ha egy olyan osztályt kell
létre hozni amit meg lehet változtatni, de mégis immutable,
akkor egy trükköt kell alkalmazni. A trükk pedig az, hogy új
példányt hozok létre a `new` kulcsszóval.
Szintaxis: `new Osztaly();`.
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
megfelelő az adott adattípusnak. Java-ban a `new`-nak nincs
párja, ami felszabadítja a memóriát, ehelyett, a
szemétgyűjtő *(garbage collector)* szabadítja fel. Az indok
erre az egyszerűség.
A `new` lefutattja ezután a konstruktort, aztán visszaadja a
referenciát a lefoglalt területre.

> ### Feladat
> Esszé: **Programming in small vs. programming in large**

### Automatikus memória allokáció a Java-ban:

| Technikai név | Magyar név | Tartalom              |
|---------------|------------|-----------------------|
| STACK         | verem      | pl.: lokális változók |
| HEAP          | halom      | dinamikus memória     |
