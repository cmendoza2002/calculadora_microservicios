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
 * <p>Con esta clase se envian las excepciones que sucedan en las clases de calculo.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public class CalculadoraException extends RuntimeException{
    
    /**
     * <p>Constructor de la case, recibe una cadena con el
     * mensaje que sera desplegado.</p>
     * 
     * @since 1.0
     * @param message <i>Mensaje a enviar con la excepcion.</i>
     */
    
    CalculadoraException(String message){
        super(message);
    }
}