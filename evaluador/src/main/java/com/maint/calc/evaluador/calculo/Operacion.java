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

/**
 * <p>Esta clase se encarga de operar dos valores dados.</p>
 * 
 * <p>Esta clase hereda de la clase abstracta de <i>{@link ExpresionBase}</i>.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 * @see ExpresionBase
 */

public class Operacion extends ExpresionBase {


    /**
     * <p>Valores a operar.</p>
     * 
     * @since 1.0
     */
    
    private final ExpresionBase a,b;
    
    /**
     * <p>Tipo de operacion que se va a realizar.</p>
     * 
     * @since 1.0
     */
    
    private final Operador operador;
    
    /**
     * <p>Constructor de la clase que recibe los valores y la operacion que se 
     * va a realizar</p>
     * 
     * @since 1.0
     * @param a <i>Primer valor, numerador en una operacion de tipo division.</i>
     * @param b <i>Segundo valor, denominador en una operacion de tipo division</i>
     * @param operador <i>Tipo de operacion que se va a realizar.</i>
     */
    private final SumaServicio  sumaServicio;
    private final RestaServicio restaServicio;
    private final MultiplicacionServicio multiplicacionServicio;
    private final DivisionServicio divisionServicio;
    Operacion(ExpresionBase a, ExpresionBase b, Operador operador, SumaServicio sumaServicio, RestaServicio restaServicio, MultiplicacionServicio multiplicacionServicio, DivisionServicio divisionServicio){
        this.sumaServicio = sumaServicio;
        this.restaServicio = restaServicio;
        this.multiplicacionServicio = multiplicacionServicio;
        this.divisionServicio = divisionServicio;
        this.a = a;
        this.b = b;
        this.operador = operador;
    }
    
    
    /**
     * <p>Retorna la expresion en notacion <i>.</i></p>
     * 
     * @since 1.0
     * @return <i>Cadena con la notacion n de la expresion</i>
     */
    
    @Override
    String showExpresion() {
        return "{[".concat(a.showExpresion()).concat("][").concat(b.showExpresion())
                .concat("] ").concat(operador.toString()).concat("}");
    }
    
    /**
     * <p>Obtiene el resultado de operar los valores con el operador ingresado.</p>
     * 
     * @since 1.0
     * @return <i>Resultado de la expresion.</i>
     */

    @Override
    double getValor() {
        //return operador.operar(a, b);
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
        //return operador.operar(a, b);
    }
}