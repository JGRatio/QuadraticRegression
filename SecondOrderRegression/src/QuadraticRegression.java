class QuadraticRegression {
    private double B0,B1,B2;
    private double[][] dataMatrix;


    public QuadraticRegression(double[][] x) {
        this.dataMatrix = x;
        calculate();
    }
    public void setDataMatrix(double[][] dataMatrix) {
        calculate();
    }

    public double getB0() {
        return B0;
    }

    public double getB1() {
        return B1;
    }

    public double getB2() {
        return B2;
    }

    private void calculate(){
        double sumXi = 0,sumXi_2 = 0,sumYi = 0,sumXi_3 = 0,sumXi_4 = 0,sumXiYi = 0,sumXi_2Yi = 0,n = dataMatrix.length;
        for (int i = 0; i < dataMatrix.length; i++){
            sumXi += dataMatrix[i][0];
            sumXi_2 += dataMatrix[i][0] * dataMatrix[i][0];
            sumXi_3 += dataMatrix[i][0] * dataMatrix[i][0] * dataMatrix[i][0];
            sumXi_4 += dataMatrix[i][0] * dataMatrix[i][0] * dataMatrix[i][0] * dataMatrix[i][0];
            sumYi   += dataMatrix[i][1];
            sumXiYi += dataMatrix[i][0] * dataMatrix[i][1];
            sumXi_2Yi += (dataMatrix[i][0] * dataMatrix[i][0]) * dataMatrix[i][1];
        }

        double[][] systemEquations = {
                { n      , sumXi  , sumXi_2, sumYi  },
                { sumXi  , sumXi_2, sumXi_3, sumXiYi},
                { sumXi_2, sumXi_3, sumXi_4, sumXi_2Yi}
        };

        Helper helper = new Helper(systemEquations);
        B0 = helper.getDeterminant1()/helper.getSystemDeterminant();
        B1 = helper.getDeterminant2()/helper.getSystemDeterminant();
        B2 = helper.getDeterminant3()/helper.getSystemDeterminant();





    }
}
