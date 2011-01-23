public class Sample extends Perceptron {
    
    public double [] x;
    public  int y;

    public Sample(int n) {
        super(n);
        x = new double[nEnt];
    }

    public void getSample(double [] E){
        
        double u = 0.0, sigma = 0.0, teta = 0.0;
        
        for(int i=0; i < nEnt; i++) {
            x[i] = E[i];
        }
        
        for(int i=1; i<nEnt; i++) {
            sigma += x[i] * w[i];
        }

        u = sigma - w[0];       // w[0] é teta
        if(u>=0) {
            y = 1;
        } else {
            y = -1;
        }
    }

    public int getOutput() {
        return y;               // y é o resultado da aplicação da função (bipolar)
    }

    public double getExpValue() {
        return x[0];            // x[0] é d que é o valor esperado
    }

}
