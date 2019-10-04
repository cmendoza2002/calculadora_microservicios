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

/**
 * <p>Clase que representan los numeros de manera unitaria</p>
 * 
 * <p>Esta clase hereda de la clase abstracta de <i>{@link ExpresionBase}</i>.</p>
 * 
 * @author Carlos Lozano
 * @since 1.0
 * @version 1.0
 * @see ExpresionBase
 */

public class Numero extends ExpresionBase {
    
    /**
     * <p>Variable que guarda el valor del numero.</p>
     * 
     * @since 1.0
     */
    
    private final double valor;
    
    /**
     * <p>Constructor de la clase que convierte una expresion en un valor numerico.</p>
     * 
     * @since 1.0
     * @param expresion <i>Expresion de la cual se obtendra el valor numerico de
     * la clase.</i>
     */
    
    Numero(String expresion) {
        try{
            valor = Double.parseDouble(expresion);
        } catch(NumberFormatException e){
            throw new CalculadoraException("Error intentando parsear la siguiente expresion: ".concat(expresion));
        }
    }
    
    /**
     * <p>Constructor sin parametros de la clase, el valor numerico se inicializa
     * en 0.</p>
     * 
     * @since 1.0
     */
    
    Numero() {
        this.valor = 0;
    }
    
    /**
     * <p>Constructor en el cual el valor numerico se ingresa de manera literal 
     * a la clase.</p>
     * 
     * @since 1.0
     * @param valor <i>Valor que va a tener el numero de la clase.</i> 
     */
    
    Numero(double valor){
        this.valor = valor;
    }

    /**
     * <p>Obtiene el valor de la clase.</p>
     * 
     * @since 1.0
     * @return <i>Resultado de la expresion.</i>
     */
    
    @Override
    double getValor() {
        return valor;
    }
}