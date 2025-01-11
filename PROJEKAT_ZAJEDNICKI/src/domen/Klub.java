/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Matija
 */
public class Klub implements ApstraktniDomenskiObjekat {
    private int idKlub;
    private String naziv;
    private int brojEvropskihTitula;
    private int brojDomacihTitula;
    private int kvalitetKluba;
    private String email;
    private Mesto mesto;

    public Klub(int idKlub, String naziv, int brojEvropskihTitula, int brojDomacihTitula, int kvalitetKluba, String email, Mesto mesto) {
        this.idKlub = idKlub;
        this.naziv = naziv;
        this.brojEvropskihTitula = brojEvropskihTitula;
        this.brojDomacihTitula = brojDomacihTitula;
        this.kvalitetKluba = kvalitetKluba;
        this.email = email;
        this.mesto = mesto;
    }

    public Klub() {
    }

   

    public int getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(int idKlub) {
        this.idKlub = idKlub;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojEvropskihTitula() {
        return brojEvropskihTitula;
    }

    public void setBrojEvropskihTitula(int brojEvropskihTitula) {
        this.brojEvropskihTitula = brojEvropskihTitula;
    }

    public int getBrojDomacihTitula() {
        return brojDomacihTitula;
    }

    public void setBrojDomacihTitula(int brojDomacihTitula) {
        this.brojDomacihTitula = brojDomacihTitula;
    }

    public int getKvalitetKluba() {
        return kvalitetKluba;
    }

    public void setKvalitetKluba(int kvalitetKluba) {
        this.kvalitetKluba = kvalitetKluba;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return naziv+", "+mesto.getNaziv();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.idKlub;
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
        final Klub other = (Klub) obj;
        return this.idKlub == other.idKlub;
    }

    @Override
    public String vratiNazivTabele() {
         return "klub";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,brojEvropskihTitula,brojDomacihTitula,kvalitetKluba,email,mesto";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
         return "'"+naziv+"',"+brojEvropskihTitula+","+brojDomacihTitula+","+kvalitetKluba+",'"+email+"',"+mesto.getIdMesto();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "klub.idKlub="+idKlub;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"',brojEvropskihTitula="+brojEvropskihTitula+",brojDomacihTitula="+brojDomacihTitula+",kvalitetKluba="+kvalitetKluba+",email='"+email+"',mesto="+mesto.getIdMesto();
    }
    
}
