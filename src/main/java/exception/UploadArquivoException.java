//Em toda Exceção precisamos extender ela a outra exceção e sobrescrever alguns métodos

package exception;

public class UploadArquivoException extends RuntimeException {
    //método construtor padrão
    public UploadArquivoException(String mensagem) {
        //criando um super() para sobrescrever essa mensagem criada pelo construtor.
        super(mensagem);
    }

    public UploadArquivoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
    
}
