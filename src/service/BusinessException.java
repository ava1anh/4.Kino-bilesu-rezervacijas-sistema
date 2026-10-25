/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author andre
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Izveido kļūdu ar lietotājam saprotamu ziņojumu.
     *
     * @param message ziņojums lietotājam
     */
    public BusinessException(String message) {
        super(message);
    }
}

