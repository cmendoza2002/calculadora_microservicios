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
 * <p>Excepcion de tiempo de ejecucion y se utiliza cuando la expresion no es
 * valida pero aun asi se intenta acceder a un resultado.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public class EValidacion extends RuntimeException{
    EValidacion(String detalles){
        super("La sentencia no cumple con los parametros. Detalles: ".concat(detalles));
    }
}