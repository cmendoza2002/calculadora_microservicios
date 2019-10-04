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
 * <p>Clase base para las operaciones que se realizan.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public abstract class ExpresionBase {
    
    /**
     * <p>Constructor por defecto de la clase, solo accesible por medio de 
     * elementos de su <i style="color:blue">package</i>.</p>
     * 
     * @since 1.0
     */
    
    ExpresionBase(){}
    
    /**
     * <p>Metodo a implementar para obtener el valor que tiene el elemento.</p>
     * 
     * @since 1.0
     * @return <i>Retorna el valor de la clase que implementa.</i>
     */
    
    abstract double getValor();
}