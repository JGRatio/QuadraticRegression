import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.FileReader;
import java.util.List;

class DataSet {

 private double[][] data;
 private String csvFileName = "YieldData.csv";
 private double range1, range2;

 public DataSet(String file){

     csvFileName = file;
     readSimpleData();
 }

    public double getRange1() {
        return range1;
    }

    public double getRange2() {
        return range2;
    }

    public void readSimpleData() {
        try {
            FileReader filereader = new FileReader("C:\\Users\\elcam\\IdeaProjects\\SecondOrderRegression\\src\\csvData\\"+csvFileName);
            CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(0).build();
            List<String[]> allData = csvReader.readAll();
            double dataReaderX [][] = new double[allData.size()][2];
            for (int i = 0 ; i < allData.size(); i++){
                String[] row = allData.get(i);
                dataReaderX[i][0] = Double.parseDouble(row[0]);
                dataReaderX[i][1] = Double.parseDouble(row[1]);
            }
            data = dataReaderX;
            range1 = data[0][0];
            range2 = data[data.length-1][0];

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public double[][] getVectorDataX() {
        return data;
    }
}
