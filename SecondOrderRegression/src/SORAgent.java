import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import org.jfree.ui.RefineryUtilities;

public class SORAgent extends Agent {


    protected void setup() {
        // Create and show the GUI
        InputDialogBox myInputDialogBox = new InputDialogBox(this);
        myInputDialogBox.showGui();
        System.out.println("Hello world! I'm a OneShot Second Order Regression agent!");
        System.out.println("My local name is Agent" + getAID().getLocalName());

    }

    public void getX(final String x1) {
        addBehaviour(new OneShotBehaviour() {
            public void action() {
                DataSet data = new DataSet("tempvspressure.csv");
                QuadraticRegression SOR = new QuadraticRegression(data.getVectorDataX());
                System.out.println("B0:" + SOR.getB0());
                System.out.println("B1:" + SOR.getB1());
                System.out.println("B2:" + SOR.getB2());
                System.out.print("Y = ");
                System.out.println(Math.pow(SOR.getB2() * Integer.parseInt(x1),2) + SOR.getB1() * Integer.parseInt(x1) + SOR.getB0());
                Plot demo = new Plot("",SOR.getB2(),SOR.getB1(),SOR.getB0(),data.getRange1(),data.getRange2());
                demo.pack();
                RefineryUtilities.centerFrameOnScreen(demo);
                demo.setVisible(true);
            }
        });

    }
}
