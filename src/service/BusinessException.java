package service;

/**
 * Biznesa loģikas kļūda, kuras ziņojums ir paredzēts rādīšanai lietotājam (piemēram, "Šī vieta jau ir rezervēta.").
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
