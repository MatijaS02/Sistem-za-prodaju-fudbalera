/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;


import domen.ApstraktniDomenskiObjekat;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.db.DbConnectionFactory;
import repository.db.DbRepository;
import java.sql.Connection;

/**
 *
 * @author Matija
 */
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat> {

    @Override
    public List<ApstraktniDomenskiObjekat> vratiSveObjekte(ApstraktniDomenskiObjekat parametar, String uslov) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
       
       String upit = "SELECT FROM "+parametar.vratiNazivTabele();
       if(uslov!=null){
           upit+=uslov;
       }
       Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
       ResultSet rs = st.executeQuery(upit);
       lista = parametar.vratiListu(rs);
       rs.close();
       st.close();
       return lista;
    }

    @Override
    public void dodaj(ApstraktniDomenskiObjekat parametar) throws Exception {
      String upit = "INSERT INTO "+parametar.vratiNazivTabele()+" ("+parametar.vratiKoloneZaUbacivanje()+") VALUES ("+parametar.vratiVrednostiZaUbacivanje()+")";
        System.out.println(upit);
        
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void azuriraj(ApstraktniDomenskiObjekat parametar) throws Exception {
       String upit ="UPDATE "+parametar.vratiNazivTabele()+" SET "+parametar.vratiVrednostiZaIzmenu();
        System.out.println(upit);
       Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
       st.executeUpdate(upit);
       st.close();
       
    }

    @Override
    public void izbrisi(ApstraktniDomenskiObjekat parametar) throws Exception {
        String upit = "DELETE FROM "+parametar.vratiNazivTabele()+" WHERE="+parametar.vratiPrimarniKljuc();
        System.out.println(upit);
        Statement st = DbConnectionFactory.getInstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiSveObjekte() {
       return null; //TODO
    }
    
}
