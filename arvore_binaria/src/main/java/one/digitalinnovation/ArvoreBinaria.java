package one.digitalinnovation;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(T conteudo){
        BinNo<T> novoNo = new BinNo<T>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo){
        if (atual == null){
            return novoNo;
        }else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0){
            atual.setNoEsc(inserir(atual.getNoEsc(), novoNo));
        }else {
            atual.setNoDir(inserir(atual.getNoDir(), novoNo));
        }
        return atual;
    }

    public void exibirInOrder(){
        System.out.println("\n Exibindo InOrder");
        exibirInOrder(this.raiz);
    }

    private void exibirInOrder(BinNo<T> atual){
        if (atual != null){
            exibirInOrder(atual.getNoEsc());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrder(atual.getNoDir());
        }
    }

    public void exibirPosOrder(){
        System.out.println("\n Exibindo PosOrder");
        exibirPosOrder(this.raiz);
    }

    private void exibirPosOrder(BinNo<T> atual){
        if (atual != null){
            exibirPosOrder(atual.getNoEsc());
            exibirPosOrder(atual.getNoDir());
            System.out.print(atual.getConteudo() + ", ");
        }
    }

    public void exibirPreOrder(){
        System.out.println("\n Exibindo PreOrder");
        exibirPreOrder(this.raiz);
    }

    private void exibirPreOrder(BinNo<T> atual){
        if (atual != null){
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrder(atual.getNoEsc());
            exibirPreOrder(atual.getNoDir());
        }
    }

    public void remover(T conteudo){
        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                if (conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsc();
                }else{
                    atual = atual.getNoDir();
                }
            }

            if (atual == null){
                System.out.printf("conteudo nao encontrado. Bloco Try");
            }

            if (pai == null){
                if (atual.getNoDir() == null){
                    this.raiz = atual.getNoEsc();
                }else if (atual.getNoEsc() == null){
                    this.raiz = atual.getNoDir();
                }else {
                    for(temp = atual, filho = atual.getNoEsc();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoEsc()
                    ){
                        if (filho != atual.getNoEsc()){
                            temp.setNoDir(filho.getNoEsc());
                            filho.setNoEsc(raiz.getNoEsc());
                        }
                    }
                    filho.setNoDir(raiz.getNoDir());
                    raiz = filho;
                }
            }else if (atual.getNoDir() == null){
                if (pai.getNoEsc() == atual){
                    pai.setNoEsc(atual.getNoEsc());
                }else{
                    pai.setNoDir(atual.getNoEsc());
                }
            } else if (atual.getNoEsc() == null){
                if (pai.getNoEsc() == atual){
                    pai.setNoEsc(atual.getNoDir());
                }else{
                    pai.setNoDir(atual.getNoDir());
                }
            }else {
                for (
                        temp = atual, filho = atual.getNoEsc();
                        filho.getNoDir() != null;
                        temp = filho, filho = filho.getNoDir()
                ){
                    if (filho != atual.getNoEsc()){
                        temp.setNoDir(filho.getNoEsc());
                        filho.setNoEsc(atual.getNoEsc());
                    }
                    filho.setNoDir(atual.getNoDir());
                    if (pai.getNoEsc() == atual) {
                        pai.setNoEsc(filho);
                    }else {
                        pai.setNoDir(filho);
                    }
                }
            }

        }catch (NullPointerException erro){
            System.out.printf("conteudo nao encontrado. Bloco catch");
        }
    }
}
