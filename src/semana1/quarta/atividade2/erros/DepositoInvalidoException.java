package semana1.quarta.atividade2.erros;

public class DepositoInvalidoException extends RuntimeException{

    public DepositoInvalidoException(String message){
        super(message);
    }
}
