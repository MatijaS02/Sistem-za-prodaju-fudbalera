/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Matija
 */
public class MenadzerLicenca implements ApstraktniDomenskiObjekat {
    private LocalDate datumIzdavanja;
    private Licenca licenca;
    private Menadzer menadzer;

    public MenadzerLicenca() {
    }

    public MenadzerLicenca(LocalDate datumIzdavanja, Menadzer menadzer, Licenca licenca) {
        this.datumIzdavanja = datumIzdavanja;
        this.menadzer = menadzer;
        this.licenca = licenca;
    }

    public LocalDate getDatumIzdavanja() {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja(LocalDate datumIzdavanja) {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    public Licenca getLicenca() {
        return licenca;
    }

    public void setLicenca(Licenca licenca) {
        this.licenca = licenca;
    }

    @Override
    public String toString() {
        return "MenadzerLicenca{" + "datumIzdavanja=" + datumIzdavanja + ", menadzer=" + menadzer + ", licenca=" + licenca + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.menadzer);
        hash = 79 * hash + Objects.hashCode(this.licenca);
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
        final MenadzerLicenca other = (MenadzerLicenca) obj;
        if (!Objects.equals(this.menadzer, other.menadzer)) {
            return false;
        }
        return Objects.equals(this.licenca, other.licenca);
    }

    @Override
    public String vratiNazivTabele() {
        return "menadzerlicenca";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "datumIzdavanja,licenca,menadzer";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
       return datumIzdavanja+","+licenca.getIdLicenca()+","+menadzer.getIdMenadzer();
    }

    @Override
    public String vratiPrimarniKljuc() {
         return "menadzerlicenca.licenca="+licenca.getIdLicenca()+" AND menadzerlicenca.menadzer="+menadzer.getIdMenadzer();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "datumIzdavanja="+datumIzdavanja+",licenca="+licenca.getIdLicenca()+",menadzer="+menadzer.getIdMenadzer();
    }
    
}
