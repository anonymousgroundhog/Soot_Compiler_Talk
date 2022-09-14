import java.util.Map;

import soot.*;
import soot.BodyTransformer;
import soot.PackManager;
import soot.Transform;
import soot.Unit;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;

public class Main {
  static int yes = 0, no = 0;

  /**
   * @param args
   */
  public static void main(String[] args) {
    PackManager.v().getPack("jtp").add(new Transform("jtp.fixedie", new BodyTransformer() {

      @Override
      protected void internalTransform(Body body, String phaseName, Map<String, String> options) {
        System.out.println("Main Class:" + String.valueOf(Scene.v().getMainClass()));
        for (Unit this_unit : body.getUnits()) {
          Stmt this_statement = (Stmt) this_unit;
          if (this_statement.containsInvokeExpr()) {
            InvokeExpr this_invoke_expression = this_statement.getInvokeExpr();
            if (FixedMethods.isFixed(this_invoke_expression)) {
              System.err.println("+++ " + this_invoke_expression);
              yes++;
            } else {
              System.err.println(" -  " + this_invoke_expression);
              no++;
            }
          }
        }
      }

    }));
    soot.Main.main(args);
    System.err.println("+++ " + yes);
    System.err.println(" -  " + no);
  }

}