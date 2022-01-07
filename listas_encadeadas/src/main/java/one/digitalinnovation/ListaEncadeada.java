package one.digitalinnovation;

public class ListaEncadeada<T> {

    No<T> refEntrada;

    public ListaEncadeada(){
        this.refEntrada = null;
    }

    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = refEntrada;

        while (true) {
            if (referenciaAux != null){
                tamanhoLista ++;
                if (referenciaAux.getProximoNo() != null){
                    referenciaAux = referenciaAux.getProximoNo();
                } else break;
            } else {
                break;
            }
        }

        return tamanhoLista;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (this.isEmpty()){
            refEntrada = novoNo;
            return;
        }

        No<T> noAux = refEntrada;
        for (int i = 0; i < this.size()-1; i++){
            noAux = noAux.getProximoNo();
        }
        noAux.setProximoNo(novoNo);
    }

    private No<T> getNo(int index){

        validaIndice(index);
        No<T> noAux = refEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= index; i++){
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return noRetorno;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public T remove(int index){
        No<T> noPivor = this.getNo(index);
        if (index == 0){
            refEntrada = noPivor.getProximoNo();
            return noPivor.getConteudo();
        }
        No<T> noAnterior = getNo(index -1);
        noAnterior.setProximoNo(noPivor.getProximoNo());
        return noPivor.getConteudo();
    }

    public boolean isEmpty(){
        return refEntrada == null ? true : false;
    }

    private void validaIndice(int index){
        if (index >= size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteudo no indice "
                    + index + " desta lista. Esta lista só vai ate o indice "
                    + ultimoIndice + ".");
        }
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = refEntrada;
        for (int i = 0; i < this.size(); i++){
            strRetorno += "[No{conteudo=" + noAux.getConteudo() + "} ---> ";
            noAux = noAux.getProximoNo();
        }
        strRetorno += "null";
        return strRetorno;
    }
}
