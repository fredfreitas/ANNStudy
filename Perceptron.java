import java.util.*;

public class Perceptron {
    
    private double ni;
    private int epoca;
    public double [] w;
    public int nEnt, nSamp;         // número de entradas, número de amostras
    public Sample [] S;

    public Perceptron(int n) {
        
        nEnt = n+1;
        w = new double[nEnt];

        for(int i=0; i<4; i++) {
			w[i] = (double) (Math.random() * nEnt);
		}
    }


    public void setSample(int s) {
        nSamp = s;
        S = new Sample[nSamp];
    }        
    

    public void doTraining(int s) { 
        setSample(s);
        ni = (double) Math.random() * 1;
        int erro;
        int inexiste = 1;
        int existe = 0;
        do {
            erro = inexiste; // = 1             
            for(int i=0; i<nSamp; i++) {
                for(int j=1; j<nEnt; j++){
                    if(S[i].getOutput() != S[i].getExpValue()){             // y != d
                        w[j] = w[j] + ni * (S[i].getExpValue() - S[i].getOutput()) * S[i].x[j];
                        erro = existe; // = 0
                    }
                }
            }
            epoca++;
        } while(erro != inexiste); // erro != 1;
    }


    public void doOps() {
        double u;
    }

}
