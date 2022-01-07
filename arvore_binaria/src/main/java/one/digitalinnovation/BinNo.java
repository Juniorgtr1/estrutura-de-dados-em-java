package one.digitalinnovation;

public class BinNo<T extends Comparable<T>> {

    private T conteudo;
    private BinNo<T> noEsc;
    private BinNo<T> noDir;

    public BinNo(T conteudo){
        this.conteudo = conteudo;
        noEsc = noDir = null;
    }

    public BinNo(){}

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public BinNo<T> getNoEsc() {
        return noEsc;
    }

    public void setNoEsc(BinNo<T> noEsc) {
        this.noEsc = noEsc;
    }

    public BinNo<T> getNoDir() {
        return noDir;
    }

    public void setNoDir(BinNo<T> noDir) {
        this.noDir = noDir;
    }

    @Override
    public String toString() {
        return "[BinNo{" +
                "conteudo=" + conteudo +
                "}]";
    }
}
