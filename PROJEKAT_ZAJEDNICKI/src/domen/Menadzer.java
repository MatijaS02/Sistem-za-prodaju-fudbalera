/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Matija
 */
public class Menadzer implements ApstraktniDomenskiObjekat {
    private int idMenadzer;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String sifra;

    public Menadzer() {
    }

    public Menadzer(int idMenadzer, String ime, String prezime, String korisnickoIme, String sifra) {
        this.idMenadzer = idMenadzer;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    public int getIdMenadzer() {
        return idMenadzer;
    }

    public void setIdMenadzer(int idMenadzer) {
        this.idMenadzer = idMenadzer;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.korisnickoIme);
        hash = 67 * hash + Objects.hashCode(this.sifra);
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
        final Menadzer other = (Menadzer) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.sifra, other.sifra);
    }

    @Override
    public String vratiNazivTabele() {
        return "menadzer";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("menadzer.idMenadzer");
            String ime = rs.getString("menadzer.ime");
            String prezime = rs.getString("menadzer.prezime");
            String korisnickoIme = rs.getString("menadzer.korisnickoIme");
            String sifra = rs.getString("menadzer.sifra");
            Menadzer m = new Menadzer(id,ime,prezime,korisnickoIme,sifra);
            lista.add(m);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,korisnickoIme,sifra";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+ime+"','"+prezime+"','"+korisnickoIme+"','"+sifra+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
       return "menadzer.idMenadzer="+idMenadzer;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "ime='"+ime+"',prezime='"+prezime+"',korisnickoIme='"+korisnickoIme+"',sifra='"+sifra+"'";
    }
    
    
}
