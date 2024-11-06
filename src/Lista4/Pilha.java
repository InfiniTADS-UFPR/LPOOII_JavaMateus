/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lista4;

import static java.lang.constant.ConstantDescs.NULL;

/**
 *
 * @author mateus
 */
class Pilha<T> {
    
    public T value;
    public Pilha<T> next;
    
    Pilha<T> comeco;
    Pilha<T> anda;

    void empilha(T value) {
        if (comeco == NULL){
            comeco = new Pilha<T>();
            comeco.value = value;
            comeco.next = null;
        } else {
            Pilha<T> valor = new Pilha<T>();
            valor.value = value;
            valor.next = comeco;
            comeco = valor;
        }
    }

    void desempilha() {
        comeco = comeco.next;
    }
    
    @Override
    public String toString(){
        String retorno = "[";
        anda = comeco;
        while(anda.next != null){
            retorno += anda.value+",";
            anda = anda.next;
        }
        retorno +=anda.value+"]";
        return retorno;
    }
    
}
