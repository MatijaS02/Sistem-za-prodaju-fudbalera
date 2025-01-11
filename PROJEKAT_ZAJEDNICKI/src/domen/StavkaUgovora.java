/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Matija
 */
public class StavkaUgovora implements ApstraktniDomenskiObjekat {
    private Ugovor ugovor;
    private int rb;
    private double cenaIgraca;
    private double bonusZaGol;
    private double bonusZaAsist;
    private Igrac igrac;

    public StavkaUgovora() {
    }

    public StavkaUgovora(Ugovor ugovor, int rb, double cenaIgraca, double bonusZaGol, double bonusZaAsist, Igrac igrac) {
        this.ugovor = ugovor;
        this.rb = rb;
        this.cenaIgraca = cenaIgraca;
        this.bonusZaGol = bonusZaGol;
        this.bonusZaAsist = bonusZaAsist;
        this.igrac = igrac;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public double getCenaIgraca() {
        return cenaIgraca;
    }

    public void setCenaIgraca(double cenaIgraca) {
        this.cenaIgraca = cenaIgraca;
    }

    public double getBonusZaGol() {
        return bonusZaGol;
    }

    public void setBonusZaGol(double bonusZaGol) {
        this.bonusZaGol = bonusZaGol;
    }

    public double getBonusZaAsist() {
        return bonusZaAsist;
    }

    public void setBonusZaAsist(double bonusZaAsist) {
        this.bonusZaAsist = bonusZaAsist;
    }

    public Igrac getIgrac() {
        return igrac;
    }

    public void setIgrac(Igrac igrac) {
        this.igrac = igrac;
    }

    @Override
    public String toString() {
        return "StavkaUgovora{" + "ugovor=" + ugovor + ", rb=" + rb + ", cenaIgraca=" + cenaIgraca + ", bonusZaGol=" + bonusZaGol + ", bonusZaAsist=" + bonusZaAsist + ", igrac=" + igrac + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.ugovor);
        hash = 53 * hash + this.rb;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaUgovora other = (StavkaUgovora) obj;
        if (this.rb != other.rb) {
            return false;
        }
        return Objects.equals(this.ugovor, other.ugovor);
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaugovora";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ugovor,rb,cenaIgraca,bonusZaGol,bonusZaAsist,igrac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return ugovor.getIdUgovor()+","+rb+","+cenaIgraca+","+bonusZaGol+","+bonusZaAsist+","+igrac.getIdIgrac();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkaugovora.ugovor="+ugovor.getIdUgovor()+" AND stavkaugovora.rb="+rb;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ugovor="+ugovor.getIdUgovor()+",rb="+rb+",cenaIgraca="+cenaIgraca+",bonusZaGol="+bonusZaGol+",bonusZaAsist="+bonusZaAsist+",igrac="+igrac.getIdIgrac();
    }
    
}
