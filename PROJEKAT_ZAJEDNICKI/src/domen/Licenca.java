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
public class Licenca implements ApstraktniDomenskiObjekat{
    private int idLicenca;
    private String naziv;
    private String tip;

    public Licenca() {
    }

    public Licenca(int idLicenca, String naziv, String tip) {
        this.idLicenca = idLicenca;
        this.naziv = naziv;
        this.tip = tip;
    }

    public int getIdLicenca() {
        return idLicenca;
    }

    public void setIdLicenca(int idLicenca) {
        this.idLicenca = idLicenca;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return naziv+", "+tip;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idLicenca;
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
        final Licenca other = (Licenca) obj;
        return this.idLicenca == other.idLicenca;
    }

    @Override
    public String vratiNazivTabele() {
        return "licenca";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("licenca.idLicenca");
            String naziv = rs.getString("licenca.naziv");
            String tip = rs.getString("licenca.tip");
            Licenca l = new Licenca(id, naziv, tip);
            lista.add(l);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,tip";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+naziv+"','"+tip+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "licenca.idLicenca="+idLicenca;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
       return "naziv='"+naziv+"',tip='"+tip+"'";
    }
    
}
