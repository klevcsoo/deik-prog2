# Magas szintű programozási nyelvek *(2022. ősz)*

## OOP alapelvek

### Egységbezárás *(encapsulation)*
Az adatszerkezetet és az azon végrehalytható metódusokat egy egységbe zárjuk, amelynek a neve az **osztály**. Az osztály két részből áll: mezőből és metódusokból. A mezők írják le az adatszerkezetet és a és a metódusok az mezőkön végrehajtható műveleteket, azaz a viselkedést.

### Öröklődés *(inheritance)*
Minden osztálynak van ősosztálya, a gyermek mindent megörököl az őstől. Java-ban 4 láthatósági szint van:
 - **package:** kulcsszava nincs, default az osztályoknak, metódusoknak és a mezőknek, csomagon belül látható
 - **public:** bárki láthatja, bárki használhatja
 - **protected:** csak az öröklődési láncon belül látható
 - **private:** csak az adott osztály láthatja és használhatja

Legegészségesebb, ha minden private és az adatszerkezetet kívülről nem módosítjuk.
A osztály felfelé örökli a mezőket és a metódusokat is.

### Többalakúság *(polymorphism)*
Az objektumoknak több típusa is van és mindegyik típusként használható. Például egy kutyát használhatunk kutyaként, háziállatként, állatként és élőlényként is.
Az öröklödési láncon felfelé az osztály minden típusként használható, beleértve az interfészeket is *(egy példány bármelyik felületén keresztül használható)*.

Java-ban egyszeres öröklődés van, ezért vannak az interfészek *(interface)*. Az öröklődés kulcsszava az `extends`, az interfész megvalósításé az `implements`.

Szemantikai nézőpontból az osztálynak van felülete *(interface)* és megvalósítása *(implementation)*.

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

Az öndokumentáló megjegyzés a programozói dokumentáció (/**). A Java forrásból a JavaDoc HTML oldalt generál az
osztály API leírásához.
A Java a forrásból byte kódot fordít *(compile = fordítás, `javac`-ben a "c" a compile-t jelenti)*. Ezután a kódot egy JVM gép (Java Virtual Machine) futtatja interpreter módon, azaz utasításról utasításra, azaz menet közen interpretál. Emiatt a trükk miatt a Javaból fordított kód nem közvetlenül a gépen fut, hanem a gép oprendszere által futtatott VM-en. Ez lehetővé teszi a hordozhatóságot, platformfüggetlenséget. Így futhat különboző architektúrákon.
Ettől függetlenül a Java egy haldokló nyelv.

### Belső állapot *(internal state)*

A belső állapot az a mezők pillanatnyi értéke. A felső példában a k1.suly belső állapota 5.2. A belső állapot kezdő értékét a constructor állítja be (kezdő állapot).<br/>
Belső állapot szerint az osztály lehet:
 - **stateless:** Állapot nélküli. Itt nincs egy mező sem.
 - **immutable:** Megváltoztathatatlan. Itt vannak mezők, de csak a constructor állítja azokat.
 - **mutable:** Megváltoztatható. Ha vannak setter-ek akkor mutable (de van kivétel).

 > A `String` osztály immutable.

Ha módosítjuk az előző kódrészletet megfelelőképpen, a `Kutya` osztályunk mutable lesz.

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
Nem beszélünk viselkedésről, amíg nincs *if*. Ha nincs, a megvalósítás és a viselkedés lényegében ugyanaz, de mégsem. **A megvalósítás a forráskód statikus vetülete, amíg a viselkedés a forráskód dinamikus vetülete.** A viselkedés a futó forráskód.
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
            return "grrr grrr"
        } else {
            return "vau vau"
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
A konstructor állítja be a kezdő állapotot. Olyan **publikus** függvény, melynek a neve megegyezik az osztály nevével és visszatérési típusa nincs. Konstruktort nem kötelező írni, de ha nem írunk akkor is van egy automatikus *(explicit)* konstruktor képében, ami 0 paraméteres és egyetlen egy dolgot csinál: az ős 0 paraméteres konstruktorát hívja. Ha bármilyen konstruktort írunk, akkor explicit konstruktor már nem él.

A konstruktorban illik minden mezőt beállítani, ugyanakkor nem muszáj. Ha egy mezőnek nem adunk értéket deklarációkor, és a konstruktorban sem, akkor a mezőnek az értéke a típusának megfelelő alapértelmezett érték lesz *(String: `null`, int: `0`, boolean: `false`, double: `0.0`)*.

Különbség a lokális változó és a mező között: **lokális változót érték nélkül nem lehet használni, viszont egy mezőt igen**.
```java
int i;
System.out.println(i);
// Hibaüzenet
```

A konstruktorokat hívási láncba lehet szervezni, a `this` és a `super` kulcsszavak segítségével. Ilyenkor az egyik kulcsszónak kell lennie az első szónak. Saját konstruktort úgy kell hívni, hogy `this(current, parameter, list)`, illetve ősnek konstruktorát úgy, hogy `super(current, parameter, list)`.

Tegyük fel, hogy 4 mezőből 2 elhagyható. Ilyenkor szokás csinálni egy 4 paraméteres konstruktort, illetve egy 2 paraméterest ami meghívja a 4 paraméterest.

Konstruktorból lehet konstruktort hívni, de csak az első utasításként.
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
