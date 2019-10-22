using Android.App;
using Android.OS;
using Android.Runtime;
using Android.Widget;
using Android.Views;
using System.Net.Http;
using Newtonsoft.Json;
using System.Threading.Tasks;
using System.Text;

namespace CalculadoraMicroFox
{
    [Activity(Label = "@string/app_name", MainLauncher = true)]
    public class MainActivity : Activity
    {

        private const string URL = "http://192.168.43.148:9090/calculadora/v1/evaluador/procesar";
        private readonly HttpClient client = new HttpClient();


        private TextView calculatorText;

        private string[] numbers = new string[2];
        private string @operator;

        protected override void OnCreate(Bundle savedInstanceState)
        {
            base.OnCreate(savedInstanceState);

            SetContentView(Resource.Layout.Main);

            calculatorText = FindViewById<TextView>(Resource.Id.calculator_text_view);
        }

        [Java.Interop.Export("ButtonClick")]
        public void ButtonClick(View v)
        {
            Button button = (Button)v;
            if ("0123456789.".Contains(button.Text))
                AddDigitOrDecimalPoint(button.Text);
            else if ("÷×+-".Contains(button.Text))
                AddOperator(button.Text);
            else if ("=" == button.Text)
                Calculate();
            else
                Erase();
        }

        private void AddDigitOrDecimalPoint(string value)
        {
            int index = @operator == null ? 0 : 1;

            if (value == "." && numbers[index].Contains("."))
                return;

            numbers[index] += value;

            UpdateCalculatorText();
        }

        private void AddOperator(string value)
        {
            if (numbers[1] != null)
            {
                Calculate(value);
                return;
            }

            @operator = value;

            UpdateCalculatorText();
        }

        private void Calculate(string newOperator = null)
        {
            double? result = null;
            double? first = numbers[0] == null ? null : (double?)double.Parse(numbers[0]);
            double? second = numbers[1] == null ? null : (double?)double.Parse(numbers[1]);

            //result = operar(first.Value, second.Value, @operator);
            switch (@operator)
            {
                case "÷":
                    result = operar(first.Value, second.Value, "/");//first / second;
                    break;
                case "×":
                    result = operar(first.Value, second.Value, "*");//first * second;
                    break;
                case "+":
                    result = operar(first.Value, second.Value, "+");//first + second;
                    break;
                case "-":
                    result = operar(first.Value, second.Value, "-");//first - second;
                    break;
            }

            if (result != null)
            {
                numbers[0] = result.ToString();
                @operator = newOperator;
                numbers[1] = null;
                UpdateCalculatorText();
            }
        }

        private void Erase()
        {
            numbers[0] = numbers[1] = null;
            @operator = null;
            UpdateCalculatorText();
        }

        private void UpdateCalculatorText() => calculatorText.Text = $"{numbers[0]} {@operator} {numbers[1]}";


        private double operar(double a, double b, string operador)
        {
            EvaluadorRequest request = new EvaluadorRequest("" + a + operador + b);
            string content = JsonConvert.SerializeObject(request);
            Task<HttpResponseMessage> result = client.PostAsync(URL, new StringContent(content, Encoding.UTF8, "application/json"));
            //Task<string> rr = result.Result.Content;

            var rp = result.Result.Content.ReadAsStringAsync().Result;

            OperacionResponse resp = JsonConvert.DeserializeObject<OperacionResponse>(rp);
            return resp.resultado;

        }
    }
}

