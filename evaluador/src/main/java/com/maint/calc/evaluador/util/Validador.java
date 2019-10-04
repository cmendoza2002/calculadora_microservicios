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

package com.maint.calc.evaluador.util;

import com.maint.calc.evaluador.calculo.Util;

/**
 * <p>Esta clase valida que la expresion ingresada sea correcta.</p>
 * 
 * <p>Los parametros de revision son que la expresion cumpla ciertas reglas de
 * manera general y otra es que los parentesis sean correctos.</p>
 * 
 * @author Carlos Lozano
 * @version 1.0
 * @since 1.0
 */

public class Validador {
    
    /**
     * <p>Expresion regular para evaluar de manera general la expresion.</p>
     * 
     * @since 1.0
     */
    private final String REGEX = "^[\\(]*(([-]|[\\+])?[\\d]+([.][\\d]+)?)([\\)]*(\\+|\\*|\\/|-)([\\(][-]?)*([\\d]+([.][\\d]+)?)[\\)]*)*[\\)]*$";

    /**
     * <p>Revisa si se cumplen todos los parametros de validacion.</p>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a revisar.</b>
     * @return <b>Si se cumplen todos los parametros de validacion retorna 
     * <i style="color:blue">true</i>, en caso contrario retorna
     * <i style="color:blue">false</i>.</b>
     */
    public boolean isValido(String sentencia){
        return sentencia.matches(REGEX) && isParenctecisCorrectos(sentencia);
    }
    
    /**
     * <p>Esta funcion nos indica el estado de las validaciones de la expresion.</p>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a evaluar.</b>
     * @return <b>Retorna un mensaje que detalla las validaciones de la expresion
     * ingresada.</b>
     */
    public String getValidacion(String sentencia){
        return "General: ".concat(getGeneral(sentencia)).concat("|Parentecis: ").concat(getValidacionParentencis(sentencia));
    }
    
    /**
     * <p>Obtiene las revisiones de la sentencia en forma de un arreglo.</p>
     * 
     * <p>El primer elemento indica si se cumple la expresion general y el segundo
     * si los parentesis estan bien formados.</p>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a revisar.</b>
     * @return <b>Arreglo con las revisiones en partes.</b>
     */
    
    public boolean[] getBanderas(String sentencia){
        return new boolean[]{sentencia.matches(REGEX), isParenctecisCorrectos(sentencia)};
    }
    
    /**
     * <p>Esta funcion nos indica el estado de una sentencia al evaluarse generalmente.</p>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a evaluar.</b>
     * @return <b>Retorna un mensaje que detalla el estado de la validacion.</b>
     */
    
    private String getGeneral(String sentencia){
        if(sentencia.matches(REGEX))return "correcto";
        return "incorrecto, un error en la sintaxis general de la expresion.";
    }
    
    /**
     * <p>Esta funcion nos muestra el estado de la validacion de parentesis de 
     * la expresion.</p>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a evaluar.</b>
     * @return <b>Nos indica el estado de la validacion con respecto a los parentesis.</b>
     */
    
    private String getValidacionParentencis(String sentencia){
        if(isParenctecisCorrectos(sentencia))return "correcto";
        int apertura = 0;
        int cierre = 0;
        for (int i = 0; i < sentencia.length(); i++) {
            char caracter = sentencia.charAt(i);
            switch(caracter){
                case '(':
                    apertura++;
                    continue;
                case ')':
                    cierre++;
                default:
            }
        }
        return "incorrecto, no se ".concat(apertura>cierre?"cierran ":"abren ").concat("todos los perentecis ingresados.");
    }
    
    /**
     * <p>Este metodo revisa que la sentencia cumpla con las reglas de parentesis.
     * Como las siguientes:</p>
     * 
     * <ul>
     *  <li>Se tienen que cerrar todos los parentesis.</li>
     *  <li>No puede ser el parentesis ")" el primero en ser encontrado.</li>
     * </ul>
     * 
     * @since 1.0
     * @param sentencia <b>Sentencia a evaluar.</b>
     * @return <b>Si cumple las reglas de parentesis retorna <i style="color:blue">true</i>,
     * en caso contrario retornaria <i style="color:blue">false</i>.</b>
     */
    
    private boolean isParenctecisCorrectos(String sentencia){
        if(sentencia.isEmpty())return false;
        int apertura = 0, cierre = 0;
        for(int i = 0; i < sentencia.length(); i++){
            if(sentencia.charAt(i)=='(')apertura++;
            if(sentencia.charAt(i)==')')cierre++;
            if(cierre>apertura)return false;
        }
        return apertura == cierre;
    }

    /**
     * <p>Este metodo ingresa ciertos operadores en caso de que en la expresion
     * ingresada se hubieran obviado. Casos:</p>
     * <ul>
     *  <li>Expresion: "(1)(1)" Formato: "(1)*(1)"</li>
     *  <li>Expresion: "1(2)" Formato: "1*(1)"</li>
     *  <li>Expresion: "(1)1" Formato: "(1)*1"</li>
     * </ul>
     *
     * @since 1.0
     * @param sentencia <b>Se ingresa la sentencia que se va a evaluar.</b>
     * @return <b>Sentencia formateada</b>
     */

    public String formatearSentencia(String sentencia){
        if(sentencia.isEmpty())return sentencia;
        sentencia = sentencia.replaceAll("[\\s]", "");
        sentencia = sentencia.replaceAll("\\)\\(", ")*(");
        String aux = String.valueOf(sentencia.charAt(0));
        for (int i = 1; i < sentencia.length() - 1; i++) {
            if(sentencia.charAt(i)=='(' && Util.isNumero(sentencia.charAt(i - 1)))aux = aux.concat("*(");
            else if(sentencia.charAt(i)==')' && Util.isNumero(sentencia.charAt(i + 1)))aux = aux.concat(")*");
            else aux = aux.concat(String.valueOf(sentencia.charAt(i)));
        }
        System.out.println(sentencia);
        return sentencia.length()>1?aux.concat(String.valueOf(sentencia.charAt(sentencia.length() - 1))):aux;
    }

}