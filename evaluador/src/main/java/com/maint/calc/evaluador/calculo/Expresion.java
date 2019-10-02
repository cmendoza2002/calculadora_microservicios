/*
 * Copyright (C) 2019 Carlos Lozano
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.maint.calc.evaluador.calculo;

import com.maint.calc.evaluador.calculo.servicios.DivisionServicio;
import com.maint.calc.evaluador.calculo.servicios.MultiplicacionServicio;
import com.maint.calc.evaluador.calculo.servicios.RestaServicio;
import com.maint.calc.evaluador.calculo.servicios.SumaServicio;
import com.maint.calc.evaluador.servicios.ServicioCalculadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.maint.calc.evaluador.calculo.Operador.*;

/**
 * <p>Clase que se encarga de hacer las gestiones del segmento de <i>expresion</i></p>
 * 
 * <p>Esta clase hereda de la clase abstracta de <i>{@link ExpresionBase}</i>.</p>
 *
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 * @see ExpresionBase
 */
public class Expresion extends ExpresionBase {




    /**
     * <p>Lista de elementos que contiene esta expresion.</p>
     * 
     * @since 1.0
     */
    
    private final List<ExpresionBase> elementos = new ArrayList<>();
    
    /**
     * <p>Lista de operadores a iterar con los elementos</p>
     * 
     * @since 1.0
     */
    
    private final List<Operador> operadores = new ArrayList<>();
    
    /**
     * <p>Texto con la expresion ingresada en la clase.</p>
     * 
     * @since 1.0
     */
    
    private final String expresion;
    
    /**
     * <p>Contructor unico de la case, cuando el objeto es construido se trata
     * la cadena ingresada.</p>
     * 
     * @since 1.0
     * @param expresion <i>Expresion a tratar.</i>
     */
    private final SumaServicio  sumaServicio;
    private final RestaServicio restaServicio;
    private final MultiplicacionServicio multiplicacionServicio;
    private final DivisionServicio divisionServicio;
    Expresion(String expresion, SumaServicio sumaServicio, RestaServicio restaServicio, MultiplicacionServicio multiplicacionServicio, DivisionServicio divisionServicio){
        this.sumaServicio = sumaServicio;
        this.restaServicio = restaServicio;
        this.multiplicacionServicio = multiplicacionServicio;
        this.divisionServicio = divisionServicio;
        this.expresion = expresion;
        tratarExpresion();
    }
    
    /**
     * <p>Este metodo secciona, clasifica y acomoda en las listas los objetos que 
     * se vayan requiriendo para resolver la operacion.</p>
     * 
     * @since 1.0
     */
    
