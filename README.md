# intern-assignment-emarsys

Ivanics Szilárd

###Technológia: 
JavaSE 1.8, Maven, Junit

Alapos tervezést, próbálgatást követően TDD - ben valósítottam meg az implementációt.

A megvalósítás alap ötlete: 

Irányított gráfként értelmeztem a problémát, ahol nincsenek körök. Amelyik elemnek nincs függősége az a "legközelebbi" abban az irányban. A legtávolabbi pontok azok a helyszínek, amik nincsenek benne a függőségek halmazában. A legtávolabbi helyről be lehet járni az utat rekurzívan.
 
Használat:

A Location osztály adja a vázat a bemenő és a kimenő adatoknak. Példányosítás után külön meg kell hívni a setCloserLocation() metódust a függőség beállításához. 
 A RouteOptimization osztály opcionálisan bármennyi Location paramétert fogad, hogy kiszámolja az optimális utat. Az optimális utat (a kimenetet) a getOptimalRoute() metódussal tudjuk lekérdezni.

