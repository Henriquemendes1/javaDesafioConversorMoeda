import java.util.ArrayList;
import java.util.List;

public class Conversor {
    private String base_code;
    private String target_code;
    private double conversion_result;
    private double conversion_rate;
    private double valor;


    public Conversor(String base_code, String target_code, double valor) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.valor = valor;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getValor() {
        return valor;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("""
                \n
                **----------------------------------------------------------**
                %.2f em [%s] Convertidos para [%s] é igual a: %.2f.
                **----------------------------------------------------------**
                """, (this.conversion_result / this.conversion_rate ), this.base_code, this.target_code, this.conversion_result);
    }
}
