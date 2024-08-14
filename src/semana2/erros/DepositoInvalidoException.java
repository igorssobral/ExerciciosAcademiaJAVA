package semana2.erros;

public class DepositoInvalidoException extends RuntimeException{

    public DepositoInvalidoException(String message){
        super(message);
    }
}
