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
 * <p>Esta clase contiene metodos diversos que pueden ser utiles a varias clases.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public class Utileria {
    
    /**
     * <p>Este metodo revisa si un caracter es un caracter numerico.</p>
     * 
     * @since 1.0
     * @param caracter <b>Caracter a evaluar.</b>
     * @return <b>En caso que el caracter sea un numero retornara 
     * <i style="color:blue">true</i>, en caso contrario retornara 
     * <i style="color:blue">false</i>.</b>
     */
    
    public static boolean isNumero(char caracter){
        switch(caracter){
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }
}