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
 * <p>Esta clase es con la cual podemos acceder a un calculo sin necesidad de
 * utilizar la clase calculadora. Con lo cual podemos hacer calculos con una 
 * validacion propia.</p>
 * 
 * <p>En caso de errores en la expresion ingresada se mandara una excepcion 
 * de tiempo de ejecucion.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public class Calculo {
    
    /**
     * <p>Expresion a calcular. Es una clase <i>{@link Expresion}</i>.</p>
     * 
     * @since 1.0
     */
    
    private final Expresion expresion;
    
    /**
     * <p>Constructor publico de la clase, el cual recibe una sentencia en texto.</p>
     * 
     * @since 1.0
     * @param sentencia <i>Sentenca a calcular.</i> 
     */
    
    public Calculo(String sentencia){
        expresion = new Expresion(sentencia);
    }
    
    /**
     * <p>Este metodo nos regresa la notacion  de la expresion
     * ingresda.</p>
     * @return <i>Notacion  de la expresion.</i>
     */
    
    public String showExpresion(){
        return expresion.showExpresion();
    }
    
    /**
     * <p>Obtiene el resultado de la expresion ingresada.</p>
     * 
     * @return <i>Resultado de la expresion.</i>
     */
    
    public double getResultado(){
        return expresion.getValor();
    }
}
