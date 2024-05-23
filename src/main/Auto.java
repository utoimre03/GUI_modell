package main;

/* SPECIFIKÁCIÓ:
Ha egy autóval megyünk, akkor elfogy az üzemanyag. 
Ha tankoltunk, akkor újra tudunk menni, lesz üzemanyag.
Csak akkor tudunk menni, ha be van indítva az autó.
Csak akkor tudunk tankolni, ha le van állítva az autó.
TODO:
Van pótkerék, kaphatunk defektet, lehet kereket cserélni:
 - Meg lehet adni a pótkerekek számát (lehet 0 is), ha nem adjuk meg, akkor 1.
 - Ha megy az autó 20% eséllyel kaphat defektet!
 - Ha defektet kapott, nem fogy el az üzemanyag!
 - Nem csak defektes kereket cserélhetünk!
 - Ha lecseréltük a defektes kereket, csökken a pótkerekek száma!
 - Ha nincs több pótkerék, nem tudunk cserélni többet! 
 - Defekttel nem haladhatunk!
//// specifikáció vége */

public class Auto {
    /* ADATTAGOK */
    private static int objektumDb = 0; //osztály adattagja, lehet itt inicializálni

    static void setBeinditva() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /* objektum adattagokat a konstruktor inicializál: */
    private boolean uzemanyag; //példány v. másnéven az objektum adattagja
    private boolean beinditva; //példány v. másnéven az objektum adattagja

    private boolean defekt;
    private int potkerek;
    
    /* TAGFÜGGVÉNYEK */
    /* kstr hívási lánc: túlterhelt kstr hívja a másik kstr-t */
    public Auto(){
        /* semmi nem lehet a kstr. hívás előtt, mert nem fordul le! */
        //int i = 7;
        
        /* kstr csak kstr-ból hívunk, this kulcsszóval, nem a nevével */
        this(true, false);
    }
    
    public Auto(boolean beinditva){
        this(false, beinditva);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva){
        this(uzemanyag, beinditva, 1);
    }
    
    public Auto(boolean uzemanyag, boolean beinditva, int potkerek){
        Auto.objektumDb++;
        this.uzemanyag = uzemanyag;
        this.beinditva = beinditva;
        this.potkerek = potkerek;
        this.defekt = false;
    }
    
    public void setBeinditva(boolean beinditva){
        /* lehetne további ellenőrzés, pl.:
        csak akkor lehet beindítani, ha van üzemanyag
        */
        this.beinditva = beinditva;
    }
    
     public void megyEselyDefektre(){
        megyEselyDefektre(.2);
    }
    
    public void megyEselyDefektre(double esely){
        if (beinditva && uzemanyag && !defekt) {
            if(Math.random() < esely){
                defektetKap();
            }else{
                megy();
            }
        }
    }
    
    //setUzemanyag(false)
    public void megy(){
        if (beinditva && uzemanyag && !defekt) {
           this.uzemanyag = false;
        }
    }
    
    //setUzemanyag(true)
    public void tankol(){
        if (!beinditva) {
            this.uzemanyag = true;
        }
    }
    
    public void kerekCsere(){
        if (defekt && potkerek > 0) {
            this.defekt = false;
            potkerek--;
        }
    }
    
    public void defektetKap(){
        this.defekt = true;
    }

    public boolean isUzemanyag() {
        return uzemanyag;
    }

    public boolean isDefekt() {
        return defekt;
    }

    public int getPotkerek() {
        return potkerek;
    }


    public boolean isBeinditva() {
        return beinditva;
    }
}