    private void tratarExpresion() {
        if(!expresion.isEmpty() && (expresion.charAt(0)=='*' 
                || expresion.charAt(0)=='/'))throw new CalculadoraException("Operador "
                        .concat(String.valueOf(expresion.charAt(0)))
                        .concat(" invalido para comenzar una expresion."));
        String aux = "0";
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            switch(caracter){
                case '-':case '+':case '*':case '/':
                    if(!aux.isEmpty())insertarElemento(new Numero(aux));
                    operadores.add(Operador.obtenerOperador(caracter));
                    aux = "";                    
                    break;
                case '(':
                    int inicio = i + 1;
                    int cierre = getCierre(inicio);
                    insertarElemento(new Expresion(expresion.substring(inicio, cierre),sumaServicio, restaServicio, multiplicacionServicio, divisionServicio));
                    aux = "";
                    i = cierre;
                    break;
                default:
                    if(Util.isNumero(caracter) || caracter == '.'){
                        aux = aux.concat(String.valueOf(caracter));
                    } else {
                        switch(caracter){
                            case ')':
                                throw new CalculadoraException("Los parencecis no abren de manera correcta.");
                            default:
                                throw new CalculadoraException("El caracter en la posicion "
                                    .concat(String.valueOf(i)).concat(" de la expresion ")
                                    .concat(expresion).concat(" no se pudo tratar"));
                        }
                                
                    }
            }
        }      
        if(!aux.isEmpty())insertarElemento(new Numero(aux));
        insertarElemento(new Numero());
        operadores.add(SUMA);
    }
    
    /**
     * <p>Este metodo nos indica donde cierra un parentecisis dado en cierto
     * segmento de la expresion.</p>
     * 
     * <p>En caso de no encontrar un cierre valido retorna una excepcion en
     * tiempo de ejecucion. Tambien retornada una excepcion si el indice no se
     * mueve del inicio.</p>
     * 
     * @since 1.0
     * 
     * @param inicio <i>Indice donde se va a comenzar a buscar.</i>
     * @return <i>Indice del cierre de una subexpresion.</i>
     */
    
    private int getCierre(int inicio){
        int apertura = 1;
        int cierre = 0;
        for (int i = inicio; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            if(caracter=='(')apertura++;
            if(caracter==')')cierre++;
            if(apertura==cierre){
                if(i==inicio)throw new CalculadoraException("Se ingreso un parentesis vacio");
                return i;
            }
        }
        throw new CalculadoraException("Los parencecis no cierran de manera correcta.");
    }
    
    /**
     * <p>Este metodo inserta un elemento en la lista de elementos, en caso de 
     * que el operador sea una multiplicacion o division genera un operacion, con
     * las reglas establecidas para ello en la notacion .</p>
     * 
     * @since 1.0
     * @param elemento <i>Elemento a ingresar en las lista.</i> 
     */

    private void insertarElemento(ExpresionBase elemento){
        if(!operadores.isEmpty() && (operadores.get(operadores.size() - 1)== MULTIPLICACION
                || operadores.get(operadores.size()-1)== Operador.DIVISION)){
            ExpresionBase anterior = elementos.get(elementos.size() - 1);
            elementos.remove(anterior);
            elementos.add(new Operacion(anterior, elemento, operadores.get(operadores.size() - 1),sumaServicio, restaServicio, multiplicacionServicio, divisionServicio));
            operadores.remove(operadores.size() - 1);
        } else elementos.add(elemento);
    }
    
    /**
     * <p>Genera una lista espejo de los elementos que estan en la lista de elementos, 
     * y con ellos hace las operaciones requeridas sin modificar el orden de los 
     * elementos originales.</p>
     * 
     * @since 1.0
     * @return <i>Copia de la lista de elementos.</i>
     */
    
    private List<ExpresionBase> copiarElementos(){
        List<ExpresionBase> aux = new ArrayList<>();
        elementos.stream().forEach((elemento) -> {
            aux.add(elemento);
        });
        return aux;
    }
    /**
     * <p>Retorna la expresion en notacion <i>.</i></p>
     * 
     * @since 1.0
     * @return <i>Cadena con la notacion n de la expresion</i>
     */
    @Override
    String showExpresion() {
        String aux = "(";
        for(ExpresionBase elemento:elementos)aux = aux.concat("[")
                .concat(elemento.showExpresion()).concat("]");
        aux = aux.concat(" ");
        for(Operador operador:operadores)aux = aux.concat(operador.toString());
        return aux.concat(")");
    }
    
    /**
     * <p>Obtiene el valor de las operaciones en la expresion.</p>
     * 
     * @since 1.0
     * @return <i>Resultado de la expresion.</i>
     */
    @Override
    double getValor() {
        List<ExpresionBase> aux = copiarElementos();
        operadores.stream().forEach((operador) -> {
            if(aux.size()<2)throw new CalculadoraException("Error en la configuracion de las operaciones, favor de revisar.");
            ExpresionBase a = aux.get(0);
            ExpresionBase b = aux.get(1);
            aux.remove(a);
            aux.remove(b);
            aux.add(0,new Numero(getValor(operador,a,b)));
        });
        return aux.get(0).getValor();
    }



    /**
     * <p>Obtiene el resultado de operar los valores con el operador ingresado.</p>
     *
     * @since 1.0
     * @return <i>Resultado de la expresion.</i>
     */

    double getValor(Operador operador, ExpresionBase a, ExpresionBase b) {
        switch(operador){
            case SUMA:
                return sumaServicio.calcular(a.getValor(),b.getValor());//a.getValor() + b.getValor();
            case RESTA:
                return restaServicio.calcular(a.getValor(),b.getValor());//a.getValor() - b.getValor();
            case MULTIPLICACION:
                return multiplicacionServicio.calcular(a.getValor(),b.getValor());//a.getValor() * b.getValor();
            default:
                return divisionServicio.calcular(a.getValor(),b.getValor());//a.getValor() / b.getValor();
        }

    }

}
