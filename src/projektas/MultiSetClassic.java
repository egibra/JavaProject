/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektas;

/**
 *
 * @author Acer
 * @param <T>
 */
    public interface MultiSetClassic<T> {

        int put (T obj);

        int remove (T obj);

        int contains (T obj);

        int size ();
    }
