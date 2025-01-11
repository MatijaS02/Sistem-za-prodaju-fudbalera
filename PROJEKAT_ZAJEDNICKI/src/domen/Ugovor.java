/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Ugovor implements ApstraktniDomenskiObjekat {
    private int idUgovor;
    private LocalDate datumSklapanja;
    private double iznosUgovora;
    private Menadzer menazder;
    private Klub klub;
    List<StavkaUgovora> listaStavki= new ArrayList<>();

    public Ugovor() {
    }

    public Ugovor(int idUgovor, LocalDate datumSklapanja, double iznosUgovora, Menadzer menazder, Klub klub) {
        this.idUgovor = idUgovor;
        this.datumSklapanja = datumSklapanja;
        this.iznosUgovora = iznosUgovora;
        this.menazder = menazder;
        this.klub = klub;
    }
    
    public List<StavkaUgovora> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaUgovora> listaStavki) {
        this.listaStavki = listaStavki;
    }
    

    public int getIdUgovor() {
        return idUgovor;
    }

    public void setIdUgovor(int idUgovor) {
        this.idUgovor = idUgovor;
    }

    public LocalDate getDatumSklapanja() {
        return datumSklapanja;
    }

    public void setDatumSklapanja(LocalDate datumSklapanja) {
        this.datumSklapanja = datumSklapanja;
    }

    public double getIznosUgovora() {
        return iznosUgovora;
    }

    public void setIznosUgovora(double iznosUgovora) {
        this.iznosUgovora = iznosUgovora;
    }

    public Menadzer getMenazder() {
        return menazder;
    }

    public void setMenazder(Menadzer menazder) {
        this.menazder = menazder;
    }

    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    @Override
    public String toString() {
        return "Ugovor{" + "datumSklapanja=" + datumSklapanja + ", iznosUgovora=" + iznosUgovora + ", menazder=" + menazder + ", klub=" + klub + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.idUgovor;
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
        final Ugovor other = (Ugovor) obj;
        return this.idUgovor == other.idUgovor;
    }

    @Override
    public String vratiNazivTabele() {
        return "ugovor";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumSklapanja,iznosUgovora,menadzer,klub";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return datumSklapanja+","+iznosUgovora+","+menazder.getIdMenadzer()+","+klub.getIdKlub();
    }

    @Override
    public String vratiPrimarniKljuc() {
       return "ugovor.idUgovor="+idUgovor;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       return "datumSklapanja="+datumSklapanja+",iznosUgovora="+iznosUgovora+",menadzer="+menazder.getIdMenadzer()+",klub="+klub.getIdKlub();
    }
    
}
