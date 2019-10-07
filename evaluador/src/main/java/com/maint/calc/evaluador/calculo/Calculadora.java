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
import com.maint.calc.evaluador.util.Validador;

/**
 * <p>Esta clase nos sirve para revisar que las expresiones esten bien estructuradas, 
 * asi como poder saber saber de antemano si la expresion puede ser evaluada o no.</p> 
 * 
 * <p>Tambien nos provee de distintas banderas para saber el motivo de que la expresion
 * no es valida.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */


public class Calculadora {

    /**
     * Valida las expresiones pasadas como string
     */
    private Validador validador;

    /**
     * <p>Expresion a calcular. Es una clase <i>{@link Expresion}</i>.</p>
     *
     * @since 1.0
     */

    private Expresion expresion = null;

    /**
     * <p>Constructor privado de la clase para que quien se encarge de hacer los 
     * calculos solo sea un objeto y este no sea replicable.</p>
     * 
     * @since 1.0
     */
    private final SumaServicio  sumaServicio;
    private final RestaServicio restaServicio;
    private final MultiplicacionServicio multiplicacionServicio;
    private final DivisionServicio divisionServicio;


    public Calculadora(SumaServicio sumaServicio, RestaServicio restaServicio, MultiplicacionServicio multiplicacionServicio, DivisionServicio divisionServicio){
        this.sumaServicio = sumaServicio;
        this.restaServicio = restaServicio;
        this.multiplicacionServicio = multiplicacionServicio;
        this.divisionServicio = divisionServicio;
        validador = new Validador();
    }
    
    /**
     * <p>Metodo para ingresar una nueva sentencia.</p>
     * 
     * <p>La sentencia se formatea para que sea valida, en caso de ser posible. y realiza las operaciones</p>
     * 
     * @since 1.0
     * @param sentencia <i>Sentencia ingresada en la clase.</i>
     */
    public double calcularExpresion(String sentencia){
        if(validador.isValido(sentencia))
        {
            expresion = new Expresion(sentencia,sumaServicio, restaServicio, multiplicacionServicio, divisionServicio);
            return expresion.getValor();
        }
        throw new RuntimeException("Sentencia no definida aun");
    }


}