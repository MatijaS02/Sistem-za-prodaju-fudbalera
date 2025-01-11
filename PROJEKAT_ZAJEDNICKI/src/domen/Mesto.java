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
public class Mesto implements ApstraktniDomenskiObjekat {
    private int idMesto;
    private String naziv;
    private int postanskiBroj;
    private String drzava;

    public Mesto() {
    }

    public Mesto(int idMesto, String naziv, int postanskiBroj, String drzava) {
        this.idMesto = idMesto;
        this.naziv = naziv;
        this.postanskiBroj = postanskiBroj;
        this.drzava = drzava;
    }

    public int getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(int idMesto) {
        this.idMesto = idMesto;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public String toString() {
        return naziv+", "+drzava;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idMesto;
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
        final Mesto other = (Mesto) obj;
        return this.idMesto == other.idMesto;
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("mesto.idMesto");
            String naziv = rs.getString("mesto.naziv");
            int postBroj = rs.getInt("mesto.postanskiBroj");
            String drzava = rs.getString("mesto.drzava");
            Mesto m = new Mesto(id, naziv, postBroj, drzava);
            lista.add(m);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "naziv,postanskiBroj,drzava";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
         return "'"+naziv+"',"+postanskiBroj+",'"+drzava+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
       return "mesto.idMesto="+idMesto;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "naziv='"+naziv+"',postanskiBroj="+postanskiBroj+",drzava='"+drzava+"'";
    }
    
    
}
