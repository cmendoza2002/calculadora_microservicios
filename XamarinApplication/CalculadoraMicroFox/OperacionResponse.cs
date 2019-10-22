using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;

namespace CalculadoraMicroFox
{
    public class OperacionResponse
    {
        public TipoRespuesta tipoRespuesta { get; set; }
        public String mensaje { get; set; }
        public double resultado { get; set; }
    }

    public enum TipoRespuesta
    {
        EXITO,
        ERROR
    }
}