/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Igrac implements ApstraktniDomenskiObjekat{
    private int idIgrac;
    private String ime;
    private String prezime;
    private String nacionalnost;
    private String pozicija;
    private double cena;

    public Igrac() {
    }

    public Igrac(int idIgrac, String ime, String prezime, String nacionalnost, String pozicija, double cena) {
        this.idIgrac = idIgrac;
        this.ime = ime;
        this.prezime = prezime;
        this.nacionalnost = nacionalnost;
        this.pozicija = pozicija;
        this.cena = cena;
    }

    public int getIdIgrac() {
        return idIgrac;
    }

    public void setIdIgrac(int idIgrac) {
        this.idIgrac = idIgrac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getNacionalnost() {
        return nacionalnost;
    }

    public void setNacionalnost(String nacionalnost) {
        this.nacionalnost = nacionalnost;
    }

    public String getPozicija() {
        return pozicija;
    }

    public void setPozicija(String pozicija) {
        this.pozicija = pozicija;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idIgrac;
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
        final Igrac other = (Igrac) obj;
        return this.idIgrac == other.idIgrac;
    }

    @Override
    public String vratiNazivTabele() {
        return "igrac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
      List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
      while(rs.next()){
          int id = rs.getInt("igrac.idIgrac");
          String ime = rs.getString("igrac.ime");
          String prezime = rs.getString("igrac.prezime");
          String nacionalnost = rs.getString("igrac.nacionalnost");
          String pozicija = rs.getString("igrac.pozicija");
          double cena = rs.getDouble("igrac.cena");
          Igrac i = new Igrac(id, ime, prezime, nacionalnost, pozicija, cena);
          lista.add(i);
      }
      return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,nacionalnost,pozicija,cena";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
       return "'"+ime+"','"+prezime+"','"+nacionalnost+"','"+pozicija+"',"+cena;
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "igrac.idIgrac="+idIgrac;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',nacionalnost='"+nacionalnost+"',pozicija='"+pozicija+"',cena="+cena;
    }
    
}
