package one.digitalinnovation;

public class Pilha {

    private No refNoEntradaPilha;

    public Pilha(){
        this.refNoEntradaPilha = null;
    }

    public No top(){return refNoEntradaPilha;}

    public void push(No novoNo){
        No refAux = refNoEntradaPilha;
        refNoEntradaPilha = novoNo;
        refNoEntradaPilha.setRefNo(refAux);
    }

    public No pop(){
        if (!isEmpty()){
            No noPoped = refNoEntradaPilha;
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
            return noPoped;
        }
        return null;
    }

    public boolean isEmpty(){return refNoEntradaPilha == null ? true : false;}

    @Override
    public String toString() {
        String stringRetorno = "-------------\n"
                + "    Pilha\n"
                + "-------------\n";

        No noAux = refNoEntradaPilha;

        while (true) {
            if (noAux != null) {
                stringRetorno += "[No{dado=" + noAux.getDado() + "}]\n";
                noAux = noAux.getRefNo();
            } else {
                break;
            }
        }
        stringRetorno += "=============\n";

        return stringRetorno;
    }
}