/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author Matija
 */
public interface Repository<T> {
    List<T> vratiSveObjekte(T parametar, String uslov) throws Exception;
    void dodaj (T parametar) throws Exception;
    void azuriraj (T parametar) throws Exception;
    void izbrisi (T parametar) throws Exception;
    List<T> vratiSveObjekte();
}
